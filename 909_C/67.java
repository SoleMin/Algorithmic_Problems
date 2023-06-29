import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ZYCSwing
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        private static final int MOD = (int) 1e9 + 7;
        private static final int N = 5000;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] dp = new int[N];
            Arrays.fill(dp, 0);
            dp[0] = 1;
            String pre = null, ch;
            for (int i = 0; i < n; ++i) {
                ch = in.next();
                if (i > 0) {
                    if (pre.equals("s")) {
                        int j = N - 1;
                        while (dp[j] == 0) {
                            --j;
                        }
                        long sum = 0;
                        for (; j >= 0; --j) {
                            sum += dp[j];
                            sum %= MOD;
                            dp[j] = (int) sum;
                        }
                    } else {
                        for (int k = N - 1; k > 0; --k) {
                            dp[k] = dp[k - 1];
                        }
                        dp[0] = 0;
                    }
                }
                pre = ch;
            }

            long sum = 0;
            for (int i = 0; i < N; ++i) {
                sum += dp[i];
                sum %= MOD;
            }
            out.println(sum);
        }

    }
}

