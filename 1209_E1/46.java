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
 * @author beginner1010
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE1 solver = new TaskE1();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE1 {
        int n;
        int m;
        int[][] map;
        int[][] dp;

        int two(int idx) {
            return 1 << idx;
        }

        boolean contain(int mask, int idx) {
            return (mask & two(idx)) > 0;
        }

        int best(int mask, int col) {
            int res = 0;
            for (int rot = 0; rot < n; rot++) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    int curRow = (rot + i) % n;
                    if (contain(mask, curRow)) {
                        sum += map[i][col];
                    }
                }
                res = Math.max(res, sum);
            }
            return res;
        }

        int rec(int col, int used) {
            if (col == m)
                return 0;

            int res = dp[col][used];
            if (res != -1)
                return res;
            res = 0;
            for (int mask = 0; mask < two(n); mask++)
                if ((mask & used) == 0) {
                    res = Math.max(res, rec(col + 1, used | mask) + best(mask, col));
                }
            dp[col][used] = res;
            return res;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int test = 0; test < t; test++) {
                n = in.nextInt();
                m = in.nextInt();
                map = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        map[i][j] = in.nextInt();
                    }
                }
                dp = new int[m][1 << n];
                for (int[] aux : dp)
                    Arrays.fill(aux, -1);
                int ans = rec(0, 0);
                out.println(ans);
            }
        }

    }

    static class InputReader {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputStream stream;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private int read() {
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

        public int nextInt() {
            int c = read();
            while (isWhitespace(c))
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
            } while (!isWhitespace(c));
            return res * sgn;
        }

    }
}

