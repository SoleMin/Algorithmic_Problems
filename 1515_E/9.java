//package com.company.cf.global14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E {
    FastScanner in;
    PrintWriter out;
    private int M;

    public static void main(String[] args) {
        new E().solve();
    }

    private void solve() {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solveCase();

        out.close();
    }

    long[][] comb = new long[512][512];
    private void solveCase() {
        int n = in.nextInt();
        this.M = in.nextInt();

        calcComb(n, M);
        for (int i = 0; i < 512; i++) {
            for (int j = 0; j < 512; j++) {
                memoDivide[i][j] = -1;
                memoDP[i][j] = -1;
                dpG[i] = -1;
            }
        }

        long res = g(n);
        for (int i = 1;i <= n - 1; i++) {
            res = (res + dp(n, i)) % M;
        }

        out.println(res);
    }

    long[] dpG = new long[512];
    private long g(int n) {
        if (n < 2) return 1;
        if (n == 2) return 2;
        if (dpG[n] != -1) return dpG[n];

        long res = 0;
        for (int divide = 0; divide < n; divide++) {
            res = (res + divider(divide, n - divide - 1)) % M;
        }
        return (dpG[n] = res);
    }

    long[][] memoDivide = new long[512][512];
    private long divider(int a, int b) {
        if (a == 0 || b == 0) return 1;
        if (memoDivide[a][b] != -1) return memoDivide[a][b];
        return (memoDivide[a][b] = ((divider(a - 1, b) + divider(a, b - 1)) % M));
    }

    long[][] memoDP = new long[512][512];
    private long dp(int n, int i) {
        if (n > 0 && i == 0) return 0;
        if (n == 0 && i > 0) return 0;
        if (i > n) return 0;
        if (n == 0 && i == 0) return 1;
        if (i == n) return g(n);
        if (i <= 1) return 0;
//        if (n == 1 && i != 1) return 0;
//        if (n == 2 && i == 1) return 0;
        if (memoDP[n][i] != -1) return memoDP[n][i];

//        long res = (i * dp(n - 2, i - 1)) % M;
        long res = 0;
        for (int failure = 1; failure < n - 1 && i - failure >= 1; failure++) {
            res += ((g(failure) * comb[i][failure]) % M) * dp(n - failure - 1, i - failure);
            res %= M;
        }
        return (memoDP[n][i] = res);
    }

    private void calcComb(int n, int m) {
        for (int i = 0; i < 512; i++) {
            comb[0][i] = 0;
        }
        for (int i = 0; i < 512; i++) {
            comb[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % m;
            }
        }
    }


    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

}
