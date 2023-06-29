import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class A {
    static MyScanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws Throwable {
        sc = new MyScanner();
        pw = new PrintWriter(System.out);

        n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        val = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(val[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++)
                    val[i][j] = val[j][i] = Math.min(val[i][j], Math.abs(a[i][k] - a[j][k]));
            }

        val2 = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(val2[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m - 1; k++)
                    val2[i][j] = Math.min(val2[i][j], Math.abs(a[i][k] - a[j][k + 1]));
            }
        mem = new Integer[n][n][1 << n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp(i, i, 1 << i));
        }
        if (n == 1)
            pw.println(val2[0][0]);
        else
            pw.println(ans);


        pw.flush();
        pw.close();
    }

    static int n;
    static int[][] val, val2;
    static Integer[][][] mem;

    static int dp(int st, int lst, int msk) {
        int bits = Integer.bitCount(msk);
        if (mem[st][lst][msk] != null)
            return mem[st][lst][msk];
        int ans = 0;
        for (int i = 0; i < n; i++)
            if ((msk & (1 << i)) == 0) {
                int newMsk = (msk | (1 << i));
                if (bits < n - 1)
                    ans = Math.max(ans, Math.min(val[lst][i], dp(st, i, newMsk)));
                else
                    ans = Math.max(ans, Math.min(val[lst][i], val2[i][st]));
            }
        return mem[st][lst][msk] = ans;
    }

    static class MyScanner {
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