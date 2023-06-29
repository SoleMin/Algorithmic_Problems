import java.io.*;

import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String testSentence = null;
		int charCount = 0, emptyCount = 0;
		char[] sentence = new char[1024];
		
		while(input.hasNextLine()){
			testSentence = input.nextLine();
		
		sentence = testSentence.toCharArray();
		
		for(int i = 0; i < sentence.length; i++){
			if((i == 0 && (sentence[0]!='\n' && sentence[0] != '\t' && sentence[0] != ' ' && sentence[0] != '\r'))
				 || (i > 0 && (sentence[i-1] == '\n' || sentence[i-1] == '\t' || sentence[i-1] == ' ' || sentence[i-1] == '\r')
				&& (sentence[i] != '\n' && sentence[i] != '\t' && sentence[i] != ' '  && sentence[i] != '\r'))){
				emptyCount++;
			}
			if(sentence[i] != '\n' && sentence[i] !='\t' && sentence[i] != ' ' && sentence[i] != '\r'){
				charCount++;
			}
		
		}
		
		System.out.println(charCount + " " + emptyCount);
			emptyCount = 0;
			charCount = 0;
		}
	}
}