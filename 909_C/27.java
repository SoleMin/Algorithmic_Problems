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
 * @author ankur
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        long mod = (long) 1e9 + 7;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            char ar[] = new char[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readString().charAt(0);
            }
            long dp[][] = new long[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                dp[n - 1][i] = 1;
            }
            long prev = n;
            for (int i = n - 2; i >= 0; i--) {
                if (ar[i] == 'f') {
                    if (ar[i + 1] == 's') {
                        for (int j = n - 2; j >= 0; j--) {
                            dp[i][j] = dp[i + 1][j + 1];
                        }
                    } else {
                        for (int j = n - 2; j >= 0; j--) {
                            dp[i][j] = dp[i + 1][j + 1];
                        }

                    }
                } else {
                    for (int j = n - 1; j >= 0; j--) {
                        if (prev < 0) {
                            prev += mod;
                        }
                        dp[i][j] = prev;
                        prev = prev - dp[i + 1][j];
                    }
                }
                prev = 0;
                for (int j = 0; j < n; j++) {
                    prev += dp[i][j];
                    prev = prev % mod;
                }
            }
            out.println(dp[0][0] % mod);

        }

    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;

        public InputReader(InputStream st) {
            this.stream = st;
        }

        public int read() {
            //*-*------clare------

            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

