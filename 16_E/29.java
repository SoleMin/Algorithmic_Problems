import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Fish {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        int n = in.nextInt();

        double[] dp = new double[1 << n];
        Arrays.fill(dp, 0);
        dp[(1 << n) - 1] = 1;//?

        double[][] prob = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prob[i][j] = in.nextDouble();
            }
        }

        
        for (int t = (1 << n) - 1; t >= 0; t--) {
            int k = Integer.bitCount(t);
            for (int i = 0; i < n; i++) {
                if ((t & (1 << i)) > 0) {
                    for (int j = 0; j < n; j++) {
                        if ((t & (1 << j)) > 0) {
                            if (i != j) {
                                dp[t - (1 << j)] += dp[t] * prob[i][j] / (k*(k-1)/2);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dp[1 << i] + " ");
        }
    }
}
