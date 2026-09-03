package D2;

import java.util.Arrays;
import java.util.Scanner;

//수도 요금 경쟁
public class Q1284_s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
					9 100 20 3 10
				""");
		
		int[] waterData = new int[5];
		for(int i=0; i<waterData.length; i++) {
			waterData[i] = sc.nextInt();
		}
		
		//A사 요금계산(월간)
		int feeA = waterData[0] * waterData[4];
		
		//B사 요금계산(월간)
		int feeB = waterData[1]+waterData[3]*Math.max(0, waterData[4]-waterData[2]);
		
		System.out.println(Math.min(feeA, feeB));
	}
}
