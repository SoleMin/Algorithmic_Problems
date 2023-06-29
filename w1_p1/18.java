import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			int letters = 0, words = 0;
			for (int i=0; i<input.length(); i++) {
				if ((i==0 && (input.charAt(i) != ' ' && input.charAt(i) != '\t')) || i>0 && (input.charAt(i-1)==' ' || input.charAt(i-1)=='\t') && (input.charAt(i) != ' ' && input.charAt(i) != '\t'))
					words++;
				if (input.charAt(i) != '\t' && input.charAt(i) != ' ')
					letters++;
			}
			System.out.println(letters + " " + words);
		}
	}
}