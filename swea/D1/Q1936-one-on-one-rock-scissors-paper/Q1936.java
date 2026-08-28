package D1;

import java.util.Scanner;

public class Q1936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				3 1
				"""
				);
		
		int[] rsp = {1, 2, 3};
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a == rsp[b%3]) {
			System.out.println("A"); // 이기거나 -> a가 이길 수 있는 값 == b%3 인덱스의 값
		}else {
			System.out.println("B"); // 지거나
		}
	}
}
