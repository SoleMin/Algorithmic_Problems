import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
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
        SquareFreeDivisionHardVersion solver = new SquareFreeDivisionHardVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class SquareFreeDivisionHardVersion {
        static final int MAX = 10000001;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int t = in.nextInt();
            int[] d = PrimesAndDivisors.generateDivisors(MAX);
            int[] reduced = new int[MAX];
            for (int i = 1; i < MAX; i++) {
                int val = i;
                reduced[i] = 1;
                while (val != 1) {
                    int prime = d[val], exponent = 0;
                    while (val % prime == 0) {
                        val /= prime;
                        exponent ^= 1;
                    }
                    if (exponent > 0) reduced[i] *= prime;
                }
            }
            int counter = 0;
            int[] seen = new int[MAX];
            for (int jjjj = 0; jjjj < t; jjjj++) {
                int n = in.nextInt(), k = in.nextInt();

                int[] a = in.readIntArray(n);
                for (int x : a) seen[reduced[x]] = -1;
                int[][] dp = new int[n + 1][k + 1];
                TreeSet<Integer> ts = new TreeSet<>();
                int num = 0;
                for (int i = 0; i < n; i++) {
                    int R = reduced[a[i]];
                    if (seen[R] != -1) {
                        ts.add(-seen[R]);
                        if (ts.size() > k + 1) ts.remove(ts.last());
                        num++;
                    }
                    Arrays.fill(dp[i], n + 1);
                    for (int j = num; j <= k; j++) dp[i][j] = 1;
                    seen[R] = i;
                    int u = 0;
                    for (int r : ts) {
                        for (int j = u; j <= k; j++) dp[i][j] = Integer.min(dp[i][j], dp[-r][j - u] + 1);
                        u++;
                    }
//                System.out.println(i + " "  + Arrays.toString(dp[i]));
//                System.out.println("Treeset : " + ts);
                }
                out.println(dp[n - 1][k]);
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

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
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

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
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

    static class PrimesAndDivisors {
        public static int[] generateDivisors(int n) {
            int[] divisors = IntStream.range(0, n + 1).toArray();
            for (int i = 2; i * i <= n; i++)
                if (divisors[i] == i)
                    for (int j = i * i; j <= n; j += i) divisors[j] = i;
            return divisors;
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
}

