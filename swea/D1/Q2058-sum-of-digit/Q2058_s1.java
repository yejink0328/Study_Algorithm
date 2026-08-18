package com.ssafy.ws.step1;

import java.util.Scanner;

// 자릿수 더하기
public class Q2058_s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(rSumPlaceValue(N));
		
	}
	
	public static int rSumPlaceValue(int num) {
		if(num == 0) {
			return num;
		}else {
			return num%10 + rSumPlaceValue(num/=10);
		}
	}
}
