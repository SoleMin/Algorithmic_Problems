

import java.util.Scanner;

public class A338 {

	public static void main (String args[]){
		
		Scanner in= new Scanner(System.in);
		long n = in.nextInt();
		long m=in.nextInt();
		long k=in.nextInt();
		
		long x = n-m;
		long y=n/k;
		if(x>=y)
			System.out.println(m);
		else
		{
			long t= y-x;
			long ans=0;
			ans+=k*(pow(t+1)-2);
			ans%=1000000009;
			ans+=m-t*k;
			ans%=1000000009;
			if(ans<0)
				ans+=1000000009;
			System.out.println(ans);
			
		}
			
		
		
	}
	
	public static long pow(long m ){
		
		if(m==1)
			return 2;
		long x = pow(m/2);
		
		x%=1000000009;
		x*=x;
		if(m%2!=0)
			x*=2;
		x%=1000000009;
		return (x);
		
	}
	
}
