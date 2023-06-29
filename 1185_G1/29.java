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
        TaskG1 solver = new TaskG1();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskG1 {
        final int mod = (int) 1e9 + 7;
        int[][][] dp;

        int rec(int mask, int time, int T, int genre, int[] ts, int[] gs) {
            if (time > T)
                return 0;
            if (time == T)
                return 1;
            if (mask == (1 << ts.length) - 1)
                return 0;
            int res = dp[genre][time][mask];
            if (res != -1)
                return res;
            res = 0;
            for (int i = 0; i < ts.length; i++) {
                if ((mask & (1 << i)) == 0 && (mask == 0 || gs[i] != genre)) {
                    res += rec(mask | (1 << i), time + ts[i], T, gs[i], ts, gs);
                    if (res >= mod)
                        res -= mod;
                }
            }
            return dp[genre][time][mask] = res;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] ts = new int[n];
            int[] gs = new int[n];
            int T = in.nextInt();
            for (int i = 0; i < n; i++) {
                ts[i] = in.nextInt();
                gs[i] = in.nextInt() - 1;
            }
            dp = new int[3][T][1 << n];
            for (int[][] aux : dp) {
                for (int[] aux2 : aux)
                    Arrays.fill(aux2, -1);
            }
            int ans = rec(0, 0, T, 0, ts, gs);
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

