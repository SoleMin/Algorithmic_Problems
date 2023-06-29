import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan=new Scanner(System.in);
		while(scan.hasNextLine()){
			String input=scan.nextLine();
			//String input=br.readLine();
			int letter=0;
			int blank=0;
			for(int i=0;i<input.length();i++){
				if((i==0&&(input.charAt(i)!=' '&&input.charAt(i)!='\t'))||i>0&&(input.charAt(i-1)==' '||input.charAt(i-1)=='\t')&&(input.charAt(i)!=' '&&input.charAt(i)!='\t')){
					blank++;
				}if(input.charAt(i)!='\t'&&input.charAt(i)!=' '){
					letter++;
				}
			}
			System.out.println(letter+" "+blank);
		}
	}
}