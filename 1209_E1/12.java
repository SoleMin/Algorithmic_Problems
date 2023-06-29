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
    static int n,m,need,a[][],dp[][][],real[][];
    static void solve() throws IOException
    {
        //initIo(true);
        initIo(false);
        StringBuilder sb = new StringBuilder();
        int t = ni();
        while(t-->0) {
            n = ni();
            m = ni();
            a = new int[n][m];
            for(int i=0;i<n;++i) {
                for(int j=0;j<m;++j) {
                    a[i][j] = ni();
                }
            }
            need = min(n,m);
            Pair max_in_cols[] = new Pair[m];
            for(int COL=0;COL<m;++COL) {
                int max = 0;
                for(int i=0;i<n;++i) {
                    max = max(max, a[i][COL]);
                }
                max_in_cols[COL] = new Pair(max, COL);
            }
            real = new int[n][need];
            Arrays.sort(max_in_cols);
            for(int i=0;i<need;++i) {
                int COL = max_in_cols[m-1-i].y;
                for(int j=0;j<n;++j) {
                    real[j][i] = a[j][COL];
                }
            }
//            pl("need : "+need);
//            pa("Real", real);
            dp = new int[need][n+1][(1<<n)];
            for(int i=0;i<need;++i) {
                for(int j=0;j<=n;++j) {
                    for(int k=0;k<(1<<n);++k) {
                        dp[i][j][k] = -1;
                    }
                }
            }
            pl(f(0, n, 0));
        }
        pw.flush();
        pw.close();
    }
    static int f(int idx, int bias, int mask) {
        //pl("idx: "+idx+" bias : "+bias + " mask : "+mask);
        if(idx==need) {
            return 0;
        }
        if(dp[idx][bias][mask]!=-1) {
            return dp[idx][bias][mask];
        }

        //didn't fix bias yet
        if(bias==n) {
            int max = 0;
            for(int b=0;b<n;++b) {
                max = max(max, f(idx, b, mask));
            }
            //pl("maxxxxxxx : "+max);
            dp[idx][bias][mask] = max;
            return max;
        }
        else {
            int max = f(idx+1, n, mask);
            for(int i=0;i<n;++i) {
                if((mask&(1<<i))==0) {
                    max = max(max, real[(i-bias+n)%n][idx] + f(idx, bias, mask | (1<<i)));
                }
            }
            //pl("max : "+max);
            dp[idx][bias][mask] = max;
            return max;
        }
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
            return "("+x+","+y+")";
        }
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