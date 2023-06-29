import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main implements Runnable {
    
    // ////////////////////////////////////////////////////////////////////
    // Solution

    private int n;
    private int nn;
    private double[][] a;
    private double[] dp;

    private void solve() throws Throwable {
        n = nextInt();
        nn = 1 << n;
        a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextDouble();
            }
        }
        dp = new double[nn];
        Arrays.fill(dp, -1.0);
        dp[nn - 1] = 1.0;
        for (int j = 0; j < n; j++) {
            pw.format(Locale.US, "%.7f ", Dp(1 << j));
        }
    }

    private double Dp(int i) {
        if (dp[i] >= 0.0)
            return dp[i];
        
        double ans = 0;
        int count = Integer.bitCount(i);
        for (int j = 0; j < n; j++) {
            int jj = 1 << j;
            if ((jj & i) == 0) {
                double p = Dp(jj | i);
                double pPair = 2.0 / (double)((count + 1) * count);
                double s = 0;
                for (int l = 0; l < n; l++) {
                    int ll = 1 << l;
                    if ((ll & i) != 0) {
                        s += a[l][j];
                    }
                }
                ans += p * pPair * s;
                
            }
        }
        dp[i] = ans;
        return dp[i];
    }

    // ////////////////////////////////////////////////////////////////////
    // Utility functions

    PrintWriter pw;
    BufferedReader in;
    StringTokenizer st;

    void initStreams() throws FileNotFoundException {
        //System.setIn(new FileInputStream("1"));
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
