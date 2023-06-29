import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class SolutionD extends Thread {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                                            InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static final FastReader scanner = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        solve();
        out.close();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] hori = new int[n][m-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-1; j++) {
                int xij = scanner.nextInt();
                hori[i][j] = xij;
            }
        }

        int[][] vert = new int[n-1][m];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                int xij = scanner.nextInt();
                vert[i][j] = xij;
            }
        }

        if (k % 2 != 0) {
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    s.append("-1 ");
                }
                out.println(s);
            }
            return;
        }

        k /= 2;

        long[][][] dp = new long[n][m][k+1];

        for (int kTmp = 1; kTmp <= k; kTmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j][kTmp] = Integer.MAX_VALUE;
                    if (i > 0) {
                        dp[i][j][kTmp] = Math.min(dp[i][j][kTmp], dp[i-1][j][kTmp-1] + 2L * vert[i - 1][j]);
                    }
                    if (j > 0) {
                        dp[i][j][kTmp] = Math.min(dp[i][j][kTmp], dp[i][j-1][kTmp-1] + 2L * hori[i][j - 1]);
                    }
                    if (i + 1 < n) {
                        dp[i][j][kTmp] = Math.min(dp[i][j][kTmp], dp[i+1][j][kTmp-1] + 2L * vert[i][j]);
                    }
                    if (j + 1 < m) {
                        dp[i][j][kTmp] = Math.min(dp[i][j][kTmp], dp[i][j+1][kTmp-1] + 2L * hori[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < m; j++) {
                s.append(dp[i][j][k]).append(" ");
            }
            out.println(s);
        }
    }
}