import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class C {

    static int MOD = 1_000_000_007;

    public static void main(String[] args) {

        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        char prev = ' ';

        // index, maxNumOfIntents -> count
        int[][] dp = new int[n+1][n+2];

        dp[0][0] = 1;
        for(int i=0;i<n;++i){
            char ch = in.next().charAt(0);
            if(prev == 's'){
                int sum = 0;
                for(int j=n;j>=0;--j){
                    sum = (sum + dp[i-1][j]) % MOD;
                    dp[i][j] = sum;
                }
            }else if(prev == 'f'){
                for(int j=0;j<n;++j){
                    dp[i][j+1] = dp[i-1][j];
                }
            }

            prev = ch;
        }

        int result = 0;
        for(int i=0;i<=n;++i){
            result = (result + dp[n-1][i]) % MOD;
        }


        out.println(result);
        out.close();

    }


    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    // --------------------------------------------------------

}