package D2;

public class Q1945 {
	public static void main(String[] args) {
		
		int[] primeNumbers = {2, 3, 5, 7, 11};
		
		for(int i : primeNumbers) {
			System.out.print(rDivid(8575, i)+" ");
			
		}
	}
	
	public static int rDivid(int num, int i) {
		if(num%i != 0) {
			return 0;
		}else {
			return rDivid(num/i, i)+1;
		}
	} 

//	public static int rDivid(int num, int i) {
//		if(num == 1) {
//			return 0;
//		}else {
//			if (num%i == 0) {
//				return rDivid(num/i, i) + 1;								
//			}else {
//				return rDivid(num, i+1);
//			}
//		}
//	} 
}
