import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n;
		while(scan.hasNext())
		{
			String input = scan.next();
			if(input.charAt(0) == '0')
				System.out.println(Integer.decode(input));
			else{
				n = Integer.parseInt(input);
				System.out.println("0x" + Integer.toHexString(n).toUpperCase());
			}
		}
	}
}