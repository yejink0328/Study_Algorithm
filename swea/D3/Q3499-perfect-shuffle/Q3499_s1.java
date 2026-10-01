package swea;

import java.util.Scanner;

public class Q3499_s1 {
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
			
			String[] names = new String[N];
			
			for(int i=0; i<N; i++) {
				names[i] = sc.next();
			}
			
			System.out.print("#"+t);	

			for(int i=0; i<N; i++) {
				System.out.print(" "+(names[(i/2)+(N/2+(N%2))*(i%2)]));
			}
			
			System.out.println();
		}
	}
}
