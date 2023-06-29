import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main implements Runnable {

    private int n;
    private int nn;
    private long[][] dp;
    private boolean[][] gr;

    // ////////////////////////////////////////////////////////////////////
    // Solution

    private void solve() throws Throwable {
        n = nextInt();
        nn = 1 << n;
        gr = new boolean[n][n];
        dp = new long[n][nn];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int m = nextInt();
        for (int i = 0; i < m; i++) {
            int a = nextInt() - 1, b = nextInt() - 1;
            gr[a][b] = gr[b][a] = true;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int mask = 1; mask < nn; mask++) {
            int bCount = Integer.bitCount(mask);
            if (bCount < 2) {
                dp[Integer.numberOfTrailingZeros(mask)][mask] = 0;
            } else if (bCount == 2) {
                int msk = mask;
                int one = Integer.numberOfTrailingZeros(msk);
                msk ^= (1 << one);
                int two = Integer.numberOfTrailingZeros(msk);
                dp[two][mask] = gr[one][two] ? 1 : 0;
            }
        }
        long count = 0;
        for (int mask = 1; mask < nn; mask++) {
            if (Integer.bitCount(mask) < 3) continue;
            int i = Integer.numberOfTrailingZeros(mask);
            for (int j = i + 1; j < n; j++) {
                int jj = 1 << j;
                if (gr[i][j] && ((jj & mask) != 0)) {
                    count += Dp(j, mask);
                }
            }
        }
        pw.println(count / 2);
    }

    private long Dp(int j, int mask) {
        if (dp[j][mask] != -1) return dp[j][mask];
        int i = Integer.numberOfTrailingZeros(mask);
        assert i < j;
        int m = mask ^ (1 << j);
        long ans = 0;
        for (int p = i + 1; p < n; p++) {
            if (!gr[p][j]) continue;
            if ((mask & (1 << p)) == 0) continue;
            ans += Dp(p, m);
        }
        dp[j][mask] = ans;
        return ans;
    }

    // ////////////////////////////////////////////////////////////////////
    // Utility functions

    PrintWriter pw;
    BufferedReader in;
    StringTokenizer st;

    void initStreams() throws FileNotFoundException {
        //System.setIn(new FileInputStream("2"));
        in = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }

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

    static Throwable sError;

    public static void main(String[] args) throws Throwable {
        Thread t = new Thread(new Main());
        t.start();
        t.join();
        if (sError != null) {
            throw sError;
        }
    }

    public void run() {
        try {
            initStreams();
            solve();
        } catch (Throwable e) {
            sError = e;
        } finally {
            if (pw != null)
                pw.close();
        }
    }
}
