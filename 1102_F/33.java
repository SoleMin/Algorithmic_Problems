import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
public class F {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] maxDist = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(maxDist[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < M; i++) {
            for(int  j = 0; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    maxDist[j][k] = Math.min(maxDist[j][k], Math.abs(matrix[k][i] - matrix[j][i]));
                    maxDist[k][j] = maxDist[j][k];
                }
            }
        }
        int[][] distTop = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(distTop[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < M-1; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    distTop[j][k] = Math.min(distTop[j][k], Math.abs(matrix[j][i] - matrix[k][i+1]));
                }
            }
        }
        if (N == 1) {
            System.out.println(distTop[0][0]);
            System.exit(0);
        }
        int[] bitLoc = new int[1<<N];
        for(int i = 0; i < N; i++) {
            bitLoc[1 << i] = i;
        }
        int[][][] dp = new int[1<<N][N][N];
        //iterate over every row
        for(int mask = 1; mask < (1 << N); mask++) {
            for(int smask = mask; smask > 0; smask &= (smask-1)) {
                int i = bitLoc[Integer.lowestOneBit(smask)];
                for (int ss = mask ^ 1 << i; ss > 0; ss &= ss - 1) {
                    int j = bitLoc[Integer.lowestOneBit(ss)];
                    if (mask == (1 << i ^ 1 << j))
                        dp[mask][i][j] = maxDist[i][j];
                    else {
                        int x = 0;
                        for (int sss = mask ^ 1 << i ^ 1 << j; sss > 0; sss &= sss - 1) {
                            int k = bitLoc[sss & -sss];
                            x = Math.max(x, Math.min(dp[mask ^ 1 << j][i][k], maxDist[k][j]));
                        }
                        dp[mask][i][j] = x;
                    }
                }
            }
        }
        int mxMsk = (1 << N) -1;
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (i==j) continue;
                max = Math.max(max, Math.min(dp[mxMsk][i][j], distTop[i][j]));
            }
        }
        System.out.println(max);
    }
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        public FastScanner() {
            this(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }
}
