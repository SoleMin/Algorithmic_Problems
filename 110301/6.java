import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String keyBoard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./";
		
		while (sc.hasNextLine()) {
			String result = "";
			String s = sc.nextLine();
			String in = s.toUpperCase();
			
			for (int i = 0; i < in.length(); i++) {
				if (in.charAt(i) == ' ') result += " ";
				else
					result += keyBoard.charAt(keyBoard.indexOf(in.charAt(i))-1);
			}
			
			System.out.println(result);
		}
	}
}