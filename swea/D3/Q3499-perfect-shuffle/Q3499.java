package swea;

import java.util.Scanner;

public class Q3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				3
				6
				A B C D E F
				4
				JACK QUEEN KING ACE
				5
				ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA
				"""
				);
		
		int T = sc.nextInt();
		int t = 0;
		while(t++ < T) {
			
			int N = sc.nextInt();
			int end = (N%2) == 0 ? N/2:N/2+1;
			
			String[] names1 = new String[end];
			String[] names2 = new String[N-end];
			
			for(int i=0; i<end; i++) {
				names1[i] = sc.next();
			}
			
			for(int i=0; i<N-end; i++) {
				names2[i] = sc.next();
			}

			System.out.print("#"+t);	

			for(int i=0; i<N; i++) {
				System.out.print(" "+((i%2==0) ? names1[i/2]:names2[i/2]));
			}
			
			System.out.println();
		}
	}
}
