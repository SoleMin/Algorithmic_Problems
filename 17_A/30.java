import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    int n, k;

    boolean[] prime;
    int[] primes;

    void sieve() {
        prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        int cnt = 0;
        for (int i = 2; i <= n; ++i)
            if (prime[i]) {
                ++cnt;
                for (int j = i + i; j <= n; j += i)
                    prime[j] = false;
            }
        primes = new int[cnt];
        cnt = 0;
        for (int i = 0; i <= n; ++i)
            if (prime[i])
                primes[cnt++] = i;
    }

    void solve() throws IOException {
        n = ni();
        k = ni();
        sieve();
        int cnt = 0;
        for (int i = 2; i <= n; ++i) {
            if (!prime[i])
                continue;
            boolean ok = false;
            for (int j = 0; j < primes.length - 1; ++j)
                if (primes[j] + primes[j + 1] + 1 == i) {
                    ok = true;
                    break;
                }
            if (ok)
                ++cnt;
        }
        if (cnt >= k)
            out.println("YES");

        else
            out.println("NO");
    }

    public Solution() throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    String ns() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int ni() throws IOException {
        return Integer.valueOf(ns());
    }

    long nl() throws IOException {
        return Long.valueOf(ns());
    }

    double nd() throws IOException {
        return Double.valueOf(ns());
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
