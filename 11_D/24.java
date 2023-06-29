import java.util.Scanner;


public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][]a = new int[n][n];
        for (int i = 1; i <= m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            v1--;
            v2--;
            a[v1][v2] = a[v2][v1] = 1;
        }
        long[][]dp = new long[1 << n][n];
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 1;
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) > 1) {
                for (int i = 0; i < n; i++) {
                    if (i==Integer.numberOfTrailingZeros(mask))
                        continue;
                    if ((mask & (1 << i)) != 0) {
                        for (int j = 0; j < n; j++) {
                            if ((mask & (1 << j)) != 0 && a[j][i]==1) {
                                dp[mask][i] += dp[(mask ^ (1 << i))][j];
                            }
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) >= 3) {
                int t = Integer.numberOfTrailingZeros(mask);
                for (int i = 0; i < n; i++) {
                    if (a[t][i]==1)
                        ans += dp[mask][i];
                }
            }
        }
        ans /= 2;
        System.out.println(ans);
    }
}   
