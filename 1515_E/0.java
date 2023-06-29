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
        EPhoenixAndComputers solver = new EPhoenixAndComputers();
        solver.solve(1, in, out);
        out.close();
    }

    static class EPhoenixAndComputers {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            ModInt mod = new ModInt(m);
            int[] factorial = new int[n + 1];
            int[][] binomial = new int[n + 1][n + 1];
            int[] two = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                binomial[i][0] = 1;
                for (int j = 1; j <= i; j++)
                    binomial[i][j] = mod.add(binomial[i - 1][j], binomial[i - 1][j - 1]);
                factorial[i] = i == 0 ? 1 : mod.multiply(factorial[i - 1], i);
                two[i] = i == 0 ? 1 : mod.multiply(2, two[i - 1]);
            }
            int[][] dp = new int[n + 1][n + 1];
            dp[0][0] = 1;
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    for (int x = 1; x <= i; x++) {
                        dp[i][j] = mod.add(dp[i][j],
                                mod.multiply(binomial[i][x], mod.multiply(two[x - 1], dp[i - x][j - 1])));
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                answer = mod.add(answer, dp[n - k][k + 1]);
            }
            out.println(answer);
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

    static class ModInt {
        int modulo;

        public ModInt(int m) {
            modulo = m;
        }

        public int add(int x, int y) {
            x += y;
            if (x >= modulo) x -= modulo;
            return x;
        }

        public int multiply(int x, int y) {
            return (int) ((x * 1L * y) % modulo);
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

