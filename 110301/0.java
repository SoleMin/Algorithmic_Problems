import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		
		String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line == null || line.length() == 0) break;
			
			for (int i=0; i < line.length(); i++) {
				char ch = ' ';
				if (line.charAt(i) != ch) {
					ch = keyboard.charAt(keyboard.indexOf(line.charAt(i)) - 1);
				}
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}