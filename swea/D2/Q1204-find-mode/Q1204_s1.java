package D2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1204_s1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				5 5 5 8 4 4 4
				"""
				);
		
		//제출 시 테스트 케이스마다 map 초기화 해야 함
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<7; i++) {
			int score = sc.nextInt();
			if(null==map.get(score)) {
				map.put(score, 1);				
			}else {
				map.put(score, map.get(score)+1);
			}
		}
		
		int mod = 0;
		int max = 0;
		for(Integer k : map.keySet()) {
			if(max <= map.get(k) && mod < k) {
				max = map.get(k);
				mod = k;				
			}
			System.out.println(k +" / "+ map.get(k));
		}
		
		System.out.println(mod);
	}
}
