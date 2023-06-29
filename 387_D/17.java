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
        for(int i = 0; i <= n; i++) {
            g.add(new ArrayList<Integer>());
        }
        int[] c = new int[n + 1];
        int[] loop = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int u = from[i];
            int v = to[i];
            g.get(u).add(v);
            c[u]++;
            c[v]++;
            if(u == v) {
                loop[u]++;
            }
        }
        class Utils {
            int[] prev = new int[n + 1];
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
                        return true;
                    }
                }
                return false;
            }
            int maxMatch = 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            Utils utils = new Utils();
            utils.forbidden = i;
            utils.maxMatch();
            ans = Math.min(ans, (2 * n - 1 - c[i] + loop[i]) + (m - c[i] + loop[i] - utils.maxMatch) + (n - 1 - utils.maxMatch));
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        new D().solve();
    }
}
