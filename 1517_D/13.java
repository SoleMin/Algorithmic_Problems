import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        static int n;
        static int m;
        static int steps;
        static long[][] distJ;
        static long[][] distI;
        static long[][][] memo;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            steps = in.nextInt();
            memo = new long[n][m][steps];
            distJ = new long[n][m - 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    distJ[i][j] = in.nextLong();
                }
            }
            distI = new long[n - 1][m];
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    distI[i][j] = in.nextLong();
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (steps % 2 != 0) {
                        out.print(-1 + " ");
                    } else {
                        out.print(2 * lowestCost(i, j, steps / 2) + " ");
                    }
                }
                out.println();
            }
        }

        private long lowestCost(int i, int j, int distance) {
            if (distance == 0) {
                return 0;
            }
            if (memo[i][j][distance] > 0) {
                return memo[i][j][distance];
            }

            long minDist = Long.MAX_VALUE;
            //j + 1 and j -1
            if (j < m - 1) {
                // move forward on j
                minDist = Math.min(minDist, distJ[i][j] + lowestCost(i, j + 1, distance - 1));
            }
            if (j > 0) {
                // move backward on j
                minDist = Math.min(minDist, distJ[i][j - 1] + lowestCost(i, j - 1, distance - 1));
            }

            if (i < n - 1) {
                // move forward on i
                minDist = Math.min(minDist, distI[i][j] + lowestCost(i + 1, j, distance - 1));
            }
            if (i > 0) {
                // move backward on i
                minDist = Math.min(minDist, distI[i - 1][j] + lowestCost(i - 1, j, distance - 1));
            }

            //memoize
            memo[i][j][distance] = minDist;
            return minDist;
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

        public void println() {
            writer.println();
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

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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

