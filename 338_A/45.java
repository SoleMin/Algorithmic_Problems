import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by hama_du on 15/09/10.
 */
public class A {
    private static final long MOD = 1000000009;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextInt();
        long correct = in.nextInt();
        long k = in.nextInt();
        long wrong = n - correct;
        long set = wrong * k + k - 1;
        if (set >= n) {
            out.println(correct);
        } else {
            long needExtraCorrect = n - (wrong * k + k - 1);
            long firstSet = needExtraCorrect + k - 1;
            long otherSet = correct - firstSet;

            long firstDouble = firstSet / k;
            otherSet += firstSet % k;
            long[][] mat = new long[][]{ {2, 2*k}, {0, 1}};
            long[][] A = pow(mat, firstDouble, MOD);
            long score = (A[0][1] + otherSet) % MOD;
            out.println(score);
        }
        out.flush();
    }

    public static long[][] pow(long[][] a, long n, long mod) {
        long i = 1;
        long[][] res = E(a.length);
        long[][] ap = mul(E(a.length), a, mod);
        while (i <= n) {
            if ((n & i) >= 1) {
                res = mul(res, ap, mod);
            }
            i *= 2;
            ap = mul(ap, ap, mod);
        }
        return res;
    }

    public static long[][] E(int n) {
        long[][] a = new long[n][n];
        for (int i = 0 ; i < n ; i++) {
            a[i][i] = 1;
        }
        return a;
    }

    public static long[][] mul(long[][] a, long[][] b, long mod) {
        long[][] c = new long[a.length][b[0].length];
        if (a[0].length != b.length) {
            System.err.print("err");
        }
        for (int i = 0 ; i < a.length ; i++) {
            for (int j = 0 ; j < b[0].length ; j++) {
                long sum = 0;
                for (int k = 0 ; k < a[0].length ; k++) {
                    sum = (sum + a[i][k] * b[k][j]) % mod;
                }
                c[i][j] = sum;
            }
        }
        return c;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int next() {
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

        public char nextChar() {
            int c = next();
            while (isSpaceChar(c))
                c = next();
            if ('a' <= c && c <= 'z') {
                return (char) c;
            }
            if ('A' <= c && c <= 'Z') {
                return (char) c;
            }
            throw new InputMismatchException();
        }

        public String nextToken() {
            int c = next();
            while (isSpaceChar(c))
                c = next();
            StringBuilder res = new StringBuilder();
            do {
                res.append((char) c);
                c = next();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int nextInt() {
            int c = next();
            while (isSpaceChar(c))
                c = next();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = next();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c-'0';
                c = next();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = next();
            while (isSpaceChar(c))
                c = next();
            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = next();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c-'0';
                c = next();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}
