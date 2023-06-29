import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String num, n16;
		int n10;
		
		while(sc.hasNextLine()) {
			num = sc.nextLine();
			
			//16-10: Integer.parseInt()
			if(num.charAt(0)=='0') {
				num = num.substring(2);
				n10 = Integer.parseInt(num, 16);
				System.out.println(n10);
			}
			//10-16: Integer.toHexString() + .toUpperCase()
			else {
				n10 = Integer.parseInt(num);
				n16 = "0x" + Integer.toHexString(n10).toUpperCase();
				System.out.println(n16);
			}
		}
		
		sc.close();
	}
}