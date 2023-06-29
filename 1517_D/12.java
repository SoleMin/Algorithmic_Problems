import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
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
        OutputWriter out = new OutputWriter(outputStream);
        DExplorerSpace solver = new DExplorerSpace();
        solver.solve(1, in, out);
        out.close();
    }

    static class DExplorerSpace {
        static final int oo = 1000000000;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
            int[][] right = new int[n][m - 1];
            int[][] down = new int[n - 1][m];

            for (int i = 0; i < n; i++) right[i] = in.readIntArray(m - 1);
            for (int i = 0; i + 1 < n; i++) down[i] = in.readIntArray(m);
            if (k % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) out.print(-1 + " ");
                    out.println();
                }
                return;
            }
            int[][][] dp = new int[k / 2 + 1][n][m];

            for (int r = 1; 2 * r <= k; r++) {
                for (int i = 0; i < n; i++) Arrays.fill(dp[r][i], oo);
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m - 1; j++) {
                        int cost = right[i][j];
                        dp[r][i][j] = Integer.min(dp[r][i][j], dp[r - 1][i][j + 1] + cost);
                        dp[r][i][j + 1] = Integer.min(dp[r][i][j + 1], dp[r - 1][i][j] + cost);
                    }

                for (int i = 0; i + 1 < n; i++)
                    for (int j = 0; j < m; j++) {
                        int cost = down[i][j];
                        dp[r][i][j] = Integer.min(dp[r][i][j], dp[r - 1][i + 1][j] + cost);
                        dp[r][i + 1][j] = Integer.min(dp[r][i + 1][j], dp[r - 1][i][j] + cost);
                    }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(2 * dp[k / 2][i][j] + " ");
                }
                out.println();
            }
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

        public void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            writer.print('\n');
        }

        public void close() {
            writer.close();
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

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
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

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
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
}

