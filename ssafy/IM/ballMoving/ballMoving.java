package D2;

import java.util.Scanner;

public class ballMoving {
	
	public static int size;
	public static int field[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5
				14 93 67 38 72
				49 26 81 55 17
				63 44 29 76 88
				31 95 12 58 83
				42 69 35 91 24
				"""
				);
		
		size = sc.nextInt();
		field = new int[size][size];
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				field[i][j] = sc.nextInt();
			}
		}
		
		int R, C, ans = 0;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {

				ans = Math.max(ans, MoveCnt(i, j));
				
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static int MoveCnt(int R, int C) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int cnt = 1;
		
		while(true) {
			int nextR = -1;
			int nextC = -1;
			int min = field[R][C];
			
			for(int d=0; d<4; d++) {
				int nr = R + dr[d];
				int nc = C + dc[d];
				
				if(nr >= 0 && nr < size && nc >= 0 && nc < size) {
					if(field[nr][nc] < min) {
						min = field[nr][nc];
						nextR = nr;
						nextC = nc;
					}
				}
				
			} // 사방탐색 1회 종료
			
			if(field[R][C] == min) {
				break;
			}
			cnt++;
			R = nextR;
			C = nextC;
			
		}
		
		return cnt;
	}
}
