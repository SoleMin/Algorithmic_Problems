import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<String> key_seq = new ArrayList<>();
		key_seq.add("`");
		for(int i = 0; i < 9; i++) {
			key_seq.add(String.valueOf((char)('1' + i)));
		}
		key_seq.add("0"); key_seq.add("-"); key_seq.add("="); 
		key_seq.add("Q"); key_seq.add("W"); key_seq.add("E"); key_seq.add("R"); key_seq.add("T"); key_seq.add("Y"); key_seq.add("U"); key_seq.add("I"); key_seq.add("O"); key_seq.add("P"); key_seq.add("["); key_seq.add("]"); key_seq.add("\\"); 
		key_seq.add("A"); key_seq.add("S"); key_seq.add("D"); key_seq.add("F"); key_seq.add("G"); key_seq.add("H"); key_seq.add("J"); key_seq.add("K"); key_seq.add("L"); key_seq.add(";"); key_seq.add("\'"); 
		key_seq.add("Z"); key_seq.add("X"); key_seq.add("C"); key_seq.add("V"); key_seq.add("B"); key_seq.add("N"); key_seq.add("M"); key_seq.add(","); key_seq.add("."); key_seq.add("/");
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			for(int idx = 0; idx < s.length(); idx++) {
				if(s.charAt(idx) == ' ')
					System.out.print(" ");
				else {
					System.out.printf("%s",key_seq.get(key_seq.indexOf(String.valueOf(s.charAt(idx))) - 1));
				}
			}
			System.out.println();
		}
		
	}
	
}