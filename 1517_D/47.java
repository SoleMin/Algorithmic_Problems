import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Lynn
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        Scanner in;
        PrintWriter out;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            this.in = in;
            this.out = out;
            run();
        }

        void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[][][] dis = new int[n][m][4];
            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int tmp;
            final int M = (int) (1e8);
            Algo.fill(dis, M);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    tmp = in.nextInt();
                    dis[i][j][0] = tmp;
                    dis[i][j + 1][1] = tmp;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    tmp = in.nextInt();
                    dis[i][j][2] = tmp;
                    dis[i + 1][j][3] = tmp;
                }
            }
            int[][] ans = new int[n][m];

            if (k % 2 == 1) {
                Algo.fill(ans, -1);
            } else {
                int halfK = k / 2;
                int[][][] dp = new int[halfK + 1][n][m];
                Algo.fill(dp, M);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        dp[0][i][j] = 0;
                    }
                }

                for (int step = 1; step <= halfK; step++) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            for (int d = 0; d < dir.length; d++) {
                                int toX = i + dir[d][0];
                                int toY = j + dir[d][1];
                                if (toX < 0 || toY < 0 || toX >= n || toY >= m) continue;
                                dp[step][i][j] = Math.min(dp[step - 1][toX][toY] + 2 * dis[i][j][d], dp[step][i][j]);
                            }
                        }
                    }
                }
                ans = dp[halfK];
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(ans[i][j]);
                    out.print(' ');
                }
                out.println("");
            }


        }

    }

    static class Algo {
        public static void fill(int[][] iss, int v) {
            for (int[] is : iss) Arrays.fill(is, v);
        }

        public static void fill(int[][][] isss, int v) {
            for (int[][] iss : isss) Algo.fill(iss, v);
        }

    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            eat("");
        }

        private void eat(String s) {
            st = new StringTokenizer(s);
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!st.hasMoreTokens()) {
                String s = nextLine();
                if (s == null)
                    return false;
                eat(s);
            }
            return true;
        }

        public String next() {
            hasNext();
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

