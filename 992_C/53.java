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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CNastyaAndAWardrobe solver = new CNastyaAndAWardrobe();
        solver.solve(1, in, out);
        out.close();
    }

    static class CNastyaAndAWardrobe {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long x = in.nextLong(), k = in.nextLong();
            if (x != 0) {
                long m = (int) 1e9 + 7;
                x = x % m;
                long res = in.fastPowerMod(2, k, m);
                long res1 = (2 * res) % m;
                long ans = ((res1 * x) % m - (res - 1) % m) % m;
                ans = (ans + m) % m;
                out.println(ans);
            } else {
                out.println(0);
            }
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

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

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

        public long fastPowerMod(long x, long y, long m) {
            long res = 1;
            x = x % m;
            while (y > 0) {
                if ((y & 1) == 1) {
                    res = (x * res) % m;
                }
                x = (x * x) % m;
                y = y >> 1;
            }
            return res % m;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

