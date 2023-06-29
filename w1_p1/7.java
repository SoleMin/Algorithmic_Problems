import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String s = input.nextLine();
			int letters = 0, words = 0;
			for(int i=0; i<s.length(); i++) {
				if(i != 0) {
					if(isBlank(s.charAt(i-1)) && !isBlank(s.charAt(i))) {words++;}
				}
				else {
					if(!isBlank(s.charAt(i))) {words++;}
				}
				
				if(!isBlank(s.charAt(i)))
					letters++;
			}
			
			System.out.println(letters + " " + words);
		}
		input.close();
	}
	
	public static boolean isBlank(int c) {
		if(c == ' ')
			return true;
		if(c == '\t')
			return true;
		return false;
	}
}