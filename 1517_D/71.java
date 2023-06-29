import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static public void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt(), K = s.nextInt();
        int[][] p = new int[n][m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                p[i][j] = s.nextInt();
            }
        }
        int[][] v = new int[n - 1][m];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = s.nextInt();
            }
        }
        if (K % 2 == 1){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("-1 ");
                }
                System.out.println();
            }

            return;
        }

        long[][][] dp = new long[K + 1][n][m];
        for (int k = 2; k <= K; k += 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long res = Long.MAX_VALUE;
                    if (i + 1 < n) {
                        res = Math.min(res, dp[k - 2][i + 1][j] + v[i][j] * 2);
                    }
                    if (i - 1 >= 0) {
                        res = Math.min(res, dp[k - 2][i - 1][j] + v[i - 1][j] * 2);
                    }
                    if (j + 1 < m) {
                        res = Math.min(res, dp[k - 2][i][j + 1] + p[i][j] * 2);
                    }

                    if (j - 1 >= 0) {
                        res = Math.min(res, dp[k - 2][i][j - 1] + p[i][j - 1] * 2);
                    }
                    dp[k][i][j] = res;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[K][i][j] + " ");
            }
            System.out.println();
        }

    }
}

