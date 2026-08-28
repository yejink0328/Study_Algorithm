package D1;

import java.util.Scanner;

public class Q2025 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        System.out.println(rSum(N));
	}
    
    public static int rSum(int num) {
    	if(num <= 0) {
        return 0;
        }else {
            return rSum(num-1)+num;
        }
    }
}
