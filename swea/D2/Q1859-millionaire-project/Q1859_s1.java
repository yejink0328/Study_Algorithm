package D2;

import java.util.Scanner;

public class Q1859_s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				3
				3 5 9
				"""
				);
		
		int day = sc.nextInt();
		int[] days = new int[day];
		int profitTotal = 0;
		
		for(int i=day-1; i>=0; i--) {
			days[i] = sc.nextInt();
		}

		int max = days[0];
		for(int i=1; i<day; i++) {
			if(max < days[i]) {
				max = days[i];
			}else {
				profitTotal += (max - days[i]);				
			}
		}
		
		System.out.println(profitTotal);
	}
}
