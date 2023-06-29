import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
	
			
		Scanner input=new Scanner(System.in);
		while(input.hasNextLine()){
			String s=input.nextLine();
			int words=0,letters=0;
			
			for(int i=0;i<s.length();i++){
				if( (i==0 && (s.charAt(i) !=' ' && s.charAt(i) != '\t') ) || (i>0 && (s.charAt(i-1)==' ' || s.charAt(i-1)=='\t')) && (s.charAt(i)!=' ' && s.charAt(i) !='\t') )  //단어의 처음과 끝 구분
					words++;  //단어수
				if(s.charAt(i) !='\t' && s.charAt(i) != ' ')
					letters++;  //글자수
			}
			 System.out.println(letters + " "+ words);
		}
		
		
	}
}