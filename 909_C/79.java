import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        static final long MODULO = (long) (1e9 + 7);

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            long[][] dp = new long[n + 100][n + 100];
            dp[0][0] = 1;
            for (int i = 0; i < n; ++i) {
                char current = in.nextCharacter();
                if (current == 'f') {
                    for (int j = 0; j < n; ++j) {
                        dp[i + 1][j + 1] += dp[i][j];
                        dp[i + 1][j + 1] %= MODULO;
                    }
                } else {
                    long runningSum = 0;
                    for (int j = n; j >= 0; --j) {
                        runningSum += dp[i][j];
                        runningSum %= MODULO;

                        dp[i + 1][j] += runningSum;
                        dp[i + 1][j] %= MODULO;
                    }
                }
            }
            out.println(dp[n][0]);
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public char nextCharacter() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            return (char) c;
        }

    }
}

