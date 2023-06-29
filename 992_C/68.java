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
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CNastyaAndAWardrobe solver = new CNastyaAndAWardrobe();
        solver.solve(1, in, out);
        out.close();
    }

    static class CNastyaAndAWardrobe {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            long x = in.nextLong();
            long k = in.nextLong();
            if (x == 0) {
                out.println(0);
            } else {
                long mod = (long) (1e9 + 7);
                long ans = (((((2 * x - 1) % mod)) * power(2, k, mod)) % mod) + 1;
                ans %= mod;
                out.println(ans);
            }

        }

        long power(long x, long y, long p) {
            long res = 1;
            x = x % p;
            while (y > 0) {
                if ((y & 1) > 0)
                    res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
            return res;
        }

    }

    static class FastScanner {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

    }
}

