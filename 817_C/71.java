import java.io.*;
import java.util.*;

/**
 *
 * @author Jishnu_T
 */
public class ReallyBigNums {
    
    private static long[] factorArray(long s)
    {
        int d=0;
        long n=s;
        long f=1;
        while(n>0)
        {
            n=n/10;
            d++;
            f = f*10;
        }
        
        long[] fact = new long[d+1];
        n=s;
        for(int i=d;i>=0;i--)
        {
            if(f==1)
                fact[i] = n;
            else
            {
                fact[i] = n/(f-1);
                n = n%(f-1);
                f=f/10;
            }
        }
        int carry=0;
        for(int i=0;i<=d;i++)
        {
            fact[i] = fact[i]+carry;
            if(fact[i]>9 || (i==0 && fact[i]>0))
            {
                fact[i] = 0;
                carry = 1;
                for(int j=i-1;j>=0;j--)
                {
                    fact[j] =0;
                }
            }
            else
            {
                carry = 0;
            }
        }
        
        return fact;
    }
    
    private static long bigNumCount(long n, long s)
    {
        if(s>=n)
            return 0;
        if(s==0)
            return n;
        long[] fact = factorArray(s);
        
        long startNum = 0;
        int len = fact.length;
        long tenPow = 1;
        for(int i=0;i<len;i++)
        {
            startNum = startNum+tenPow*fact[i];
            tenPow = tenPow*10;
        }
        
        return(Math.max(0,n-startNum+1));
    }
    private static class FastReader
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
    public static void main(String args[])
    {
        FastReader r = new FastReader();
        long n = r.nextLong();
        long s=  r.nextLong();
        System.out.println(bigNumCount(n,s));
    }
    
}
