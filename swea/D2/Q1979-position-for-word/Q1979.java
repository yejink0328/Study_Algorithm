package D2;

import java.util.Scanner;

public class Q1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5 3
				0 0 1 1 1
				1 1 1 1 0
				0 0 1 0 0
				0 1 1 1 1
				1 1 1 0 1
				"""
				);
		
		int ans = 0;
		int size = sc.nextInt();
		int wordSize = sc.nextInt();
		
		int[][] map = new int[size][size];
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		
		//가로방향 체크
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[i][j] == 0) {
					if(cnt == wordSize) {
						ans++;
					}
					cnt = 0;
				}else {
					cnt++;
				}
			}
			
			if(cnt == wordSize) {
				ans++;
			}
			cnt = 0;
		}
		
		//세로방향 체크
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[j][i] == 0) {
					if(cnt == wordSize) {
						ans++;
					}
					cnt = 0;
				}else {
					cnt++;
				}
			}
			
			if(cnt == wordSize) {
				ans++;
			}
			cnt = 0;
		}
		
		System.out.println(ans);
	}
}
