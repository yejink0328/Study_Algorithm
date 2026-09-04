package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Q1966 {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5
				1 4 7 8 0
				"""
				);
		
		int[] nums = new int[sc.nextInt()];
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i=nums.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
