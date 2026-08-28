package D1;

public class Q2027 {
	public static void main(String[] args) {
			
		int cnt = 0;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(cnt == j) {
					System.out.print("#");					
				}else {
					System.out.print("+");
				}
			}
			cnt++;
			System.out.println();
		}
	}
}
