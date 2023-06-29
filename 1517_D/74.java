import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
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
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DExplorerSpace solver = new DExplorerSpace();
        solver.solve(1, in, out);
        out.close();
    }

    static class DExplorerSpace {
        int n;
        int m;
        int k;
        int[][] col;
        int[][] row;
        long[][][] memo;

        public void readInput(Scanner sc) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            col = new int[n][m - 1];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m - 1; j++)
                    col[i][j] = sc.nextInt();
            row = new int[n - 1][m];
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < m; j++)
                    row[i][j] = sc.nextInt();
        }

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = 1;
            while (q-- > 0) {
                readInput(sc);
                if (k % 2 == 1) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++)
                            pw.print(-1 + " ");
                        pw.println();
                    }
                    return;
                }
                memo = new long[k + 1][n][m];
                for (long[][] x : memo)
                    for (long[] y : x)
                        Arrays.fill(y, -1);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        pw.print(2l * dp(i, j, k / 2) + " ");
                    }
                    pw.println();
                }
            }
        }

        private long dp(int i, int j, int rem) {
            if (rem == 0)
                return 0;
            if (memo[rem][i][j] != -1)
                return memo[rem][i][j];
            long min = (long) 1e18;
            if (j <= m - 2)
                min = Math.min(min, col[i][j] + dp(i, j + 1, rem - 1));
            if (j > 0)
                min = Math.min(min, col[i][j - 1] + dp(i, j - 1, rem - 1));
            if (i <= n - 2)
                min = Math.min(min, row[i][j] + dp(i + 1, j, rem - 1));
            if (i > 0)
                min = Math.min(min, row[i - 1][j] + dp(i - 1, j, rem - 1));
            return memo[rem][i][j] = min;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

