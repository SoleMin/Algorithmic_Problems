
/**
 * Created by IntelliJ IDEA.
 * User: aircube
 * Date: 11.01.11
 * Time: 4:14
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Exchanger;


public class Template {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Template().run();
    }

    void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = null;
        out = new PrintWriter(System.out);
        solve();
        br.close();
        out.close();
    }
    double dm[];
    double a[][];
    boolean fil[];
    int p[];
    int n;
    // x & (x - 1)
    // 10
    //
    void solve() throws  IOException {
        n = nextInt();
        a = new double[n][n];
        for(int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                a[i][j] = nextDouble();
            }
        dm = new double[1 << n];
        dm[(1 << n) - 1] = 1;
        for(int mask = (1 << n) - 1; mask >= 1; --mask) {
            int c = Integer.bitCount(mask);
            if (c == 1) continue ;
            double p = 2.0 / (double)(c - 1) / (double) c;
            for(int i = 0; i < n; ++i) {
                for (int j =0 ; j < n; ++j) {
                    if (i != j && (mask & (1 << i)) > 0 && (mask & (1 << j)) > 0) {
                        dm[mask ^ (1 << j)] += a[i][j] * dm[mask] * p;
                    }
                }
            }
        }
        for(int i = 0; i < n; ++i) {
            out.print(dm[1 << i] + " ");
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
}