import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        E2VrashayaStolbciUslozhnennayaVersiya solver = new E2VrashayaStolbciUslozhnennayaVersiya();
        solver.solve(1, in, out);
        out.close();
    }

    static class E2VrashayaStolbciUslozhnennayaVersiya {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int tn = in.nextInt();
            for (int t = 0; t < tn; t++) {
                int n = in.nextInt();
                int m = in.nextInt();
                Col[] a = new Col[m];
                for (int i = 0; i < m; i++) {
                    a[i] = new Col(n);
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        a[j].a[i] = in.nextInt();
                        if (a[j].a[i] > a[j].max) {
                            a[j].max = a[j].a[i];
                        }
                    }

                }

                Arrays.sort(a, (o1, o2) -> o2.max - o1.max);

                if (m > n) {
                    m = n;
                }

                for (int i = 0; i < m; i++) {
                    a[i].calcMask();
                }

                int[][] dp = new int[m + 1][1 << n];
                Arrays.fill(dp[0], -1);
                dp[0][0] = 0;
                for (int i = 0; i < m; i++) {
                    for (int msk = 0; msk < (1 << n); msk++) {
                        dp[i + 1][msk] = dp[i][msk];
                        for (int sub = msk; sub > 0; sub = (sub - 1) & msk) {
                            int v = dp[i][msk ^ sub] + a[i].mask[sub];
                            if (v > dp[i + 1][msk]) {
                                dp[i + 1][msk] = v;
                            }
                        }
                    }
                }

                out.println(dp[m][(1 << n) - 1]);
            }
        }

        class Col {
            int n;
            int[] a;
            int[] mask;
            int max;

            public Col(int n) {
                this.n = n;
                a = new int[n];
            }

            void calcMask() {
                mask = new int[1 << n];
                for (int i = 0; i < (1 << n); i++) {
                    for (int j = 0; j < n; j++) {
                        int sum = 0;
                        for (int k = 0; k < n; k++) {
                            if (((1 << k) & i) != 0) {
                                sum += a[(j + k) % n];
                            }
                        }
                        if (sum > mask[i]) {
                            mask[i] = sum;
                        }
                    }
                }
            }

        }

    }
}

