import java.util.*;
import java.io.*;

public class E74 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(); int m = sc.nextInt();
        String s = sc.next();
        long time = System.currentTimeMillis();
        int [][] a = new int[m][m];
        int [][] pre = new int[m][(1 << m)];
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) continue;
            a[s.charAt(i) - 'a'][s.charAt(i + 1) - 'a']++;
            a[s.charAt(i + 1) - 'a'][s.charAt(i) - 'a']++;
        }
        //System.out.println("Process Input: " + (System.currentTimeMillis() - time));
        for (int i = 0; i < m; i++) {
            int b = 0; int stor = 2;
            for (int j = 1; j < (1 << m); j++) {
                if (j == stor) {
                    b++;
                    stor = (1 << (b + 1));
                }
                pre[i][j] = pre[i][j ^ (1 << b)] + a[i][b];
            }
        }
        //System.out.println("Precomp: " + (System.currentTimeMillis() - time));
        long [] dp = new long[1 << m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 1; mask < (1 << m); mask++) {
            // loop on the last added character in the mask
            for (int i = 0; i < m; i++) {
                if (((mask >> i) & 1) == 0) continue;
                long prev = dp[mask ^ (1 << i)];
                long contribution = (pre[i][mask] - pre[i][((1 << m) - 1) ^ mask]) * Integer.bitCount(mask);
                dp[mask] = Math.min(dp[mask], prev + contribution);
            }
        }
        //System.out.println("Done: " + (System.currentTimeMillis() - time));
        out.println(dp[(1 << m) - 1]);
        out.close();
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        String nextLine() {
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