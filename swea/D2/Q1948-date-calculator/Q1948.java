package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Q1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				3 
				3 1 3 31
				5 5 8 15
				7 17 12 24   
				"""
				);
		
		int T = sc.nextInt();
		int[] cal = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int i=2; i<cal.length; i++) {
			cal[i] += cal[i-1];
		}
		
		System.out.println(Arrays.toString(cal));
		
		for(int tc=1; tc<=T; tc++) {
			
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			
			m1--;
			m2--;
			
			int ans = cal[m2] - cal[m1] - d1 + d2 +1;
			
			System.out.println("#"+tc+" "+ans); 
		
		}
	}
}
