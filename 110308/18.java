import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		while(scan.hasNextLine()){
			int i=0;
			String input="";
			String[] word_temp= new String[999];
			while(scan.hasNextLine()){
				input= scan.nextLine();
				if(input.equals("") && input.length()==0 && i>0){
					break;
				}
				word_temp[i]=input+" ";
				i++;
			}
			
			String temp="";
			for(int j=0;j<i;j++){
				temp+=word_temp[j];
			}
			
			String[] word= temp.split(" ");
			String print="";
			for(int j=0;j<word.length;j++){
				if((print.length()+word[j].length())>72){
					if(print.length() == 0 && word[j].length()>72){
						System.out.println(word[j]);
					}else{
						print= print.substring(0,print.length()-1);
						System.out.println(print);
						print="";
						print+=word[j]+" ";
					}
				}else{
						print+=word[j]+" ";
				}
			}
			print=print.substring(0,print.length()-1);
			System.out.println(print);
			System.out.println("");
		}
	}
		
}
