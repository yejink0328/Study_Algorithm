package swea;

import java.util.Scanner;

public class Q7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				2
				6 6
				6 4
				"""
				);
		
		int T = sc.nextInt();
		int t = 0;

		while(t++<T) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] nums = new int[N+M+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					nums[i+j]++;
				}
			}
			
			int max = 0;
			for(int i=0; i<nums.length; i++) {
				if(max <= nums[i]) {
					max = nums[i];
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i=0; i<nums.length; i++) {
				if(nums[i] == max) 
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}
}
