import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main
{
    static MyScanner scan;
    static PrintWriter pw;
    public static void main(String[] args) {
        new Thread(null,null,"_",1<<25)
        {
            public void run()
            {
                try
                {
                    solve();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }
    static void solve() throws IOException {
        scan = new MyScanner();
        pw = new PrintWriter(System.out, true);
        StringBuilder sb = new StringBuilder();
        int n = ni();
        int d = ni();
        int arr[] = new int[n];
        int cnt = 2;
        for(int i=0;i<n;++i)
            arr[i] = ni();
        for(int i=0;i<n-1;++i)
        {
            if(arr[i+1]-d==arr[i]+d)
            {
                ++cnt;
                continue;
            }
            if(arr[i+1]-(arr[i]+d)>d)
                ++cnt;
            if((arr[i+1]-d)-arr[i]>d)
                ++cnt;
        }
        pl(cnt);
        pw.flush();
        pw.close();
    }
    static long MMI(long A,long MOD)
    {
        return modpow(A,MOD-2,MOD);
    }
    static long modpow(long x,long y,long MOD)
    {
        if(y==0)
            return 1;
        if((y&1)==0)
            return modpow((x*x)%MOD,y>>1,MOD);
        else return (x*modpow(x,y-1,MOD))%MOD;
    }
    static class Pair implements Comparable<Pair>
    {
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
        public int compareTo(Pair other)
        {
            if(this.x!=other.x)
                return this.x-other.x;
            return this.y-other.y;
        }
        public String toString()
        {
            return "{"+x+","+y+"}";
        }
    }
    static int ni() throws IOException
    {
        return scan.nextInt();
    }
    static long nl() throws IOException
    {
        return scan.nextLong();
    }
    static double nd() throws IOException
    {
        return scan.nextDouble();
    }
    static String ne() throws IOException
    {
        return scan.next();
    }
    static String nel() throws IOException
    {
        return scan.nextLine();
    }
    static void pl()
    {
        pw.println();
    }
    static void p(Object o)
    {
        pw.print(o+" ");
    }
    static void pl(Object o)
    {
        pw.println(o);
    }
    static void psb(StringBuilder sb)
    {
        pw.print(sb);
    }
    static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        MyScanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine()throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
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
    }
}