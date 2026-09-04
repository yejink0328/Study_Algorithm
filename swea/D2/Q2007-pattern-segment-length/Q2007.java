package D2;

import java.util.Scanner;

public class Q2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				MMMMMMMMMOMMMMMMMMMOMMMMMMMMMO
				"""
				);
		
		String s = sc.next();
		StringBuilder sb1 = new StringBuilder();
		String s2;
		
		for(int i=1; i<=10; i++) {
			for(int j=0; j<30/i; j++) {
				sb1.append(s.substring(0, i));
			}
			s2 = s.substring(0, (30/i)*i);
			if(s2.equals(sb1.toString())) {
				System.out.println(i);
				break;
			}
			sb1.setLength(0);
		}
	}	
}
