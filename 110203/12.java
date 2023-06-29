import java.io.*;
import java.util.*;

class Main{
	
	static boolean hartal(int []P,int N_i){
		if(N_i % 7 ==6 || N_i % 7 ==0)
			return false;
		for(int i =0; i <P.length; i++){
			if(N_i%P[i]==0)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args)throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		int T =scanner.nextInt();
		
		for(int i =0; i <T; i++){
			int N = scanner.nextInt();
			int P_size= scanner.nextInt();
			int[] P = new int[P_size];
			for(int j=0;j<P.length;j++){
				P[j]=scanner.nextInt();
		}
			int count =0;
			for(int j=1;j<=N;j++){
				if(hartal(P,j)){
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
}