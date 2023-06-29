import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		while(input.hasNextLine()){
			
			
			String first=input.nextLine();
			String second=input.nextLine();
				
			List<String> a=new ArrayList<String>();
			List<String> b=new ArrayList<String>();
			
			
			for(int i=0;i<first.length();i++)
				a.add(first.substring(i,i+1));
			for(int i=0;i<second.length();i++)
				b.add(second.substring(i,i+1));
			
			
			a.retainAll(b);
			b.retainAll(a);
			
			//길이가 다르면 더 작은길이 출력하기.
			Collections.sort(b);
			Collections.sort(a);
		
		
			if(a.size()>b.size()){
				for(String s:b){
					System.out.print(s);
				}
				System.out.println();
			}else if(a.size()<b.size()){
				for(String s:a){
					System.out.print(s);
				}System.out.println();
			}else{
				for(String s:a){
					System.out.print(s);
				}
				System.out.println();
			}
		}
	}
}