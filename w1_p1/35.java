import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(true){
			if (input.hasNextLine() == false)
				break;
			String sentence = input.nextLine();
			int w = 0;
			int c = 0;
			
			for (int i=0; i<sentence.length(); i++) {
				//c 글자수 세기
				if( sentence.charAt(i) != ' ' && sentence.charAt(i) != '\t' )
					c++;
				//w 단어 세기
				if( (i == 0  && (sentence.charAt(i) != ' ' && sentence.charAt(i) != '\t' ))  ||  i>0 &&(sentence.charAt(i-1) == ' ' || sentence.charAt(i-1) == '\t') && (sentence.charAt(i) != ' ' && sentence.charAt(i) != '\t') )
					w++;
			}	
		
			System.out.println(c + " " + w);
		}
		
	}
}