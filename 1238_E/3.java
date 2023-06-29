/**
 * BaZ :D
 */
import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Main
{
    static MyScanner scan;
    static PrintWriter pw;
    static long MOD = 1_000_000_007;
    static long INF = 1_000_000_000_000_000_000L;
    static long inf = 2_000_000_000;
    public static void main(String[] args) {
        new Thread(null, null, "BaZ", 1 << 27) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }
    static int n,m;
    static int dp[], cnt[][], sum[];
    static void solve() throws IOException
    {
        //initIo(true);
        initIo(false);
        StringBuilder sb = new StringBuilder();
        n = ni();
        m = ni();
        dp = new int[(1<<m)];
        char c[] = ne().toCharArray();
        cnt = new int[m][m];
        for(int i=0;i+1<n;++i) {
            if(c[i]!=c[i+1]) {
                ++cnt[c[i] - 'a'][c[i+1] - 'a'];
                ++cnt[c[i+1] - 'a'][c[i] - 'a'];
            }
        }
        sum = new int[1<<m];
        calc(0, 0, 0);
        Arrays.fill(dp, -1);
        pl(f(0));
        pw.flush();
        pw.close();
    }
    static void calc(int mask, int S, int pos) {
        if(pos==m) {
            sum[mask] = S;
            return;
        }
        calc(mask, S, pos+1);
        int newSum = S;
        for(int i=0;i<pos;++i) {
            if((mask&(1<<i))!=0) {
                newSum-=cnt[i][pos];
            }
            else {
                newSum+=cnt[i][pos];
            }
        }
        for(int i=pos+1;i<m;++i) {
            newSum+=cnt[i][pos];
        }
        calc(mask|(1<<pos), newSum, pos+1);
    }
    static int f(int mask) {
        if(mask==(1<<m) - 1) {
            return 0;
        }
        if(dp[mask]!=-1) {
            return dp[mask];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<m;++i) {
            if((mask&(1<<i))==0) {
                min  =  min(min, sum[mask]+f(mask|(1<<i)));
            }
        }
        return dp[mask] = min;
    }
    static void initIo(boolean isFileIO) throws IOException {
        scan = new MyScanner(isFileIO);
        if(isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output.txt");
        }
        else {
            pw = new PrintWriter(System.out, true);
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
    static void pa(String arrayName, Object arr[])
    {
        pl(arrayName+" : ");
        for(Object o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, int arr[])
    {
        pl(arrayName+" : ");
        for(int o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, long arr[])
    {
        pl(arrayName+" : ");
        for(long o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, double arr[])
    {
        pl(arrayName+" : ");
        for(double o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, char arr[])
    {
        pl(arrayName+" : ");
        for(char o : arr)
            p(o);
        pl();
    }
    static void pa(String listName, List list)
    {
        pl(listName+" : ");
        for(Object o : list)
            p(o);
        pl();
    }
    static void pa(String arrayName, Object[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(Object o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, int[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(int o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, long[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(long o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, char[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(char o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, double[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(double o : arr[i])
                p(o);
            pl();
        }
    }
    static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        MyScanner(boolean readingFromFile) throws IOException
        {
            if(readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input.txt"));
            }
            else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
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