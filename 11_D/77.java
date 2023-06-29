import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ATailouloute
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        QuickScanner in = new QuickScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, QuickScanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[][] is = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                is[i][i] = true;
            }
            long[][] dp = new long[1 << n | 1][n];
            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                is[u][v] = is[v][u] = true;
                dp[(1 << u) + (1 << v)][v] = 1;
                dp[(1 << u) + (1 << v)][u] = 1;
            }
            int k = 0;
            long res = 0;
            for (int mask = 1; mask < 1 << n; ++mask) {
                boolean f = true;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0 && dp[mask][i] == 0) {
                        if (f) {
                            f = false;
                            k = i;
                        } else {
                            for (int j = k + 1; j < n; j++) {
                                if ((mask & (1 << j)) != 0 && is[i][j]) {
                                    dp[mask][i] += dp[mask - (1 << i)][j];
                                }
                            }
                        }
                        if (is[k][i]) res += dp[mask][i];
                    }
                }
            }
            out.println(res >> 1);
        }

    }

    static class QuickScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream is;

        public QuickScanner(InputStream stream) {
            is = stream;
            br = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

    }
}

