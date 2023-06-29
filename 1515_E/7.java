//https://github.com/EgorKulikov/yaal/tree/master/lib/main/net/egork
        
import java.util.*;
import java.io.*;
public class B{
    static PrintWriter out;
    static InputReader in;
    public static void main(String args[]){
        out = new PrintWriter(System.out);
        in = new InputReader();
        new B();
        out.flush(); out.close();
    }   
    B(){
        solve();
    }
    class pair{
        int F, S;
        pair(int a, int b){
            F = a; S = b;
        }
    }
    void solve(){
        int n = in.nextInt(), mod = in.nextInt();
        long dp[][] = new long[n + 1][n + 1];
        long ncr[][] = new long[810][410];
        ncr[0][0] = 1;
        for(int i = 1; i < 810; i++){
            for(int j = 0; j < 410; j++){
                ncr[i][j] = (ncr[i - 1][j] + (j > 0 ? ncr[i - 1][j - 1] : 0)) % mod;
            }
        }
        for(int i = 1; i <= n; i++)dp[i][i] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 1; j + i <= n; j++){
                int end = i + j;
                dp[j][end] = (dp[j + 1][end] + dp[j][end - 1]) % mod;
            }
        }
        long value[] = new long[n + 1];
        for(int i = 1; i <= n; i++){
            value[i] = dp[1][i];
        }
        long fdp[][] = new long[n + 2][n + 2];
        fdp[0][0] = 1;
        long ans = 0;
        for(int b = 1; b <= (n + 1) / 2; b++){
            for(int i = 1; i <= n; i++){
                for(int k = Math.max(0, b - 2); k < i; k++){
                    fdp[i + 1][b] = (fdp[i + 1][b] + fdp[k][b - 1] * value[i - k] % mod * ncr[k - b + 2 + i - k - 1][i - k] % mod) % mod;
                }
            }
            ans = (ans + fdp[n + 1][b]) % mod;
        }
        out.print(ans);
    }
    public static class InputReader{
        BufferedReader br;
        StringTokenizer st;
        InputReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){}
            }
            return st.nextToken();
        }
    }
}
	