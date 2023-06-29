import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		//keyboard.charAt(0);
		char[] key = keyboard.toCharArray();
		
		while(scan.hasNextLine()){
			String wert = scan.nextLine();
			if(wert.equals("")) break;
			char[] newwert = new char[wert.length()];
			char[] abc = wert.toCharArray();
			for(int i = 0 ; i < wert.length(); i++){
				if(abc[i] == '`' || abc[i] == 'Q' || abc[i] == 'A' || abc[i] == 'Z'){
					break;
				} else if(abc[i] == ' ') {
					 newwert[i] = ' ';
				 } else{
					newwert[i] = key[keyboard.indexOf(abc[i])-1];
				}
			}
			System.out.println(newwert);
		}
		
	}
}