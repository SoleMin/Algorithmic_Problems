import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String s="";
		int i;
		int p=0;
		int n=0;
		String sentence="";
		String save="";
		
		
		while(input.hasNextLine()){
			if(!save.equals("")) {
				s=save;
				save="";
			}else
				s=input.nextLine();
			
			if(s.equals("")) {
				System.out.println(sentence);
				System.out.println();
				sentence="";
				n=0;
				p=0;
				continue;
			}
			for(i=0;i<s.length();i++) {
				if(s.charAt(i)==' ')
					p=i;
				n++;
				if(n==72) {
					//if(s.length()>72 && p==0)
					//	sentence=
					if(i+1<s.length()&& s.charAt(i+1)==' ' && p!=i)
						p=i+1;
					break;
				}
			}
			
			if(n!=72) {
				if(!sentence.equals("")){
					sentence=sentence+" "+s;
				}
				else
					sentence=s;
				n++;
				p=0;//
				if(n==72){
					System.out.println(sentence);
					sentence="";
					p=0;
					n=0;
				}
				//s=input
				continue;
			}
			
			if(s.length()>=72&&p==0){
				if(!sentence.equals(""))
					System.out.println(sentence);
				System.out.println(s);
				//save=s;
				sentence="";
				n=0;
				p=0;
				continue;
			}
			if(!sentence.equals("")) {
				if(p!=0){
					sentence=sentence+" "+s.substring(0,p);
				}
			}else {
				if(s.length()==72 || s.length()>=72&&p==0)
					sentence=s;
				sentence=s.substring(0,p);
			}
			if(p==0)
				save=s;
			else
				save=s.substring(p+1);
			
			//save=s.substring(p+1);
			//if(n==72) {
				System.out.println(sentence);
				sentence="";
				p=0;
				n=0;
			//}
			
				
			//for(i=0;i<save.length();i++) {
				
			//}
		}
		if(!sentence.equals(""))
			System.out.println(sentence);
		if(save!=null)
			System.out.println(save);
	}
}