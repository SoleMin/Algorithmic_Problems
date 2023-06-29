import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		int w=0;
		int c=0;
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String s = input.nextLine();
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)!=' '&&s.charAt(i)!='	')
					c++;
				if(i==0 && s.charAt(i)!=' ' && s.charAt(i)!='\t' || i!=0&& (s.charAt(i)!=' ' &&s.charAt(i)!='\t') && (s.charAt(i-1)==' ' || s.charAt(i-1)=='	'))
					w++;
			}
			System.out.println(c + " " + w);
			w=0;
			c=0;
		}
	}
}