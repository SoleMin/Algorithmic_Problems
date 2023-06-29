import java.util.*;
import java.io.*;

public class F531 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(); int m = sc.nextInt();
        long [][] mn1 = new long[n][n];
        long [][] mn2 = new long[n][n];
        long [][] grid = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) grid[i][j] = sc.nextInt();
        }
        if (n == 1) {
            long ans = Integer.MAX_VALUE;
            for (int i = 0; i < m - 1; i++) ans = Math.min(ans, Math.abs(grid[0][i] - grid[0][i + 1]));
            out.println(ans);
            out.close();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long min = Long.MAX_VALUE;
                for (int k = 0; k < m; k++) min = Math.min(min, Math.abs(grid[i][k] - grid[j][k]));
                mn1[i][j] = min;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long min = Long.MAX_VALUE;
                for (int k = 0; k < m - 1; k++) min = Math.min(min, Math.abs(grid[i][k] - grid[j][k + 1]));
                mn2[i][j] = min;
            }
        }
        long [][] dp = new long[1 << n][n];

        // start vertex
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (long [] a: dp) Arrays.fill(a, -1);
            for (int j = 0; j < n; j++) {
                if (j == i) dp[1 << j][j] = Long.MAX_VALUE;
                else dp[1 << j][j] = 0;
            }
            for (int mask = 1; mask < (1 << n); mask++) {
                for (int last = 0; last < n; last++) {
                    if (dp[mask][last] != -1) continue;
                    for (int prev = 0; prev < n; prev++) {
                        if (prev == last) continue;
                        if (((mask >> prev) & 1) == 1) {
                            dp[mask][last] = Math.max(dp[mask][last], Math.min(mn1[prev][last], dp[mask ^ (1 << last)][prev]));
                        }
                    }
                }
            }
            // end vertex
            for (int j = 0; j < n; j++) {
                // step from the last vertex to the first
                long end = mn2[j][i];
                ans = Math.max(ans, Math.min(dp[(1 << n) - 1][j], end));
            }
        }
        out.println(ans);
        out.close();
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


    }

}