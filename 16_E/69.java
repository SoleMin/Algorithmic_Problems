import java.util.Scanner;

public class Fishes {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double[][] p = new double[n][n];
        double[] dp = new double[1 << 18];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = Double.parseDouble(s.next());
            }
        }
        int last = 1 << n;
        dp[last - 1] = 1.0;
        for (int i = last - 2; i > 0; i--) {
            int res = 0;
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) > 0) res++;
            }
            res++;
            res = res * (res - 1) / 2;
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) == 0) {
                    for (int z = 0; z < n; z++) {
                        if (((1 << z) & i) > 0) {
                            dp[i] += dp[i | (1 << j)] * 1.0 / res * p[z][j];
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
