import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        E2RotateColumnsHardVersion solver = new E2RotateColumnsHardVersion();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class E2RotateColumnsHardVersion {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            E2RotateColumnsHardVersion.Column[] columns = new E2RotateColumnsHardVersion.Column[m];
            for (int i = 0; i < columns.length; ++i) columns[i] = new E2RotateColumnsHardVersion.Column(new int[n]);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    columns[j].v[i] = in.nextInt();
                    if (i == n - 1) columns[j].initMax();
                }
            }
            Arrays.sort(columns, new Comparator<E2RotateColumnsHardVersion.Column>() {

                public int compare(E2RotateColumnsHardVersion.Column o1, E2RotateColumnsHardVersion.Column o2) {
                    return o2.max - o1.max;
                }
            });
            if (columns.length > n)
                columns = Arrays.copyOf(columns, n);

            long[] dp = new long[1 << n];
            for (E2RotateColumnsHardVersion.Column c : columns) {
                long[] ndp = new long[1 << n];
                System.arraycopy(dp, 0, ndp, 0, dp.length);

                for (int rot = 0; rot < n; ++rot) {
                    long[] temp = new long[1 << n];
                    System.arraycopy(dp, 0, temp, 0, dp.length);
                    for (int i = 0, pos = rot; i < n; ++i, ++pos) {
                        if (pos >= n) pos = 0;
                        int val = c.v[pos];
                        for (int j = 0; j < temp.length; ++j) {
                            if ((j & (1 << i)) == 0)
                                temp[j | (1 << i)] = Math.max(temp[j | (1 << i)], temp[j] + val);
                        }
                    }
                    for (int i = 0; i < ndp.length; ++i)
                        ndp[i] = Math.max(ndp[i], temp[i]);
                }
                dp = ndp;
            }
            out.println(dp[dp.length - 1]);
        }

        static class Column {
            int[] v;
            int max;

            public Column(int[] v) {
                this.v = v;
            }

            void initMax() {
                max = 0;
                for (int vv : v) max = Math.max(max, vv);
            }

        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

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

        public String next() {
            return nextString();
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

        public String nextString() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = pread();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

