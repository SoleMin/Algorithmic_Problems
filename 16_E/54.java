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
        fil = new boolean[1 << n];
        for(int i = 0; i < n; ++i) {
            out.print(brute((1 << i)) + " ");
        }
    }

    private double brute(int mask) {
        if (Integer.bitCount(mask) == n) return 1;
        if (fil[mask]) return dm[mask];
        int c = Integer.bitCount(mask);
        double res = 0;
        double p = 2.0 / (double) (c + 1) / (double)(c ) ;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if ((mask & (1 << i)) == 0 && (mask & (1 << j)) > 0) {
                    res += a[j][i] * brute(mask ^ (1 << i));
                }
            }
        }
        res *= p;
        dm[mask] = res;
        fil[mask] = true;
        return dm[mask];
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