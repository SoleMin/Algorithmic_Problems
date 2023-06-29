import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out, false);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[] str = scanner.next().toCharArray();
        int maxMask = 1 << m;
        long[] dp = new long[maxMask];
        int[][] dists = new int[m][m];
        for(int i = 1; i < n; i++) {
            int c1 = str[i] - 'a';
            int c2 = str[i-1] - 'a';
            dists[c1][c2]++;
            dists[c2][c1]++;
        }
        int[] pre = new int[maxMask];
        for(int mask = 0; mask < maxMask; mask++) {
            for(int i = 0; i < m; i++) {
                if (((1 << i) & mask) == 0) continue;
                for(int j = 0; j < m; j++) {
                    if (((1 << j) & mask) > 0) continue;
                    pre[mask] += dists[i][j];
                }
            }
        }
        Arrays.fill(dp, Long.MAX_VALUE/4);
        dp[0] = 0;
        for(int mask = 0; mask < maxMask; mask++) {
            if (dp[mask] == Long.MAX_VALUE/4) continue;
            for(int i = 0; i < m; i++) {
                if (((1 << i) & mask) > 0) continue;
                int nmask = mask | (1 << i);
                dp[nmask] = Math.min(dp[nmask], dp[mask] + pre[nmask]);
            }
        }
        out.println(dp[maxMask - 1]);
        out.flush();
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
    }
}
