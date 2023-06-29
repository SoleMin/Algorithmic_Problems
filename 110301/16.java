import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		String lines = "'1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./";
		
		while(scanner.hasNextLine()){
			String input = scanner.nextLine();
			
			for(int i = 0; i < input.length(); i++){
				if(input.charAt(i) == ' '){
					System.out.print(" ");
				}
				else
					System.out.print(lines.charAt(lines.indexOf(input.charAt(i)) - 1));
			}
			System.out.println();
		}
		scanner.close();
	}
}