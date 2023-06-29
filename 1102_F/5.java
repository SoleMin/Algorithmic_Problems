import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskF solver = new TaskF();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskF {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] graph = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    graph[i][j] = in.nextInt();
            }
            int[][] mn1 = new int[n][n];
            int[][] mn2 = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    int min_val = Integer.MAX_VALUE;
                    for (int k = 0; k < m; k++)
                        min_val = Math.min(min_val, Math.abs(graph[i][k] - graph[j][k]));
                    mn1[i][j] = min_val;
                    min_val = Integer.MAX_VALUE;
                    for (int k = 0; k < m - 1; k++) {
                        min_val = Math.min(min_val, Math.abs(graph[i][k] - graph[j][k + 1]));
                    }
                    mn2[i][j] = min_val;
                }
            int[][] dp = new int[(1 << (n + 2))][n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int[] temp : dp)
                    Arrays.fill(temp, -1);
                for (int j = 0; j < n; j++) {
                    dp[1 << j][j] = (j == i ? Integer.MAX_VALUE : 0);
//                dp[1 << j][j] = (j == i ? 0: Integer.MAX_VALUE );
                }
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, Math.min(mn2[j][i], calc((1 << n) - 1, j, dp, mn1, n)));
                }
            }
            out.println(ans);
        }

        public int calc(int mask, int v, int[][] dp, int[][] mn1, int n) {
//        System.out.println(mask+","+v);
            if (dp[mask][v] != -1)
                return dp[mask][v];
            dp[mask][v] = 0;
            for (int u = 0; u < n; u++) {
                if (u != v && (((mask >> u) & 1) == 1))
                    dp[mask][v] = Math.max(dp[mask][v], Math.min(mn1[u][v], calc(mask ^ (1 << v), u, dp, mn1, n)));
            }
            return dp[mask][v];
        }

    }
}

