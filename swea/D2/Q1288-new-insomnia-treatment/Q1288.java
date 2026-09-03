package D2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1288 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				1295
				"""
				);
		
		int N = sc.nextInt();
		Set<Integer> set = new HashSet<>();

		int cnt = 0;
		while(set.size() != 10) {
			cnt++;
			rSheepCount(set, N*cnt);
		}
		System.out.println(N*cnt);
		//cnt가 아니라 N*cnt.... 문제 너무 헷갈리게 설명해놨다.
		
	}
	
	public static int rSheepCount(Set<Integer> set, int num) {
		if(num == 0) {
			return 0;
		}else {
			set.add(num%10);
			
			return rSheepCount(set, num/10);
		}
	}
}
