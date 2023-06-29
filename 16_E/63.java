import java.util.Locale;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        new E().solve();
    }
    
    private int c(int n) {
        return n * (n - 1) / 2;
    }
    
    public void solve() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] pb = new double[n][n];
        for (int i=0; i<n; ++i)
            for (int j=0; j<n; ++j)
                pb[i][j] = sc.nextDouble();
        
        int m = (1<<n);
        double[] dp = new double[m];
        dp[0] = 1.0f;
        for (int i=1; i<m; ++i)
            for (int j=0; j<n; ++j) if ((i & (1<<j)) != 0)
                for (int k=0; k<n; ++k) if ((i & (1<<k)) == 0)
                    dp[i] += pb[k][j] * dp[i & ~(1<<j)] / c(n - Integer.bitCount(i) + 1);
        
        int w = (1<<n) - 1;
        for (int i=0; i<n-1; ++i)
            System.out.printf("%.6f ", dp[w & ~(1<<i)]);
        System.out.printf("%.6f\n", dp[w & ~(1<<(n-1))]);
    }
}
