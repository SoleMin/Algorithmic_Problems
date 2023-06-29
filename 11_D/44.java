/**
 * Codeforces Beta Round #10
 * 
 * @author ProjectYoung
 */

import java.util.Scanner;

public class CF11D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    boolean[][] map = new boolean[n][n];
    long[][] dp = new long[1 << n][n];
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      map[a][b] = map[b][a] = true;
      dp[(1 << a) + (1 << b)][Math.max(a, b)] = 1;
    }
    long ans = 0;
    for (int mask = 1; mask < (1 << n); mask++) {
      int lowbit = 0;
      for (; (mask & (1 << lowbit)) == 0; lowbit++);
      for (int i = lowbit + 1; i < n; i++) {
        if ((mask & (1 << i)) == 0) {
          continue;
        }
        for (int j = lowbit + 1; j < n; j++) {
          if ((mask & (1 << j)) == 0 || j == i) {
            continue;
          }
          if (map[i][j]) {
            dp[mask][i] += dp[mask ^ (1 << i)][j];
          }
        }
        if (map[lowbit][i]) {
          ans += dp[mask][i];
        }
      }
    }
    System.out.println((ans - m) / 2);
    sc.close();
  }
}
