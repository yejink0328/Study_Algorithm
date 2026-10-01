package swea;

import java.util.Scanner;

public class Q1216 {
	static int N;
	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				ABAA
				ACCA
				CBAB
				BCBA
				"""
				);
		
		N = 4;
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			arr[i] = str.toCharArray();			
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, Math.max(maxPendLen('R', i), maxPendLen('C', i)));
		}
		
		System.out.println(max);
	}
	
	public static boolean isP(char[] arrS) {
		for(int i=0; i<arrS.length/2; i++) {
			if(arrS[i] == (arrS[arrS.length-i-1])) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static int maxPendLen(char RC, int C) {
		for(int l=0; l<N; l++) {
			for(int c=N; c>1; c--) {
				for(int k=0; k<N-c+1; k++) {
					char[] test = new char[c];
					for(int i=0; i<c; i++) {
						test[i] = RC == 'R' ? arr[C][i+k] : arr[i+k][C];
					}
					if(isP(test)) {
						return c;
					}
				}
			}			
		}
		
		return 1;
	}
	
}
