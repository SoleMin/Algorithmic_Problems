//package pack;

import java.util.*;

public class first
{
	public static long power(long x, long y, long p)
    {
        long res = 1;
        x = x % p; 
        while (y > 0)
        {	if((y & 1)==1)
                res = (res * x) % p;
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		long x=sc.nextLong();
		long k=sc.nextLong();
		long mod=1000000007;
		if(k==0 || x==0)
			System.out.println((2*x)%mod);
		else
		{	long answer=1;
			answer+=(power(2,k,mod))*(((2*x)-1)%mod);
			System.out.println(answer%mod);
		}
	}
}