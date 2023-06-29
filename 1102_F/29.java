import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main {
    static final long MOD = 1_000_000_007, INF = 1_000_000_000_000_000_000L;
    static final int INf = 1_000_000_000;
    static FastReader reader;
    static PrintWriter writer;
    public static void main(String[] args) {
        Thread t = new Thread(null, new O(), "Integer.MAX_VALUE", 100000000);
        t.start();
    }
    static class O implements Runnable {
        public void run() {
            try {
                magic();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
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
    static int n,m,pre[][], pre_stop_and_start[][],mat[][], dp[][][];
    static void magic() throws IOException {
        reader = new FastReader();
        writer = new PrintWriter(System.out, true);
        n = reader.nextInt();
        m = reader.nextInt();
        mat = new int[n][m];
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                mat[i][j] = reader.nextInt();
            }
        }
        if(n==1) {
            int ans = Integer.MAX_VALUE;
            for(int i=0;i+1<m;++i) {
                ans = min(ans, abs(mat[0][i] - mat[0][i+1]));
            }
            writer.println(ans);
            System.exit(0);
        }
        pre = new int[n][n];
        pre_stop_and_start = new int[n][n];
        for(int i=0;i<n;++i) {
            for(int j=i+1;j<n;++j) {
                int min = Integer.MAX_VALUE;
                for(int k=0;k<m;++k) {
                    min = min(min, abs(mat[i][k] - mat[j][k]));
                }
                pre[i][j] = pre[j][i] = min;
            }
        }
        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(j==i) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int k=0;k+1<m;++k) {
                    min = min(min, abs(mat[j][k+1] - mat[i][k]));
                }
                pre_stop_and_start[i][j] = min;
            }
        }
//        writer.println("Pre array: ");
//        for(int i=0;i<n;++i) {
//            for(int j=0;j<n;++j) {
//                writer.print(pre[i][j]+" ");
//            }
//            writer.println();
//        }
//        writer.println("Pre stop and start array: ");
//        for(int i=0;i<n;++i) {
//            for(int j=0;j<n;++j) {
//                if(j==i) {
//                    writer.print("SKIP ");
//                }
//                else writer.print(pre_stop_and_start[i][j]+" ");
//            }
//            writer.println();
//        }
        dp = new int[1<<n][n][n];
        for(int i=0;i<(1<<n);++i) {
            for(int j=0;j<n;++j) {
                for(int k=0;k<n;++k) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;++i) {
            ans = max(ans, f((1<<i), i, i));
        }
        writer.println(ans);
    }
    static int f(int mask_already, int prev, int first) {
        if(mask_already==(1<<n) - 1) {
            return pre_stop_and_start[prev][first];
        }
        if(dp[mask_already][prev][first] != -1) {
            return dp[mask_already][prev][first];
        }
        int max = 0;
        for(int i=0;i<n;++i) {
            if((mask_already&(1<<i)) == 0) {
                max = max(max, min(pre[prev][i], f(mask_already|(1<<i), i, first)));
            }
        }
        return dp[mask_already][prev][first] = max;
    }
}