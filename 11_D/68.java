
import java.util.Arrays;
import java.util.Scanner;

public class C {
    static boolean[][] matrix;
    static long[][] dp;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        matrix = new boolean[n][n];
        for (int i=0; i<m; ++i) {
            int v1 = s.nextInt()-1;
            int v2 = s.nextInt()-1;
            matrix[v1][v2] = true;
            matrix[v2][v1] = true;
        }
        dp = new long[n][1<<n+1];
        for (int i=0; i<n; ++i) Arrays.fill(dp[i], -1);
        
        long res = 0;
        for (int i=0; i<n; ++i)
            res += calc(i, i, (1<<i), 1);
        
        System.out.println(res/2);
    }
    
    public static long calc(int h, int c, int m, int len) {
        if (dp[c][m] != -1)
            return dp[c][m];
        
        long ret = 0;
        if (len > 2 && matrix[c][h])
            ret = 1;
        for (int i=h+1; i<n; ++i)
            if ((m & (1<<i)) == 0 && matrix[c][i])
                ret += calc(h, i, m | (1<<i), len + 1);
        return dp[c][m] = ret;
    }
}