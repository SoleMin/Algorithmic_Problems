import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class A implements Runnable
{
    String file = "input";
    
    void init() throws IOException
    {
        //input = new BufferedReader(new FileReader(file + ".in"));
        input = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    void solve() throws IOException
    {
        String s = next();
        int res = 0;
        int L = s.length();
        for(int i = 0; i < L; i++)
            for(int j = i + 1; j <= L; j++)
            {
                String ss = s.substring(i, j);
                int k = s.indexOf(ss);
                //print(ss, k);
                if(k >= 0)
                {
                    if(s.substring(k + 1).indexOf(ss) >= 0) res = max(res, j - i);
                }
            }
        System.out.println(res);
    }
    
    String next() throws IOException
    {
        if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
        return st.nextToken();
    }
    
    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }
    
    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }
    
    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
    
    void print(Object... o)
    {
        System.out.println(deepToString(o));
    }
    
    void gcj(Object o)
    {
        String s = String.valueOf(o);
        out.println("Case #" + test + ": " + s);
        System.out.println("Case #" + test + ": " + s);
    }
    
    BufferedReader input;
    PrintWriter out;
    StringTokenizer st;
    int test;
    
    public static void main(String[] args) throws IOException
    {
        new Thread(null, new A(), "", 1 << 20).start();
    }
    
    public void run()
    {
        try
        {
            init();
            solve();
            out.close();        
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}