import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pranay2516
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CBanhMi solver = new CBanhMi();
        solver.solve(1, in, out);
        out.close();
    }

    static class CBanhMi {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt(), q = in.nextInt();
            char c[] = in.next().toCharArray();
            int mod = (int) 1e9 + 7;
            Pair<Long, Long>[] a = new Pair[n + 1];
            a[0] = new Pair<>(0L, 0L);
            for (int i = 1; i <= n; ++i) {
                if (c[i - 1] == '0') {
                    a[i] = new Pair<>(a[i - 1].x, a[i - 1].y + 1);
                } else {
                    a[i] = new Pair<>(a[i - 1].x + 1, a[i - 1].y);
                }
            }
            while (q-- > 0) {
                int l = in.nextInt(), r = in.nextInt();
                long ones = a[r].x - a[l - 1].x;
                long zeros = a[r].y - a[l - 1].y;
                long po = func.power(2, ones, mod);
                while (po < 0) po += mod;
                po %= mod;
                long pz = func.power(2, zeros, mod);
                while (pz < 0) pz += mod;
                pz %= mod;
                out.println(((po - 1) % mod * pz % mod) % mod);
            }
        }

    }

    static class func {
        public static long power(long x, long y, int mod) {
            if (y == 0) return 1;
            long p = power(x, y / 2, mod);
            p = (p * p) % mod;
            return (y % 2 == 0) ? p : (x * p) % mod;
        }

    }

    static class Pair<U, V> implements Comparable<Pair<U, V>> {
        public U x;
        public V y;

        public Pair(U x, V y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair<U, V> o) {
            int value = ((Comparable<U>) x).compareTo(o.x);
            if (value != 0) return value;
            return ((Comparable<V>) y).compareTo(o.y);
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return x.equals(pair.x) && y.equals(pair.y);
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
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
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

