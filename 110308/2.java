import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int max = 72;
		String paragraph ="";
		
		while(scanner.hasNextLine()){
			String input= scanner.nextLine();
			if(!input.equals(""))
				paragraph+=input+" ";
			if(input.equals("") || !scanner.hasNextLine()){
				//System.out.println("->"+paragraph);
				
				String first="";
				int j=0;
				
				while(paragraph.charAt(j)==' '){
					first+=paragraph.charAt(j);
					j++;
				}
				
				String output="";
				output+=first;
				//System.out.println("->"+first);
				paragraph=paragraph.trim();
				
				
				String[] dic = paragraph.split(" ");
				//System.out.println("->"+Arrays.toString(dic));
				if(dic.length==1){
					System.out.println(paragraph);
				}
				else{
					for(int i=0; i<dic.length;i++){
						if((output.length() + (dic[i].length()+1)) >72 && i==dic.length-1){
							System.out.println(output);
							System.out.println(dic[i]);
						}
						else if((output.length() + (dic[i].length()+1)) >72 && i==0){
							output=dic[i];
						}
						else if(i==dic.length-1){
							output+=" "+dic[i];
							System.out.println(output);
						}
						else if((output.length() + (dic[i].length()+1)) <=72 && i==0){
							output+=dic[i];
						}
						else if((output.length() + (dic[i].length()+1)) <=72){
								output+=" "+dic[i];
						}
						else{
							System.out.println(output);
							output=dic[i];
						}
					}
				}
				paragraph="";
				System.out.println("");
			}
		}
		
		
	}
}