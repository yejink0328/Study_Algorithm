package IM;

import java.util.Arrays;
import java.util.Scanner;

public class Q26059 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5 1 3
				1 1 1 2 5
				"""
				);
		
		int N = sc.nextInt();
		int lo = sc.nextInt();
		int hi = sc.nextInt();
		
		int score = 10000;
		int[] fruits = new int[score+1];
		
		for(int i=0; i<N; i++) {
			fruits[sc.nextInt()]++;
		}
	
		for(int i=2; i<=score; i++) {
			fruits[i] += fruits[i-1];
		}

		System.out.println(Arrays.toString(fruits));
		int cnt2, cnt3, diff = Integer.MAX_VALUE;
		
		for(int i=1; i<=score-2; i++) {
			if(fruits[i]<lo || fruits[i]>hi) continue;
			for(int j=i+1; j<=score-1; j++) {
				cnt2 = fruits[j]-fruits[i];
				cnt3 = fruits[score] - fruits[j];
				
				if(cnt2<lo || cnt2>hi || cnt3<lo || cnt3>hi) continue;
				
				diff = Math.min(diff, 
					Math.max(fruits[i], Math.max(cnt2, cnt3)) - Math.min(fruits[i], Math.min(cnt2, cnt3)));
			}
		}
		
		System.out.println(diff == Integer.MAX_VALUE ? -1 : diff);
	}
}
