import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./"	;
		
		while(sc.hasNextLine()){
			
			String in = sc.nextLine();
			
			for(int i = 0; i < in.length(); i++){
				for(int j = 0 ; j < keyboard.length(); j++){
					if(in.charAt(i) == ' '){
						System.out.print(" ");
						break;
					}
					else if (in.charAt(i) == 'A' || in.charAt(i) == 'Q' || in.charAt(i) == 'Z'){
						System.out.print(in.charAt(i));
						break;
					}
					else{
						if(in.charAt(i) == keyboard.charAt(j))
							System.out.print(keyboard.charAt(j-1));
						else
							continue;
					}
				}
			}
			System.out.println("");
		}
	}
}