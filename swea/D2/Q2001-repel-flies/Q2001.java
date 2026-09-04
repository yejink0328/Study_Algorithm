package D2;

import java.util.Scanner;

public class Q2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				6 3
				29 21 26 9 5 8
				21 19 8 0 21 19
				9 24 2 11 4 24
				19 29 1 0 21 19
				10 29 6 18 4 3
				29 11 15 3 3 29
				"""
				);
		
		int size = sc.nextInt();
		int toolSize = sc.nextInt();
		int[][] fliesArray = new int[size][size];
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				fliesArray[i][j] = sc.nextInt();
			}
		}
		
		int cnt = size-toolSize+1;
		int maxSum = 0;
		int sum;
		
		for(int jStep=0; jStep<cnt; jStep++) {
			for(int iStep=0; iStep<cnt; iStep++) {
				
				sum = 0;
				for(int i=iStep; i<toolSize+iStep; i++) {
					for(int j=jStep; j<toolSize+jStep; j++) {
						sum += fliesArray[i][j];
						if(maxSum < sum) {
							maxSum = sum;
						}
					}
				}
			}
		}
		System.out.println("maxSum : "+maxSum);
	}
}
