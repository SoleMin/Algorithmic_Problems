/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author is2ac
 */
public class D_CF {

    public static void main(String[] args) {
        FastScanner58 fs = new FastScanner58();
        PrintWriter pw = new PrintWriter(System.out);
        //int t = fs.ni();
        int t = 1;
        // for (int tc = 0; tc < t; tc++) {
        for (int tc = 0; tc < t; tc++) {
            int n = fs.ni();
            int m = fs.ni();
            int k = fs.ni();
            int[][] a = new int[n][m - 1];
            int[][] b = new int[n - 1][m];
            for (int i = 0; i < n; i++) {
                a[i] = fs.intArray(m - 1);
            }
            for (int i = 0; i < n - 1; i++) {
                b[i] = fs.intArray(m);
            }
            int[][] res = new int[n][m];
            Integer[][][] dp = new Integer[n][m][k / 2 + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res[i][j] = recur(i, j, k / 2, dp, a, b) * 2;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < m; j++) {
                    //matrix[i][j]++;
                    if (k%2==1) {
                        sb.append(-1 + " ");
                    } else {
                        sb.append(res[i][j] + " ");
                    }
                }
                sb.append("\n");
            }
            pw.println(sb);
        }
        pw.close();
    }

    public static int recur(int i, int j, int k, Integer[][][] dp, int[][] a, int[][] b) {
        if (k == 0) {
            return 0;
        }
        int n = (int) (1e9);
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        if (i != 0) {
            n = Math.min(n, recur(i - 1, j, k - 1, dp, a, b) + b[i - 1][j]);
        }
        if (j != 0) {
            n = Math.min(n, recur(i, j - 1, k - 1, dp, a, b) + a[i][j - 1]);
        }
        if (i != a.length - 1) {
            n = Math.min(n, recur(i + 1, j, k - 1, dp, a, b) + b[i][j]);
        }
        if (j != b[0].length - 1) {
            n = Math.min(n, recur(i, j + 1, k - 1, dp, a, b) + a[i][j]);
        }
        return dp[i][j][k] = n;
    }
}

class FastScanner58 {

    BufferedReader br;
    StringTokenizer st;

    public FastScanner58() {
        br = new BufferedReader(new InputStreamReader(System.in), 32768);
        st = null;
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

    int ni() {
        return Integer.parseInt(next());
    }

    int[] intArray(int N) {
        int[] ret = new int[N];
        for (int i = 0; i < N; i++) {
            ret[i] = ni();
        }
        return ret;
    }

    long nl() {
        return Long.parseLong(next());
    }

    long[] longArray(int N) {
        long[] ret = new long[N];
        for (int i = 0; i < N; i++) {
            ret[i] = nl();
        }
        return ret;
    }

    double nd() {
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

class UnionFind17 {

    int[] id;

    public UnionFind17(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public void union(int p, int q) {
        int a = find(p), b = find(q);
        if (a == b) {
            return;
        }
        id[b] = a;
    }
}
