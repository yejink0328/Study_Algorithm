package com.ssafy.ws.step1;

import java.util.Scanner;

// 큰 놈, 작은 놈, 같은 놈
public class Q2070 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++) {
			
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			char c;
			
			if(num1 > num2) {
				c = '>';
			}else if(num1 < num2) {
				c = '<';
			}else {
				c = '=';
			}
			System.out.println("#"+test_case+" "+c);
		}
	}
}
