import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */

public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FCookies solver = new FCookies();
        solver.solve(1, in, out);
        out.close();
    }

    static class FCookies {
        long[] BIT;
        long[] BIT1;
        int[] cookie;
        int[] time;
        long[] max;
        long T;
        int[][][] G;

        void update(int x, long delta) {
            for (; x <= 1000001; x += x & -x)
                BIT[x] += delta;
        }

        long query(int x) {
            if (x <= 0) return 0;
            long sum = 0;
            for (; x > 0; x -= x & -x)
                sum += BIT[x];
            return sum;
        }

        void update1(int x, long delta) {
            for (; x <= 1000001; x += x & -x)
                BIT1[x] += delta;
        }

        long query1(int x) {
            if (x <= 0) return 0;
            long sum = 0;
            for (; x > 0; x -= x & -x)
                sum += BIT1[x];
            return sum;
        }

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            BIT = new long[1000001];
            BIT1 = new long[1000001];
            int n = in.scanInt();
            T = in.scanLong();
            cookie = new int[n + 1];
            time = new int[n + 1];
            max = new long[n + 1];
            for (int i = 1; i <= n; i++) cookie[i] = in.scanInt();
            for (int i = 1; i <= n; i++) time[i] = in.scanInt();
            int[] from = new int[n - 1];
            int[] to = new int[n - 1];
            int[] weight = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                from[i] = i + 2;
                to[i] = in.scanInt();
                weight[i] = in.scanInt();
            }
            G = CodeHash.packGraphW(from, to, weight, n);
            dfs(1, -1, 0);
            out.println(max[1]);

        }

        private void dfs(int n, int p, long t) {
            update(time[n], ((long) time[n]) * cookie[n]);
            update1(time[n], cookie[n]);
            if (t > T) {
                max[n] = 0;
                update(time[n], -(((long) time[n]) * cookie[n]));
                update1(time[n], -cookie[n]);
                return;
            } else max[n] = findMax(T - t);
            long max1 = 0;
            long max2 = 0;
            for (int[] i : G[n]) {
                if (i[0] == p) continue;
                dfs(i[0], n, t + 2 * i[1]);
                if (max1 <= max[i[0]]) {
                    max2 = max1;
                    max1 = max[i[0]];
                } else if (max2 <= max[i[0]]) {
                    max2 = max[i[0]];
                }
            }
            update(time[n], -(((long) time[n]) * cookie[n]));
            update1(time[n], -cookie[n]);
            if (n != 1) max[n] = Math.max(max[n], max2);
            else max[n] = Math.max(max[n], max1);
        }

        private long findMax(long TT) {
            int index2 = -1;
            {
                int low = 0;
                int high = 1000000;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (query(mid) <= TT) {
                        index2 = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            if (index2 == -1) return 0;
            if (query(index2) == TT) return query1(index2);
            int index = -1;
            {
                int low = index2 + 1;
                int high = 1000000;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (query(mid) > TT) {
                        index = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            if (index == -1) return query1(index2);
            long index1 = -1;
            {
                long low = 0;
                long high = query1(index) - query1(index - 1);
                long prev = query(index - 1);
                while (low <= high) {
                    long mid = (low + high) / 2;
                    if (prev + ((mid) * index) <= TT) {
                        index1 = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            if (index1 == -1) return 0;
            return query1(index - 1) + index1;

        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

        public long scanLong() {
            long integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

    }

    static class CodeHash {
        public static int[][][] packGraphW(int[] from, int[] to, int[] w, int n) {
            int[][][] g = new int[n + 1][][];
            int[] p = new int[n + 1];
            for (int i : from) p[i]++;
            for (int i : to) p[i]++;
            for (int i = 0; i <= n; i++) g[i] = new int[p[i]][2];
            for (int i = 0; i < from.length; i++) {
                --p[from[i]];
                g[from[i]][p[from[i]]][0] = to[i];
                g[from[i]][p[from[i]]][1] = w[i];
                --p[to[i]];
                g[to[i]][p[to[i]]][0] = from[i];
                g[to[i]][p[to[i]]][1] = w[i];
            }
            return g;
        }

    }
}