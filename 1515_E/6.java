import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            int MOD = in.nextInt();

            int[][] C = new int[n + 1][n + 1];
            C[0][0] = 1;
            for (int i = 1; i < C.length; i++) {
                C[i][0] = 1;
                for (int j = 1; j < C.length; j++) {
                    C[i][j] = C[i - 1][j] + C[i - 1][j - 1];
                    if (C[i][j] >= MOD) {
                        C[i][j] -= MOD;
                    }
                }
            }

            int[] p2 = new int[n + 1];
            p2[0] = 1;
            for (int i = 1; i < p2.length; i++) {
                p2[i] = 2 * p2[i - 1] % MOD;
            }

            int[][] d = new int[n + 1][n + 1];
            d[0][0] = 1;
            // Total.
            for (int i = 1; i <= n; i++) {
                // Switched on manually.
                for (int j = 1; j <= i; j++) {
                    // Switched on manually in the first block.
                    for (int t = 1; t <= j; t++) {
                        if (t == i - 1) {
                            continue;
                        }
                        d[i][j] = (int) ((d[i][j] + (long) C[j][t] * p2[t - 1] % MOD * d[i - t - (i == t ? 0 : 1)][j - t]) % MOD);
                    }
                }
            }

            int ans = 0;
            for (int k = 1; k <= n; k++) {
                ans += d[n][k];
                if (ans >= MOD) {
                    ans -= MOD;
                }
            }

            out.println(ans);
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

