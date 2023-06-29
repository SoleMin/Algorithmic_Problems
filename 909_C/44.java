import java.util.*;
public class A{
       
       public static int mod = 1000000007;
       
       public static void main(String args[]){
              Scanner sc = new Scanner(System.in);
              int n = sc.nextInt();
              char s[] = new char[n];
              for(int i = 0; i < n; i++)
                     s[i] = sc.next().charAt(0);
              int dp[][] = new int[5001][5001];
              int sum[][] = new int[5001][5001];
              dp[0][0] = 1;
              sum[0][0] = 1;
              for(int i = 1; i < n; i++){
                     for(int j = n - 1; j >= 0; j--){
                            if(s[i-1] == 'f' && j > 0){
                                   dp[i][j] = dp[i-1][j-1] % mod;
                            }else if(s[i-1] == 's'){
                                   dp[i][j] = sum[i-1][j] % mod;
                            }
                            sum[i][j] = (sum[i][j+1] + dp[i][j]) % mod;
                     }
              }
              System.out.println(sum[n-1][0]);
       }
}