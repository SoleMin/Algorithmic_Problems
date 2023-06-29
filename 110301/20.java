import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		String keyboard="`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		while(scan.hasNextLine()){
			String input=scan.nextLine();
			String decode="";
			for(int i=0;i<input.length();i++){
				if(input.charAt(i)==' ')
					decode+=" ";
				else
					decode+=keyboard.charAt(keyboard.indexOf(input.charAt(i))-1);
			}
			System.out.println(decode);
		}
	}
}