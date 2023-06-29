import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aman Kumar Singh
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        G1PlaylistForPolycarpEasyVersion solver = new G1PlaylistForPolycarpEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class G1PlaylistForPolycarpEasyVersion {
        final long mod = 1000000007;
        PrintWriter out;
        InputReader in;
        int n;
        int time;
        int[][] arr;
        long[][][] dp;

        long go(int last, int t, int mask) {
            if (t > time)
                return 0;
            if (t == time) {
                return 1l;
            }
            if (mask == (1 << n) - 1)
                return 0;
            if (dp[last][t][mask] != -1)
                return dp[last][t][mask];
            long cnt = 0;
            int i = 0, j = 0;
            for (i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0 && arr[i][1] != last) {
                    cnt += go(arr[i][1], t + arr[i][0], mask | (1 << i));
                    cnt %= mod;

                }
            }
            dp[last][t][mask] = cnt;
            return cnt;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            n = ni();
            time = ni();
            arr = new int[n][2];
            int i = 0;
            for (i = 0; i < n; i++) {
                arr[i][0] = ni();
                arr[i][1] = ni() - 1;
            }
            dp = new long[3][time + 1][1 << n];
            for (i = 0; i < 3; i++) {
                for (int j = 0; j <= time; j++)
                    Arrays.fill(dp[i][j], -1);
            }
            long ans = (((go(0, 0, 0) + go(1, 0, 0)) % mod + go(2, 0, 0)) % mod);
            ans *= modPow(2, mod - 2);
            ans %= mod;
            pn(ans);
        }

        int ni() {
            return in.nextInt();
        }

        void pn(Object o) {
            out.println(o);
        }

        long modPow(long a, long p) {
            long o = 1;
            while (p > 0) {
                if ((p & 1) == 1) o = mul(o, a);
                a = mul(a, a);
                p >>= 1;
            }
            return o;
        }

        long mul(long a, long b) {
            if (a >= mod) a %= mod;
            if (b >= mod) b %= mod;
            a *= b;
            if (a >= mod) a %= mod;
            return a;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

