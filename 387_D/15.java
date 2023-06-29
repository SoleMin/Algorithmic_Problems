//package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);
    StringTokenizer stringTokenizer;

    String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(reader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    final int MOD = 1000 * 1000 * 1000 + 7;
    int sum(int a, int b) {
        a += b;
        return a >= MOD ? a - MOD : a;
    }

    @SuppressWarnings("unchecked")
    void solve() throws IOException {
        final int n = nextInt();
        int m = nextInt();
        int[] from = new int[m];
        int[] to = new int[m];
        for(int i = 0; i < m; i++) {
            from[i] = nextInt();
            to[i] = nextInt();
        }
        int ans = solve(n, m, from, to);
        writer.println(ans);
        writer.close();
    }

    private int solve(final int n, int m, int[] from, int[] to) {
        final List<List<Integer>> g = new ArrayList<>();
        final List<List<Integer>> rg = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            g.add(new ArrayList<Integer>());
            rg.add(new ArrayList<Integer>());
        }
        int[] c = new int[n + 1];
        int[] loop = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int u = from[i];
            int v = to[i];
            g.get(u).add(v);
            rg.get(v).add(u);
            c[u]++;
            c[v]++;
            if(u == v) {
                loop[u]++;
            }
        }
        class Utils {
            int[] prev = new int[n + 1];
            int[] next = new int[n + 1];
            int[] used = new int[n + 1];
            int mark;
            int forbidden;
            int maxMatch() {
                maxMatch = 0;
                for(int i = 1; i <= n; i++) {
                    mark = i;
                    if(findPath(i)) {
                        maxMatch++;
                    }
                }
                return maxMatch;
            }
            boolean findPath(int u) {
                if(u == forbidden) {
                    return false;
                }
                used[u] = mark;
                for (int v : g.get(u)) {
                    if(v == forbidden) {
                        continue;
                    }
                    if(prev[v] == 0 || (used[prev[v]] != mark && findPath(prev[v]))) {
                        prev[v] = u;
                        next[u] = v;
                        return true;
                    }
                }
                return false;
            }
            int maxMatch = 0;
            void amend(int u) {
//                Arrays.fill(used, false);
                if(findPath(u)) {
                    maxMatch++;
                }
            }
            void cancel(int u) {
                forbidden = u;
                int v = next[u];
                if(v != 0) {
                    maxMatch--;
                    prev[v] = 0;
                    next[u] = 0;
                    for (int i : rg.get(v)) {
                        if(next[i] == 0) {
                            amend(i);
                        }
                    }
//                    amend(v);
                }
                if(prev[u] != 0) {
                    maxMatch--;
                    amend(prev[u]);
                    prev[u] = 0;
                }
            }
        }
//        Utils utils = new Utils();
//        for(int i = 1; i <= n; i++) {
//            utils.amend(i);
//        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
//            utils.cancel(i);
//            utils.amend(i - 1);
            Utils utils = new Utils();
            utils.forbidden = i;
            utils.maxMatch();
            ans = Math.min(ans, (2 * n - 1 - c[i] + loop[i]) + (m - c[i] + loop[i] - utils.maxMatch) + (n - 1 - utils.maxMatch));
        }
        return ans;
    }

    void test() {
        final int N = 4;
        final int[] ef = new int[N * N];
        final int[] et = new int[N * N];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                ef[(i - 1) * N + j - 1] = i;
                et[(i - 1) * N + j - 1] = j;
            }
        }
        List<Integer> good = new ArrayList<>();
        for(int mask = 0; mask < 1 << N * N; mask++) {
            int[] in = new int[N + 1];
            int[] out = new int[N + 1];
            for(int i = 0; i < N * N; i++) {
                if((mask >> i) % 2 == 1) {
                    out[ef[i]]++;
                    in[et[i]]++;
                }
            }
            boolean ok = false;
            for(int i = 1; i <= N; i++) {
                if(in[i] == N && out[i] == N) {
                    in[i] = 2;
                    out[i] = 2;
                    ok = true;
                    break;
                }
            }
            for(int i = 1; i <= N; i++) {
                if(in[i] != 2 || out[i] != 2) {
                    ok = false;
                }
            }
            if(ok) {
                good.add(mask);
            }
        }
        System.out.println("good graphs count: " + good.size());
        for (int mask : good) {
            int m = Integer.bitCount(mask);
            int[] from = new int[m];
            int[] to = new int[m];
            int index = 0;
            for(int i = 0; i < N * N; i++) {
                if((mask >> i) % 2 == 1) {
                    from[index] = ef[i];
                    to[index] = et[i];
                    index++;
                }
            }
            if(solve(N, m, from, to) != 0) {
                writer.println(N + " " + m);
                for(int i = 0; i < m; i++) {
                    writer.println(from[i] + " " + to[i]);
                }
                writer.close();
                return;
            }
        }
        for(int mask = 0; mask < 1 << N * N; mask++) {
            int optimal = Integer.MAX_VALUE;
            for (Integer i : good) {
                optimal = Math.min(optimal, Integer.bitCount(i ^ mask));
            }
            int m = Integer.bitCount(mask);
            int[] from = new int[m];
            int[] to = new int[m];
            int index = 0;
            for(int i = 0; i < N * N; i++) {
                if((mask >> i) % 2 == 1) {
                    from[index] = ef[i];
                    to[index] = et[i];
                    index++;
                }
            }
            final int fast = solve(N, m, from, to);
            if(optimal != fast) {
                System.out.println("fast = " + fast + ", optimal = " + optimal);
                writer.println(N + " " + m);
                for(int i = 0; i < m; i++) {
                    writer.println(from[i] + " " + to[i]);
                }
                writer.close();
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new D().solve();
    }
}
