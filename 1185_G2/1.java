import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        TaskG2 solver = new TaskG2();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskG2 {
        static final int MOD = 1000000000 + 7;
        static final int MAXN = 51;

        int getWays(int i, int j, int k, int l, int[][][][] ways, boolean[][][][] cached) {
            if (i + j + k == 0) return l == -1 ? 1 : 0;
            if (l < 0) return 0;
            if (cached[i][j][k][l]) return ways[i][j][k][l];
            int s = i + j + k;
            long value = 0;
            if (l == 0 && i != 0) {
                for (int x = -1; x < 3; x++)
                    if (x != l) {
                        value += getWays(i - 1, j, k, x, ways, cached);
                    }
            }
            if (l == 1 && j != 0) {
                for (int x = -1; x < 3; x++)
                    if (x != l) {
                        value += getWays(i, j - 1, k, x, ways, cached);
                    }
            }
            if (l == 2 && k != 0) {
                for (int x = -1; x < 3; x++)
                    if (x != l) {
                        value += getWays(i, j, k - 1, x, ways, cached);
                    }
            }
            ways[i][j][k][l] = (int) (value % MOD);
            cached[i][j][k][l] = true;
            return ways[i][j][k][l];
        }

        int totalWays(int i, int j, int k, int[][][][] ways, boolean[][][][] cached, int[] factorial) {
            long ret = 0;
            for (int l = 0; l < 3; l++) ret += getWays(i, j, k, l, ways, cached);
            ret *= factorial[i];
            ret %= MOD;

            ret *= factorial[j];
            ret %= MOD;

            ret *= factorial[k];
            ret %= MOD;

            return (int) ret;
        }

        int add(int type, int value, int[] sizes, int sum, int[][][][] dp) {
            sizes[type]++;
            if (type == 0) {
                for (int s = sum + value; s >= value; s--) {
                    for (int i = 1; i <= sizes[0]; i++)
                        for (int j = 0; j <= sizes[1]; j++)
                            for (int k = 0; k <= sizes[2]; k++) {
                                dp[i][j][k][s] += dp[i - 1][j][k][s - value];
                                if (dp[i][j][k][s] >= MOD)
                                    dp[i][j][k][s] -= MOD;
                            }
                }
            }

            if (type == 1) {
                for (int s = sum + value; s >= value; s--) {
                    for (int i = 0; i <= sizes[0]; i++)
                        for (int j = 1; j <= sizes[1]; j++)
                            for (int k = 0; k <= sizes[2]; k++) {
//                            System.out.println(i + " " + j + " " + k + " " + s + " " + dp.length + " " + dp[0].length + " " + dp[0][0].length + " " + dp[0][0][0].length);
                                dp[i][j][k][s] += dp[i][j - 1][k][s - value];
                                if (dp[i][j][k][s] >= MOD)
                                    dp[i][j][k][s] -= MOD;
                            }
                }
            }

            if (type == 2) {
                for (int s = sum + value; s >= value; s--) {
                    for (int i = 0; i <= sizes[0]; i++)
                        for (int j = 0; j <= sizes[1]; j++)
                            for (int k = 1; k <= sizes[2]; k++) {
//                            System.out.println(i + " " + j + " " + k + " " + s + " " + dp.length + " " + dp[0].length + " " + dp[0][0].length + " " + dp[0][0][0].length);
                                dp[i][j][k][s] += dp[i][j][k - 1][s - value];
                                if (dp[i][j][k][s] >= MOD)
                                    dp[i][j][k][s] -= MOD;
                            }
                }
            }

            return sum + value;
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int[][][][] ways = new int[MAXN][MAXN][MAXN][3];
            boolean[][][][] cached = new boolean[MAXN][MAXN][MAXN][3];
//        Arrays.fill(ways, -1);

            int n = in.nextInt(), T = in.nextInt();

            ArrayList<Integer>[] ar = new ArrayList[3];
            for (int i = 0; i < 3; i++) ar[i] = new ArrayList<Integer>();
            int total_sum = 0;
            for (int i = 0; i < n; i++) {
                int t = in.nextInt(), g = in.nextInt();
                ar[g - 1].add(t);
                total_sum += t;
            }

            if (T > total_sum) {
                out.println(0);
                return;
            }
            int min_index = 0, mn = 0;

            for (int i = 0; i < 3; i++) {
                if (ar[i].size() > mn) {
                    mn = ar[i].size();
                    min_index = i;
                }
            }

            int[][][][] dp = new int[ar[(1 + min_index) % 3].size() + 1][ar[(2 + min_index) % 3].size() + 1][1][total_sum + 1];
            int[][][][] dp2 = new int[1][1][mn + 1][total_sum + 1];
            dp[0][0][0][0] = dp2[0][0][0][0] = 1;
            int[] sizes = {0, 0, 0};
            int sum = 0;
            int[] order = {(min_index + 1) % 3, (min_index + 2) % 3};
            int type = 0;
            for (int i : order) {
                for (int v : ar[i])
                    sum = add(type, v, sizes, sum, dp);
                type++;
            }
            sum = 0;
            sizes[0] = sizes[1] = sizes[2] = 0;
            for (int i : ar[min_index])
                sum = add(2, i, sizes, sum, dp2);
            int[] factorial = new int[MAXN];
            factorial[0] = 1;
            for (int i = 1; i < MAXN; i++)
                factorial[i] = (int) ((factorial[i - 1] * 1L * i) % MOD);

            long answer = 0;
            for (int i = 0; i < dp.length; i++)
                for (int j = 0; j < dp[0].length; j++)
                    for (int k = 0; k <= mn; k++)
                        for (int s = 0; s <= T; s++) {

                            long x = (dp[i][j][0][s] * 1L * totalWays(i, j, k, ways, cached, factorial)) % MOD;
                            x *= dp2[0][0][k][T - s];
                            x %= MOD;
                            answer += x;

                        }
            out.println(answer % MOD);
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

