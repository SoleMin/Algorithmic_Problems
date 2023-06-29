import java.util.*;
public class prob
{
		
	public static long ans(long x, long y, long p)
    {
        long r = 1;     
        x = x % p;
        while (y > 0)
        {
            if((y & 1)==1)
                r = (r * x) % p;
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return r;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		long x = scan.nextLong();
		long k = scan.nextLong();
		long v = 1000000007L;
		if(x>0){
			long p = ((2*x)-1)%v;
			long a = ans(2L,k,v);
			long b = (p*a)%v;
			System.out.println((b+1)%v);
		}
		else{
			System.out.println(0);
		}
	}
}
