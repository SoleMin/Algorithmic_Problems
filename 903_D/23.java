import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.SplittableRandom;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = in.nextIntArray(n);
            int[] b = a.clone();
            b = Arrays.copyOf(b, a.length + 2);
            b[a.length] = 0;
            b[a.length + 1] = (int) 2e9;
            ArrayUtils.sort(b);
            b = ArrayUtils.uniqueArray(b);
            SegmentTreeSumL segmentTreeSumL = new SegmentTreeSumL(b.length + 1);
            SegmentTreeSumL size = new SegmentTreeSumL(b.length + 1);
            for (int i = 0; i < n; ++i) {
                segmentTreeSumL.update(Arrays.binarySearch(b, a[i]), a[i]);
                size.update(Arrays.binarySearch(b, a[i]), 1);
            }
            Debug debug = new Debug(out);
            BigInteger sum = new BigInteger("0");
            for (int i = 0; i < n; ++i) {
                segmentTreeSumL.update(Arrays.binarySearch(b, a[i]), -a[i]);
                size.update(Arrays.binarySearch(b, a[i]), -1);
                int indG = ArrayUtils.LowerBound(b, a[i] + 2);
                indG = Math.min(indG, b.length);
                long s1 = size.getRangeSum(indG, b.length);
                long sum1 = segmentTreeSumL.getRangeSum(indG, b.length);
                //debug.tr("1", s1, sum1);
                sum = sum.add(BigInteger.valueOf(sum1 - s1 * a[i]));
                int indL = ArrayUtils.LowerBound(b, a[i] - 1) - 1;
                indL = Math.max(0, indL);
                long s2 = size.getRangeSum(0, indL);
                long sum2 = segmentTreeSumL.getRangeSum(0, indL);
                //debug.tr("2", s2, sum2);
                sum = sum.add(BigInteger.valueOf(sum2 - s2 * a[i]));
            }
            out.println(sum.toString());
        }

    }

    static class ArrayUtils {
        public static int LowerBound(int[] a, int v) {
            int high = a.length;
            int low = -1;
            while (high - low > 1) {
                int mid = (high + low) >>> 1;
                if (a[mid] >= v) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
            return high;
        }

        public static int[] sort(int[] a) {
            a = shuffle(a, new SplittableRandom());
            Arrays.sort(a);
            return a;
        }

        public static int[] shuffle(int[] a, SplittableRandom gen) {
            for (int i = 0, n = a.length; i < n; i++) {
                int ind = gen.nextInt(n - i) + i;
                int d = a[i];
                a[i] = a[ind];
                a[ind] = d;
            }
            return a;
        }

        public static int[] uniqueArray(int[] a) {
            int n = a.length;
            int p = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || a[i] != a[i - 1]) a[p++] = a[i];
            }
            return Arrays.copyOf(a, p);
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        private static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class SegmentTreeSumL {
        long[] lazy;
        long[] seg;
        long[] a;
        int size;
        int N;

        public SegmentTreeSumL(long[] a) {
            this.N = a.length;
            size = 4 * N;
            seg = new long[size];
            lazy = new long[size];
            this.a = a;
            build(0, N - 1, 0);
        }

        public SegmentTreeSumL(int n) {
            this.N = n;
            size = 4 * N;
            seg = new long[size];
            lazy = new long[size];
        }

        private void build(int s, int e, int c) {
            if (s == e) {
                seg[c] = a[s];
                return;
            }
            int m = (s + e) >>> 1;
            build(s, m, 2 * c + 1);
            build(m + 1, e, 2 * c + 2);
            seg[c] = seg[2 * c + 1] + seg[2 * c + 2];
        }

        public void update(int index, int value) {
            update(0, N - 1, 0, index, value);
        }

        private void update(int s, int e, int c, int index, int value) {
            if (s == e) {
                seg[c] += value;
                return;
            }
            int m = (s + e) >>> 1;
            if (index <= m) {
                update(s, m, 2 * c + 1, index, value);
            } else {
                update(m + 1, e, 2 * c + 2, index, value);
            }
            seg[c] = seg[2 * c + 1] + seg[2 * c + 2];
        }

        public long getRangeSum(int l, int r) {
            return getRangeSum(0, N - 1, 0, l, r);
        }

        private long getRangeSum(int s, int e, int c, int l, int r) {
            if (s > e || l > r || l > e || r < s) return 0;
            if (lazy[c] != 0) {
                if (s != e) {
                    lazy[2 * c + 1] += lazy[c];
                    lazy[2 * c + 2] += lazy[c];
                }
                seg[c] += (e - s + 1) * (1L) * lazy[c];
                lazy[c] = 0;
            }
            if (s == e) {
                return seg[c];
            }
            if (s >= l && e <= r) {
                return seg[c];
            }
            int m = (s + e) >>> 1;
            return getRangeSum(s, m, 2 * c + 1, l, r)
                    + getRangeSum(m + 1, e, 2 * c + 2, l, r);
        }

    }

    static class Debug {
        PrintWriter out;
        boolean oj;

        public Debug(PrintWriter out) {
            oj = System.getProperty("ONLINE_JUDGE") != null;
            this.out = out;
        }

    }
}

