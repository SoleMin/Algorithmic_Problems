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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C909 solver = new C909();
        solver.solve(1, in, out);
        out.close();
    }

    static class C909 {
        int N;
        long MOD = 1_000_000_007;
        boolean[] type;
        long[][] memo;

        long dp(int cmd, int dep) {
            // safe if we came out of a statement, we can traverse
            if (dep < 0) return 0;
            if (cmd == N) return 1;
            if (memo[cmd][dep] != -1) return memo[cmd][dep];

            boolean safe = cmd == 0 ? true : !type[cmd - 1];
            int d = type[cmd] ? 1 : 0;

            long ways = 0;
            if (!safe) {
                // we must use this indentation
                ways += dp(cmd + 1, dep + d);
                ways %= MOD;
            } else {
                ways += dp(cmd + 1, dep + d);
                ways %= MOD;
                ways += dp(cmd, dep - 1);
                ways %= MOD;
            }

            return memo[cmd][dep] = ways;
        }

        public void solve(int testNumber, FastScanner s, PrintWriter out) {
            N = s.nextInt();
            type = new boolean[N];
            for (int i = 0; i < N; i++) {
                type[i] = s.next().charAt(0) == 'f';
            }

            memo = new long[N][N + 1];
            for (long[] a : memo)
                Arrays.fill(a, -1);

            out.println(dp(0, 0));

        }

    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

    }
}

