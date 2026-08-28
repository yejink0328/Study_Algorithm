package D1;

import java.util.Scanner;

public class Q2019 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(
				"""
				8
				""");
		int N = sc.nextInt();
		
		for(int i=0; i<=N; i++) {
			System.out.print(rSquare(i)+" ");
		}
	}
	
	public static int rSquare(int num) {
		if(num <= 0) {
			return 1; // 곱셈일 때는 반환값 1 주의
		}else {
			return rSquare(num-1)*2;
		}
	}
}
