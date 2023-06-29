import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
        _992C solver = new _992C();
        solver.solve(1, in, out);
        out.close();
    }

    static class _992C {
        static int mod = (int) 1e9 + 7;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long x = in.nextLong();
            long k = in.nextLong();

            if (x == 0) {
                out.println(0);
                return;
            }

            long[][] base = new long[][]{{2, 0}, {1, 1}};

            _992C.Matrix.N = 2;

            base = _992C.Matrix.matrixPower(base, base, k);

            x %= mod;
            long ans = 2 * base[0][0] * x - base[1][0];

            ans %= mod;

            if (ans < 0)
                ans += mod;

            out.println(ans);
        }

        static public class Matrix {
            static int N;
            static long[][] id = new long[][]{{1, 0}, {0, 1}};

            static long[][] matrixPower(long[][] mat, long[][] base, long pow) {
                if (pow == 0) {
                    return id;
                }
                if (pow == 1) {
                    return base;
                }

                long[][] t = matrixPower(mat, base, pow / 2);

                t = multiplyMatrix(t, t);
                if (pow % 2 == 1) {
                    t = multiplyMatrix(t, base);
                }

                return t;
            }

            static long[][] multiplyMatrix(long[][] m, long[][] m2) {
                long[][] ans = new long[N][N];

                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++) {
                        ans[i][j] = 0;
                        for (int k = 0; k < N; k++) {
                            ans[i][j] += m[i][k] * m2[k][j];
                            ans[i][j] %= mod;
                        }
                    }

                return ans;
            }

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

        public void close() {
            writer.close();
        }

        public void println(long i) {
            writer.println(i);
        }

        public void println(int i) {
            writer.println(i);
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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

