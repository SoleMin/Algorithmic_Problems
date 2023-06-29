import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Template {

    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        final PrintStream out = System.out;
        int n = in.nextInt(), m = in.nextInt();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < m; ++i) {
            int a = in.nextInt(), b = in.nextInt();
            --a; --b;
            g[a][b] = g[b][a] = true;
        }
        final int mx = 1<<n;
        long[][] dp = new long[mx][n];
        long res = 0;
        for (int mask = 0; mask < mx; ++mask)
            for (int i = 0; i < n; ++i) {
                if (mask == (1 << i)) {
                    dp[mask][i] = 1;
                } else if (((mask & (1 << i)) != 0) && ((mask & ((1 << i) - 1)) != 0)) {
                    long r = 0;
                    int next = mask ^ (1<<i);
                    for (int j = 0; j < n; ++j) if (g[i][j]) {
                        r += dp[next][j];
                    }
                    dp[mask][i] = r;
                } else {
                    dp[mask][i] = 0;
                }

                if ((mask & (mask-1)) != 0 && g[i][lowestBit(mask)]) {
                    res += dp[mask][i];
                }

            }

        System.out.println((res-m)/2);
    }

    private static int lowestBit(int mask) {
        for (int i = 0;;++i) {
            if ((mask & (1<<i)) > 0) {
                return i;
            }
        }
    }

}
