import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;
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
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int INF = 1000 * 1000 * 1000;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int x0 = in.readInt();
            int y0 = in.readInt();
            int n = in.readInt();
            int[] xs = new int[n + 1], ys = new int[n + 1];
            xs[0] = x0;
            ys[0] = y0;
            for (int i = 1; i <= n; i++) {
                xs[i] = in.readInt();
                ys[i] = in.readInt();
            }
            int[] one = new int[n];
            for (int i = 0; i < n; i++) one[i] = dist(0, i + 1, xs, ys) * 2;
            int[][] two = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    two[i][j] = dist(0, i + 1, xs, ys) + dist(0, j + 1, xs, ys) + dist(i + 1, j + 1, xs, ys);
                }
            }
            int[] dp = new int[(1 << n)];
            Arrays.fill(dp, INF);
            dp[0] = 0;
            int[] prev = new int[(1 << n)];
            for (int mask = 0; mask < (1 << n); mask++) {
                for (int i = 0; i < n; i++) {
                    if (((mask >> i) & 1) != 0) continue;
                    ;
                    int nmask = mask | (1 << i);
                    int cost = one[i] + dp[mask];
                    if (cost < dp[nmask]) {
                        dp[nmask] = cost;
                        prev[nmask] = i;
                    }
                    for (int j = i + 1; j < n; j++) {
                        if (((mask >> j) & 1) != 0) continue;
                        int nnmask = nmask | (1 << j);
                        cost = two[i][j] + dp[mask];
                        if (cost < dp[nnmask]) {
                            dp[nnmask] = cost;
                            prev[nnmask] = n + i * n + j;
                        }
                    }
                    break;
                }
            }
            int mask = (1 << n) - 1;
            out.printLine(dp[mask]);
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            while (mask > 0) {
                if (prev[mask] < n) {
                    res.add(prev[mask] + 1);
                    mask &= ~(1 << prev[mask]);
                } else {
                    int ii = (prev[mask] - n) / n;
                    int jj = (prev[mask] - n) % n;
                    int i = Math.max(ii, jj);
                    int j = Math.min(ii, jj);
                    res.add(i + 1);
                    res.add(j + 1);
                    mask &= ~(1 << i);
                    mask &= ~(1 << j);
                }
                res.add(0);
            }
            Collections.reverse(res);
            for (int val : res) out.print(val + " ");
            out.printLine();
        }

        int dist(int i, int j, int[] xs, int[] ys) {
            return (xs[i] - xs[j]) * (xs[i] - xs[j]) + (ys[i] - ys[j]) * (ys[i] - ys[j]);
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

        public int readInt() {
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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine() {
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }
    }
}

