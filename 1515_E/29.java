import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PhoenixAndComputers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n+2][n+1];
        long[] pow = new long[n+1];
        pow[0] = 1;
        for (int i=1; i <= n; i++){
            pow[i] = pow[i-1]*2;
            pow[i] %= mod;
        }
        long[][] choose = new long[n*2+1][n+1];
        for (int i=0; i <= n; i++){
            choose[i][i] = 1;
        }
        for (int i=1; i <= n*2; i++){
            for (int j=0; j <= n; j++){
                choose[i][j] = choose[i-1][j];
                if (j > 0){
                    choose[i][j] += choose[i-1][j-1];
                }
                choose[i][j] %= mod;
            }
        }
        dp[0][0] = 1;
        for (int i=0; i < n; i++){ // number of computers on
            for (int j=0; j <= i; j++){ // number manually turned on
                for (int k=1; k+i <= n; k++){ // number of computers manually turned on in next "block"
                    dp[i+k+1][j+k] += (pow[k-1] * choose[j+k][k])%mod * dp[i][j];
                    dp[i+k+1][j+k] %= mod;
                }
            }
        }
        long ans = 0;
        for (int j=0; j <= n; j++){
            ans += dp[n+1][j];
            ans %= mod;
        }
        System.out.println(ans);
    }
}
