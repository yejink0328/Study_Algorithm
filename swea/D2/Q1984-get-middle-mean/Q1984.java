package D2;

import java.util.Scanner;

public class Q1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int max = 0;
            int min = Integer.MAX_VALUE;
            int n = 0;
            int sum = 0;
            
            for(int i=0; i<10; i++) {
            	n = sc.nextInt();
                
                if(n > max) {
                	max = n;
                }
                
                if(n < min) {
                	min = n;
                }
                
                sum += n;
            }
            
            sum -= max;
            sum -= min;
            
            System.out.printf("#%d %.0f %n", test_case, sum/8.0);

		}
	}
}
