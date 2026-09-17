"""
커밋 메시지와 문제 폴더 구조를 바탕으로 README.md의
'진행 현황' / '문제 목록' 섹션을 자동 갱신한다.

데이터 출처:
- 문제 목록(어떤 문제가 있는지, 이름, 플랫폼, 난이도, 경로): 폴더 구조 전체를 스캔하며,
  각 문제 README.md의 다음 줄들을 읽는다.
    '# 문제번호 문제이름'      -> 이름
    '- 플랫폼: <약어>'         -> 플랫폼 약어 (신규 플랫폼도 이 줄만 있으면 자동 인식)
    '- 난이도: ...'            -> 난이도 표기 (사이트 표기 그대로, 코드에서 매핑하지 않음)
  '- 플랫폼:' 줄이 없는 README.md(루트 README, 템플릿 등)는 문제로 취급하지 않는다.
- 풀이 통계(AC/전체, 최근 풀이일): 커밋 메시지

커밋 메시지 형식:
  [약어] Q문제번호 (난이도) [AC|WA|TLE|MLE|RE]
  [약어] 문제식별자 (난이도) [AC|WA|TLE|MLE|RE]                 <- 번호 대신 이름을 쓰는 플랫폼(SSAFY 등)
  [약어] Q문제번호_s솔루션번호:접근방식 (난이도) [상태]           <- 반복 풀이
  [약어] Q문제번호 (난이도): 설명                                <- README만 갱신, 집계 제외

★ 새 플랫폼을 추가하려면
  1. 문제 폴더의 README.md에 '- 플랫폼: <약어>' 를 적는다.
  2. 커밋 메시지의 '[ ]' 안에 동일한 약어를 그대로 쓴다.
  그 외 코드 수정은 필요 없다. (플랫폼 목록이 코드에 하드코딩되어 있지 않음)
  단, 커밋에서 쓰는 문제 식별자와 폴더 이름의 앞부분(숫자 또는 영문 토큰)은 일치해야
  풀이 통계(AC/전체)가 정확히 매칭된다. 예: 폴더 'Q1954-snail-number' <-> 커밋 'Q1954',
  폴더 'ballMoving' <-> 커밋 'ballMoving'.

플랫폼 한글 표시명은 scripts/platform_labels.json 에서 선택적으로 관리한다.
(약어: 표시명) 형태로 등록하지 않은 약어는 약어 자체를 표시명으로 사용하므로,
이 파일을 건드리지 않아도 신규 플랫폼은 정상적으로 표에 반영된다.
"""
import json
import re
import subprocess
from collections import defaultdict
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
README = ROOT / "README.md"
LABELS_PATH = Path(__file__).resolve().parent / "platform_labels.json"

# rglob 스캔에서 문제 폴더로 취급하지 않을 최상위 디렉터리
SKIP_TOP_PARTS = {"_template", "scripts", ".github", ".git"}

PLATFORM_LINE_RE = re.compile(r"^-\s*플랫폼\s*:\s*(.+)$")
LEVEL_LINE_RE = re.compile(r"^-\s*난이도\s*:\s*(.+)$")
DATE_VALUE_RE = re.compile(r"^\d{4}-\d{2}-\d{2}$")

# 폴더/커밋에 쓰인 문제 식별자에서 앞부분 영숫자 토큰만 뽑아낸다:
#   "1545"                  -> "1545"
#   "Q1545"                 -> "1545"           (Q + 숫자만인 경우 숫자만 보존, 기존 표기 호환)
#   "Q1545-print-backward"  -> "1545"
#   "ballMoving"            -> "ballMoving"      (번호 없이 이름을 쓰는 플랫폼)
ID_TOKEN_RE = re.compile(r"^([A-Za-z0-9]+)")
Q_NUMBER_RE = re.compile(r"^Q(\d+)$")

# 커밋 메시지: [약어] 식별자(_s번호:설명)? (난이도) [상태]?
# 약어/식별자를 특정 값으로 제한하지 않아 새 플랫폼이 코드 수정 없이 인식된다.
COMMIT_RE = re.compile(
    r"^\[(\w+)\]\s+([A-Za-z0-9]+)(?:_s\d+(?::[^\s(]+)?)?\s+\(([^)]+)\)(?:\s+\[(\w+)\])?"
)


def load_labels():
    """플랫폼 약어 -> 한글 표시명 매핑을 선택적으로 로드한다. 파일이 없거나 값이 없으면
    약어 자체를 표시명으로 사용하므로 신규 플랫폼도 항상 정상 동작한다."""
    try:
        return json.loads(LABELS_PATH.read_text(encoding="utf-8"))
    except FileNotFoundError:
        return {}


