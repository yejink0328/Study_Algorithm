package D2;

import java.util.Base64;
import java.util.Scanner;

public class Q1928 {
	static String input = "TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u";
	public static void main(String[] args) {
		
		byte[] decodedBytes = Base64.getDecoder().decode(input);
		String decodedStr = new String(decodedBytes);
		
		System.out.println(decodedStr);
	}
	
}
