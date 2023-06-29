import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class A implements Runnable
{
    String file = "input";
    
    boolean TEST = System.getProperty("ONLINE_JUDGE") == null;
    
    void solve() throws IOException
    {
        int n = nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = nextInt();
        int[] b = a.clone();
        qsort(b);
        //sortInt(b);
        int count = 0;
        for(int i = 0; i < a.length; i++)
            if(a[i] != b[i]) count++;
        if(count == 0 || count == 2) out.println("YES");
        else out.println("NO");
    }
    
    void qsort(int[] a)
    {
        List<Integer> as = new ArrayList<Integer>();
        for(int x : a) as.add(x);
        Collections.shuffle(as);
        for(int i = 0; i < a.length; i++) a[i] = as.get(i);
        sort(a);
    }
    
    Random rnd = new Random();
    
    void sortInt(int[] a)
    {
        sortInt(a, 0, a.length - 1);
    }
    
    void sortInt(int[] a, int from, int to)
    {
        if(from >= to) return;
        int i = from - 1;
        int p = rnd.nextInt(to - from + 1) + from;
        int t = a[p]; a[p] = a[to]; a[to] = t;
        for(int j = from; j < to; j++)
            if(a[j] <= a[to])
            {
                i++;
                t = a[i]; a[i] = a[j]; a[j] = t;
            }
        t = a[i + 1]; a[i + 1] = a[to]; a[to] = t;
        sortInt(a, i + 2, to);
        while(i >= 0 && a[i] == a[i + 1]) i--;
        sortInt(a, from, i);
        
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
        new Thread(null, new A(), "", 1 << 22).start();
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