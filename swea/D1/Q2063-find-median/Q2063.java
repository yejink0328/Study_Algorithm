package com.ssafy.ws.step1;

import java.util.Scanner;

// 중간값 찾기
public class Q2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] nums = new int[T];
		
		for(int i=0; i<T; i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i=T-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		System.out.println(nums[T/2]);
	}
}
