import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String s = input.nextLine();
			if(s.charAt(0) == '0'){
				int h = Integer.parseInt(s.substring(2), 16);
				System.out.println(h);
			}
			else{
				int d = Integer.parseInt(s);
				String hs = Integer.toHexString(d);
				System.out.println("0x"+hs.toUpperCase());
			}
		}
		
	}
}