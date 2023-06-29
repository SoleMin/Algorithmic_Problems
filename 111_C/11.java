import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class C implements Runnable
{
    String file = "input";
    
    boolean TEST = false;
    
    void solve() throws IOException
    {
        rows = nextInt();
        cols = nextInt();
        if(cols > rows)
        {
            int t = rows; rows = cols; cols = t;
        }
        dp = new int[rows][cols][1 << cols][1 << cols][1 << cols];      
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                for(int k = 0; k < 1 << cols; k++)
                    for(int u = 0; u < 1 << cols; u++)
                        for(int v = 0; v < 1 << cols; v++) dp[i][j][k][u][v] = -1;  
        out.println(go(0, 0, 0, 0, 0));
    }
    int rows, cols;
    int[][][][][] dp;
    int INF = 1 << 20;
    int go(int i, int j, int a, int b, int c)
    {   
        if(i == rows)
        {
            return a == 0 && b == 0 && c == 0 ? 0 : -INF;
        }
        if(i + 1 == rows && b != 0 && c != 0) return -INF;
        if(i + 2 == rows && c != 0) return -INF;
        if(j == cols)
        {
            return go(i + 1, 0, b, c, 0);
        }
        
        if(dp[i][j][a][b][c] != -1) return dp[i][j][a][b][c];
        
        if(!test(a, j, -1, -1)) return go(i, j + 1, a, b, c);
        
        int res = -INF;
        
        //1
        if(test(a, j, -1, -1))
            res = max(res, go(i, j + 1, set(a, j, -1, -1), b, c));
        //2
        if(test(a, j, -1, -1) && test(b, j, -1, -1)) 
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j, -1, -1), c) + 1);
        //3
        if(j + 2 <= cols && test(a, j, j + 1, -1)) 
            res = max(res, go(i, j + 2, set(a, j, j + 1, -1), b, c) + 1);
        //4
        if(j + 3 <= cols && test(a, j, j + 1, j + 2)) 
            res = max(res, go(i, j + 2, set(a, j, j + 1, j + 2), b, c) + 2);
        //5
        if(test(a, j, -1, -1) && test(b, j, -1, -1) && test(c, j, -1, -1)) 
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j, -1, -1), set(c, j, -1, -1)) + 2);
        //6
        if(j - 1 >= 0 && test(a, j, -1, -1) && test(b, j - 1, j, -1) && test(c, j, -1, -1))
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j - 1, j, -1), set(c, j, -1, -1)) + 3);
        //7
        if(j + 2 <= cols && test(a, j, -1, -1) && test(b, j, j + 1, -1) && test(c, j, -1, -1))
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j, j + 1, -1), set(c, j, -1, -1)) + 3);
        //8
        if(j + 3 <= cols && test(a, j, j + 1, j + 2) && test(b, j + 1, -1, -1)) 
            res = max(res, go(i, j + 3, set(a, j, j + 1, j + 2), set(b, j + 1, -1, -1), c) + 3);
        //9
        if(j + 2 <= cols && j - 1 >= 0 && test(b, j - 1, j, j + 1))
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j - 1, j, j + 1), c) + 3);
        //10
        if(j + 2 <= cols && j - 1 >= 0 && test(b, j - 1, j, j + 1) && test(c, j, -1, -1))
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j - 1, j, j + 1), set(c, j, -1, -1)) + 4);
            
        //11
        if(j + 2 <= cols && test(b, j, j + 1, -1))
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j, j + 1, -1), c) + 2);
        
        //12
        if(j - 1 >= 0 && test(b, j - 1, j, -1))
            res = max(res, go(i, j + 1, set(a, j, -1, -1), set(b, j - 1, j, -1), c) + 2);
        
        //13
        if(j + 2 <= cols && test(a, j, j + 1, -1) && test(b, j, -1, -1))
            res = max(res, go(i, j + 2, set(a, j, j + 1, -1), set(b, j, -1, -1), c) + 2);
        
        //14
        if(j + 2 <= cols && test(a, j, j + 1, -1) && test(b, j + 1, -1, -1))
            res = max(res, go(i, j + 2, set(a, j, j + 1, -1), set(b, j + 1, -1, -1), c) + 2);
        
        return dp[i][j][a][b][c] = res; 
    }
    int set(int a, int i, int j, int k)
    {
        if(i != -1) a |= 1 << i;
        if(j != -1) a |= 1 << j;
        if(k != -1) a |= 1 << k;
        return a;
    }
    boolean test(int a, int i, int j, int k)
    {
        if(i != -1 && (a >> i & 1) != 0) return false;
        if(j != -1 && (a >> j & 1) != 0) return false;
        if(k != -1 && (a >> k & 1) != 0) return false;
        return true;
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
        new Thread(null, new C(), "", 1 << 20).start();
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