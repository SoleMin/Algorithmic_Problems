/**
 * BaZ :D
 */
import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class ACMIND
{
    static FastReader scan;
    static PrintWriter pw;
    static long MOD = 1_000_000_007;
    static long INF = 1_000_000_000_000_000_000L;
    static long inf = 2_000_000_000;
    public static void main(String[] args) {
        new Thread(null,null,"BaZ",1<<25)
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
    static int n, g[], t[], T;
    static int dp[][];
    static void solve() throws IOException
    {
        scan = new FastReader();
        pw = new PrintWriter(System.out,true);
        StringBuilder fast = new StringBuilder();
        n = ni();
        T = ni();
        g = new int[n];
        t = new int[n];
        for(int i=0;i<n;++i) {
            t[i] = ni();
            g[i] = ni();
        }
        int MAX = (1<<n);
        dp = new int[MAX][4];
        for(int i=0;i<MAX;++i) {
            for(int j=0;j<4;++j) {
                dp[i][j] = -1;
            }
        }
        pl(f((1<<n)-1,0));
        pw.flush();
        pw.close();
    }

    static int f(int mask, int prev) {
        if(dp[mask][prev]!=-1) {
            return dp[mask][prev];
        }
        int left = T;
        for(int i=0;i<n;++i) {
            if((mask&(1<<i))==0) {
                left-=t[i];
            }
        }
        if(left==0) {
            return 1;
        }
        int cnt = 0;
        for(int i=0;i<n;++i) {
            if((mask&(1<<i))!=0) {
                if(g[i]!=prev && left>=t[i]) {
                    cnt+=f(mask^(1<<i), g[i]);
                    if(cnt>=MOD) {
                        cnt-=MOD;
                    }
                }
            }
        }
        return dp[mask][prev] = cnt;
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
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1000000];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }
}