package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Q1983 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				10 2
				87 59 88
				99 94 78
				94 86 86
				99 100 99
				69 76 70
				76 89 96
				98 95 96
				74 69 60
				98 84 67
				85 84 91
				"""
				);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		String scores[] = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"}; 
		double scoreList[] = new double[N];
		double kScore = 0;
		
		for(int i=0; i<N; i++) {
			
			int midterm = sc.nextInt();
			int finalExam = sc.nextInt();
			int assignment = sc.nextInt();
			
			double totalScore = midterm * 0.35 + finalExam * 0.45 + assignment * 0.2;
			scoreList[i] = Math.round(totalScore * 100)/100.0;
			
			if(i == K-1) {
				kScore = scoreList[i];
			}
			
		}
		
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if (scoreList[j] < scoreList[j+1]) {
					double tmp = scoreList[j];
					scoreList[j] = scoreList[j+1];
					scoreList[j+1] = tmp;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if (scoreList[i] == kScore) {
				System.out.println(scores[i/(N/10)]);
			}
		}
		
		
	}
}
