package D2;

import java.util.Scanner;

public class Q21425 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5
				1 2 2
				1 2 3
				1 2 4
				1 2 5
				10 7 1293
				"""
				);
		
		int N = sc.nextInt();
		int nums[] = new int[3];
				
		for(int test_case=1; test_case <= N; test_case++) {
			
			nums[0] = sc.nextInt();
			nums[1] = sc.nextInt();
			nums[2] = sc.nextInt();
			
			System.out.println(rSum(nums));
		}
	}
	
	public static int rSum(int[] nums) {
		int idx = Math.min(nums[0], nums[1]) == nums[0] ? 0 : 1;
		int sum = nums[0] + nums[1];
		if(sum > nums[2]) {
			return 1;
		} else {
			nums[idx] = sum;
			return rSum(nums)+1;
		}
	}
}
