import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			String str = input.next();
			String result = "";
			
			if(str.charAt(0) == '0') {
				int hex = Integer.parseInt(str.substring(2), 16);
				result = "" + hex;
			}
			else {
				int dec = Integer.parseInt(str);
				String hs = Integer.toHexString(dec);
				result = "0x" + hs.toUpperCase();
			}
			
			System.out.println(result);
		}
	}
}