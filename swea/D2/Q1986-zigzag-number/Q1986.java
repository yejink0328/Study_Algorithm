package D2;

import java.util.Scanner;

public class Q1986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				13
				"""
				);
		
		int N = sc.nextInt();
		int ans = 0;
		if(N%2 == 0) {
			ans = (N/2)*(-1);
		}else {
			ans = (N/2)+1;
		}
		
		System.out.println(ans);
	}
}
