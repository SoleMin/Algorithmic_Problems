import java.io.PrintWriter;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        for (int i = 0; i < t; i++) {
            solve(sc, pw);
        }
        pw.close();
    }
    static void solve(Scanner in, PrintWriter out){
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[][] ri = new int[n][m - 1];
        int[][] dn = new int[n - 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                ri[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                dn[i][j] = in.nextInt();
            }
        }
        long[][][] dp = new long[n][m][k + 1];
        if (k % 2 == 1){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(-1 +" ");
                }
                out.println();
            }
        }else{
            for (int l = 2; l <= k; l += 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        long dm = Long.MAX_VALUE;
                        if (i > 0){
                            int pi = i - 1, pj = j;
                            dm = Math.min(dm, dp[pi][pj][l - 2] + dn[pi][pj] * 2);
                        }
                        if (j > 0){
                            int pi = i ,pj = j - 1;
                            dm = Math.min(dm, dp[pi][pj][l - 2] + ri[pi][pj] * 2);
                        }
                        if (i < n - 1){
                            dm = Math.min(dm, dp[i + 1][j][l - 2] + dn[i][j] * 2);
                        }
                        if (j < m - 1){
                            dm = Math.min(dm, dp[i][j + 1][l - 2] + ri[i][j] * 2);
                        }
                        dp[i][j][l] = dm;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dp[i][j][k] == Long.MAX_VALUE){
                        out.print(-1 +" ");
                    }else{
                        out.print(dp[i][j][k] +" ");
                    }
                }
                out.println();
            }
        }


    }

    static boolean isPrime(long n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }

    public static int[] sieveEratosthenes(int n) {
        if (n <= 32) {
            int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
            for (int i = 0; i < primes.length; i++) {
                if (n < primes[i]) {
                    return Arrays.copyOf(primes, i);
                }
            }
            return primes;
        }

        int u = n + 32;
        double lu = Math.log(u);
        int[] ret = new int[(int) (u / lu + u / lu / lu * 1.5)];
        ret[0] = 2;
        int pos = 1;

        int[] isnp = new int[(n + 1) / 32 / 2 + 1];
        int sup = (n + 1) / 32 / 2 + 1;

        int[] tprimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int tp : tprimes) {
            ret[pos++] = tp;
            int[] ptn = new int[tp];
            for (int i = (tp - 3) / 2; i < tp << 5; i += tp) ptn[i >> 5] |= 1 << (i & 31);
            for (int j = 0; j < sup; j += tp) {
                for (int i = 0; i < tp && i + j < sup; i++) {
                    isnp[j + i] |= ptn[i];
                }
            }
        }

        // 3,5,7
        // 2x+3=n
        int[] magic = {0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4, 13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17, 9, 6, 16, 5, 15, 14};
        int h = n / 2;
        for (int i = 0; i < sup; i++) {
            for (int j = ~isnp[i]; j != 0; j &= j - 1) {
                int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
                int p = 2 * pp + 3;
                if (p > n) break;
                ret[pos++] = p;
                if ((long) p * p > n) continue;
                for (int q = (p * p - 3) / 2; q <= h; q += p) isnp[q >> 5] |= 1 << q;
            }
        }

        return Arrays.copyOf(ret, pos);
    }

    //    reverse division for 2
    public static long[] rdiv2(int n, int mod){
        long[] arr = new long[n + 5];
        arr[0] = 1;
        long rev2 = (mod + 1) / 2;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * rev2 % mod;
        }
        return arr;
    }
    static List<Integer> primeFactors(int n)
    {
        // Print the number of 2s that divide n
        List<Integer> ls = new ArrayList<>();
        if (n % 2 == 0) ls.add(2);
        while (n%2==0)
        {
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            if (n  % i == 0) ls.add(i);
            while (n%i == 0)
            {
                n /= i;
            }
        }
        if (n > 1) ls.add(n);
        return ls;
    }
}
