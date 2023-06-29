import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        String[] str;
        long mod = (long) 1e9 + 7;
        long[][] dp;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            str = new String[n];
            dp = new long[n + 2][n + 2];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            for (int i = 0; i < n; i++) {
                str[i] = in.readString();
            }
            if (str[0].charAt(0) == 'f') {
                out.print(solve(1, 1));
            } else {
                out.print(solve(1, 0));
            }
        }

        long solve(int n, int horiz) {
            if (horiz < 0)
                return 0;
            if (n >= str.length - 1) {
                return 1;
            }
            if (dp[n][horiz] != -1) {
                return dp[n][horiz];
            }
            if (str[n].charAt(0) == 'f') {
                return dp[n][horiz] = solve(n + 1, horiz + 1);
            } else {
                long ans1 = solve(n, horiz - 1);
                //System.out.println(ans1+" "+n+" egsvd"+horiz);
                ans1 += solve(n + 1, horiz);
                //System.out.println(ans1+" "+n+" "+horiz);
                ans1 = ans1 % mod;
                return dp[n][horiz] = ans1;
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

