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
import java.math.BigInteger;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author darkhan imangaliyev
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyReader in = new MyReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, MyReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                if (map.containsKey(a[i])) {
                    map.put(a[i], map.get(a[i]) + 1);
                } else {
                    map.put(a[i], 1);
                }
            }
            List<Integer> compressed = new ArrayList<>();
            compressed.add(-1);
            compressed.add(Integer.MAX_VALUE);
            compressed.addAll(map.keySet());
            Collections.sort(compressed);
            //        System.out.println(compressed);
            int N = compressed.size() + 10;
            BIT count = new BIT(N);
            BIT sum = new BIT(N);

            BigInteger ret = BigInteger.ZERO;
            for (int i = n - 1; i >= 0; --i) {
                int l = findLeft(compressed, a[i] - 2);
                int r = findRight(compressed, a[i] + 2);
                long left = sum.sum(0, l);
                long countLeft = count.sum(0, l);
                long right = sum.sum(r, N);
                long countRight = count.sum(r, N);
                //            System.out.println("b[i] = " + b[i]);
                //            System.out.println("l = " + l + ", r = " + r);
                //            System.out.println("left = " + left + ", right = " + right);
                //            System.out.println("countLeft = " + countLeft + ", countRight = " + countRight);
                //            System.out.println();
                long t = (left - countLeft * a[i]) + (right - a[i] * countRight);
                ret = ret.add(BigInteger.valueOf(t));
                int x = Collections.binarySearch(compressed, a[i]);
                sum.update(x, a[i]);
                count.update(x, 1);
            }
            out.println(ret);
        }

        private int findLeft(List<Integer> a, int t) {
            int lo = -1, hi = a.size();
            while (hi - lo > 1) {
                int m = lo + (hi - lo) / 2;
                if (a.get(m) <= t) {
                    lo = m;
                } else {
                    hi = m;
                }
            }
            return lo;
        }

        private int findRight(List<Integer> a, int t) {
            int lo = -1, hi = a.size();
            while (hi - lo > 1) {
                int m = lo + (hi - lo) / 2;
                if (a.get(m) < t) {
                    lo = m;
                } else {
                    hi = m;
                }
            }
            return hi;
        }

        class BIT {
            long[] tree;

            public BIT(int n) {
                tree = new long[n + 1];
            }

            public void update(int x, long d) {
                while (x < tree.length) {
                    tree[x] += d;
                    x += x & -x;
                }
            }

            public long sum(int l, int r) {
                return sum(r) - sum(l - 1);
            }

            public long sum(int x) {
                long sum = 0;
                while (x > 0) {
                    sum += tree[x];
                    x -= x & -x;
                }
                return sum;
            }

        }

    }

    static class MyReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public MyReader(InputStream stream) {
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

