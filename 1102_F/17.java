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
        TaskF solver = new TaskF();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskF {
        final int INF = (int) 1e9 + 5;
        int n;
        int m;
        int[][][] dp;
        int[][] diff;
        int[][] diffStartLast;

        int two(int x) {
            return 1 << x;
        }

        boolean contain(int mask, int x) {
            return (mask & two(x)) > 0;
        }

        int rec(int start, int pre, int mask) {
            if (mask == two(n) - 1)
                return INF;
            int res = dp[start][pre][mask];
            if (res != -1)
                return res;
            res = 0;

            for (int i = 0; i < n; i++)
                if (contain(mask, i) == false) {
                    int diffPre = mask == 0 ? INF : diff[pre][i]; // mask == 0 should never happen
                    int diffLast = (mask | two(i)) == two(n) - 1 ? diffStartLast[start][i] : INF;
                    res = Math.max(res, Math.min(rec(start, i, mask | two(i)), Math.min(diffLast, diffPre)));
                }

            dp[start][pre][mask] = res;
            return res;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    grid[i][j] = in.nextInt();

            if (n == 1) {
                int res = INF;
                for (int i = 0; i + 1 < m; i++) {
                    res = Math.min(res, Math.abs(grid[0][i] - grid[0][i + 1]));
                }
                out.println(res);
                return;
            }

            diff = new int[n][n];
            diffStartLast = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    diff[i][j] = INF;
                    diffStartLast[i][j] = INF;
                    for (int k = 0; k < m; k++) {
                        diff[i][j] = Math.min(diff[i][j], Math.abs(grid[i][k] - grid[j][k]));
                        if (k + 1 < m) {
                            diffStartLast[i][j] = Math.min(diffStartLast[i][j], Math.abs(grid[i][k + 1] - grid[j][k]));
                        }
                    }
                }
            }

            dp = new int[n][n][two(n)];
            for (int[][] aux : dp)
                for (int[] aux2 : aux)
                    Arrays.fill(aux2, -1);

            int ans = 0;
            for (int start = 0; start < n; start++) {
                ans = Math.max(ans, rec(start, start, two(start)));
            }
            out.println(ans);
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

