package D2;

import java.util.Scanner;

public class Q1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				3 
				3 17 1 39
				8 22 5 10
				6 53 2 12   
				"""
				);
		
		int T = sc.nextInt(), t = 0;
		while(t++<T) {
			
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			
			int ans = (h1+h2)*60+m1+m2;
			int h = (ans/60)%12 + (1-Math.min((ans/60)/12, 1))*12;
            int m = ans%60;
			
			System.out.println("#"+t+" "+h+" "+m);
			
			System.out.println((ans/60)/12);
		}
		
	}
}
