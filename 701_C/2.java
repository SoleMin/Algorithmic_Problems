import java.io.*;
import java.util.*;
import java.math.*;

public class Main implements Runnable {
    public InputReader in;
    public PrintWriter out;

    public void solve() throws Exception {
        // solution goes here
        int N = in.nextInt();

        int[] houses = new int[N];
        boolean[] exist = new boolean[52];

        for (int i = 0; i < N; i++) {
            char c = in.nextChar();
            if ('a' <= c && c <= 'z') {
                houses[i] = 26 + (c - 'a');
            } else {
                houses[i] = (c - 'A');
            }
            exist[houses[i]] = true;
        }

        int[][] pokemons = new int[N][52];

        pokemons[0][houses[0]] = 1;

        for (int i = 1; i < N; i++) {
            System.arraycopy(pokemons[i-1], 0, pokemons[i], 0, pokemons[i].length);
            pokemons[i][houses[i]]++;
        }

        int uniques = 0;
        for(boolean bool : exist)
            if (bool)
                uniques++;

        if (uniques == 1) {
            out.print(1);
            return;
        }


        int last_variant = -1;
        for (int i = 0; i < N-1; i++) {
            if (pokemons[i][houses[i]] == pokemons[N-1][houses[i]]) {
                last_variant = i;
                break;
            }
        }

        int minimum = N;

        for (int i = 0; i <= last_variant; i++) {
            if (houses[i] == houses[i+1])
                continue;

            // binary search

            int low = i+1;
            int high = N-1;

            while (low < high) {
                int mid = (low + high) / 2;

                boolean allPresent = true;
                for (int j = 0; j < 52; j++) {
                    if (j != houses[i] && exist[j] && pokemons[mid][j] == pokemons[i][j]) {
                        allPresent = false;
                        break;
                    }
                }

                if (allPresent) {
                    high = mid; // infinite??
                } else {
                    low = mid + 1;
                }
            }

            minimum = min(minimum, low - i + 1);

        }

        out.print(minimum);
    }

    public void run() {
        try {
            in = new InputReader(System.in);
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            Locale.setDefault(Locale.US);
            int tests = 1;
            while (tests-- > 0) {
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(7);
        }
    }

    static int abs(int x) {
        return x < 0 ? -x : x;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static long abs(long x) {
        return x < 0 ? -x : x;
    }

    static long max(long a, long b) {
        return a > b ? a : b;
    }

    static long min(long a, long b) {
        return a < b ? a : b;
    }

    public static void main(String args[]) {
        new Thread(null, new Main(), "Main", 1 << 28).start();
    }

    static boolean OJ = System.getProperty("ONLINE_JUDGE") != null;

    public void console(Object... objects) {
        if (!OJ) {
            out.println(Arrays.deepToString(objects));
            out.flush();
        }
    }

    @SuppressWarnings({"Duplicates", "unused"})
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[2048];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader() {
            this.stream = System.in;
        }

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public InputReader(SpaceCharFilter filter) {
            this.stream = System.in;
            this.filter = filter;
        }

        public InputReader(InputStream stream, SpaceCharFilter filter) {
            this.stream = stream;
            this.filter = filter;
        }

        public int read() {
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
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public int nextDigit() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return c - '0';
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            boolean negative = false;
            if (c == '-') {
                negative = true;
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
            return negative ? -res : res;
        }

        public int[] nextInts(int N) {
            int[] nums = new int[N];
            for (int i = 0; i < N; i++)
                nums[i] = nextInt();
            return nums;
        }

        public long[] nextLongs(int N) {
            long[] nums = new long[N];
            for (int i = 0; i < N; i++)
                nums[i] = nextLong();
            return nums;
        }

        public int nextUnsignedInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res;
        }

        public final long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return negative ? -res : res;
        }

        public final long nextUnsignedLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            long sgn = 1;
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
            } while (!(c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1 || c == '.'));

            if (c != '.') {
                return res * sgn;
            }
            c = read();

            long aft = 0;
            int len = 1;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                aft *= 10;
                len *= 10;
                aft += c - '0';
                c = read();
            } while (!isSpaceChar(c));

            return res * sgn + aft / (1.0 * len);
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public char[] nextChars() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            char[] chars = new char[res.length()];
            res.getChars(0, chars.length, chars, 0);
            return chars;
        }

        public int[][] nextIntMatrix(int rows, int cols) {
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    matrix[i][j] = nextInt();
            return matrix;
        }

        public long[][] nextLongMatrix(int rows, int cols) {
            long[][] matrix = new long[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    matrix[i][j] = nextLong();
            return matrix;
        }

        public char[][] nextCharMap(int rows, int cols) {
            char[][] matrix = new char[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    matrix[i][j] = nextChar();
            return matrix;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}