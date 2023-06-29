import java.io.*;
import java.util.*;

public class E2 {
    static ArrayList<Integer> primes;
    static int[] mind;
    final static int MAXA = (int) 1e7;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int t = Integer.parseInt(st.nextToken());
        primes = new ArrayList<>();
        mind = new int[MAXA + 1];
        for (int i = 2; i <= MAXA; i++) {
            if (mind[i] == 0) {
                primes.add(i);
                mind[i] = i;
            }
            for (int x : primes) {
                if (x > mind[i] || x * i > MAXA) break;
                mind[x * i] = x;
            }
        }
        int[] count = new int[MAXA + 1];
        for (int on8y = 0; on8y < t; on8y++) {
            st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            Arrays.fill(a, 1);
            st = new StringTokenizer(f.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                int cnt = 0;
                int last = 0;
                while (x > 1) {
                    int p = mind[x];
                    if (last == p) cnt++;
                    else {
                        if (cnt % 2 == 1) a[i] *= last;
                        last = p;
                        cnt = 1;
                    }
                    x /= p;
                }
                if (cnt % 2 == 1) a[i] *= last;
            }
            int[][] mnleft = new int[n][k + 1];
            for (int j = 0; j < k + 1; j++) {
                int l = n;
                int now = 0;
                for (int i = n - 1; i >= 0; i--) {
                    while (l - 1 >= 0 && now + ((count[a[l - 1]] > 0) ? 1 : 0) <= j) {
                        l--;
                        now += (count[a[l]] > 0) ? 1 : 0;
                        count[a[l]]++;
                    }
                    mnleft[i][j] = l;
                    if (count[a[i]] > 1) now--;
                    count[a[i]]--;
                }
            }
            int[][] dp = new int[n + 1][k + 1];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(dp[i], (int) 1e9 + 1);
            }
            for (int i = 0; i < k + 1; i++) dp[0][i] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    if (j > 0) dp[i][j] = dp[i][j - 1];
                    for (int lst = 0; lst <= j; lst++) {
                        dp[i][j] = Math.min(dp[i][j], dp[mnleft[i - 1][lst]][j - lst] + 1);
                    }
                }
            }
            int ans = (int) 1e9 + 1;
            for (int c : dp[n]) ans = Math.min(ans, c);
            System.out.println(ans);

        }
    }
}


