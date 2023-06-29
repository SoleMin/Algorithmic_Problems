import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by shirsh.bansal on 07/08/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean graph[][] = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a-1][b-1] = true;
            graph[b-1][a-1] = true;
        }

        if(n <= 2) {
            System.out.println(0);
            return;
        }

        long dp[][] = new long[1<<n][n];

        for (int i = 0; i < (1<<n); i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i < (1<<n); i++) {
            for (int j = 0; j < n; j++) {
                f(i, j, dp, graph, n);
            }
        }

        long sum = 0;

//        for (int i = 7; i < (1 << n); i++) {
//            if(Integer.bitCount(i) < 3) continue;
//            for (int j = 0; j < n; j++) {
//                int startNode = Integer.numberOfTrailingZeros(Integer.highestOneBit(i));
//                int endNode = j;
//
//                if(graph[startNode][endNode] && dp[i][j] != -1) {
////                    System.out.println(i + " " + startNode + " " + endNode + " " + dp[i][j]);
//                    sum += dp[i][j];
//                }
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                if(Integer.bitCount(j) >= 3 && graph[Integer.numberOfTrailingZeros(j)][i]) {
                    sum += dp[j][i];
                }
            }
        }

        System.out.println(sum/2);
    }

    private static long f(int mask, int i, long[][] dp, boolean[][] graph, int n) {
        if(dp[mask][i] != -1) return dp[mask][i];
        if(Integer.bitCount(mask) == 1 && (mask&(1<<i)) != 0) {
            dp[mask][i] = 1;
        } else if(Integer.bitCount(mask) > 1 && (mask&(1<<i)) != 0 && i != Integer.numberOfTrailingZeros(mask)) {
            dp[mask][i] = 0;
            for (int j = 0; j < n; j++) {
                if(graph[i][j]) dp[mask][i] = dp[mask][i] + f(mask^(1<<i), j, dp, graph, n);
            }
        } else {
            dp[mask][i] = 0;
        }

//        int tmpMask = mask ^ (1<<i);
//        for (int j = 0; j <= firstNode; j++) {
//            if(((1<<j)&tmpMask) != 0 && graph[i][j]) {
//                dp[mask][i] += f(tmpMask, j, dp, graph, n, firstNode);
//            }
//        }
//
        return dp[mask][i];
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
