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
 *
 * @author Darshandarji
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[][] g = new boolean[n][n];
            for (int i = 0; i < m; ++i) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                g[a][b] = true;
                g[b][a] = true;
            }
        /*for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                g[i][j] = true;*/
            long[] am = new long[n + 1];
            long[][] ways = new long[1 << n][n];
            for (int start = 0; start < n; ++start) {
                for (int mask = 0; mask < (1 << (n - start)); ++mask)
                    for (int last = start; last < n; ++last) {
                        ways[mask][last - start] = 0;
                    }
                ways[1][0] = 1;
                for (int mask = 0; mask < (1 << (n - start)); ++mask) {
                    int cnt = 0;
                    int tmp = mask;
                    while (tmp > 0) {
                        ++cnt;
                        tmp = tmp & (tmp - 1);
                    }
                    for (int last = start; last < n; ++last)
                        if (ways[mask][last - start] > 0) {
                            long amm = ways[mask][last - start];
                            for (int i = start; i < n; ++i)
                                if ((mask & (1 << (i - start))) == 0 && g[last][i]) {
                                    ways[mask | (1 << (i - start))][i - start] += amm;
                                }
                            if (g[last][start])
                                am[cnt] += ways[mask][last - start];
                        }
                }
            }
            long res = 0;
            for (int cnt = 3; cnt <= n; ++cnt) {
                if (am[cnt] % (2) != 0)
                    throw new RuntimeException();
                res += am[cnt] / (2);
            }
            out.println(res);
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

        public int nextInt() {
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
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

