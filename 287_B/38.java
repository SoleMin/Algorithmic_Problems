
import java.util.Scanner;

public class B2 {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long k = in.nextLong();
		long upn = k;
		long tmp=upn;
		if(n==1){
			System.out.println(0);
			return;
		}
		if(n<=k){
			System.out.println(1);
			return;
		}
		//---
		if(!bS(n, k, upn)){
			System.out.println(-1);
			return;
		}
		boolean flag = false;
			while(bS(n, k, upn)){
				tmp = upn;
				flag = true;
				upn=5*upn/6;
				if(tmp==upn)
					break;
			}
			long ans = tmp;
			if(!flag)
				upn=0;
			for(int i = (int)tmp;i>=upn;i--){
				if(bS(n, k, i)){
					ans=i;
				}
				else
					break;
			}
			System.out.println(ans);
	}
	
	static boolean bS(long key,long k ,long n) 
	    {
		long pipe = (n * (k-n+k+1))/2;
		pipe = pipe - n+1;
	         if(pipe>=key){
	        	 return true;
	         }
	         else
	        	 return false;
	   }
}
