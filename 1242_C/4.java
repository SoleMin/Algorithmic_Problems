import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int n;
        int[] bitCount;
        long neededSum;
        long[] sums;
        Map<Long, Integer> where;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            n = in.nextInt();
            int[][] a = new int[n][];
            neededSum = 0;
            sums = new long[n];
            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                a[i] = new int[k];
                for (int j = 0; j < k; j++) {
                    a[i][j] = in.nextInt();
                    neededSum += a[i][j];
                    sums[i] += a[i][j];
                }
            }

            if (neededSum % n != 0) {
                out.println("No");
                return;
            }
            neededSum /= n;

            where = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    where.put((long) a[i][j], i);
                }
            }
            bitCount = new int[1 << n];
            for (int i = 0; i < bitCount.length; i++) {
                bitCount[i] = Integer.bitCount(i);
            }

            Entry[][] cycleSol = new Entry[1 << n][];

            List<Entry> sol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int x : a[i]) {
                    search(i, i, x, x, 0, 0, sol, cycleSol);
                }
            }

            boolean[] can = new boolean[1 << n];
            int[] via = new int[1 << n];
            can[0] = true;
            for (int mask = 0; mask < 1 << n; mask++) {
                for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                    if (cycleSol[submask] != null && can[mask ^ submask]) {
                        can[mask] = true;
                        via[mask] = submask;
                    }
                }
            }

            if (!can[(1 << n) - 1]) {
                out.println("No");
                return;
            }

            int[][] ans = new int[n][2];
            for (int mask = (1 << n) - 1; mask > 0; ) {
                int sm = via[mask];
                mask ^= sm;

                for (Entry e : cycleSol[sm]) {
                    ans[e.from][0] = e.what;
                    ans[e.from][1] = e.to + 1;
                }
            }

            out.println("Yes");
            for (int i = 0; i < n; i++) {
                out.println(ans[i][0] + " " + ans[i][1]);
            }
        }

        private void search(int start, int cur, long fromStart, long fromCur, int hasIn, int hasOut, List<Entry> sol, Entry[][] cycleSol) {
            for (int i = start; i < n; i++) {
                if ((hasIn & (1 << i)) > 0) {
                    continue;
                }
                if ((hasOut & (1 << cur)) > 0) {
                    continue;
                }
                long fromI = sums[i] + fromCur - neededSum;
                Integer w = where.get(fromI);
                if (w == null || w != i) {
                    continue;
                }
                sol.add(new Entry(cur, i, (int) fromCur));
                int nHasIn = hasIn | (1 << i);
                int nHasOut = hasOut | (1 << cur);
                if (i == start && fromI == fromStart) {
                    cycleSol[nHasOut] = sol.toArray(new Entry[0]);
                }
                search(start, i, fromStart, fromI, nHasIn, nHasOut, sol, cycleSol);
                sol.remove(sol.size() - 1);
            }
        }

        class Entry {
            int from;
            int to;
            int what;

            Entry(int from, int to, int what) {
                this.from = from;
                this.to = to;
                this.what = what;
            }

            public String toString() {
                return from + " " + to + " " + what;
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
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
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

