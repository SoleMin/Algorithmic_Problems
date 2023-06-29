import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int word = 0;
		int num = 0;
		while(scan.hasNextLine()) {
			word = 0;
			num = 0;
			String input = scan.nextLine();
			for(int i = 0; i < input.length(); i++) {
				if((input.charAt(i)) != ' ' && (input.charAt(i) != '\t')) {
					num++;
				}
				if((i == 0 && (input.charAt(i) != ' ' && input.charAt(i) != '\t')) || (input.charAt(i) != ' ' && input.charAt(i) != '\t' && (input.charAt(i-1) == ' ' || input.charAt(i-1) == '\t'))) {
					word++;
				}
			}
			System.out.println(num+" "+word);
		}
	}
}