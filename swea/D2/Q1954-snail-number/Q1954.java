package D2;

import java.util.Scanner;

public class Q1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				4
				""");
		
		int N = sc.nextInt();
		int[][] snailArr = new int[N][N];
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		int r = 0, c = 0;
		int cnt = 1;
		int d = 0;
		
		for(int k=0; k<N*N; k++) {
			snailArr[r][c] = cnt;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if((nr >= 0) && (nr<N) && (nc >=0) && (nc<N) && (snailArr[nr][nc] == 0)){
				r = nr;
				c = nc;
			} else {
				d = (d+1)%4;
				r = r + dr[d];
				c = c + dc[d];
			}
			cnt++;
			
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(snailArr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
