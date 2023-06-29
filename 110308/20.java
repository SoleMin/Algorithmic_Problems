import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		
	  
		String line="";
		
		
		while(input.hasNextLine()){
			String scanner=input.nextLine();
			
      
			
			if(!scanner.equals("")){
				line+=scanner+" ";			
			}
			if(scanner.equals("") || !input.hasNextLine()){
				String[] word=line.split(" "); //단어 별로 나누기
				String output="";//출력할 문자열
				
				if(word.length==1){//단어 개수가 하나면 그냥 출력하기
				 System.out.println(line);
				}
				else{
					for(int i=0;i<word.length;i++){

						if(output.length()+(word[i].length()+1)<=72 && i==0)//첫번째 단어가 작을때 추가
							output +=word[i];
						else if(output.length()+(word[i].length()+1)>72 && i==0) //계속 더햇을때 72 미만일때 계속 추가
							output+=" "+word[i];
						else if(output.length()+(word[i].length()+1)>72 && i==word.length-1){ //마지막일때 출력
							System.out.println(output);
							System.out.println(word[i]);
						}
						else if(i==(word.length-1)){ //마지막 단어 일때 
							output+=" "+word[i];
							System.out.println(output);
						}
						else if(output.length()+(word[i].length()+1)<=72){
							output+=" "+word[i];
						}else{
							System.out.println(output);
							output=word[i];
						}

				
				}
			
			
				
			}
			line="";
			System.out.println();
			 
			}
		
			
		}
		
		
		
	}
}