
import java.util.Arrays;
import java.util.Scanner;

public class e1515 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        solve(s.nextInt(), s.nextLong());
    }


    public static long inv(long n, long mod) {
        if (n == 1) return 1;
        return (inv(mod % n, mod) * (mod - mod / n)) % mod;
    }

    public static void solve(int n, long mod) {
        long fact[] = new long[n + 2];
        long invFact[] = new long[n + 2];
        long twoPow[] = new long[n + 2];

        fact[0] = 1;
        invFact[0] = 1;
        twoPow[0] = 1;

        for (int i = 1; i < n + 2; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
            invFact[i] = (invFact[i - 1] * inv(i, mod)) % mod;
            twoPow[i] = (2 * twoPow[i - 1]) % mod;
        }

        long dp[][] = new long[n + 2][];
        dp[0] = new long[]{1};

        long next[] = null;
        for (int i = 1; i <= n + 1; i++) {
            next = new long[i + 1];

            for (int j = 0; j < i - 1; j++) {
                for (int k = 0; k < dp[j].length; k++) {
                    next[k + i - j - 1] = (next[k + i - j - 1] + ((((dp[j][k] * twoPow[i - j - 2]) % mod * fact[k + i - j - 1]) % mod * invFact[k]) % mod * invFact[i - j - 1]) % mod) % mod;
                }
            }

            dp[i] = next;
        }

        long sum = 0;
        for (int i = 0; i < next.length; i++) {
            sum = (sum + next[i]) % mod;
        }

        System.out.println(sum);
    }
}
