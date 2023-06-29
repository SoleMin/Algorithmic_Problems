import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            final int[] dr = {-1, 0, 1, 0};
            final int[] dc = {0, -1, 0, 1};

            int height = in.nextInt();
            int width = in.nextInt();
            int k = in.nextInt();

            int[][][] cost = new int[4][height][width];
            for (int r = 0; r < height; r++) {
                for (int c = 0; c + 1 < width; c++) {
                    int x = in.nextInt();
                    cost[3][r][c] = x;
                    cost[1][r][c + 1] = x;
                }
            }

            for (int r = 0; r + 1 < height; r++) {
                for (int c = 0; c < width; c++) {
                    int x = in.nextInt();
                    cost[2][r][c] = x;
                    cost[0][r + 1][c] = x;
                }
            }

            boolean odd = (k % 2 != 0);
            k /= 2;
            int[][][] d = new int[k + 1][height][width];
            for (int len = 1; len <= k; len++) {
                for (int r = 0; r < height; r++) {
                    for (int c = 0; c < width; c++) {
                        d[len][r][c] = Integer.MAX_VALUE;
                        for (int dir = 0; dir < 4; dir++) {
                            int nr = r + dr[dir];
                            int nc = c + dc[dir];
                            if (nr < 0 || nr >= height || nc < 0 || nc >= width) {
                                continue;
                            }
                            d[len][r][c] = Math.min(d[len][r][c], d[len - 1][nr][nc] + cost[dir][r][c]);
                        }
                    }
                }
            }

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    if (c > 0) {
                        out.print(" ");
                    }
                    out.print(odd ? -1 : 2 * d[k][r][c]);
                }
                out.println();
            }
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

