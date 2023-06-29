import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		int max = 72;
		String prg= "";
		
		while(sc.hasNextLine()){
			String input =sc.nextLine();
			if(!input.equals(""))
				prg +=input + " ";
			if(input.equals("") || !sc.hasNextLine()){
				
				String first = "";
				int j=0;
				
				while(prg.charAt(j) == ' '){
					first +=prg.charAt(j);
					j++;
				}
				String output = "";
				output += first;
				prg=prg.trim();
				String[] dic = prg.split(" ");
				
				if(dic.length == 1) {
					System.out.println(prg);
				}else{
					for(int i=0; i<dic.length; i++){
						if((output.length()+(dic[i].length()+1))>72&&i==dic.length-1){
							System.out.println(output);
							System.out.println(dic[i]);
						}else if((output.length()+ (dic[i].length()+1))>72&& i ==0){
							output =dic[i];
						}else if(i==dic.length -1){ 
							output +=" " + dic[i];
							System.out.println(output);
						}else if((output.length()+(dic[i].length()+1))<=72 && i==0){
							output+=dic[i];
						}else if((output.length()+ (dic[i].length()+1))<=72){
							output += " "+dic[i];
						}else{
							System.out.println(output);
							output = dic[i];
						}
					}
				}
				prg="";
				System.out.println("");
			}
			
		}
	}
}