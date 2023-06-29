/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author is2ac
 */
public class D_CF {

    static Integer[][] dp;

    public static void main(String[] args) {
        FastScanner58 fs = new FastScanner58();
        PrintWriter pw = new PrintWriter(System.out);
        //int t = fs.ni();
        int t = 1;
        // for (int tc = 0; tc < t; tc++) {
        for (int tc = 0; tc < t; tc++) {
            int n = fs.ni();
            long k = fs.nl();
            long[] a = fs.longArray(n);
            List<Map<Long, Integer>> list = new ArrayList();
            for (int i = 0; i <= 10; i++) {
                Map<Long, Integer> temp = new HashMap();
                list.add(temp);
            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                long x = a[i] % k;
                for (int j = 1; j <= 10; j++) {
                    x *= 10L;
                    x %= k;
                    if (x == 0) {
                        if (list.get(j).containsKey(0L)) res += list.get(j).get(0L);
                    } else {
                        if (list.get(j).containsKey(k-x)) res += list.get(j).get(k - x);
                    }
                }
                int l = (a[i] + "").length();
                list.get(l).put(a[i] % k, list.get(l).getOrDefault(a[i] % k, 0) + 1);
            }
            list = new ArrayList();
            for (int i = 0; i <= 10; i++) {
                Map<Long, Integer> temp = new HashMap();
                list.add(temp);
            }
            for (int i = n - 1; i > -1; i--) {
                long x = a[i] % k;
                for (int j = 1; j <= 10; j++) {
                    x *= 10L;
                    x %= k;
                    if (x == 0) {
                        if (list.get(j).containsKey(0L)) res += list.get(j).get(0L);
                    } else {
                        if (list.get(j).containsKey(k-x)) res += list.get(j).get(k - x);
                    }
                }
                int l = (a[i] + "").length();
                list.get(l).put(a[i] % k, list.get(l).getOrDefault(a[i] % k, 0) + 1);
            }
            pw.println(res);
        }
        pw.close();
    }
}

class UnionFind18 {

    int[] id;

    public UnionFind18(int size) {
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
