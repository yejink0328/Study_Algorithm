package com.ssafy.ws.step1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 알파벳을 숫자로 변환
public class Q2050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> map = new HashMap<>();
		
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), i+1);
		}
		
		String inputStr = sc.next();
		
		for(int i=0; i<inputStr.length(); i++) {
			System.out.print(map.get(inputStr.charAt(i))+" ");
			
		}
	}
}
