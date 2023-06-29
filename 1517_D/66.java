import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class A {

    private static final int INF = (int) 1e9 + 7;

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        PrintWriter pr = new PrintWriter(System.out);
//        int T=fs.nextInt();
//        for (int tt=1; tt<=T; tt++) {
            int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
            int[][] right = new int[n][m -1], down = new int[n - 1][m];
            for(int i = 0; i < n; i++) right[i] = fs.readArray(m - 1);
            for(int i = 0; i < n - 1; i++) down[i] = fs.readArray(m);
            if (k % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) pr.print(-1 + " ");
                    pr.println();
                }
            } else {
                int[][][] dp = new int[k / 2 + 1][n][m];

                for(int r = 1; 2 * r <= k; r++) {
                    for(int i = 0; i < n; i++) Arrays.fill(dp[r][i], INF);
                    for(int i = 0; i < n; i++)
                        for(int j = 0; j  + 1 < m; j++) {
                            int cost = right[i][j];
                            dp[r][i][j] = Integer.min(dp[r][i][j], dp[r - 1][i][j + 1] + cost);
                            dp[r][i][j + 1] = Integer.min(dp[r][i][j + 1], dp[r - 1][i][j] + cost);
                        }
                    for(int i = 0; i + 1 < n; i++)
                        for(int j = 0; j < m; j++) {
                            int cost = down[i][j];
                            dp[r][i][j] = Integer.min(dp[r][i][j], dp[r - 1][i + 1][j] + cost);
                            dp[r][i + 1][j] = Integer.min(dp[r][i + 1][j], dp[r - 1][i][j] + cost);
                        }
                }
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        pr.print(2 * dp[k/2][i][j] + " ");
                    }
                    pr.println();
                }
            }


//        }

        pr.flush();
        pr.close();
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long[] readLongArray(int n) {
            long[] a=new long[n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
