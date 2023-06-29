import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.ni();
            int[] a = in.na(n);
            TreeMap<Integer, TreeMap<Integer, Segment>> map = new TreeMap<>();
            int[] pref = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pref[i + 1] = pref[i] + a[i];
            }

            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    int val = pref[i + 1] - pref[j];
                    TreeMap<Integer, Segment> dp = map.computeIfAbsent(val, k -> new TreeMap<>());
                    if (!dp.containsKey(i)) {

                        Map.Entry<Integer, Segment> lastEntry = dp.lastEntry();
                        if (lastEntry == null) {
                            dp.put(i, new Segment(j, i, 1, null));
                        } else {
                            Segment lastValue = lastEntry.getValue();
                            Map.Entry<Integer, Segment> prev = dp.lowerEntry(j);
                            if (prev == null) {
                                if (lastValue.dp >= 1)
                                    dp.put(i, lastValue);
                                else
                                    dp.put(i, new Segment(j, i, 1, null));
                            } else if (lastValue.dp >= prev.getValue().dp + 1) {
                                dp.put(i, lastValue);
                            } else {
                                dp.put(i, new Segment(j, i, prev.getValue().dp + 1, prev.getValue()));
                            }
                        }
                    }
                }
            }
            Segment best = null;
            for (TreeMap<Integer, Segment> segments : map.values()) {
                Segment seg = segments.lastEntry().getValue();
                if (best == null || best.dp < seg.dp) {
                    best = seg;
                }
            }
            if (best == null)
                throw new RuntimeException("Null best");
            out.println(best.dp);
            while (best != null) {
                out.printf("%d %d%n", best.from + 1, best.to + 1);
                best = best.prev;
            }
        }

        class Segment {
            int from;
            int to;
            int dp;
            Segment prev;

            public Segment(int from, int to, int dp, Segment prev) {
                this.from = from;
                this.to = to;
                this.dp = dp;
                this.prev = prev;
            }

        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
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

        public int ni() {
            return Integer.parseInt(ns());
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

    }
}

