package com.ssafy.ws.step1;

import java.util.Scanner;

// 스탬프 찍기
public class Q2046_s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		rStamp(T);
	}
	
	public static int rStamp(int N) {
		if(N==0) {
			return 0;
		}else {
			System.out.print("#");
			return rStamp(N-1);
		}
	}
}
