import java.io.*;
import java.util.Scanner;

class Main {	
	public static void main(String[] args) throws Exception {
		String[] strArr = new String[1024];
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String str = input.nextLine();
			strArr = str.split("");
			int words = 0, letters = 0;
			boolean check = false;
			
			for(int i=0; i<str.length(); i++) {
				if(strArr[i].equals(" ") || strArr[i].equals("\t")) {
					if(i > 0 && (strArr[i-1].equals(" ") || strArr[i-1].equals("\t")))
						continue;
					if(check)
						letters++;
				}
				else {
					if(!check)
						check = true;
					if(i == str.length()-1)
						letters++;
					
					words++;
				}
			}
			
			System.out.println(words + " " + letters);
		}
		
		input.close();
	}
}