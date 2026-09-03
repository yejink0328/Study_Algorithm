package D2;

import java.util.Scanner;

public class Q1940 {
	public static void main(String[] args) {
		// 현재 속도 유지(0)
		// 가속(1) -> +가속도
		// 감속(2) -> -가속도
		// 가속도 1, 2
		// 현재속도 < 감속할 속도 -> 0
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int currentSpeed = 0;
		int distance = 0;
		
		for(int i=0; i<cnt; i++) {
			int speed = sc.nextInt();
			if(speed==1) {
				int accel = sc.nextInt();				
				currentSpeed += accel;
				
			}else if(speed==2){
				int decel = sc.nextInt();
				if(currentSpeed < decel) {
					currentSpeed = 0;
				}else {
					currentSpeed -= decel;
				}
			}
			
			distance += currentSpeed;
		}
		
		System.out.println(distance);
	}
}
