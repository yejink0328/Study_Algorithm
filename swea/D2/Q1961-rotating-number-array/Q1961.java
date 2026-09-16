package D2;

import java.util.Scanner;

public class Q1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				3
				1 2 3
				4 5 6
				7 8 9
				""");
		
		int N = sc.nextInt();
		int[][] oriN = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				oriN[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(oriN[N-j-1][i]);
			}
			
			System.out.print(" ");
			
			for(int j=0; j<N; j++) {
				System.out.print(oriN[N-i-1][N-j-1]);
			}

			System.out.print(" ");
			
			for(int j=0; j<N; j++) {
				System.out.print(oriN[j][N-i-1]);
			}			
			System.out.println();
		}
	}
}
