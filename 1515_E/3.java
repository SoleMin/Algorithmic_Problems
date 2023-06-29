import java.io.*;
import java.util.*;

/*
polyakoff
*/

public class Main {

    static FastReader in;
    static PrintWriter out;
    static Random rand = new Random();
    static final int oo = (int) 1e9 + 10;
    static final long OO = (long) 1e18 + 10;
    static final int MOD = (int) 1e9 + 7;

    static int M;
    static long[] f, fi, two;

    static long pow(long a, long b) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1)
                res = (res * a) % M;
            a = (a * a) % M;
            b >>= 1;
        }
        return res;
    }

    static long C(int n, int k) {
        return f[n] * fi[k] % M * fi[n - k] % M;
    }

    static void prepare(int n) {
        f = new long[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = (f[i - 1] * i) % M;
        }
        fi = new long[n];
        for (int i = 0; i < n; i++) {
            fi[i] = pow(f[i], M - 2);
        }
        two = new long[n];
        two[0] = 1;
        for (int i = 1; i < n; i++) {
            two[i] = (two[i - 1] * 2) % M;
        }
    }

    static void solve() {
        int n = in.nextInt();
        M = in.nextInt();
        prepare(n + 10);
        long[][] dp = new long[n + 1][n];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = two[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j < n; j++) {
                for (int k = 1; k <= i - 2; k++) {
                    if (k < j - 2)
                        continue;
                    int len = i - k - 1;
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * two[len - 1] % M * C(k - (j - 2) + len, len) % M) % M;
                }
            }
        }
        long ans = 0;
        for (int j = 1; j < n; j++) {
            ans = (ans + dp[n][j]) % M;
        }
        out.println(ans);

    }

    public static void main(String[] args) {
        in = new FastReader();
        out = new PrintWriter(System.out);

        int t = 1;
//        t = in.nextInt();
        while (t-- > 0) {
            solve();
        }

        out.flush();
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            this(System.in);
        }
        FastReader(String file) throws FileNotFoundException {
            this(new FileInputStream(file));
        }
        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }
        String nextLine() {
            String line;
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }
    }
}
