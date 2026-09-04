package D2;

import java.util.Scanner;

public class Q1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5 3
				3 6 -7 5 4
				1 5 3
				"""
				);
		
		//값 세팅
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] NM = {N, M};
		
		int[][] nmlist = new int[2][];
		
		for(int i=0; i<2; i++) {
			nmlist[i] = new int[NM[i]];
			for(int j=0; j<nmlist[i].length; j++) {
				nmlist[i][j] = sc.nextInt();
			}
		}
		
		// 전체 이동 반복횟수
		int cnt = Math.abs(N-M)+1;
		
		int nm = N>M ? 0 : 1;
		
		int max = 0;
		for(int i=0; i<cnt; i++) {
			int sum = 0;
			for(int j=0; j<nmlist[1-nm].length; j++) {
				sum += nmlist[1-nm][j]*nmlist[nm][i+j];
			}
			max = sum > max ? sum : max;
		}
		System.out.println(max);
	}
}
