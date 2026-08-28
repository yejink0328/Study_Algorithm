# 📚 Algorithm Study

알고리즘 공부기록.
- 같은 문제도 여러 방식으로 풀 것.
- 실패한 시도도 기록으로 남길 것.

---

<details>
<summary><b>📋 작업 규칙 (펼쳐서 보기)</b></summary>

### 커밋 메시지 형식

```
[약어] Q문제번호_해결방법1:접근방법설명 (난이도) [상태]
```

**예시**
```
[PRG] Q12345 (Lv1) [TLE]
[PRG] Q12345_s1:DFS (Lv1) [WA]
[PRG] Q12345_s1:DFS (Lv1) [AC]
[SWEA] Q1954 (D3) [AC]
[PRG] Q12345 (Lv1): README 풀이 이력 표 갱신
```
> 마지막 예시처럼 README만 갱신하는 커밋은 `[상태]`를 생략한다.

**규칙**
- 커밋 하나 = 풀이 시도 하나 (여러 문제를 한 커밋에 묶지 않음)
- 코드 변경 커밋에는 `[상태]` 필수

### 플랫폼 약어

| 플랫폼 | 약어 | 메인 페이지 |
|---|---|---|
| 프로그래머스 | `PRG` | https://programmers.co.kr/ |
| SWEA | `SWEA` | https://swexpertacademy.com/main/main.do |
| 백준 | `BOJ` | - |

### 채점 상태 코드

| 코드 | 원어 | 의미 |
|---|---|---|
| `AC` | Accepted | 정답, 통과 |
| `WA` | Wrong Answer | 실행되지만 출력이 틀림 |
| `TLE` | Time Limit Exceeded | 시간 제한 초과 |
| `MLE` | Memory Limit Exceeded | 메모리 제한 초과 |
| `RE` | Runtime Error | 실행 중 비정상 종료 |

### 폴더 / 파일 이름 규칙

- 폴더: `Q문제번호` (한글·공백·특수문자 금지)
- 파일: `Q문제번호.py`
- 해결방법에 따른 분류: `Q문제번호_s1.py`
- 실패한 풀이 파일은 삭제하지 않고 보존

</details>

---

## 📁 디렉토리 구조

```
algorithm-study/
├── README.md
├── programmers/
│   ├── level1/
│   │   └── Q12345-unfinished-racers/
│   │       ├── README.md
│   │       ├── Q12345.py
│   │       ├── Q12345_s1.py
│   │       └── Q12345_s2.py
│   ├── level2/
│   └── level3/
├── swea/
│   └── D3/
│       └── Q1954-snail-numbers/
│           ├── README.md
│           └── Q1954.py
├── baekjoon/
└── _template/
    └── problem_README_template.md
```

---

## 📊 진행 현황

<!-- PROGRESS:START -->
| 플랫폼 | 문제 수 | 마지막 업데이트 |
|---|---|---|
| - | 0 | - |
<!-- PROGRESS:END -->

## 📌 문제 목록

> 새 문제 등록 시 이 표 상단에 한 줄 추가, 최초 AC 시 위 진행 현황 카운트 갱신.

<!-- PROBLEM_LIST:START -->
| No. | 번호 | 문제 | 플랫폼 | 난이도 | 풀이 수 (AC/전체) | 최근 풀이일 |
|---|---|---|---|---|---|---|
| | | (등록된 문제 없음) | | | | |
<!-- PROBLEM_LIST:END -->

