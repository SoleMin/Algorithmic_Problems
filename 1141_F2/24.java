import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskF solver = new TaskF();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskF {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            Map<Integer, List<Range>> rgs = new HashMap<Integer, List<Range>>();
            for (int i = 0; i < n; i++) {
                int s = 0;
                for (int j = i; j < n; j++) {
                    s += a[j];

                    if (rgs.get(s) == null) {
                        rgs.put(s, new ArrayList<Range>());
                    }

                    rgs.get(s).add(new Range(i, j));
                }
            }

            Iterator it = rgs.entrySet().iterator();

            List<Range> ans = new ArrayList<Range>();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                int sum = (int) pair.getKey();
                Object[] intermediate = ((List<Object[]>) pair.getValue()).toArray();
                Range[] ranges = new Range[intermediate.length];
                for (int i = 0; i < intermediate.length; i++) {
                    ranges[i] = (Range) intermediate[i];
                }
                Arrays.sort(ranges);

                List<Range> cand = new ArrayList<Range>();

                for (Range r : ranges) {
                    if (cand.size() == 0) {
                        cand.add(r);
                        continue;
                    }

                    if (cand.get(cand.size() - 1).j < r.i) {
                        cand.add(r);
                    } else {
                        if (cand.get(cand.size() - 1).j > r.j) {
                            cand.remove(cand.size() - 1);
                            cand.add(r);
                        }
                    }
                }

                if (cand.size() > ans.size()) {
                    ans = cand;
                }
            }

            out.println(ans.size());
            for (Range r : ans) {
                out.println((r.i + 1) + " " + (r.j + 1));
            }
        }

        public class Range implements Comparable {
            public int i;
            public int j;

            public Range(int i, int j) {
                this.i = i;
                this.j = j;
            }

            public int compareTo(Object o) {
                Range t = (Range) o;
                if (this.i == t.i) {
                    if (this.j < t.j) return 1;
                    else return 0;
                }
                if (this.i < t.i) return 1;
                return 0;
            }

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
}

