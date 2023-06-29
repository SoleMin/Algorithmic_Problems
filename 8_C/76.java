import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    int[] x;
    int[] y;
    int n;
    int X, Y;

    int[] d;
    int[][] dist;

    int sqr(int a) {
        return a * a;
    }

    int dist(int X, int Y, int i) {
        return sqr(X - x[i]) + sqr(Y - y[i]);
    }

    int[] dp;
    byte[][] pred;

    int rec(int mask) {
        if (dp[mask] == -1) {
            int res = 1 << 29;
            boolean ok = false;
            for (int i = 0; i < n; ++i)
                if ((mask & (1 << i)) > 0) {
                    ok = true;
                    int mm = mask & ~(1 << i);
                    for (int j = i; j < n; j++)
                        if ((mask & (1 << j)) > 0) {
                            int nmask = mm & ~(1 << j);
                            int a = rec(nmask) + d[i] + d[j] + dist[i][j];
                            if (a < res) {
                                res = a;
                                pred[0][mask] = (byte) (i);
                                pred[1][mask] = (byte) (j);
                            }
                        }
                    break;
                }
            if (!ok)
                res = 0;
            dp[mask] = res;
        }
        return dp[mask];
    }

    void solve() throws IOException {
        X = ni();
        Y = ni();
        n = ni();
        // if (n > 5)
        // return;
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = ni();
            y[i] = ni();
        }
        d = new int[n];
        dist = new int[n][n];
        for (int i = 0; i < n; ++i)
            d[i] = dist(X, Y, i);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; j++) {
                dist[i][j] = dist(x[i], y[i], j);
            }
        pred = new byte[2][1 << n];
        dp = new int[1 << n];
        Arrays.fill(dp, -1);
        out.println(rec((1 << n) - 1));
        int a = (1 << n) - 1;
        while (a > 0) {
            if (pred[0][a] != pred[1][a])
                out.print(0 + " " + (pred[0][a] + 1) + " " + (pred[1][a] + 1)
                        + " ");
            else
                out.print(0 + " " + (pred[0][a] + 1) + " ");
            int na = a & ~(1 << pred[0][a]);
            na &= ~(1 << pred[1][a]);
            a = na;
        }
        out.println(0);
    }

    public Solution() throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    String ns() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int ni() throws IOException {
        return Integer.valueOf(ns());
    }

    long nl() throws IOException {
        return Long.valueOf(ns());
    }

    double nd() throws IOException {
        return Double.valueOf(ns());
    }

    public static void main(String[] args) throws IOException,
            InterruptedException {
        Thread th = new Thread(null, new Solution(), "", 536870912);
        th.start();
        th.join();
    }

    @Override
    public void run() {
        try {
            Locale.setDefault(Locale.US);
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
