import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
static double p[][];
    static double dp[];
    static int n;
 
    public static int BitCount(int u) {
        int uCount;
 
        uCount = u - ((u >> 1) & 033333333333) - ((u >> 2) & 011111111111);
        return ((uCount + (uCount >> 3)) & 030707070707) % 63;
    }
 
    public static double f(int mask) {
        if (dp[mask] > -0.5)
            return dp[mask];
 
        dp[mask] = 0;
 
        int ones = BitCount(mask);
        double pairs = (((ones * (ones + 1))) >> 1);
        //System.out.println(pairs);
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << i)) != 0 && (mask & (1 << j)) == 0)
                    dp[mask] += f(mask | (1 << j)) * p[i][j] / pairs;
            }
        }
 
        return dp[mask];
    }
 
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        p = new double[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                p[i][j] = Double.parseDouble(st.nextToken());
            }
        }
 
        dp = new double[1 << n];
 
        Arrays.fill(dp, -1.0);
 
        dp[(1 << n) - 1] = 1.;
 
        for (int i = 0; i < n - 1; i++) {
            System.out.print(f(1 << i) + " ");
        }
 
        System.out.println(f((1 << (n - 1))));
 
    }
}