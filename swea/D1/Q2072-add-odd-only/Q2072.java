package D1;

import java.util.Scanner;

// 홀수만 더하기
public class Q2072 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++) {
			int ans = 0;
			for(int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				ans += (num%2 != 0) ? num : 0;
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
