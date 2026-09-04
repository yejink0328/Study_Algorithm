package D2;

import java.util.Scanner;

public class Q1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				samsung
				"""
				);
		
		String s = sc.next();
		int ans = 1;
		
		for(int i=0; i*i<s.length(); i++) {
			if(s.charAt(i) != s.charAt(s.length()-i-1)) {
				ans = 0;
				break;
			}
		}
		System.out.println(ans);
	}
}
