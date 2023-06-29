import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class E {
    static int g[][];
    static int n, m;
    static char[] s;
    static int dp[], inf = (int) 2e9;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = in.nextInt();
        m = in.nextInt();
        s = in.next().toCharArray();
        g = new int[m][m];
        for (int i = 1; i < n; i++) {
            int x = s[i - 1] - 'a', y = s[i] - 'a';
            if (x != y) {
                g[x][y]++;
                g[y][x]++;
            }
        }
        dp = new int[1 << m];
        Arrays.fill(dp, -1);
        pw.println(solve(0, 0));

        pw.close();
    }

    static int solve(int pos, int mask) {
        if (pos >= m) return 0;
        if (dp[mask] != -1) return dp[mask];
        int min = inf;
        for (int i = 0; i < m; i++) {
            if (!check(mask, i)) {
                int res = 0;
                for (int j = 0; j < m; j++) {
                    if (check(mask, j)) res += g[i][j] * pos;
                    else res -= g[i][j] * pos;
                }
                res += solve(pos + 1, set(mask, i));
                min = min(min, res);
            }
        }
        return dp[mask] = min;
    }

    static boolean check(int N, int pos) {
        return (N & (1 << pos)) != 0;
    }

    static int set(int N, int pos) {
        return N = N | (1 << pos);
    }

    static int reset(int N, int pos) {
        return N = N & ~(1 << pos);
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}