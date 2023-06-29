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
        int mod = 1000000007;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.readInt();
            int[][] dp = new int[n + 1][5002];
            char[] a = new char[n];
            for (int i = 0; i < n; i++) a[i] = in.readCharacter();

            for (int i = 0; i < dp[n].length; i++) dp[n][i] = 1;

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (a[i] == 's') {
                        if (j > 0) dp[i][j] = dp[i][j - 1];
                        dp[i][j] = (int) ((dp[i][j] + (long) dp[i + 1][j]) % mod);
                    } else {
                        if (j > 0) dp[i][j] = dp[i][j - 1];
                        dp[i][j] = (int) ((dp[i][j] + (long) dp[i + 1][j + 1] - (long) dp[i + 1][j] + mod) % mod);
                    }
                }
            }
            out.println(dp[0][0]);
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

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

