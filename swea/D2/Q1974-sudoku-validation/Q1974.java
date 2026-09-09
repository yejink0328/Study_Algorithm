package D2;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Q1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"""
				7 3 6 4 8 9 2 5 1
				8 5 2 7 3 1 6 9 4
				9 1 4 5 6 2 7 3 8
				4 9 7 2 5 6 8 1 3
				5 6 3 1 8 7 9 4 2
				2 8 1 9 4 3 5 6 7
				6 7 5 3 2 4 1 8 9
				1 4 9 6 7 8 3 2 5
				3 2 8 1 9 5 4 7 6
				"""
				);
		
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		Set<Integer> set3 = new HashSet<>();
		
		int[][] sdk = new int[9][9];
		int[][] sdk2 = new int[9][9];
		
		int num;
		int result = 1;
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				num = sc.nextInt();
				
				sdk[i][j] = sdk2[j][i] = num;

			}
		}

		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				set.add(sdk[i][j]);
				set2.add(sdk2[i][j]);
				set3.add(sdk[(i/3)*3+(j/3)][(i%3)*3+(j%3)]);
				
			}
			
			// 가로, 세로 방향 체크 : 9칸마다 알 수 있음
			if((set.size() != 9) || (set2.size() !=9) || (set3.size() != 9)) {
				result = 0;
				break;
			}
			
			set.clear();
			set2.clear();
			set3.clear();
		}
		
		System.out.println(result);
	}
	
}
