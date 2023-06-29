import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        TaskE2 solver = new TaskE2();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE2 {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int numTests = in.nextInt();
            for (int test = 0; test < numTests; test++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int[][] a = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        a[i][j] = in.nextInt();
                    }
                }

                if (m > n) {
                    int[] maxInColumn = new int[m];
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n; i++) {
                            maxInColumn[j] = Math.max(maxInColumn[j], a[i][j]);
                        }
                    }
                    Integer[] cols = new Integer[m];
                    for (int i = 0; i < m; i++) {
                        cols[i] = i;
                    }
                    Arrays.sort(cols, (u, v) -> -(maxInColumn[u] - maxInColumn[v]));

                    int[][] na = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            na[i][j] = a[i][cols[j]];
                        }
                    }
                    m = n;
                    a = na;
                }

                int[] buf = new int[n];
                int[][] sums = new int[m][1 << n];
                int[] sumsCur = new int[1 << n];
                for (int j = 0; j < m; j++) {
                    for (int shift = 0; shift < n; shift++) {
                        for (int i = 0; i < n; i++) {
                            buf[i] = a[(i + shift) % n][j];
                        }
                        for (int mask = 1; mask < 1 << n; mask++) {
                            int k = Integer.numberOfTrailingZeros(mask);
                            sumsCur[mask] = sumsCur[mask ^ (1 << k)] + buf[k];
                            sums[j][mask] = Math.max(sums[j][mask], sumsCur[mask]);
                        }
                    }
                }

                int[] d = new int[1 << n];
                for (int j = 0; j < m; j++) {
                    for (int mask = (1 << n) - 1; mask >= 0; mask--) {
                        for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                            d[mask] = Math.max(d[mask], d[mask ^ submask] + sums[j][submask]);
                        }
                    }
                }
                int ans = 0;
                for (int x : d) {
                    ans = Math.max(ans, x);
                }
                out.println(ans);
            }
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

