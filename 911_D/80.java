import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int ar[] = in.nextIntArray(n);
            long dp[][] = new long[n][n];
            long ct = 0;
            for (int i = 0; i < n; i++) {

                for (int j = i + 1; j < n; j++) {
                    if (ar[i] > ar[j]) {
                        dp[i][j]++;
                        ct++;
                    }
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] += dp[i + 1][j];
                }
            }
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;
                long val = (r - l + 1);
                long estimated = (val * (val - 1)) / 2;
                long change = estimated - dp[l][r];
                //System.out.println(ct);
                ct = ct - dp[l][r];
                dp[l][r] = change;
                ct += dp[l][r];
                if (ct % 2 == 0) {
                    out.println("even");
                } else {
                    out.println("odd");
                }
               // System.out.println(ct);

            }


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

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

