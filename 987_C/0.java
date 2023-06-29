import java.util.Scanner;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;

public class Main {
    public static final long mod = 998244353;
    public static final int N = 20000 + 7;

    public static long qpow(long x, long n) {
        x %= mod;
        if (x == 1)
            return 1;
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1)
                ans = (ans * x) % mod;
            x = x * x % mod;
            n /= 2;
        }
        return ans % mod;
    }

    public static long get_inv(long x) {
        return qpow(x, mod - 2);
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long[] s = new long[3005];
        long[] c = new long[3005];
        int n = stdin.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = stdin.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            c[i] = stdin.nextLong();
        }
        boolean flag = false;
        long ans = mod * 10000;
        for (int j = 1; j <= n; j++) {
            long Min1 = mod, Min2 = mod;
            for (int i = 1; i <= j - 1; i++) {
                if (s[i] < s[j]) {
                    Min1 = Math.min(Min1, c[i]);
                }
            }
            for (int k = j + 1; k <= n; k++) {
                if (s[j] < s[k]) {
                    Min2 = Math.min(Min2, c[k]);
                }
            }
            if (Min1 != mod && Min2 != mod) {
                flag = true;
                ans = Math.min(ans, c[j] + Min1 + Min2);
            }
        }
        System.out.println((flag == true) ? ans : "-1");
        stdin.close();
    }
}
 		  	 	 								  	 	 	   		