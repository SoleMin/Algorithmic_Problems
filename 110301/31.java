import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		// 키보드 : 숫자, 스페이스, 대문자(Q, A, Z 제외), (구두기호 역따옴표, 단어가 붙어있는 키는 제외).
		ArrayList<Character> li1 = new ArrayList<Character>(Arrays.asList('`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='));
		ArrayList<Character> li2 = new ArrayList<Character>(Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'));
		ArrayList<Character> li3 = new ArrayList<Character>(Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\''));
		ArrayList<Character> li4 = new ArrayList<Character>(Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'));
		
		while(scan.hasNextLine()) {
			String s1 = scan.nextLine();
			StringBuffer s2 = new StringBuffer();
			for(int i=0; i<s1.length(); i++) {
				char c = s1.charAt(i);
				if(c == 32) {
					s2.append(" ");
					continue;
				}
				if(li1.contains(c)) s2.append(li1.get(li1.indexOf(c) - 1));
				else if(li2.contains(c)) s2.append(li2.get(li2.indexOf(c) - 1));
				else if(li3.contains(c)) s2.append(li3.get(li3.indexOf(c) - 1));
				else if(li4.contains(c)) s2.append(li4.get(li4.indexOf(c) - 1));
			}
		
			System.out.println(s2);
		}
	}
}