import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String a= input.nextLine();
			String b= input.nextLine();
			
			int[] bCheck=new int[b.length()];
			//char[]
			String s="";
			ArrayList<Character> list = new ArrayList<Character>();
			int i,j;
			for(i=0;i<a.length();i++){
				for(j=0;j<b.length();j++){
					if(a.charAt(i)==b.charAt(j) && bCheck[j]==0){
						bCheck[j]++;
						//s=s+b.charAt(j);
						list.add(b.charAt(j));
						break;
					}
				}
			}
			
			for(i=0;i<list.size()-1;i++){
				for(j=i+1;j<list.size();j++){
					if(list.get(i)>list.get(j)){
						char temp=list.get(i);
						list.set(i,list.get(j));
						list.set(j,temp);
					}
				}
			}
			for(i=0;i<list.size();i++)
				System.out.print(list.get(i));
			System.out.println();
		}
		
	}
}