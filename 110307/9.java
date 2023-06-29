import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
class Main {
	static HashSet<String> set = new HashSet<String>();
	static ArrayList<String> result;
	static int[] visit, count;
	static int index;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			String s=input.nextLine();
			if(s.equals(""))
				break;
			set.add(s);
		}
		
		while(input.hasNext()){
			result=new ArrayList<>();
			visit= new int[set.size()];
			count=new int[set.size()];
			index=0;
			String[] s=input.nextLine().split(" ");
			for(int j=0; j<set.size(); j++){
				if(s[0].equals(set.toArray()[j]))
					visit[j]=1;
			}
			sequence(s[0],s[1], s[0]+"\n", 0);
			
			if(result.isEmpty())
				System.out.println("No solution.\n");
			else {
				int min=0;
				for(int k=1; k<count.length; k++){
					if(count[k]==0)
						break;
					if(count[min]>count[k])
						min=k;
				}
				System.out.println(result.get(min));
			}
		}
		input.close();
	}
	
	public static boolean doublets(String a, String b){
		int wrong=0;
		if(a.length() != b.length()){
			return false;
		}
		else {
			for(int i=0; i<a.length(); i++){
				if(a.charAt(i)!=b.charAt(i))
					wrong++;
			}
		}
		if(wrong==1)
			return true;
		else
			return false;
	}
	
	public static void sequence(String x, String y, String s, int cnt){
		if(x.equals(y)){
			count[index++]=cnt;
			result.add(s);
			return;
		}
		
		for(int i=0; i<set.size(); i++) {
			String ss=""+set.toArray()[i];
			if(visit[i]==0 && doublets(x,ss)){
				visit[i]=1;
				sequence(ss,y,s+ss+"\n",cnt+1);
				visit[i]=0;
			}
		}
	}
}