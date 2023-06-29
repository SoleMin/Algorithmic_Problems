import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			int spells = 0, words = 0;
			String line = sc.nextLine().trim();
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) != ' ' && line.charAt(i) != '\t') {
					spells++;
				}
				
				if (i != 0 && (line.charAt(i-1) != ' ' && line.charAt(i-1) != '\t') && (line.charAt(i) == ' ' || line.charAt(i) == '\t')) {
					words++;
				}
				
				if (i == line.length() - 1 && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
					words++;
				}
			}
			
			System.out.println(spells + " " + words);
		}
	}
}