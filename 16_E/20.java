import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("1"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int n = nextInt();
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextDouble();
            }
        }
        double[] dp = new double[1 << n];
        dp[(1 << n) - 1] = 1.0;
        for (int mask = (1 << n) - 2; mask > 0; mask--) {
            int count = Integer.bitCount(mask);
            double pPair = 2.0 / (count * (count + 1));
            double ans = 0.0;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) == 0) {
                    double p = dp[(1 << i) | mask];
                    double s = 0.0;
                    for (int j = 0; j < n; j++) {
                        if (((1 << j) & mask) != 0)
                            s += a[j][i];
                    }
                    ans += pPair * p * s;
                }
            }
            dp[mask] = ans;
        }

        for (int i = 0; i < n; i++) {
            out.print(dp[1 << i]);
            out.print(' ');
        }
        
        in.close();
        out.close();
    }

    static StringTokenizer st;
    static BufferedReader in;
    static PrintWriter out;

    static int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextString());
    }

    static String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
