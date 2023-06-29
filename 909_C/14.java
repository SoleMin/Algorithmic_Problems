
/**
 * @author: Mehul Raheja
 */
import java.util.*;
import java.io.*;

public class indent {

    /*
        Runtime = O()
     */
    static int N, M, K;
    static String s;
    static StringTokenizer st;
    static int[] d;

    static long MOD = (int)1e9 + 7;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] d = new char[N];
        for (int i = 0; i < N; i++) {
            d[i] = br.readLine().charAt(0);
        }

        long[][] dp = new long[N][N];
        boolean det = d[0] == 'f';
        //Arrays.fill(dp[0], 1);
        dp[0][0] = 1;
        
        for (int i = 1; i < N; i++) {
           // System.out.println(Arrays.toString(dp[i-1]));
            long sum = 0;

            for (int j = 0; j < N; j++) {
                sum = (dp[i - 1][j]%MOD + sum%MOD + MOD) % MOD;
            }
            
           // System.out.println(sum);

            if (d[i] == 'f') {
                if(det){
                    for (int j = 1; j < N; j++) {
                        dp[i][j] = dp[i-1][j-1]%MOD;
                    }
                    continue;
                }
                
                for (int j = 0; j < N; j++) {
                    dp[i][j] = sum%MOD;
                    sum -= dp[i - 1][j]%MOD;

                }
                det = true;
                
                //System.out.println(Arrays.toString(dp[i]));
            } else if (d[i] == 's') {
               // System.out.println("HERE1" + det);
                
                if(det){
                    //System.out.println("HERE2");
                    det = false;
                    for (int j = 1; j < N; j++) {
                        dp[i][j] = dp[i-1][j-1]%MOD;
                    }
                   //System.out.println("HERE " + Arrays.toString(dp[i]));
                    continue;
                }
                
                //System.out.println("HERE3" + sum);
                for (int j = 0; j < N; j++) {
                    dp[i][j] = sum%MOD;

                    sum = ((sum - dp[i - 1][j])%MOD + MOD)%MOD;

                }
                
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        //System.out.println(Arrays.toString(dp[dp.length-1]));
        
        long ans = 0;
        for (long e: dp[dp.length-1]) {
            ans = (ans + e + MOD) % MOD;
        }
        System.out.println(ans);

//        boolean det = false;
//        int maxlayer = 1;
//        long ans = 1;
//        for (int i = 0; i < N; i++) {
//            if (d[i] == 'f') {
//                if (!det) {
//                    //System.out.println("HERE" + maxlayer);
//                    ans = ans * maxlayer;
//                }
//                det = true;
//                maxlayer++;
//                //System.out.println("HERE");
//            } else if (d[i] == 's') {
//                if (det) {
//                    det = false;
//                    continue;
//                }
//                det = false;
//                System.out.println(maxlayer);
//                ans = ans * maxlayer;
//            }
//        }
//
//        System.out.println(ans);
    }
}
