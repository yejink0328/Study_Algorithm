package IM;

import java.util.Arrays;
import java.util.Scanner;

public class nightViewLED {
	static int[] ledArr;
	static int[] oriArr;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				20
				0 0 0 0 1 0 0 1 0 1 0 1 0 1 0 1 1 1 0 0
				"""
				);
		
		N = sc.nextInt()+1;
		
		ledArr = new int[N];
		Arrays.fill(ledArr, 0);
		
		oriArr = new int[N];
		
		for(int i=1; i<N; i++) {
			oriArr[i] = sc.nextInt();
		}
		
		System.out.println(rChange());
	}
	
	public static int findDiff() {
		int cnt = 1;
		for(int i=1; i<N; i++) {
			if(oriArr[i] != ledArr[i]) {
				break;
			}
			cnt++;
		}
		
		return cnt;
	}
	
	public static void switch01(int startN) {
		for(int i=startN; i<N; i+=startN) {
			ledArr[i] = (1-ledArr[i]);
		}
	}
	
	public static int rChange() {
		if(Arrays.equals(ledArr, oriArr)) {
			return 0;
		}else {
			switch01(findDiff());
			return rChange()+1;
		}
	}
}
