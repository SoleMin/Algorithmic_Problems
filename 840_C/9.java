import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OnTheBench solver = new OnTheBench();
        solver.solve(1, in, out);
        out.close();
    }

    static class OnTheBench {
        long MOD = (long) (1e9) + 7;
        long[][] C = new long[333][333];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            DisjointSet dsu = new DisjointSet(N);
            long[] arr = new long[N];
            setC();
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long sqrt = (long) (Math.sqrt(arr[i] * arr[j]));
                    long sqrt2 = (long) (Math.ceil(Math.sqrt(arr[i] * arr[j])));
                    if (sqrt * sqrt == arr[i] * arr[j] || sqrt2 * sqrt2 == arr[i] * arr[j]) {
                        dsu.merge(i, j);
                    }
                }
            }
            ArrayList<Integer> sz = new ArrayList<>();
            sz.add(0);
            HashMap<Integer, Integer> seen = new HashMap<>();
            long mult = 1;
            for (int i = 0; i < N; i++) {
                if (!seen.containsKey(dsu.find(i))) {
                    seen.put(dsu.find(i), sz.size());
                    sz.add(0);
                }
                sz.set(seen.get(dsu.find(i)), sz.get(seen.get(dsu.find(i))) + 1);
            }
            for (int i : sz) {
//            if (arr[0] == 285) {
//                out.println(i);
//            }
                mult *= fact(i);
                mult %= MOD;
            }
            long[][] dp = new long[sz.size()][333];
            int sum = 0;
            dp[0][0] = 1;
            for (int n = 1; n < dp.length; n++) {
                for (int ij = 1; ij <= sz.get(n); ij++) {
                    for (int y = 0; y <= sum; y++) {
                        for (int j = 0; j <= Math.min(y, ij); j++) {
                            int i = ij - j;
                            dp[n][y - j + sz.get(n) - ij] += ((((dp[n - 1][y] * C[sum + 1 - y][i]) % MOD * C[y][j]) % MOD) * C[sz.get(n) - 1][ij - 1]) % MOD;
                            dp[n][y - j + sz.get(n) - ij] %= MOD;
                        }
                    }
                }
                sum += sz.get(n);
            }
            out.println((dp[sz.size() - 1][0] * mult) % MOD);
        }

        void setC() {
            for (int i = 0; i <= 332; i++) {
                C[i][0] = 1;
                for (int j = 1; j <= i; j++) {
                    C[i][j] = C[i - 1][j] + C[i - 1][j - 1];
                    C[i][j] %= MOD;
                }
            }
        }

        long fact(int i) {
            long res = 1;
            while (i > 0) {
                res *= i;
                res %= MOD;
                i--;
            }
            return res;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class DisjointSet {
        int[] rank;
        int[] par;

        public DisjointSet(int N) {
            rank = new int[N];
            par = new int[N];
            for (int i = 0; i < N; i++) {
                rank[i] = 1;
                par[i] = i;
            }
        }

        public int find(int x) {
            if (x == par[x]) {
                return x;
            }
            return (par[x] = find(par[x]));
        }

        public void merge(int x, int y) {
            int parX = find(x);
            int parY = find(y);
            if (parX != parY) {
                if (rank[parX] > rank[parY]) {
                    par[parY] = parX;
                    rank[parX] += rank[parY];
                } else {
                    par[parX] = parY;
                    rank[parY] += rank[parX];
                }
            }
        }

    }
}

