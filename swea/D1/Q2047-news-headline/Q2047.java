package com.ssafy.ws.step1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 신문 헤드라인
public class Q2047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Character> map = new HashMap<>();
		
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<upperCase.length(); i++) {
			map.put(lowerCase.charAt(i), upperCase.charAt(i));
		}
		
		String inputStr = sc.next();
		
		
		for(int i=0; i<inputStr.length(); i++) {
			if(map.containsKey(inputStr.charAt(i))) {
				System.out.print(map.get(inputStr.charAt(i)));
			}else {
				System.out.print(inputStr.charAt(i));
			}
		}
	}
}
