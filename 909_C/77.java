import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jarek on 2017-12-30.
 */
public class PhytonIndenter {

    private static Scanner scanner = new Scanner(System.in);

    private static int lineCount;
    private static String[] commands;

    public static void main(String args[]) {
        lineCount = scanner.nextInt();
        scanner.nextLine();
        commands = new String[lineCount];

        for (int i = 0; i < lineCount; i++) {
            commands[i] = scanner.nextLine();
        }

        resolveWithDP();
    }

    private static void resolveWithDP() {
        long dp[][] = new long[lineCount][5002];
        long mod = 1000000007;
        dp[0][0] = 1;
        for (int i = 1; i < lineCount; i++) {
            if ("f".equalsIgnoreCase(commands[i - 1])) {
                dp[i][0] = 0;
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            } else {
                long sum = 0;
                for (int j = i - 1; j >= 0; j--) {
                    sum += dp[i - 1][j] % mod;
                    dp[i][j] = sum;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < lineCount; i++) {
            result += dp[lineCount-1][i]%mod;
            result %= mod;
        }
        System.out.println(result%mod);
    }

}
