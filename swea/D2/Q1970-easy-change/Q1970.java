package D2;

import java.util.Scanner;

public class Q1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				32850   
				"""
				);
		//160
		
		int N = sc.nextInt();
		int maxMoney = 50000;
		int divideValue = 5;
		
		rChange(N, maxMoney, divideValue);
	}
	
	public static int rChange(int N, int maxMoney, int divideValue) {
		if(maxMoney >= 10) {
			System.out.print(N/maxMoney+" ");
			return rChange(N %= maxMoney, maxMoney /= divideValue, divideValue == 2 ? 5 : 2);
		}else {
			return 0;
		}
	}
}
