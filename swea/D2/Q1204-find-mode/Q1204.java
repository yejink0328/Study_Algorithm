package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Q1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5 5 5 8 4 4 4
				"""
				);
		
		int[] modArr = new int[10];
		
		for(int i=0; i<7; i++) {
			int score = sc.nextInt();
			modArr[score-1]++;
			System.out.println(Arrays.toString(modArr));
		}
		
		int max = 0;
		int mod = 0;
		for(int i=0; i<10; i++) {
			if(max <= modArr[i]) {
				max = modArr[i];
				if(mod < i+1) {
					mod = i+1;
				}
			}
		}
		System.out.println(mod);
	}
}
