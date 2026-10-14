package swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q5215_s1 {
	static int N;
	static int[] scores;
	static int[] calories;
	static int limit;

	static int max;
	static int calSum;
	static int score;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(
				new FileInputStream("data/sample_input.txt"));
		
		int T = sc.nextInt();
		N = sc.nextInt();
		scores = new int[N];
		calories = new int[N];
		limit = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			scores[i] = sc.nextInt();
			calories[i] = sc.nextInt();
		}
		
		max = 0;
		calSum = 0;
		score = 0;
	
		combination(0);
		System.out.println(max);
	}
	
	static void combination(int start) {

		for(int i=start; i<N; i++) {
			if(calSum+calories[i] > limit) {
				continue;
			}else {
				calSum += calories[i];
				score += scores[i];
				max = Math.max(score, max);
				combination(i+1);
				score -= scores[i];
				calSum -= calories[i];
			}
		}
		
	}
}
