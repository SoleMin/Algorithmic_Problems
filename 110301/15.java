import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input= new Scanner(System.in);
		String str, key;
		
		int lengt;
		
		key= "'1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		while(input.hasNext()) {
			str = input.nextLine();
			lengt = str.length();
			for(int i=0; i<lengt; i++){
				if(str.charAt(i)==' ')
					System.out.print(" ");
				else
					System.out.print(key.charAt(key.indexOf(str.charAt(i))-1));
			}
			System.out.println();
		}
	}
}