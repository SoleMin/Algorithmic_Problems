import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int[][][] dp; 
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        int n = r.nextInt();
        int m = r.nextInt();
        
        if(n > m){int t = n; n = m; m = t;}
        
        dp = new int[m+1][1 << 7][1 << 7];
        for(int[][] i : dp)
            for(int[] j : i)
                Arrays.fill(j, -1);
        int min = go(m, 0, (1<<n) -1, n, m);
        
        System.out.println(n * m - min);
    }
    private static int go(int rem, int prev, int need, int n, int m) {
//      for(int i = rem; i < m; i++)
//          System.out.print(" ");
//      System.out.println(rem + ": " + prev +","+need);
        if(rem == 0)return prev == 0?0:1 << 20;
        if(dp[rem][prev][need] != -1)return dp[rem][prev][need];
        
        int min = 1 << 20;
        for(int now = 0; now < 1 << n; now++){
            if((~now & prev) != 0)continue;
            
            int after = need & ~(now) & ~(now << 1) & ~(now >> 1);
            int next = ~(now) & ((1 << n)-1);
            int current = Integer.bitCount(now) + go(rem-1, after ,next, n, m);
            min = Math.min(min, current);
        }
        return dp[rem][prev][need] = min;
    }
}
