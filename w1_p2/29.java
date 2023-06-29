import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.charAt(0) == '0') {
				int hex = Integer.parseInt(s.substring(2), 16);
				System.out.println(hex);
			}
			else {
				int dec = Integer.parseInt(s);
				String hs = Integer.toHexString(dec);
				System.out.println("0x" + hs.toUpperCase());
			}
		}
		
		
		sc.close();
	}
}