import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
    public static long gcd(long a, long b)
    {
        return b==0? a:gcd(b, a%b);
    }
    public static long lcm(long a, long b, long c)
    {
        long d=a/gcd(a, b)*b;
        return c/gcd(c, d)*d;
    }
    public static long max(long a, long b)
    {
        return a>b? a:b;
    }
    public static void main(String[] args)
    {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        long n=in.nextLong();
        if(n<=2)
            out.println(n);
        else
            out.println(max(lcm(n, n-1, n-2), max(lcm(n, n-1, n-3), lcm(n-1, n-2, n-3))));
        out.close();
    }
}

class InputReader
{
    BufferedReader buf;
    StringTokenizer tok;
    InputReader()
    {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    boolean hasNext()
    {
        while(tok == null || !tok.hasMoreElements()) 
        {
            try
            {
                tok = new StringTokenizer(buf.readLine());
            } 
            catch(Exception e) 
            {
                return false;
            }
        }
        return true;
    }
    String next()
    {
        if(hasNext()) 
            return tok.nextToken();
        return null;
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
    BigInteger nextBigInteger()
    {
        return new BigInteger(next());
    }
    BigDecimal nextBigDecimal()
    {
        return new BigDecimal(next());
    }
}