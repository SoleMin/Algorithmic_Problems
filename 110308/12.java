import java.io.*;
import java.util.Scanner;
class Main {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			String s=input.nextLine();
			if(s.equals("")) {
				sol();
				System.out.println();
			}	
			else {
				sb.append(s+" ");
			}
		}
		sol();
		
		input.close();
	}
	
	public static void sol() { 			
		while(sb.length()!=0){
			int index=0;
			String[] ss=sb.toString().split(" ",2);
			if(ss[0].length()>72){
				index=ss[0].length();
			}
			else{
				if(sb.length()>72){
					for(int i=72; i>=0; i--){
						if(sb.charAt(i)==' '){
							index=i;
							break;
						}
					}
				}
				
				else{
					index=sb.length();
				}
			}
			System.out.println(sb.substring(0,index));
			sb.delete(0, index);
			sb=new StringBuilder(sb.toString().trim());
		}
	}
}