import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {
    int readInt() {
        int ans = 0;
        boolean neg = false;
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-') {
                    start = true;
                    neg = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    start = true;
                    ans = ans * 10 + c - '0';
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return neg ? -ans : ans;
    }

    final int N = 5010;
    final int M = 1_000_000_007;
    long[][] dp = new long[2][N];
    long[] sums = new long[N];
    char[] p = new char[N];
    Scanner sca = new Scanner(System.in);
    void start() {
        int n = Integer.parseInt(sca.nextLine());
        int idx = 0;
        Arrays.fill(dp[idx], 0);
        dp[idx][0] = 1;
        for (int i = 0; i < n; i++) p[i] = sca.nextLine().charAt(0);
        for (int i = 0; i < n;) {
            int nidx = idx ^ 1;
            Arrays.fill(dp[nidx], 0);
            Arrays.fill(sums, 0);
            int j = i;
            while (p[j] != 's') j++;
            int levels = j - i;
            i = j+1;
            for (j = n; j >= 0; j--) {
                sums[j] = sums[j + 1] + dp[idx][j];
                if (sums[j] >= M) sums[j] -= M;
            }
            for (j = 0; j <= n; j++) {
                int ind = j + levels;
                if (ind > n) continue;
                dp[nidx][ind] = sums[j];
            }
            idx = nidx;
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += dp[idx][i];
            if (ans >= M) ans -=M;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

        new Test().start();

    }
}