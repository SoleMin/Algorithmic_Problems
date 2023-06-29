import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws Exception {
		
		String qwerty = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./'";
		Scanner input = new Scanner(System.in);
		String temp;
		char space = ' ';
		
		while (input.hasNextLine()) {
			
			temp = input.nextLine();
			
			for (int i = 0; i < temp.length(); i++){
				
				if (temp.charAt(i) == space)
					System.out.print(" ");
				else
					System.out.print(qwerty.charAt(qwerty.indexOf(temp.charAt(i)) - 1));
			}
			
			//if (!input.hasNextLine())
				System.out.println();
			
			
		}
			
		
		
		
	}
}