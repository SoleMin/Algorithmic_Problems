import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        C908 solver = new C908();
        solver.solve(1, in, out);
        out.close();
    }

    static class C908 {
        int N;
        int R;
        int[] x;
        double[] ans;

        public void solve(int testNumber, FastScanner s, PrintWriter out) {

            N = s.nextInt();
            R = s.nextInt();
            x = s.nextIntArray(N);

            ans = new double[N];
            Arrays.fill(ans, R);

            for (int i = 0; i < N; i++) {
                // placing circle i
                for (int j = 0; j < i; j++) {
                    // testing collision with placed circles
                    if (Math.abs(x[i] - x[j]) <= 2 * R) {
                        // they will collide
                        // compute the increase in y that will be had
                        double dy = Math.sqrt(Math.pow(2 * R, 2) - Math.pow(x[i] - x[j], 2));
                        ans[i] = Math.max(ans[i], ans[j] + dy);
                    }
                }
            }

            for (double d : ans)
                out.print(d + " ");
            out.println();

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

        public int[] nextIntArray(int N) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = this.nextInt();
            return ret;
        }

    }
}

