/*(c) gorlum0 [at] gmail.com*/
import java.io.*;
import java.util.*;
import java.math.*;

public class E
{
    int bitcount(int x) {
        int c = 0;
        for ( ; x != 0; c++)
            x &= x-1;
        return c;
    }

    boolean bit(int x, int i)
    {
        if (i < 0) return false;
        return (x>>i & 1) == 1 ? true : false;
    }

    int solve(int n, int m)
    {
        if (m > n) { int x = m; m = n; n = x; }
        int maxmask = 1<<m;

        int[][][] dp = new int[n+1][maxmask][maxmask];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j < maxmask; j++)
                for (int k = 0; k < maxmask; k++)
                    dp[i][j][k] = inf;
        for (int i = 0; i < maxmask; i++)
            dp[0][0][i] = bitcount(i);

        for (int i = 1; i <= n; i++)
            for (int b = 0; b < maxmask; b++)
                for (int c = 0; c < maxmask; c++)
                    for (int a = 0; a < maxmask; a++) {
                        boolean nospider = false;
                        for (int j = 0; j < m; j++)
                            if (not(bit(a,j) || bit(c,j) || bit(b,j-1) || bit(b,j) || bit(b,j+1))) {
                                nospider = true;
                                break;
                            }
                        if (nospider) continue;

                        dp[i][b][c] = Math.min(dp[i][b][c], dp[i-1][a][b] + bitcount(c));
                    }
        int res = inf;
        for (int b = 0; b < maxmask; b++)
            res = Math.min(res, dp[n][b][0]);
        return n*m - res;
    }

    void main() throws IOException {
        int n;
        while ((n = nextInt()) != EOF) {
            int m = nextInt();
            out.println(solve(n, m));
        }
    }

    public static void main(String[] args) {
        new E().run();
    }

    // ======================================================================

    int inf = (int) 1e9;
    final int EOF = -1;

    boolean not(boolean p) { return !p; }

    int sqr(int x) { return x*x; }
    long sqr(long x) { return x*x; }
    double sqr(double x) { return x*x; }

    BufferedReader fin;
    StringTokenizer st;
    PrintWriter out;

    public void run() {
        try {
            fin = new BufferedReader(new InputStreamReader(System.in));
            st = null;
            out = new PrintWriter(System.out);
            main();
            fin.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = fin.readLine();
            if (line == null) return "-1";
            else st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}
