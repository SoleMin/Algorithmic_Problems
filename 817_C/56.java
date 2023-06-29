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
        atskb solver = new atskb();
        solver.solve(1, in, out);
        out.close();
    }

    static class atskb {
        long s;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = in.nextLong();
            s = in.nextLong();
            long ans = binarysearch(0, (long) Math.pow(10, 18) + 20 * 9);
            if (ans > n) {
                out.print(0);
            } else {
                out.print(n - ans + 1);
            }

        }

        public long binarysearch(long l, long r) {
            if (l == r) {
                if (check(l))
                    return l;
                return -1;

            }
            if (l - r == -1) {
                if (check(l))
                    return l;
                if (check(r)) {
                    return r;
                }

                //return -1;
            }
            long mid = l + (r - l) / 2;
            if (check(mid))
                return binarysearch(l, mid);
            return binarysearch(mid + 1, r);
        }

        public boolean check(long m) {
            String str = m + "";
            long sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            if (sum + s <= m)
                return true;
            return false;
        }

    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;

        public InputReader(InputStream st) {
            this.stream = st;
        }

        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

