import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
    @author KhanhNguyenn
 */
 
public class C{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    // sub-problem: 2 orders to merge together x1,x2,..,xn and y1,y2,..,ym
    // Dựa vào bài toán chia kẹp Euler, ta chứng minh dc số cách merge là
    // (m+n)C(m-1)=(m+n)C(n+1)
    static class Task{
        int M;
        public void solve(InputReader in, PrintWriter out) {
            int n= in.nextInt(); M= in.nextInt();
            if(n<=1){
                out.println(n);
                return;
            }

            // calculate nCk
            // nCk= (n-1)C(k-1)+ (n-1)Ck
            int[][] Ckn= new int[n+1][n+1];
            for(int i=0;i<=n;i++){
                Ckn[i][i]=1; Ckn[0][i]=1;
                for(int j=i-1;j>=1;j--){
                    Ckn[j][i]= add(Ckn[j-1][i-1],Ckn[j][i-1]);
                }
            }

            int ans=0;
            int[][] dp= new int[n+1][n+1];
            dp[1][1]=1;
            //dp[i][j]: number of ways to turn on first i , using j manually
            for(int i=2;i<=n;i++){
                dp[i][i]= mul(2,dp[i-1][i-1]);
                for(int j=1;j<=i-1;j++){
                    for(int k=1;k<=j;k++){
                            dp[i][j]= add(dp[i][j],mul(mul(dp[k][k],dp[i-k-1][j-k]),Ckn[k][j])); 
                    }
                }
            }
            for(int i=0;i<=n;i++) ans= add(ans,dp[n][i]);
            out.println(ans);
        }

        public int add(int a, int b){
            a+=b;
            if(a>=M) a-=M;
            return a;
        }

        public int mul(int a, int b){
            long res= (long)a*(long)b;
            res %=M;
            return (int)res;
        }
        

    }
    static class Pair {
        public String x;
        public int y;
        public Pair(String x, int y){
            this.x = x;
            this.y=y;
        }
 
        // @Override
        // public int compareTo(Pair o) {
        //     if (this.x > o.x){
        //         return 1;
        //     }
        //     else if (this.x < o.x){
        //         return -1;
        //     }
        //     else{
        //         return Integer.compare(this.y, o.y);
        //     }
        // }
    }
    // fast input reader class;
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
 
        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }
 
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public double nextDouble(){
            return Double.parseDouble(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}