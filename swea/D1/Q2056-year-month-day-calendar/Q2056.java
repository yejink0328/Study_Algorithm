package com.ssafy.ws.step1;

import java.util.Scanner;

// 연월일 달력
public class Q2056 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++) {
			
			String strN = sc.next();
			int N = Integer.valueOf(strN);
			
			int y = N/10000;
			int m = N/100 - y*100;
			int d = N - y*10000 - m*100;
			
			int endDay = 0;
			switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				endDay = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				endDay = 30;
				break;
			case 2:
				endDay = 28;
				break;
			default:
				endDay = 0;
			}
			
			if((endDay != 0) && (d>=0) && (d<=endDay)) {
				System.out.println("#" + test_case + " " + strN.substring(0, 4)+"/"+strN.substring(4, 6)+"/"+strN.substring(6));
			}else {
				System.out.println("#" + test_case + " " + -1);
			}
		}
	}
}
