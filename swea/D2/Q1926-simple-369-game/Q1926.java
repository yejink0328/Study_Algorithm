package D2;

import java.util.Scanner;

public class Q1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				369
				"""
				);
		
		int num = sc.nextInt();

		for(int i=1; i<=num; i++) {
			boolean isIn3 = false;
			int n = i;
			while(n!=0) {
				if((n%10)!=0 && (n%10)%3==0) {
					System.out.print('-');
					isIn3 = true;
				}
				n /= 10;
			}
			if(!isIn3){
				System.out.print(i);				
			}
			System.out.print(' ');
		}
		
	}
}
