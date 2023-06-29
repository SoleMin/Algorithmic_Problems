import java.util.Locale;
import java.util.Scanner;


public class E {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][]p = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = sc.nextDouble();
            }
        }
        double[]dp = new double[1<<n];
        dp[(1 << n)-1] = 1;
        for (int mask = (1 << n)-1; mask > 0; mask--) {
            int t = Integer.bitCount(mask);
            if (t==1)
                continue;
            double p0 = 1.0/(t*(t-1)/2);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if (j != i && (mask & (1 << j)) != 0)
                            dp[(mask ^ (1 << i))] += dp[mask] * p[j][i]*p0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[1 << i]+" ");
        }
    }
}
