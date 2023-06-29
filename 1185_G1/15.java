import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Vaibhav Pulastya
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        G1PlaylistForPolycarpEasyVersion solver = new G1PlaylistForPolycarpEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class G1PlaylistForPolycarpEasyVersion {
        long mod = (int) 1e9 + 7;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int T = in.nextInt();
            int[] t = new int[n];
            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = in.nextInt();
                g[i] = in.nextInt();
            }
            long[] fact = new long[n + 1];
            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = (fact[i - 1] * i) % mod;
            }
            ArrayList<Integer> masks = new ArrayList<>();
            long val = 0;
            for (int i = 1; i < (1 << n); i++) {
                int time = 0;
                int[] count = new int[3];
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        time += t[j];
                        count[g[j] - 1]++;
                    }
                }
                if (time == T) {
                    masks.add(i);
                    Arrays.sort(count);
                    long v = ((fact[count[0]] * fact[count[1]]) % mod * fact[count[2]]) % mod;
                    val += ((countUtil(count[0], count[1], count[2])) * v) % mod;
                }
            }
            out.println(val%mod);

        }

        long countWays(int p, int q, int r, int last) {
            // if number of balls of any
            // color becomes less than 0
            // the number of ways arrangements is 0.
            if (p < 0 || q < 0 || r < 0)
                return 0;

            // If last ball required is
            // of type P and the number
            // of balls of P type is 1
            // while number of balls of
            // other color is 0 the number
            // of ways is 1.
            if (p == 1 && q == 0 && r == 0 && last == 0)
                return 1;

            // Same case as above for 'q' and 'r'
            if (p == 0 && q == 1 && r == 0 && last == 1)
                return 1;
            if (p == 0 && q == 0 && r == 1 && last == 2)
                return 1;

            // if last ball required is P
            // and the number of ways is
            // the sum of number of ways
            // to form sequence with 'p-1' P
            // balls, q Q Balls and r R balls
            // ending with Q and R.
            if (last == 0)
                return (countWays(p - 1, q, r, 1) +
                        countWays(p - 1, q, r, 2)) % mod;

            // Same as above case for 'q' and 'r'
            if (last == 1)
                return (countWays(p, q - 1, r, 0) +
                        countWays(p, q - 1, r, 2)) % mod;

            if (last == 2)
                return (countWays(p, q, r - 1, 0) +
                        countWays(p, q, r - 1, 1)) % mod;

            return 0;
        }

        long countUtil(int p, int q, int r) {
            // Three cases arise:
            return ((countWays(p, q, r, 0) +
                    countWays(p, q, r, 1)) % mod +
                    countWays(p, q, r, 2)) % mod;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

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
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}