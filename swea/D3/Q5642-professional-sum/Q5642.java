package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Q5642 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5
				1 3 -8 18 -8
				"""
				);
		
		int N = sc.nextInt()+1;
		int nums[] = new int[N];
		
		for(int i=1; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i=1; i<N; i++) {
			nums[i] += nums[i-1]; 
		}
		
		int max = 0;
		
		for(int i=1; i<N; i++) {
			for(int j=i; j<N; j++) {
				max = Math.max(max, nums[j]-nums[j-i]);
			}
		}
		
		System.out.println(max);
	}
}
