/**
 * Created by IntelliJ IDEA.
 * User: Taras_Brzezinsky
 * Date: 8/14/11
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class Fish extends Thread {

    public Fish() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
        this.output = new PrintWriter(System.out);
        this.setPriority(Thread.MAX_PRIORITY);
    }

    static int getOnes(int mask) {
        int result = 0;
        while (mask != 0) {
            mask &= mask - 1;
            ++result;
        }
        return result;
    }

    private void solve() throws Throwable {
        int n = nextInt();
        double[][] a = new double[n][n];
        double[] dp = new double[(1 << n)];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = nextDouble();
            }
        }
        int limit = (1 << n) - 1;
        //dp[mask] = probability of current subset (mask) to remain in the end
        dp[limit] = 1.0;
        for (int mask = limit; mask > 0; --mask) {
            int cardinality = getOnes(mask);
            int probability = cardinality * (cardinality - 1) / 2;
            for (int first = 0; first < n; ++first) {
                if ((mask & powers[first]) != 0) {
                    for (int second = first + 1; second < n; ++second) {
                        if ((mask & powers[second]) != 0) {
                            dp[mask - powers[first]] += dp[mask] * a[second][first] / probability;
                            dp[mask - powers[second]] += dp[mask] * a[first][second] / probability;
                        }

                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            output.printf("%.10f ", dp[powers[i]]);
        }
    }

    public void run() {
        try {
            solve();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(666);
        } finally {
            output.flush();
            output.close();
        }
    }


    public static void main(String[] args) {
        new Fish().start();
    }

    private String nextToken() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine());
        }
        return tokens.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static int powers[] = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144};
    private BufferedReader input;
    private PrintWriter output;
    private StringTokenizer tokens = null;
}
