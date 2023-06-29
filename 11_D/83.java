import java.util.Scanner;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.numberOfTrailingZeros;
import static java.lang.System.out;

/**
 * 11D
 *
 * @author artyom
 */
public class ASimpleTask {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        for (int i = 0, m = sc.nextInt(); i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            d[a][b] = 1;
            d[b][a] = 1;
        }
        long[][] dp = new long[1 << n][n];

        // SOLUTION BEGINS
        for (int mask = 1; mask < 1 << n; mask++) {
            int start = numberOfTrailingZeros(mask); // the starting vertex of a Hamiltonian walk
            if (bitCount(mask) == 1) {
                dp[mask][start] = 1;
                continue;
            }
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0 && i != start) {
                    int xmask = mask ^ (1 << i); // mask without vertex i
                    for (int j = 0; j < n; j++) {
                        if (d[j][i] > 0) {
                            dp[mask][i] += dp[xmask][j];
                        }
                    }
                }
            }
        }
        // SOLUTION ENDS

        long sum = 0;
        for (int mask = 1; mask < 1 << n; mask++) {
            if (bitCount(mask) >= 3) { // We need at least 3 vertices for a cycle
                for (int i = 0; i < n; i++) {
                    if (d[numberOfTrailingZeros(mask)][i] > 0) {
                        sum += dp[mask][i];
                    }
                }
            }
        }
        out.print(sum / 2);
    }
}