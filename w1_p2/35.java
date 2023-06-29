import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String s = input.nextLine();
			if(s.charAt(0)=='0'){
				int n = Integer.parseInt(s.substring(2),16);
				System.out.println(n);
			}else{
				int m =Integer.parseInt(s);
				String s2 =Integer.toHexString(m);
				System.out.println("0x"+s2.toUpperCase());
			}
		}
	}
}