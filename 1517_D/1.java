import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    static int[][][] dp = new int[505][505][15];
    static int[][] w1 = new int[505][505];
    static int[][] w2 = new int[505][505];
    public static void main(String[] args) throws java.lang.Exception {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new FastReader();
        int test = 1;
        for (int t = 0; t < test; t++) {
            solve();
        }
        out.close();
    }

    private static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                w1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                w2[i][j] = sc.nextInt();
            }
        }
        if (k % 2 != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(-1 + " ");
                }
                out.println();
            }
            return;
        }
        k /= 2;
        for (int x = 1; x <= k; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j][x] = Integer.MAX_VALUE;
                    if (inRange(i - 1, j, n, m)) {
                        int w = w2[i - 1][j];
                        dp[i][j][x] = Math.min(dp[i][j][x], dp[i - 1][j][x - 1] + w);
                    }
                    if (inRange(i, j - 1, n, m)) {
                        int w = w1[i][j - 1];
                        dp[i][j][x] = Math.min(dp[i][j][x], dp[i][j - 1][x - 1] + w);
                    }
                    if (inRange(i + 1, j, n, m)) {
                        int w = w2[i][j];
                        dp[i][j][x] = Math.min(dp[i][j][x], dp[i + 1][j][x - 1] + w);
                    }
                    if (inRange(i, j + 1, n, m)) {
                        int w = w1[i][j];
                        dp[i][j][x] = Math.min(dp[i][j][x], dp[i][j + 1][x - 1] + w);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int boredness = dp[i][j][k] * 2;
                out.print(boredness + " ");
            }
            out.println();
        }
    }

    private static boolean inRange(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    public static FastReader sc;
    public static PrintWriter out;
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}