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
        Map<String,Integer> map = new HashMap<>();
        map.put("M",0);
        map.put("L",1);
        map.put("S",2);
        map.put("XL",3);
        map.put("XS",4);
        map.put("XXL",5);
        map.put("XXS",6);
        map.put("XXXL",7);
        map.put("XXXS",8);
        int freqa[] = new int[9];
        int freqb[] = new int[9];
        int n = ni();
        for(int i=0;i<n;++i)
            ++freqa[map.get(ne())];
        for(int i=0;i<n;++i)
            ++freqb[map.get(ne())];
        for(int i=0;i<9;++i)
        {
            int xx = min(freqa[i],freqb[i]);
            freqa[i]-=xx;
            freqb[i]-=xx;
        }
        long res = 0;
        for(int i=0;i<9;++i)
            res+=freqa[i]+freqb[i];
        pl(res/2);
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