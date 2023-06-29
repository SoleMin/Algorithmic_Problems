import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		while(input.hasNextLine()){
			String str=input.nextLine();
			int w=0,l=0;
			for(int i=0;i<str.length();i++)
			{
				if((i==0&&(str.charAt(i)!=' '&&str.charAt(i)!='\t'))||i>0&&(str.charAt(i-1)==' '||str.charAt(i-1)=='\t')&&(str.charAt(i)!=' '&&str.charAt(i)!='\t'))
					w++;
				if(str.charAt(i)!='\t'&&str.charAt(i)!=' ')
					l++;
				
			}
			System.out.println(l+" "+w);
			
}
		
		
}
}