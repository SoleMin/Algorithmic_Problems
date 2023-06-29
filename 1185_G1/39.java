import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    public static long mod = 1000000007;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] d = new int[n];
        int[] g = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken())-1;
        }
        long[][] dp = new long[(1<<n)][3];
        for(int i=0;i<n;i++){
            dp[(1<<i)][g[i]] = 1;
        }
        long res = 0;
        for(int i=1;i<(1<<n);i++){
            int k = i;
            int sum = 0;
            for(int j=n-1;j>=0;j--){
                if(k>=(1<<j)){
                    k-=(1<<j);
                    sum += d[j];
                }
                else{
                    for(int r=0;r<3;r++) if(r!=g[j]) dp[i+(1<<j)][g[j]] += dp[i][r];
                    dp[i+(1<<j)][g[j]] %= mod;
                }
            }
            if(sum==t){
                res += dp[i][0] +dp[i][1] +dp[i][2];
                res %= mod;
            }
        }
        out.println(res);
        out.flush(); 
    }
}