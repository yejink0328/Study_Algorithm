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
| SWEA | 21 | 2026-08-28 |
<!-- PROGRESS:END -->

## 📌 문제 목록

> 새 문제 등록 시 이 표 상단에 한 줄 추가, 최초 AC 시 위 진행 현황 카운트 갱신.

<!-- PROBLEM_LIST:START -->
| No. | 번호 | 문제 | 플랫폼 | 난이도 | 풀이 수 (AC/전체) | 최근 풀이일 |
|---|---|---|---|---|---|---|
| 1 | 1986 | [Q1986 지그재그 숫자](./swea/D2/Q1986-zigzag-number) | SWEA | D2 | 1/1 | 2026-08-28 |
| 2 | 1945 | [Q1945 간단한 소인수분해](./swea/D2/Q1945-simple-prime-factorization) | SWEA | D2 | 1/1 | 2026-08-28 |
| 3 | 1933 | [Q1933 간단한 N의 약수](./swea/D1/Q1933-simple-N-divisor) | SWEA | D1 | 1/1 | 2026-08-28 |
| 4 | 1545 | [Q1545 거꾸로 출력해 보아요](./swea/D1/Q1545-print-backward) | SWEA | D1 | 1/1 | 2026-08-28 |
| 5 | 2019 | [Q2019 더블더블](./swea/D1/Q2019-double-double) | SWEA | D1 | 1/1 | 2026-08-28 |
| 6 | 1936 | [Q1936 1대1 가위바위보](./swea/D1/Q1936-one-on-one-rock-scissors-paper) | SWEA | D1 | 1/1 | 2026-08-28 |
| 7 | 1938 | [Q1938 아주 간단한 계산기](./swea/D1/Q1938-simple-calculator) | SWEA | D1 | 1/1 | 2026-08-28 |
| 8 | 2025 | [Q2025 N줄덧셈](./swea/D1/Q2025-add-to-N) | SWEA | D1 | 1/1 | 2026-08-28 |
| 9 | 2027 | [Q2027 대각선 출력하기](./swea/D1/Q2027-print-diagonal) | SWEA | D1 | 1/1 | 2026-08-28 |
| 10 | 2029 | [Q2029 몫과 나머지 출력하기](./swea/D1/Q2029-quotient-n-remainder) | SWEA | D1 | 1/1 | 2026-08-28 |
| 11 | 2043 | [Q2043 서랍의 비밀번호](./swea/D1/Q2043-find-password) | SWEA | D1 | 1/1 | 2026-08-28 |
| 12 | 2063 | [Q2063 중간값 찾기](./swea/D1/Q2063-find-median) | SWEA | D1 | 1/1 | 2026-08-18 |
| 13 | 2047 | [Q2047 신문 헤드라인](./swea/D1/Q2047-news-headline) | SWEA | D1 | 1/1 | 2026-08-18 |
| 14 | 2050 | [Q2050 알파벳을 숫자로 변환](./swea/D1/Q2050-apb-to-num) | SWEA | D1 | 1/1 | 2026-08-18 |
| 15 | 2056 | [Q2056 연월일 달력](./swea/D1/Q2056-year-month-day-calendar) | SWEA | D1 | 1/1 | 2026-08-18 |
| 16 | 2046 | [Q2046 스탬프 찍기](./swea/D1/Q2046-print-stamp) | SWEA | D1 | 2/2 | 2026-08-18 |
| 17 | 2058 | [Q2058 자릿수 더하기](./swea/D1/Q2058-sum-of-digit) | SWEA | D1 | 2/2 | 2026-08-18 |
| 18 | 2068 | [Q2068 최대수 구하기](./swea/D1/Q2068-calculate-the-max) | SWEA | D1 | 1/1 | 2026-08-18 |
| 19 | 2070 | [Q2070 큰 놈, 작은 놈, 같은 놈](./swea/D1/Q2070-big-small-same-thing) | SWEA | D1 | 1/1 | 2026-08-18 |
| 20 | 2071 | [Q2071 평균값 구하기](./swea/D1/Q2071-calculate-the-mean) | SWEA | D1 | 1/1 | 2026-08-18 |
| 21 | 2072 | [Q2072 홀수만 더하기](./swea/D1/Q2072-add-odd-only) | SWEA | D1 | 1/1 | 2026-08-18 |
<!-- PROBLEM_LIST:END -->

