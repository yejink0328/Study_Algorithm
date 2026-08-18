package com.ssafy.ws.step1;

import java.util.Scanner;

// 평균값 구하기
public class Q2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			for(int i = 0; i<10; i++) {
				int num = sc.nextInt();
				ans += num;
			}
			System.out.printf("#%d %.0f%n", test_case, ans/10.0);
		}
		
	}
}
