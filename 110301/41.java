import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		char[] keyboard = {'1','2','3','4','5','6','7','8','9','0','-','=',
											 'Q','W','E','R','T','Y','U','I','O','P','[',']',
											 'A','S','D','F','G','H','J','K','L',';','\'',
											 'Z','X','C','V','B','N','M',',','.','/'};
		
		while(input.hasNextLine()){	
			
			String s = input.nextLine();
			char[] before = s.toCharArray();	
			char[] after = new char[before.length];
			
			for(int i = 0; i<before.length; i++){
				for(int j = 0; j<keyboard.length; j++){
					if(before[i] == keyboard[j])
						after[i] = keyboard[j-1];
					else if(before[i] == ' ')
						after[i] = ' ';
				}
			}
			
			System.out.println(String.valueOf(after));
		}
	}
}