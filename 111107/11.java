import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken()) +8;
            int n = Integer.parseInt(st.nextToken());
            int[] tmp = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tmp);
            int[] len = new int[n+1];
            for(int i=1; i<n+1; i++) {
                len[i] = tmp[n - i];
            }
//            System.out.println(Arrays.toString(len));




            int[][] dp = new int[n+1][k+1];
            for(int i=1; i<n+1; i++){
                for(int j=1; j<k+1; j++){
                    dp[i][j] = (int)1e9;
                }
            }

            for(int i=1; i<k+1; i++){
                for(int j=3*i; j<n+1; j++){
                    dp[j][i] = Math.min(dp[j-1][i], dp[j-2][i-1] + dif(len[j-1], len[j]));
                }
            }

            System.out.println(dp[n][k]);







        }




    }
    public static int dif(int n1, int n2){
        return (int)Math.pow(n1-n2, 2);
    }
}