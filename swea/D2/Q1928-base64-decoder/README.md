# Q1928 Base64 Decoder

- 플랫폼: SWEA
- 난이도: D2
- 분류: 단순 계산

## 문제 설명
다음과 같이 Encoding 을 한다.

1. 우선 24비트 버퍼에 위쪽(MSB)부터 한 byte씩 3 byte의 문자를 집어넣는다.
2. 버퍼의 위쪽부터 6비트씩 잘라 그 값을 읽고, 각각의 값을 아래 [표-1] 의 문자로 Encoding 한다.

입력으로 Base64 Encoding 된 String 이 주어졌을 때, 해당 String 을 Decoding 하여, 원문을 출력.


### 제약조건
- 문자열의 길이는 항상 4의 배수로 주어진다.
- 문자열의 길이는 100000을 넘지 않는다.


### 입출력 예
| 입력 | 출력 |
|---|---|
| TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u | #1 Life itself is a quotation. |
| U3VzcGljaW9uIGZvbGxvd3MgY2xvc2Ugb24gbWlzdHJ1c3Qu | #2 Suspicion follows close on mistrust. |
| VG8gZG91YnQgaXMgc2FmZXIgdGhhbiB0byBiZSBzZWN1cmUu | #3 To doubt is safer than to be secure. |
| T25seSB0aGUganVzdCBtYW4gZW5qb3lzIHBlYWNlIG9mIG1pbmQu | #4 Only the just man enjoys peace of mind. |
| QSBmdWxsIGJlbGx5IGlzIHRoZSBtb3RoZXIgb2YgYWxsIGV2aWwu | #5 A full belly is the mother of all evil. |


## 풀이 이력

| 파일 | 접근 방식 | 결과 | 시간복잡도 | 날짜 | 비고 |
|---|---|---|---|---|---|
| Q1928.java | 단순 계산 | AC | O(1) | 2026-09-16 | - |


## 시도별 메모

### solution1 — (단순 계산) (AC)
- 날짜: 2026-09-16
- 접근: 
    Base64 decoder 내장 라이브러리를 사용해서 변환 / 직접 구현이 있겠으나 일단 라이브러리 사용. 
    직접 구현은 비트쉬프트 연산자를 사용한 계산이 필요해보이는데, 좀 더 살펴봐야 할 듯.
- 결과 / 실패 원인: AC
