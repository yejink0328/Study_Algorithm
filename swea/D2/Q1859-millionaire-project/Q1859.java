package D2;

import java.util.Scanner;

public class Q1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5
				1 1 3 1 2
				"""
				);
		
		int day = sc.nextInt();
		int[] days = new int[day];
		int max = 0;
		int start = 0;
		int end = 0;
		int profitTotal = 0;
		
		for(int i=0; i<day; i++) {
			days[i] = sc.nextInt();
		}
		
		int cnt = 0;
		while(end != day-1) {
			max = 0;
			start = end;
			for(int i=start+cnt; i<day; i++) {
				if(max < days[i]) {
					max = days[i];
					end = i;
				}
			}
			
			for(int j=start+cnt; j<=end; j++) {
				profitTotal += (max - days[j]);
			}
			System.out.println(profitTotal);
			cnt = 1;
		}
	}
}
