import java.io.*;
import java.util.*;
public class TestClass {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String s[] = in.readLine().split(" ");
    	long n = Long.parseLong(s[0]);
    	long k = Long.parseLong(s[1]);
    	long x = bs(n,k);
    	out.println(n-x+1);
        out.close();
    }
    public static long bs(long n,long k)
    {
    	long l=0,h=n;
    	while(l<=h)
    	{
    		long mid = l + (h-l)/2;
    		long x = mid - sum(mid);
    		if(x>=k)
    		{
    			h = mid-1;
    		}
    		else
    		{
    			l = mid+1;
    		}
    	}
    	return l;
    }
    public static long sum(long x)
    {
    	long ans=0;
    	while(x>0)
    	{
    		ans += x%10;
    		x=x/10;
    	}
    	return ans;
    }
}
