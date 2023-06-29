import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main implements Runnable {

    // ////////////////////////////////////////////////////
    // Solution

    private int n;
    private int nn;
    private int[][] D;
    private int[] dp;
    private int[] prev;

    private void solve() throws Throwable {
        int xs = nextInt(), ys = nextInt();
        n = nextInt();
        int[][] pts = new int[n][2];
        for (int i = 0; i < n; i++) {
            pts[i][0] = nextInt();
            pts[i][1] = nextInt();
        }
        D = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    D[i][i] = 2 * (sqr(pts[i][0] - xs) + sqr(pts[i][1] - ys));
                } else {
                    D[i][j] = sqr(pts[i][0] - xs) + sqr(pts[i][1] - ys)
                            + sqr(pts[i][0] - pts[j][0])
                            + sqr(pts[i][1] - pts[j][1]) + sqr(pts[j][0] - xs)
                            + sqr(pts[j][1] - ys);
                }
            }
        }
        nn = 1 << n;
        dp = new int[nn];
        prev = new int[nn];
        Arrays.fill(dp, -1);
        Arrays.fill(prev, -1);
        dp[0] = 0;
        Dp(nn - 1);
        pw.println(dp[nn - 1]);
        pw.print(0);
        for (int p = nn - 1; p != -1 && prev[p] != -1; p = prev[p]) {
            int vv = p ^ prev[p];
            for (int j = 0; j < n; j++) {
                int jj = 1 << j;
                if ((vv & jj) == 0)
                    continue;
                pw.print(' ');
                pw.print(j + 1);
            }
            pw.print(" 0");
        }
        pw.println();
    }

    private int Dp(int i) {
        if (dp[i] != -1)
            return dp[i];
        int ans = 107374182, p = -1;
        int j1 = 1, pos1 = 0;
        for (; pos1 < n && j1 < nn; j1 *= 2, pos1++) {
            if ((i & j1) == 0)
                continue;
            int a = D[pos1][pos1] + Dp(i ^ j1);
            if (a < ans) {
                ans = a;
                p = i ^ j1;
            }
            int j2 = j1 * 2, pos2 = pos1 + 1;
            for (; pos2 < n && j2 < nn; j2 *= 2, pos2++) {
                if ((i & j2) == 0)
                    continue;
                a = D[pos1][pos2] + Dp(i ^ (j1 | j2));
                if (a < ans) {
                    ans = a;
                    p = i ^ (j1 | j2);
                }
            }
            break;
        }
        dp[i] = ans;
        prev[i] = p;
        return ans;
    }

    private int sqr(int i) {
        return i * i;
    }

    // ////////////////////////////////////////////////////
    // Utility functions

    private void initstreams() throws Throwable {
        //System.setIn(new FileInputStream("1"));
        in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        pw = new PrintWriter(System.out);
    }

    BufferedReader in;
    PrintWriter pw;
    StringTokenizer st;

    String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextString());
    }

    long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextString());
    }

    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextString());
    }

    @Override
    public void run() {
        try {
            initstreams();
            solve();
        } catch (Throwable e) {
            sError = e;
        } finally {
            if (pw != null)
                pw.close();
        }
    }

    private static Throwable sError;

    public static void main(String[] args) throws Throwable {
        Thread t = new Thread(new Main());
        t.start();
        t.join();
        if (sError != null)
            throw sError;
    }
}
