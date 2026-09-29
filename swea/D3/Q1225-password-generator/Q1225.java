package swea;

import java.util.Scanner;

public class Q1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				9550 9556 9550 9553 9558 9551 9551 9551
				"""
				);
		
		int N = 8;
		int[] password = new int[N];
		for(int i=0; i<N; i++) {
			password[i] = sc.nextInt();
		}
		
		int pointer = 0;
		int minus = 1;
		while(true) {
			password[pointer]-=minus;
			
			if(password[pointer] <= 0) {
				password[pointer] = 0;
				break;
			}
			
			pointer = (pointer+1)%N;
			minus = ((minus+1)%6) == 0 ? 1:((minus+1)%6);
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(password[((pointer+1)+i)%N]+" ");
		}
		
	}
}
