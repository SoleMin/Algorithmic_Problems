import java.io.*;
import java.util.*;

class Main {
	static boolean eden(int cur, int N, int []answer,int[] s, int[] att){
		if(cur>=N)
			return  (answer[0]==answer[N])&&(answer[1]==answer[N+1]);
		for(int i=0;i<8;i++){
			if(s[cur]==att[i] &&(!cur_b(cur)||(answer[cur]*4+answer[cur+1]*2==(i&6)))){
				if(!cur_b(cur)){
					if(((i&4)>0))
						answer[0]=1;
					else
						answer[0]=0;
					
					if(((i&2)>0))
						answer[1]=1;
					else
						answer[1]=0;
				
				}
				
				if((i&1)>0)
					answer[cur+2]=1;
				else
					answer[cur+2]=0;
				
				if(eden(cur+1, N , answer, s, att)) return true;
				
			}
		}
		return false;
	}
	public static boolean cur_b(int cur){
		if(cur==0)
			return false;
		else
			return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()){
			int identifier = scanner.nextInt();
			int N = scanner.nextInt();
			String str= scanner.next();
			
			int att[] =new int[8];
			int s[]= new int[35];
			int answer[]= new int[35];
			
			for(int i=0;i<8;i++)
				att[i]=(identifier>>i)&1;
			for(int i=0;i<N;i++)
				s[i]=str.charAt(i)-'0';
			
			if(eden(0,N,answer,s,att))
				System.out.println("REACHABLE");
			else
				System.out.println("GARDEN OF EDEN");
			
		}
	}
}