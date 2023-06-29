import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String s = input.nextLine();
			int wold =0, letter = 0;
			
			/**77
			3)공백 다음으로 문자 나온 경우**/			
			
			for(int i =0; i<s.length();i++) {
				if(s.charAt(i) != ' ' && s.charAt(i) != '\t') {
					letter ++;
				}
				if(i==0 && (s.charAt(0) != ' '&& s.charAt(0) != '\t')) {
					wold++;
				}
				if(i>0 && (s.charAt(i-1) == ' ' || s.charAt(i-1) =='\t') && (s.charAt(i) != ' ' && s.charAt(i) !='\t')){
					wold++;
				}
			}
			
			System.out.println(letter + " "+ wold);
		}
	}
}