import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main
{	
	
	long mod = 1000000007;
	
	long pow(long x,long y)
	{
		if(y==0)
			return 1;
		else if(y==1)
			return x%mod;
		else if(y%2==0)
			return pow((x*x)%mod,y/2)%mod;
		else
			return (x*pow((x*x)%mod,y/2)%mod)%mod;
	}
	
	void solve()
	{
		FastReader sc =new FastReader();
		long x = sc.nextLong();
		long k = sc.nextLong();
		
		if(x == 0) {
			System.out.println(0);
			return;
		}
		long ans = pow(2, k);
		x = (2*x)%mod;
		x = (x - 1 + mod)%mod;
		ans = (ans*x)%mod;
		ans = (ans + 1)%mod;
		
		System.out.println(ans);
	}

    public static void main(String[] args)
    {
        new Main().solve();
    }
	
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}