def get_label(abbr, labels):
    return labels.get(abbr, abbr)


def ordered_platforms(present_abbrs, labels):
    """labels.json에 등록된 순서를 우선하고, 등록되지 않은(=새로) 플랫폼은
    알파벳 순으로 뒤에 붙인다."""
    known_order = [a for a in labels.keys() if a in present_abbrs]
    extra = sorted(a for a in present_abbrs if a not in labels)
    return known_order + extra


def normalize_id(token: str) -> str:
    m = Q_NUMBER_RE.match(token)
    return m.group(1) if m else token


def extract_folder_id(dirname: str) -> str:
    m = ID_TOKEN_RE.match(dirname)
    token = m.group(1) if m else dirname
    return normalize_id(token)


def get_commit_log():
    """returns list of (timestamp_str, date_str, platform, number, level, status_or_None)"""
    out = subprocess.run(
        ["git", "log", "--date=format:%Y-%m-%dT%H:%M:%S", "--pretty=format:%ad|%s"],
        cwd=ROOT, capture_output=True, text=True, check=True,
    ).stdout
    entries = []
    for line in out.splitlines():
        if "|" not in line:
            continue
        ts, subject = line.split("|", 1)
        m = COMMIT_RE.match(subject.strip())
        if not m:
            continue
        platform, raw_id, level, status = m.groups()
        platform = platform.upper()
        number = normalize_id(raw_id)
        entries.append((ts, ts[:10], platform, number, level, status))
    return entries


def extract_meta(readme_path: Path):
    """
    문제 README.md에서
      '# 문제번호 문제이름'  -> 이름
      '- 플랫폼: <약어>'     -> 플랫폼 약어 (없으면 문제 README가 아닌 것으로 간주)
      '- 난이도: ...'        -> 난이도 표기 (사이트 표기 그대로, 코드에서 매핑하지 않음)
      '## 풀이 이력' 표의 '날짜' 컬럼 -> 실제 풀이일 (커밋 날짜가 아니라 이 값을 최종 소스로 사용)
    을 읽는다.
    """
    name = "(제목 없음)"
    level = "-"
    platform = None
    solved_dates = []
    date_col = None  # '풀이 이력' 표에서 '날짜' 컬럼의 인덱스. 찾기 전까지 None

    with open(readme_path, encoding="utf-8") as f:
        for raw_line in f:
            stripped = raw_line.strip()

            if stripped.startswith("# ") and name == "(제목 없음)":
                content = stripped[2:].strip()
                tokens = content.split(maxsplit=1)
                name = tokens[1] if len(tokens) == 2 and tokens[0].isdigit() else content
                continue

            m = PLATFORM_LINE_RE.match(stripped)
            if m:
                platform = m.group(1).strip().upper()
                continue

            m = LEVEL_LINE_RE.match(stripped)
            if m:
                level = m.group(1).strip()
                continue

            # '풀이 이력' 표 파싱: '| ... | 날짜 | ... |' 형태 줄만 대상으로 함
            if stripped.startswith("|") and stripped.endswith("|"):
                cells = [c.strip() for c in stripped.strip("|").split("|")]
                if date_col is None:
                    if "날짜" in cells:
                        date_col = cells.index("날짜")
                    continue  # 헤더 행 자체는 데이터로 취급하지 않음
                if date_col < len(cells):
                    value = cells[date_col]
                    if DATE_VALUE_RE.match(value):
                        solved_dates.append(value)

    last_solved_date = max(solved_dates) if solved_dates else None
    return platform, name, level, last_solved_date


def scan_problem_folders():
    """
    저장소 전체에서 README.md를 재귀적으로 스캔한다. (플랫폼별 폴더명을 코드에 나열하지 않음)
    '- 플랫폼:' 줄이 있는 README.md만 문제 README로 취급하므로,
    새 플랫폼 폴더를 어디에 어떤 이름으로 추가하든 자동으로 인식된다.
    """
    problems = []
    for readme_path in ROOT.rglob("README.md"):
        if readme_path == README:
            continue
        rel_parts = readme_path.relative_to(ROOT).parts
        if rel_parts[0] in SKIP_TOP_PARTS:
            continue

        platform, name, level, solved_date = extract_meta(readme_path)
        if not platform:
            continue  # '- 플랫폼:' 메타가 없으면 문제 README가 아닌 것으로 간주하고 건너뜀

        problem_dir = readme_path.parent
        number = extract_folder_id(problem_dir.name)
        problems.append({
            "platform": platform,
            "number": number,
            "level": level,
            "path": problem_dir.relative_to(ROOT).as_posix(),
            "name": name,
            "solved_date": solved_date,  # README '풀이 이력' 표에서 읽은 실제 풀이일 (None 가능)
        })
    return problems


