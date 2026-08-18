package com.ssafy.ws.step1;

import java.util.Scanner;

// 자릿수 더하기
public class Q2058 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = N;
		int cnt = 0;
		
		while(M != 0) {
			M /= 10;
			cnt++;
		}
		
		int sum = 0;
		for(int i=0; i<cnt; i++) {
			sum += N%10;
			N /= 10;
		}
		
		System.out.println(sum);
		
	}
}
