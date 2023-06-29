import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _909C {

    private static final int MOD = 1000000007;

    private static void solve(Scanner scan, PrintWriter pw) {
        int n = scan.nextInt();
        scan.nextLine();

        // dp[i][j] is the number ways the ith statement is indented j times
        int[][] dp = new int[n][n];
        int[][] dpSums = new int[n][n];

        dp[0][0] = 1;

        for(int i = 0; i < n; i++) {
            dpSums[0][i] = 1;
        }

        boolean lastIsSimple = scan.nextLine().equals("s");

        for(int i = 1; i < n; i++) {

            if(lastIsSimple) {
                dp[i][0] = dpSums[i-1][n-1];
                dpSums[i][0] = dp[i][0];

                for(int j = 1; j < n; j++) {
                    dp[i][j] = (dpSums[i-1][n-1] - dpSums[i-1][j-1] + MOD) % MOD;
                    dpSums[i][j] = (dp[i][j] + dpSums[i][j-1]) % MOD;
                }
            }
            else {
                dp[i][0] = 0;
                dpSums[i][0] = 0;

                for(int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j-1];
                    dpSums[i][j] = (dp[i][j] + dpSums[i][j-1]) % MOD;
                }

            }

            lastIsSimple = scan.nextLine().equals("s");
        }

        System.out.println(dpSums[n-1][n-1]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in, 1024 * 64));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out, 1024 * 64));
        solve(scan, pw);
        pw.flush();
    }

}