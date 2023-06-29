import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prakharjain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        F2SameSumBlocksHard solver = new F2SameSumBlocksHard();
        solver.solve(1, in, out);
        out.close();
    }

    static class F2SameSumBlocksHard {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();

            long[] a = in.nextLongArray(n);

            long[] p = in.calculatePrefixSum(a);

            Map<Long, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long sum = 0;
                for (int j = i; j < n; j++) {
                    sum += a[j];
                    map.merge(sum, 1, (x, y) -> x + y);
                }
            }

            List<sum> sums = new ArrayList<>();
            for (long sum : map.keySet()) {
                sums.add(new sum(sum, map.get(sum)));
            }

            sums.sort((x, y) -> y.c - x.c);

            int ans = -1;

            int[] fca = null;
            long mxsum = -1;
            for (int i = 0; i < sums.size(); i++) {
                sum cs = sums.get(i);
                long sum = cs.sum;
                long c = cs.c;

                if (c < ans) {
                    continue;
                }

                Map<Long, Integer> lm = new HashMap<>();

                int[] ca = new int[n];
                lm.put(0l, -1);
                for (int j = 0; j < n; j++) {
                    long val = p[j];

                    if (j > 0) {
                        ca[j] = ca[j - 1];
                    }
                    long req = val - sum;

                    if (lm.containsKey(req)) {
                        int li = lm.get(req);
                        if (li == -1)
                            ca[j] = Math.max(1, ca[j]);
                        else
                            ca[j] = Math.max(1 + ca[li], ca[j]);
                    }

                    lm.put(val, j);
                }

                if (ca[n - 1] > ans) {
                    ans = ca[n - 1];
                    mxsum = sum;
                    fca = ca;
                }
            }

            List<Integer> al = new ArrayList<>();

            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (i > 0 && fca[i] != fca[i - 1]) {
                    sum = 0;
                    al.add(i + 1);
                    do {
                        sum += a[i];
                        i--;
                    } while (i >= 0 && sum != mxsum);
                    i++;
                    al.add(i + 1);
                } else if (i == 0) {
                    if (a[i] == mxsum) {
                        al.add(i + 1);
                        al.add(i + 1);
                    }
                }
            }

            out.println(al.size() / 2);

            for (int i = al.size() - 1; i >= 0; i -= 2) {
                out.println(al.get(i) + " " + al.get(i - 1));
            }
        }

        class sum {
            long sum;
            int c;

            public sum(long sum, int c) {
                this.sum = sum;
                this.c = c;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i) array[i] = nextLong();
            return array;
        }

        public long[] calculatePrefixSum(long[] a) {
            int n = a.length;

            long[] prefixSum = new long[n];

            prefixSum[0] = a[0];

            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + a[i];
            }

            return prefixSum;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }
}

