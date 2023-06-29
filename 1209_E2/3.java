import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out, false);
        int t = scanner.nextInt();
        while(t-->0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Col[] cols = new Col[m];
            int[][] mat = new int[m][n];
            for(int i = 0; i < n; i++) {
                for(int j =0; j < m; j++) {
                    mat[j][i] = scanner.nextInt();
                }
            }
            for(int i = 0; i < m; i++) {
                cols[i] = new Col(mat[i]);
            }
            Arrays.sort(cols);
            int maxMask = 1 << n;
            int[] dp = new int[maxMask];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            int sz = Math.min(n, m);
            int[][] ss = new int[sz][maxMask];
            //2^n * n^3
            for(int i = 0; i < sz; i++) {
                int[] curArr = cols[i].arr.clone();
                for(int j = 0; j < n; j++) {
                    for(int mask = 0; mask < maxMask; mask++) {
                        int cur = 0;
                        for(int k = 0; k < n; k++) if ((( 1 << k) & mask) > 0) cur += curArr[k];
                        ss[i][mask] = Math.max(ss[i][mask], cur);
                    }
                    curArr = shift(curArr);
                }
            }
            for(int i = 0; i < Math.min(n, m); i++) {
                for(int mask = maxMask-1; mask>=0; mask--) {
                    for(int smask = mask; smask >= 0; smask = (smask-1)&mask) {
                        if (dp[smask] == -1) continue;
                        dp[mask] = Math.max(dp[mask], dp[smask] + ss[i][mask ^ smask]);
                        if (smask == 0) break;
                    }
                }
            }
            out.println(dp[maxMask-1]);
        }
        out.flush();
    }
    static int[] shift (int[] a) {
        int[] b = new int[a.length];
        b[0] = a[a.length-1];
        for(int i = 0; i < a.length-1; i++) {
            b[i+1] = a[i];
        }
        return b;
    }
    static class Col implements Comparable<Col> {
        int[] arr;
        int[] sorted;
        public Col(int[] a) {
            arr = a;
            sorted= arr.clone();
            Arrays.sort(sorted);
        }
        public int compareTo(Col col) {
            return -sorted[sorted.length-1] + col.sorted[sorted.length-1];
        }
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
