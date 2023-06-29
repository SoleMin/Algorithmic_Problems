import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String index = "1234567890-=QWERTYUIOP[]||ASDFGHJKL;'ZXCVBNM,./'";
		while(input.hasNextLine()){
			String s = input.nextLine();
			int len = s.length();
			char[] str = new char[len];
			
			for(int i = 0; i < len; i++){
				if(s.charAt(i) == ' ')
					str[i] = ' ';
				else
					str[i] = index.charAt(index.indexOf(s.charAt(i)) - 1);
			}
			for(int i = 0; i < len; i++)
				System.out.print(str[i]);
			System.out.println();
		}
		input.close();
	}
}