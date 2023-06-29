import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int REM = 1000000007;
    private static int dig;
    private static int[][][] dp = new int[701][701][2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String X = in.next();
        int N = X.length();

        int[] P = new int[701];
        P[0] = 1;
        for (int i=1; i<P.length; ++i) {
            P[i] = (int)((long)P[i-1] * 10 % REM);
        }

        int ans = 0;
        for (int d=1; d<=9; ++d) { //at least d
            dig = d;

            for (int[][] array2 : dp) {
                for (int[] array1 : array2) {
                    Arrays.fill(array1, -1);
                }
            }

            for (int c=1; c<=N; ++c) { //exact count of at least d
                for (int k=0; k<c; ++k) {
                    ans = (int)((ans + (long)f(0, c, false, X) * P[k]) % REM);
                }
            }
        }
        System.out.println(ans);
    }

    private static int f(int ps, int needed, boolean less, final String X) {
        if (needed < 0) {return 0;}
        if (dp[ps][needed][less?0:1] != -1) {return dp[ps][needed][less?0:1];}
        if (ps == X.length()) {
            if (needed == 0) {return 1;}
            return 0;
        }
        int dg = X.charAt(ps)-'0';

        int ans = 0;
        for (int d=0; d<=9; ++d) {
            if (!less && d>dg) {continue;}

            boolean nless = less || d < dg;
            ans = (int)((ans + (long)f(ps+1, needed-(d>=dig?1:0), nless, X)) % REM);
        }

        dp[ps][needed][less?0:1] = ans;
        return ans;
    }
}
