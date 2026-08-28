package D1;

import java.util.Scanner;

public class Q2029 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				3
				9 2
				15 6
				369 15
				"""
				);
		
		int T = sc.nextInt();
		for(int i=0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#"+(i+1)+" "+a/b+" "+a%b);
		}
	}
}
