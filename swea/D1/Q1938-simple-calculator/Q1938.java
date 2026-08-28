package D1;

import java.util.Scanner;

public class Q1938 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				8 3
				"""
				);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
	}
}
