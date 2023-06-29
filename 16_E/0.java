import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;

    void run(FastScanner in, PrintWriter out) {

        int n = in.nextInt();
        double[][] p = new double[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = Double.valueOf(in.next());
            }
        }

        int maxMask = 1<<n;
        double[] dp = new double[maxMask];
        dp[maxMask-1] = 1;

        for (int b = maxMask-1; b >= 0; --b) {
            int k = Integer.bitCount(b);
            if (k <= 1) continue;

            double add = dp[b] / (k*(k-1)/2);
            for (int i = 0; i < n; i++) if ((b & (1<<i)) > 0) {
                for (int j = 0; j < i; j++) if ((b&(1<<j)) > 0) {
                    dp[b - (1<<j)] += add * p[i][j];
                    dp[b - (1<<i)] += add * p[j][i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%.7f ", dp[1<<i]));
        }
        System.out.println();


    }
    // void run(FastScanner in, PrintWriter out) {

    //     int n = in.nextInt();
    //     double[][] p = new double[n+1][n+1];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             p[i][j] = Double.valueOf(in.next());
    //         }
    //     }

    //     double[] f = new double[n+1];
    //     f[0] = 1;
    //     for (int i = 1; i <= n; i++) {
    //         f[i] = f[i-1]*i;
    //     }

    //     int maxMask = 1<<n;
    //     double[][] dp = new double[maxMask][n];

    //     for (int i = 0; i < n; i++) {
    //         dp[1<<i][i] = 1;
    //     }

    //     for (int mask = 0; mask < maxMask; mask++) {


    //         int cnt = Integer.bitCount(mask);
    //         int fishLeft = n-cnt;

    //         for (int survivor = 0; survivor < n; survivor++) {
    //             if ((mask & (1<<survivor)) == 0) continue;
    //             for (int challenger = 0; challenger < n; challenger++) {
    //                 if ((mask & (1<<challenger)) > 0) continue;

    //                 dp[mask | (1<<challenger)][challenger] += 1./fishLeft * dp[mask][survivor] * p[challenger][survivor];

    //                 // dp[mask | (1<<challenger)][survivor] += 1./fishLeft * dp[mask][survivor] * p[survivor][challenger];

    //             }

    //         }





    //     }

    //     for (int mask = 0; mask < maxMask; mask++) {
    //         System.out.println(Integer.toBinaryString(mask) + " " + Arrays.toString(dp[mask]));
    //     }

    //     for (int i = 0; i < n; i++) {
    //         out.print(String.format("%.7f ", dp[maxMask-1][i]));
    //         // out.print(String.format("%.7f ", dp[maxMask-1][i]/n));
    //     }
    //     out.println();

    // }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
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
    }
}
