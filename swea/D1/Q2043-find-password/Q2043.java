package D1;

import java.util.Scanner;

public class Q2043 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				100 800
				"""
				);
		
		int P = sc.nextInt();
		int K = sc.nextInt();
		
			if(P-K > 0) {
				System.out.println(P-K+1);		
			
			}else if(P-K < 0) {
				System.out.println(999+P-K+1);
			}else {
				System.out.println(0);
			}
	}
}
