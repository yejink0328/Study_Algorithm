package D2;

import java.util.Scanner;

public class blindspotOfGuard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				1
				5
				0 0 0 1 0
				1 0 1 1 0
				0 0 1 0 2
				1 0 0 0 0
				1 1 1 1 0
				"""
				);
		
		int tc = sc.nextInt();
		
		for(int t=0; t<tc; t++) {
			
			int size = sc.nextInt();
			int[][] rooms = new int[size][size];
			int sum = size*size;
			int R = 0;
			int C = 0;
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					rooms[i][j] = sc.nextInt();
					
					if(rooms[i][j] == 2) {
						R = i;
						C = j;
						sum++;
					}
					sum -= rooms[i][j];
				}
			}
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
	        for(int i=0; i<4; i++) {
	        	for(int j=1; j<size; j++) {
	           		int idxR = R+dr[i]*j;
	           		int idxC = C+dc[i]*j;
	                
	           		if(idxR >= 0 && idxR <size && idxC >= 0 && idxC <size) {
	           			if(rooms[idxR][idxC] == 0) {
	           				sum -= 1;                    
	           			}else {
	           				break;
	           			}
	                }
	            }
	        }
			
			System.out.println(sum);
			
		}
	}
}