def build_stats(commit_entries):
    """key: (platform, number) -> {total, ac, last_ts, last_date}"""
    stats = defaultdict(lambda: {"total": 0, "ac": 0, "last_ts": None, "last_date": None})
    for ts, date_str, platform, number, level, status in commit_entries:
        if status is None:
            continue
        s = stats[(platform, number)]
        s["total"] += 1
        if status == "AC":
            s["ac"] += 1
        if s["last_ts"] is None or ts > s["last_ts"]:
            s["last_ts"] = ts
            s["last_date"] = date_str
    return stats


def render_progress_table(problems, labels):
    """'마지막 업데이트'는 커밋 날짜가 아니라 각 문제 README에 적힌 실제 풀이일(solved_date) 기준"""
    per_platform = defaultdict(lambda: {"count": 0, "last": None})
    for p in problems:
        info = per_platform[p["platform"]]
        info["count"] += 1
        d = p["solved_date"]
        if d and (info["last"] is None or d > info["last"]):
            info["last"] = d

    lines = ["| 플랫폼 | 문제 수 | 마지막 업데이트 |", "|---|---|---|"]
    for abbr in ordered_platforms(per_platform.keys(), labels):
        info = per_platform[abbr]
        lines.append(f"| {get_label(abbr, labels)} | {info['count']} | {info['last'] or '-'} |")
    if len(lines) == 2:
        lines.append("| - | 0 | - |")
    return "\n".join(lines)


def render_problem_list(problems, stats, labels):
    """
    정렬 기준: README '풀이 이력' 표에 적힌 실제 풀이일(solved_date) — 커밋 시각이 아님.
    No. 컬럼: 최신 문제가 가장 큰 번호(총 문제 수)를 갖고, 가장 오래된 문제가 1이 되도록
              역순으로 매긴다. (커밋 타임스탬프는 같은 날짜끼리의 2차 정렬 기준으로만 사용)
    """
    enriched = []
    for p in problems:
        s = stats.get((p["platform"], p["number"]), {"total": 0, "ac": 0, "last_ts": None})
        enriched.append((p, s))
    enriched.sort(key=lambda x: (x[0]["solved_date"] or "", x[1]["last_ts"] or ""), reverse=True)

    total = len(enriched)
    lines = [
        "| No. | 번호 | 문제 | 플랫폼 | 난이도 | 풀이 수 (AC/전체) | 최근 풀이일 |",
        "|---|---|---|---|---|---|---|",
    ]
    for i, (p, s) in enumerate(enriched):
        no = total - i  # 역순: 맨 위(최신)가 total, 맨 아래(가장 오래됨)가 1
        link = f"[{p['name']}](./{p['path']})"
        ac_total = f"{s['ac']}/{s['total']}" if s["total"] else "-"
        lines.append(
            f"| {no} | {p['number']} | {link} | {get_label(p['platform'], labels)} | "
            f"{p['level']} | {ac_total} | {p['solved_date'] or '-'} |"
        )
    if len(lines) == 2:
        lines.append("| | | (등록된 문제 없음) | | | | |")
    return "\n".join(lines)


def replace_between_markers(content, start_marker, end_marker, new_block):
    pattern = re.compile(re.escape(start_marker) + r".*?" + re.escape(end_marker), re.DOTALL)
    if not pattern.search(content):
        raise ValueError(f"마커를 찾을 수 없음: {start_marker} ~ {end_marker}")
    replacement = f"{start_marker}\n{new_block}\n{end_marker}"
    return pattern.sub(replacement, content)


def main():
    labels = load_labels()
    commit_entries = get_commit_log()
    problems = scan_problem_folders()
    stats = build_stats(commit_entries)

    progress_table = render_progress_table(problems, labels)
    problem_table = render_problem_list(problems, stats, labels)

    content = README.read_text(encoding="utf-8")
    content = replace_between_markers(content, "<!-- PROGRESS:START -->", "<!-- PROGRESS:END -->", progress_table)
    content = replace_between_markers(content, "<!-- PROBLEM_LIST:START -->", "<!-- PROBLEM_LIST:END -->", problem_table)
    README.write_text(content, encoding="utf-8")
    print("README updated.")


if __name__ == "__main__":
    main()
