import java.util.*;

public class Compute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long M = sc.nextInt();
        long fact[] = new long[n+1];
        long inv[] = new long[n+1];
        long ifact[] = new long[n+1];
        long dp[][] = new long[n+1][n+1];
        fact[1] = 1;
        ifact[1] = 1;
        ifact[0] = 1;
        inv[1] = 1;
        dp[1][1] = 1;
        
        for(int i = 2; i <= n; i++) {
            fact[i] = (i*fact[i-1]) % M;
            inv[i] = (inv[(int)(M % i)]*(M - M/i)) % M;
            dp[i][i] = (dp[i-1][i-1] * 2) % M;
            ifact[i] = (ifact[i-1]*inv[i]) % M;
        }
            
        for(int i = 3; i <= n; i++) {
            for(int j = i/2 + 1; j <= i-1; j++) {
                for(int k = 2; k <= i-1 && j-k+1 > (i-k)/2; k++) {
                    dp[i][j] = (dp[i][j] + ((((dp[k-1][k-1]*dp[i-k][j-k+1] % M)*fact[j] % M)*ifact[k-1] % M)*ifact[j-k+1] % M)) % M;   
                }
            }   
        }
        
        long sum = 0;
        for(int i = n/2 + 1; i <= n; i++)
            sum = (sum + dp[n][i]) % M;
        
        System.out.println(sum % M);
    }
}