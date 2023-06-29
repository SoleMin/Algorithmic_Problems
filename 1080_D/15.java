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
 *
 * @author Rustam Musin (t.me/musin_acm)
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        DOlyaIMagicheskiiKvadrat solver = new DOlyaIMagicheskiiKvadrat();
        solver.solve(1, in, out);
        out.close();
    }

    static class DOlyaIMagicheskiiKvadrat {
        long inf = (long) 1e18 + 1;
        long[] maxLen;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            maxLen = new long[100];
            maxLen[1] = 0;
            for (int i = 1; i < maxLen.length; i++) {
                maxLen[i] = Math.min(inf, maxLen[i - 1] * 4 + 1);
            }
            if (false) {
                for (int n = 1; n <= 3; n++) {
                    for (int k = 1; k <= maxSplitCount(n) + 20; k++) {
                        out.print(n + " " + k + " ");
                        int res = solve(n, k);
                        if (res == -1) {
                            out.printLine("NO");
                        } else {
                            out.printLine("YES " + res);
                        }
                    }
                }
                return;
            }
            int q = in.readInt();
            while (q-- > 0) {
                int n = in.readInt();
                long k = in.readLong();
                int res = solve(n, k);
                if (res == -1) {
                    out.printLine("NO");
                    continue;
                }
                out.printLine("YES " + res);
            }
        }

        long maxSplitCount(int n) {
            if (n >= maxLen.length) {
                return inf;
            }
            return maxLen[n];
        }

        int solve(int n, long k) {
            if (maxSplitCount(n) < k) {
                return -1;
            }
            int at = 0;
            while (maxSplitCount(at + 1) <= k) {
                at++;
            }
            int curSideLog = n - at;
            k -= maxSplitCount(at);
            double sideLen = Math.pow(2, n - curSideLog);
            double pathLen = sideLen * 2 - 1;
            if (curSideLog > 0 && pathLen <= k) {
                return curSideLog - 1;
            }
            double area = sideLen * sideLen;
            double otherArea = area - pathLen;
            if (otherArea * (double) maxSplitCount(curSideLog) >= k) {
                return curSideLog;
            }
            return -1;
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

        public long readLong() {
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

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

