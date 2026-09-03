package D2;

import java.util.Arrays;
import java.util.Scanner;

//수도 요금 경쟁
public class Q1284 {
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
		int feeB;
		if(waterData[4] <= waterData[2]) {
			feeB = waterData[1]; // 0이 되어야 함.
		}else {
			feeB = waterData[1]+waterData[3]*(waterData[4]-waterData[2]);
		}
		
		if(feeA < feeB) {
			System.out.println(feeA);
		}else {
			System.out.println(feeB);
		}
	}
}
