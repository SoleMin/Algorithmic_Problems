import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String a = input.nextLine();
			int w=0;
			int l=0;
			for(int i=0; i<a.length(); i++){
				if((i ==0 && (a.charAt(i) != ' ' && a.charAt(i) != '\t'))|| i>0 && (a.charAt(i-1) == ' ' || a.charAt(i-1) == '\t') && (a.charAt(i)!= ' ' && a.charAt(i) != '\t'))
					w++;
				if(a.charAt(i) != '\t' && a.charAt(i) != ' ')
					l++;
			}
			System.out.println(l+" "+w);
			
		}
	}
}