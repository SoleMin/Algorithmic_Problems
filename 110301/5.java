import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
		String s = input.nextLine();
		
		String str = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./'";
		
		String temp[] = str.split("");
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < str.length(); j++) {
				if(s.charAt(i) == temp[j].charAt(0)) {
					System.out.print(temp[j - 1]);
					break;
				}
				else if(s.charAt(i) == ' ') {
					System.out.print(" ");
					break;
				}
			}
		}
			System.out.println();
		}
		input.close();
	}
}