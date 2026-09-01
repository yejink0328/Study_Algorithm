"""
커밋 메시지와 문제 폴더 구조를 바탕으로 README.md의
'진행 현황' / '문제 목록' 섹션을 자동 갱신한다.

데이터 출처:
- 문제 목록(어떤 문제가 있는지, 이름, 난이도, 경로): 폴더 구조 + 각 문제 README.md의
  '# 문제번호 문제이름' 제목 줄과 '- 난이도: ...' 메타데이터 줄
- 풀이 통계(AC/전체, 최근 풀이일): 커밋 메시지

커밋 메시지 형식:
  [PRG|SWEA|BOJ] Q문제번호 (난이도) [AC|WA|TLE|MLE|RE]
  [PRG|SWEA|BOJ] Q문제번호_s솔루션번호:접근방식 (난이도) [상태]   <- 반복 풀이
  [PRG|SWEA|BOJ] Q문제번호 (난이도): 설명                        <- README만 갱신, 집계 제외
"""
import re
import subprocess
from collections import defaultdict
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
README = ROOT / "README.md"

PLATFORM_DIR_TO_ABBR = {
    "programmers": "PRG",
    "swea": "SWEA",
    "baekjoon": "BOJ",
}
ABBR_TO_KOR = {
    "PRG": "프로그래머스",
    "SWEA": "SWEA",
    "BOJ": "백준",
}
PLATFORM_ORDER = ["PRG", "SWEA", "BOJ"]

LEVEL_LINE_RE = re.compile(r"^-\s*난이도\s*:\s*(.+)$")
DATE_VALUE_RE = re.compile(r"^\d{4}-\d{2}-\d{2}$")

# 폴더명 형식이 여러 버전 섞여 있어도 문제번호만 뽑아낸다:
#   "1545"                  -> 1545
#   "Q1545"                 -> 1545
#   "Q1545-print-backward"  -> 1545
FOLDER_NUMBER_RE = re.compile(r"^Q?(\d+)(?:[-_].*)?$")

COMMIT_RE = re.compile(
    r"^\[(PRG|SWEA|BOJ)\]\s+Q(\d+)(?:_s\d+:[^\s(]+)?\s+\(([^)]+)\)(?:\s+\[(\w+)\])?"
)


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
        platform, number, level, status = m.groups()
        entries.append((ts, ts[:10], platform, number, level, status))
    return entries


def extract_title_and_level(readme_path: Path):
    """
    문제 README.md에서
      '# 문제번호 문제이름'  -> 이름
      '- 난이도: ...'        -> 난이도 표기 (사이트 표기 그대로, 코드에서 매핑하지 않음)
      '## 풀이 이력' 표의 '날짜' 컬럼 -> 실제 풀이일 (커밋 날짜가 아니라 이 값을 최종 소스로 사용)
    을 읽는다.
    """
    name = "(제목 없음)"
    level = "-"
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
    return name, level, last_solved_date


def scan_problem_folders():
    """
    programmers/level1/12345/README.md
    swea/D1/2072/README.md
    baekjoon/1000/README.md
    형태를 전부 스캔해서 문제 목록을 만든다.
    """
    problems = []
    for platform_dir, abbr in PLATFORM_DIR_TO_ABBR.items():
        base = ROOT / platform_dir
        if not base.exists():
            continue
        for readme_path in base.rglob("README.md"):
            problem_dir = readme_path.parent
            m = FOLDER_NUMBER_RE.match(problem_dir.name)
            if not m:
                continue
            number = m.group(1)
            name, level, solved_date = extract_title_and_level(readme_path)
            problems.append({
                "platform": abbr,
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


def render_progress_table(problems):
    """'마지막 업데이트'는 커밋 날짜가 아니라 각 문제 README에 적힌 실제 풀이일(solved_date) 기준"""
    per_platform = defaultdict(lambda: {"count": 0, "last": None})
    for p in problems:
        info = per_platform[p["platform"]]
        info["count"] += 1
        d = p["solved_date"]
        if d and (info["last"] is None or d > info["last"]):
            info["last"] = d

    lines = ["| 플랫폼 | 문제 수 | 마지막 업데이트 |", "|---|---|---|"]
    for abbr in PLATFORM_ORDER:
        if abbr not in per_platform:
            continue
        info = per_platform[abbr]
        lines.append(f"| {ABBR_TO_KOR[abbr]} | {info['count']} | {info['last'] or '-'} |")
    if len(lines) == 2:
        lines.append("| - | 0 | - |")
    return "\n".join(lines)


def render_problem_list(problems, stats):
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
            f"| {no} | {p['number']} | {link} | {ABBR_TO_KOR[p['platform']]} | "
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
    commit_entries = get_commit_log()
    problems = scan_problem_folders()
    stats = build_stats(commit_entries)

    progress_table = render_progress_table(problems)
    problem_table = render_problem_list(problems, stats)

    content = README.read_text(encoding="utf-8")
    content = replace_between_markers(content, "<!-- PROGRESS:START -->", "<!-- PROGRESS:END -->", progress_table)
    content = replace_between_markers(content, "<!-- PROBLEM_LIST:START -->", "<!-- PROBLEM_LIST:END -->", problem_table)
    README.write_text(content, encoding="utf-8")
    print("README updated.")


if __name__ == "__main__":
    main()
