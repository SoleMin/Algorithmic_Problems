import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		while(scan.hasNextLine()){
			String input=scan.nextLine();
			if(input.charAt(0)=='0'){
				int hex=Integer.parseInt(input.substring(2),16);
				System.out.println(hex);
			}else{
				int dec=Integer.parseInt(input);
				String hs=Integer.toHexString(dec);
				System.out.println("0x"+hs.toUpperCase());
			}
		}
	}
}