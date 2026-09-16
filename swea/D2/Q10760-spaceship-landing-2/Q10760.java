package IM;

import java.util.Scanner;

public class Q10760 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5 8
				8 7 2 5 2 4 3 1 
				7 4 2 3 9 3 5 1 
				5 7 6 2 2 7 9 6 
				9 8 7 6 2 1 9 4 
				1 9 4 9 2 3 5 2  
				"""
				);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] dr = {-1, 1, 0, 0, -1, 1, 1, -1};
		int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				int cnt = 0;
				for(int d=0; d<8; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr >= 0 && nr < N && nc >=0 && nc < M) {
						if(map[nr][nc] < map[i][j]) {
							cnt++;
						}
					}
					
				} //8방탐색
				
				if(cnt >= 4) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
