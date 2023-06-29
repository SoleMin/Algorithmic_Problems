import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			int words = 0;
			int letters = 0;
			String s = in.nextLine();
			for(int i = 0; i < s.length(); i++){
				if(i == s.length() -1){
					if(s.charAt(i) != ' ' && s.charAt(i) != '\t'){
						letters++;
						words++;
					}
					break;
				}
				if((s.charAt(i) != ' ' && s.charAt(i) != '\t') && (s.charAt(i+1) == '\t' || s.charAt(i+1) == ' ')){
					words++;
				}
				if(s.charAt(i) != '\t' && s.charAt(i) != ' '){
					letters++;
				} 
			}
			System.out.println(letters + " " + words);
		}
	}
}