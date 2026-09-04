package D2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				1
				3
				A 10
				B 7
				C 5       
				"""
				);
		
		int T = sc.nextInt();
		int N = sc.nextInt();
		
		System.out.println("#"+T);
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String s = sc.next();
			int n = sc.nextInt();
			for(int j=0; j<n; j++) {
				System.out.print(s);
				cnt++;
				if(cnt == 10) {
					cnt = 0;
					System.out.println();
				}
			}
		}
	}
}
