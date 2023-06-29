import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
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
        D903 solver = new D903();
        solver.solve(1, in, out);
        out.close();
    }

    static class D903 {
        int N;
        long ripple;
        BigInteger tot;
        long[] nums;
        BigInteger[] cs;

        public void solve(int testNumber, FastScanner s, PrintWriter out) {
            N = s.nextInt();
            nums = s.nextLongArray(N);
            tot = new BigInteger("0");
            cs = new BigInteger[N + 1];
            cs[0] = new BigInteger("0");
            ripple = 0;
            for (int i = 1; i <= N; i++)
                cs[i] = cs[i - 1].add(new BigInteger("" + nums[i - 1]));

            for (int i = 1; i <= N; i++) {
                long cur = nums[i - 1];
//            out.printf("%d: cs %d, minus %d%n", i, (cs[N] - cs[i]), cur * (N - i));
                tot = tot.add(cs[N].subtract(cs[i])).subtract(new BigInteger("" + (cur * (N - i))));
            }

            HashMap<Long, Integer> seen = new HashMap<>();
            for (long i : nums) {
                Integer lo = seen.get(i - 1);
                Integer hi = seen.get(i + 1);
                if (lo != null)
                    tot = tot.subtract(new BigInteger("" + lo));
                if (hi != null)
                    tot = tot.add(new BigInteger("" + hi));

                if (!seen.containsKey(i))
                    seen.put(i, 0);
                seen.put(i, seen.get(i) + 1);
            }

            out.println(tot);
        }

    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long[] nextLongArray(int N) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = this.nextLong();
            return ret;
        }

    }
}

