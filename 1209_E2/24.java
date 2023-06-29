import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author beginner1010
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE2 solver = new TaskE2();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE2 {
        int[][] grid;
        int[][] val;
        int[][] dp;
        int rows;

        int two(int bit) {
            return 1 << bit;
        }

        boolean contain(int mask, int bit) {
            return (mask & two(bit)) > 0;
        }

        int rec(int col, int mask) {
            if (col == grid[0].length)
                return 0;

            if (dp[col][mask] != -1)
                return dp[col][mask];

            int res = rec(col + 1, mask);
            for (int newMask = mask; newMask > 0; newMask = (mask & (newMask - 1))) {
                res = Math.max(res, rec(col + 1, mask ^ newMask) + val[col][newMask]);
            }

            dp[col][mask] = res;
            return res;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            for (int t = 0; t < T; t++) {

                int n = in.nextInt();
                int m = in.nextInt();
                rows = n;

                int[][] input = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        input[i][j] = in.nextInt();
                    }
                }

                ArrayList<Col> cols = new ArrayList<>();
                for (int col = 0; col < m; col++) {
                    int maxVal = 0;
                    for (int row = 0; row < n; row++) {
                        maxVal = Math.max(maxVal, input[row][col]);
                    }
                    cols.add(new Col(maxVal, col));
                }
                Collections.sort(cols);

                m = Math.min(n, m);

                grid = new int[n][m];
                for (int i = 0; i < m; i++) {
                    int c = cols.get(i).colID;
                    for (int row = 0; row < n; row++) {
                        grid[row][i] = input[row][c];
                    }
                }

                val = new int[m][two(n)];
                for (int c = 0; c < m; c++) {
                    for (int mask = 0; mask < two(n); mask++) {
                        val[c][mask] = 0;
                        for (int offset = 0; offset < n; offset++) {
                            int sum = 0;
                            for (int bit = 0; bit < n; bit++) {
                                if (contain(mask, bit) == true)
                                    sum += grid[(bit + offset) % n][c];
                            }
                            val[c][mask] = Math.max(val[c][mask], sum);
                        }
                    }
                }

                dp = new int[m][two(n)];
                for (int[] aux : dp)
                    Arrays.fill(aux, -1);
                int ans = rec(0, two(n) - 1);
                out.println(ans);
            }
        }

        class Col implements Comparable<Col> {
            int maxVal;
            int colID;

            Col(int _maxVal, int _colID) {
                this.maxVal = _maxVal;
                this.colID = _colID;
            }


            public int compareTo(Col o) {
                if (o.maxVal != this.maxVal) return this.maxVal > o.maxVal ? -1 : 1;
                if (o.colID != this.colID) return this.colID < o.colID ? -1 : 1;
                return 0;
            }

        }

    }

    static class InputReader {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputStream stream;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private int read() {
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
            while (isWhitespace(c))
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
            } while (!isWhitespace(c));
            return res * sgn;
        }

    }
}

