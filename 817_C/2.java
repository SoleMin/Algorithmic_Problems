
import java.util.Scanner;

public class b817 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long n = scn.nextLong();
		long s = scn.nextLong();

		long lo = 0;
		long hi = n ;
		while(lo<=hi)	
		{
			long mid=(lo+hi)/2; 
			if(check(mid, s))// no's greater thn this grtr
			{
				hi=mid-1;
			}
			else
			{
				lo=mid+1;
			}
			
		}
		if(check(lo, s))
		{
		System.out.println(n-lo+1);
		}
		else // could check initially too
		{
			System.out.println("0");
			
		}
	}

	public static boolean check(long n, long s) {
		long sum=0;
		long a=n;
		while(n>0)
		{
		
		sum=sum+(n%10);
		n=n/10;
		}
		if(a-sum>=s)
		{
			return true;
		}
		return false;

	}

}
