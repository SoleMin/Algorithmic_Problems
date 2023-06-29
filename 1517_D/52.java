import java.io.*;
import java.util.*;
 
/**
 * A simple template for competitive programming problems.
 */
public class Solution {
    //InputReader in = new InputReader("input.txt");
    final InputReader in = new InputReader(System.in);
 
    final PrintWriter out = new PrintWriter(System.out);

    int n,m;

    void solve() {
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();

        int[][] hor = new int[n][m-1];
        int[][] ver = new int[n-1][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m-1; j++) {
                hor[i][j] = in.nextInt(); //hor[i][j]=mat[i][j] -> mat[i][j+1]
            }
        }

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<m; j++) {
                ver[i][j] = in.nextInt(); //ver[i][j]= mat[i][j] -> mat[i+1][j]
            }
        }

        int[][] ans = new int[n][m];

        if(k%2==1) {
            for(int i=0; i<n; i++)
                Arrays.fill(ans[i], -1);
        } else {
            for(int dummy=0; dummy<k>>1; dummy++) {
                int[][] newAns = new int[n][m];
                for(int i=0; i<n; i++) {
                    Arrays.fill(newAns[i], Integer.MAX_VALUE);
                    for(int j=0; j<m; j++) {
                        if(isGood(i+1, j)) {
                            newAns[i][j] = Math.min(newAns[i][j], 2*ver[i][j] + ans[i+1][j]);
                        }
                        if(isGood(i, j+1)) {
                            newAns[i][j] = Math.min(newAns[i][j], 2*hor[i][j] + ans[i][j+1]);
                        }
                        if(isGood(i, j-1)) {
                            newAns[i][j] = Math.min(newAns[i][j], 2*hor[i][j-1] + ans[i][j-1]);
                        }
                        if(isGood(i-1, j)) {
                            newAns[i][j] = Math.min(newAns[i][j], 2*ver[i-1][j] + ans[i-1][j]);
                        }
                    }
                }
                ans = newAns;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                out.print(ans[i][j] + " ");
            }
            out.println();
        }
    }

    boolean isGood(int i, int j) {
        return i>=0 && i<n && j>=0 && j<m;
    }

    private void shuffle(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    public static void main(final String[] args) throws FileNotFoundException {
        final Solution s = new Solution();
        final Long t1 = System.currentTimeMillis();
        s.solve();
        System.err.println(System.currentTimeMillis() - t1 + " ms");
        s.out.close();
    }

    public Solution() throws FileNotFoundException {
    }

    private static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        Random r = new Random();
        InputReader(final InputStream stream) {
            this.stream = stream;
        }

        InputReader(final String fileName) {
            InputStream stream = null;
            try {
                stream = new FileInputStream(fileName);
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            this.stream = stream;
        }

        int[] nextArray(final int n) {
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[][] nextMatrix(final int n, final int m) {
            final int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = nextInt();
            return matrix;
        }

        String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            final StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        long nextLong() {
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
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        int nextInt() {
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

        double nextDouble() {
            return Double.parseDouble(nextString());
        }

        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        private boolean isSpaceChar(final int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(final int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
 
}