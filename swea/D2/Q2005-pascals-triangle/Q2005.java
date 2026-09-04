package D2;

import java.util.Scanner;

public class Q2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				4
				""");
		
		int N = sc.nextInt();
		int C;
		
		for(int i=0; i<N; i++) {

			for(int k=0; k<=i; k++) {
				C = factorial(i)/(factorial(k)*factorial(i-k));
				System.out.print(C+" ");
			}
			System.out.println();
		}
	}
	
	public static int factorial(int num) {
		if(num == 0) {
			return 1;
		}else {
			return factorial(num-1)*num;
		}
	}
}
