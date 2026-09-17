package D3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1209 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("data/Q1209_input.txt"));
		
		for(int t=1; t<=1; t++) {
			int T = sc.nextInt();
			int N = 100;
			
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt(); 
				}
			}
			
			int sumR = 0, sumC=0, sumD1=0, sumD2=0, max = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					sumR += arr[i][j];
					sumC += arr[j][i];
				}

				sumD1 += arr[i][i];
				sumD2 += arr[i][N-i-1];
				
				max = Math.max(max, Math.max(sumR, sumC));
				sumR = 0;
				sumC = 0;
			}
			
			max = Math.max(max, Math.max(sumD1, sumD2));

			System.out.println("#"+T+" "+max);
		}
	}
}
