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
        TaskE1 solver = new TaskE1();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE1 {
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
                int[] d = new int[1 << n];
                int[] nd = new int[1 << n];
                for (int j = 0; j < m; j++) {
                    System.arraycopy(d, 0, nd, 0, d.length);
                    for (int mask = 0; mask < 1 << n; mask++) {
                        for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                            for (int shift = 0; shift < n; shift++) {
                                int sum = 0;
                                for (int i = 0; i < n; i++) {
                                    if ((submask & (1 << i)) > 0) {
                                        sum += a[(i + shift) % n][j];
                                    }
                                }
                                nd[mask] = Math.max(nd[mask], d[mask ^ submask] + sum);
                            }
                        }
                    }
                    int[] t = d;
                    d = nd;
                    nd = t;
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

