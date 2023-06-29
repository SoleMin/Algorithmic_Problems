import java.io.*;
import java.math.*;         /* Author : Life Lover */
import java.util.*;

public class Main {

    static FastReader in;
    static PrintWriter o;

    public static void solve() {
        int q = in.nextInt();
        char[] temp1 = new char[(int) 2e5 + 3];
        char[] temp2 = new char[(int) 2e5 + 3];
        char[] temp3 = new char[(int) 2e5 + 3];
        for (int i = 0; i < (int) 2e5 + 3; i++) {
            if (i % 3 == 0) temp1[i] = 'R';
            if (i % 3 == 1) temp1[i] = 'G';
            if (i % 3 == 2) temp1[i] = 'B';
            if (i % 3 == 0) temp2[i] = 'G';
            if (i % 3 == 1) temp2[i] = 'B';
            if (i % 3 == 2) temp2[i] = 'R';
            if (i % 3 == 0) temp3[i] = 'B';
            if (i % 3 == 1) temp3[i] = 'R';
            if (i % 3 == 2) temp3[i] = 'G';
        }

        while (q-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String str = in.next();

            int[] dp1 = new int[n];
            int[] dp2 = new int[n];
            int[] dp3 = new int[n];
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) != temp1[i]) dp1[i]++;
                if (str.charAt(i) != temp2[i]) dp2[i]++;
                if (str.charAt(i) != temp3[i]) dp3[i]++;
            }
            for (int i = 1; i < n; i++) {
                dp1[i] += dp1[i-1];
                dp2[i] += dp2[i-1];
                dp3[i] += dp3[i-1];
            }
//            for (int i = 0; i < n; i++) {
//                o.println(dp1[i] + " " + dp2[i] + " " + dp3[i]);
//            }
//            o.println(dp1[k-1] + " " + dp2[k-1] + " " + dp3[k-1]);
            int ans = Math.min(dp1[k-1], Math.min(dp2[k-1], dp3[k-1]));
            for (int i = k; i < n; i++) {
              //  o.println(dp1[i-k] + " " + dp2[i-k] + " " + dp3[i-k]);
                ans = Math.min(ans, dp1[i] - dp1[i-k]);
                ans = Math.min(ans, dp2[i] -  dp2[i-k]);
                ans = Math.min(ans, dp3[i] - dp3[i-k]);
            }
            o.println(ans);
        }
        o.close();
        return;
    }

    public static void main(String[] args) {
        in = new FastReader();
        o = new PrintWriter(System.out);
        solve();
        return;
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
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