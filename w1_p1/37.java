import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()){
			String s = scan.nextLine();
			int word = 0, letter = 0;
			for(int i = 0; i < s.length(); i++){
				if((i == 0 && (s.charAt(i) != ' '&& s.charAt(i) != '\t')) || i > 0 && (s.charAt(i-1)==' ' || s.charAt(i-1) == '\t') && (s.charAt(i) != ' ' && s.charAt(i) != '\t'))
					word++;
				if(s.charAt(i) != '\t' && s.charAt(i) != ' ')
					letter++;
			}
			System.out.println(letter + " " + word);
				
		}
	}
}