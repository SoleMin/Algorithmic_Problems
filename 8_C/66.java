import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");
    
    int INF = Integer.MAX_VALUE >> 1;
    
    void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        
        /* Input */
        int x0 = nextInt();
        int y0 = nextInt();
        int N = nextInt();
        int FULL_MASK = (1 << N) - 1;
        int[] xs = new int [N];
        int[] ys = new int [N];
        for (int i = 0; i < N; i++) {
            xs[i] = nextInt();
            ys[i] = nextInt();
        }
        
        /* Precalc */
        int[][] dist = new int [N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dist[i][j] = dist(x0, y0, xs[i], ys[i]) + dist(xs[i], ys[i], xs[j], ys[j]) + dist(xs[j], ys[j], x0, y0);
        
        /* DP */
        int[] dp = new int [1 << N];
        int[] pr = new int [1 << N];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int mask = 0; mask < FULL_MASK; mask++) {
            int i = Integer.numberOfTrailingZeros(~mask); // hack: use first non-zero bit
            int imask = mask | (1 << i);
            for (int j = i; j < N; j++) {
                int jmask = mask | (1 << j);
                if (jmask == mask) continue;
                int ijmask = imask | jmask;
                int nval = dp[mask] + dist[i][j];
                if (dp[ijmask] > nval) {
                    dp[ijmask] = nval;
                    pr[ijmask] = mask;
                }
            }
        }
        
        /* Output */
        out.println(dp[FULL_MASK]);
        out.print("0");
        for (int mask = FULL_MASK; mask != 0; mask = pr[mask]) {
            int diff = mask ^ pr[mask];
            int i = Integer.numberOfTrailingZeros(diff);
            diff &= ~(1 << i);
            int j = Integer.numberOfTrailingZeros(diff);
            if (i != 32) out.print(" " + (i + 1));
            if (j != 32) out.print(" " + (j + 1));
            out.print(" 0");
        }
        out.println();
        out.close();
    }
    
    /*************************************************************** 
     * Utility
     **************************************************************/
    int dist(int x1, int y1, int x2, int y2) {
        return sqr(x2 - x1) + sqr(y2 - y1);
    }

    int sqr(int x) {
        return x * x;
    }

    /*************************************************************** 
     * Input 
     **************************************************************/
    String nextToken() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
    
    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}
