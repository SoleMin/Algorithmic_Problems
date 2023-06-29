
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Trung Pham
 */
public class E {

    public static double[] dp;
    public static double[][] data;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        n = in.nextInt();
        data = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = in.nextDouble();
            }
        }
        dp = new double[1 << n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            int a = 1 << i;
            out.print(cal(a) + " ");
        }
        out.close();
        //System.out.print(builder.toString());
    }

    public static double cal(int mask) {
        if (mask == (1 << n) - 1) {
            //  System.out.println(mask);
            return 1;
        }
        if (dp[mask] != -1) {
            return dp[mask];
        }
        double result = 0;
        int c = 0;       
        for (int i = 0; i < n; i++) {
            int a = 1 << i;
            if ((a & mask) != 0) {
                c++;
                for (int j = 0; j < n; j++) {
                    int b = 1 << j;
                    if ((b & mask) == 0) {
                        result += (data[i][j] * cal(mask | b));
                    }
                }
            }
        }
    
        int nC2 = (c + 1) * c / 2;
        dp[mask] = result / nC2;
        return dp[mask];
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
