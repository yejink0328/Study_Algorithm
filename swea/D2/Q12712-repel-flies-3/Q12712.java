package D3;

import java.util.Scanner;

public class Q12712 {
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
		int killSize = sc.nextInt();
		int R = 0;
		int C = 0;
		int[][] map = new int[size][size];
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] dr = {0, 0, -1, 1};
		int[] dc = {-1, 1, 0, 0};
		
		int[] dr2 = {-1, 1, -1, 1};
		int[] dc2 = {-1, 1, 1, -1};
		
		int idxR, idxC, max = 0, sum = 0, sum2 = 0;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				
				sum += map[i][j];
				sum2 += map[i][j];
				for(int l=1; l<killSize; l++) {
					
					for(int k=0; k<4; k++) {
						idxR = i + dr[k]*l;
						idxC = j + dc[k]*l;

						if(idxR >= 0 && idxR < size && idxC >= 0 && idxC < size) {
							sum += map[idxR][idxC];
						}
					}
					
					for(int k=0; k<4; k++) {
						idxR = i + dr2[k]*l;
						idxC = j + dc2[k]*l;
						
						if(idxR >= 0 && idxR < size && idxC >= 0 && idxC < size) {
							sum2 += map[idxR][idxC];
						}
					}					
				}
				
				sum = Math.max(sum, sum2);
				
				if(max < sum) {
					max = sum;
					R = i;
					C = j;
				}
				sum = 0;
				sum2 = 0;
			}
		} 
			
		System.out.println(max+" R : "+R+" C : "+C);	
	}
}
