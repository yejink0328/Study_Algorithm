package swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Q5215 {
	static int N;
	static int[][] arr;
	static int limit;

	static boolean[] selected;
	static int max = 0;
	static int kal_sum = 0;
	static int score = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(
				new FileInputStream("data/sample_input.txt"));
		
		int T = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][2];
		selected = new boolean[N];
		limit = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
	
		combination(0, N);
		System.out.println(max);
	}
	
	static void combination(int start, int r) {
		if (r==0) {
			return;
		}
		
		for(int i=start; i<N; i++) {
			selected[i] = false;
			combination(i+1, r-1);
			selected[i] = true;
		}
		
		for(int i=0; i<N; i++) {
			if(selected[i]) {
				kal_sum += arr[i][1];
				score += arr[i][0];
			}
		}
		
		max = kal_sum <= limit ? Math.max(max, score) : max;
		
		kal_sum = 0;
		score = 0;
	}
}
