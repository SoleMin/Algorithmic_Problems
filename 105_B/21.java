import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class B implements Runnable
{
    String file = "input";
    
    boolean TEST = false;
    double EPS = 1e-8;
    void solve() throws IOException
    {
        int n = nextInt(), k = nextInt(), A = nextInt();
        int[] level = new int[n];
        int[] loyal = new int[n];
        for(int i = 0; i < n; i++)
        {
            level[i] = nextInt();
            loyal[i] = nextInt();
        }
        double res = 0;
        for(int mask = 0; mask < 1 << (n + k - 1); mask++)
        {
            if(Integer.bitCount(mask) != k) continue;
            
            int[] L = new int[n];
            int x = mask;
            for(int i = 0; i < n; i++)
            {
                L[i] = loyal[i];
                while(x % 2 == 1)
                {
                    L[i] += 10;
                    x /= 2;
                }
                L[i] = min(L[i], 100);
                x /= 2;
            }
            double tmp = 0;
            for(int w = 0; w < 1 << n; w++)
            {
                double p = 1.;
                double B = 0;
                for(int i = 0; i < n; i++)
                    if((w >> i & 1) != 0) p *= L[i] / 100.;
                    else
                    { 
                        p *= (100 - L[i]) / 100.;
                        B += level[i];
                    }
                if(Integer.bitCount(w) * 2 > n) tmp += p;
                else tmp += p * (A / (A + B));
            }
            res = max(res, tmp);
        }
        out.printf("%.8f\n", res);
    }
    
    class Player
    {
        
    }
    
    String next() throws IOException
    {
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
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
    
    void init() throws IOException
    {
        if(TEST) input = new BufferedReader(new FileReader(file + ".in")); 
        else input = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    public static void main(String[] args) throws IOException
    {
        new Thread(null, new B(), "", 1 << 20).start();
    }
    
    public void run()
    {
        try
        {
            init();
            if(TEST) 
            {
                int runs = nextInt();
                for(int i = 0; i < runs; i++) solve();
            }
            else solve();
            out.close();        
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}