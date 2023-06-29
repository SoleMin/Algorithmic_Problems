import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String s = input.nextLine();
			int letters = 0, words = 0;
			for(int i=0; i<s.length(); i++){
				if((i == 0 && s.charAt(i) != ' ' && s.charAt(i) != '\t') || i > 0 &&(s.charAt(i-1) == ' ' || s.charAt(i-1) == '\t') && (s.charAt(i) != ' ' && s.charAt(i) != '\t') )
					words++;
				if(s.charAt(i) != ' ' && s.charAt(i) != '\t')
					letters++;
			}
			System.out.println(letters + " " + words);
		}
	}
}