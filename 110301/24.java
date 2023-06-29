import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		String qwerty = "1234567890-=QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./";
		
		while(input.hasNextLine()){
			
			String s = input.nextLine();
			
			for(int i =0;i<s.length(); i++){
				for(int j =0; j<qwerty.length(); j++){
					if(s.charAt(i)==' '){
						System.out.printf(" ");
						break;
					}else if(s.charAt(i) == qwerty.charAt(j)){
						System.out.print(qwerty.charAt(j-1));
					}
				}			
			}
			
			System.out.println();
			
			
			
		}
	}
}