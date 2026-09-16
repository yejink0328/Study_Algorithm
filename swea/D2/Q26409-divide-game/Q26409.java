package IM;

import java.util.Scanner;

public class Q26409 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				2
				3
				3 5 3
				4
				3 7 5 8
				""");
		
		int tc = 0, T = sc.nextInt();
		
		while(tc++ < T) {
			
			int N = sc.nextInt();
			int[] cards = new int[N];
			
			for(int i=0; i<N; i++) {
				cards[i] = sc.nextInt();
			}
			
			int sum = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sum += cards[i] % cards[j]; 
				}
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
}
