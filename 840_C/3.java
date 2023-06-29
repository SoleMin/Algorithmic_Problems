import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        final int MOD = (int) (1e9 + 7);
        long[][] C;
        long[] fact;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            precalc(n);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                a[i] = removeSquares(a[i]);
            }
            int[] g = getGroupSizes(a);
            long ans = solve(g);
            for (int x : g) {
                ans = ans * fact[x] % MOD;
            }
            out.println(ans);
        }

        private long solve(int[] a) {
            // For a description, see http://petr-mitrichev.blogspot.com/2017/07/a-week7.html
            long[] d = new long[1];
            d[0] = 1;
            int totalPositions = 1;
            for (int x : a) {
                long[] nd = new long[d.length + x + 1];
                for (int s = 0; s < d.length; s++) {
                    if (d[s] == 0) {
                        continue;
                    }
                    for (int m = 1; m <= x; m++) {
                        for (int p = 0; p <= s && p <= m; p++) {
                            long cur = d[s];
                            cur = cur * C[s][p] % MOD;
                            cur = cur * C[totalPositions - s][m - p] % MOD;
                            cur = cur * f(x, m) % MOD;
                            int ns = s + x - m - p;
                            nd[ns] += cur;
                            if (nd[ns] >= MOD) {
                                nd[ns] -= MOD;
                            }
                        }
                    }
                }
                totalPositions += x;
                d = nd;
            }
            return d[0];
        }

        private long f(int n, int k) {
            if (n < k) {
                return 0;
            }
            n -= k;
            return C[n + k - 1][k - 1];
        }

        private void precalc(int n) {
            fact = new long[n + 1];
            fact[0] = 1;
            for (int i = 1; i < fact.length; i++) {
                fact[i] = i * fact[i - 1] % MOD;
            }

            C = new long[1000][1000];
            C[0][0] = 1;
            for (int i = 1; i < C.length; i++) {
                C[i][0] = 1;
                for (int j = 1; j < C.length; j++) {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                    if (C[i][j] >= MOD) {
                        C[i][j] -= MOD;
                    }
                }
            }
        }

        private int[] getGroupSizes(int[] a) {
            Arrays.sort(a);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < a.length; ) {
                int j = i;
                while (j < a.length && a[i] == a[j]) {
                    ++j;
                }
                res.add(j - i);
                i = j;
            }
            int[] r = new int[res.size()];
            for (int i = 0; i < r.length; i++) {
                r[i] = res.get(i);
            }
            return r;
        }

        private int removeSquares(int n) {
            int res = 1;
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) {
                    int cur = 0;
                    while (n % d == 0) {
                        n /= d;
                        ++cur;
                    }
                    if (cur % 2 == 1) {
                        res *= d;
                    }
                }
            }
            if (n > 1) {
                res *= n;
            }
            return res;
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

