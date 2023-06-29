/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author is2ac
 */
public class D_CF {

    public static void main(String[] args) throws IOException {
        FastScanner58 fs = new FastScanner58();
        //Reader fs = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        //int t = fs.ni();
        int t = 1;
        for (int tc = 0; tc < t; tc++) {
            int n = fs.ni();
            int m = fs.ni();
            long k = fs.nl();
            long[] a = fs.longArray(n);
            long res = 0;
            Long[] dp = new Long[n];
            for (int i = 0; i < n; i++) {
                res = Math.max(res,recur(i,a,m,k,dp));
            }
            pw.println(res);
        }
        pw.close();
    }

    public static long recur(int ind, long[] a, int m, long k, Long[] dp) {
        if (ind==a.length) return 0;
        long n = 0;
        if (dp[ind]!=null) return dp[ind];
        long s = 0;
        for (int i = 0; i < m && ind+i<a.length; i++) {
            s += a[ind+i];
            n = Math.max(n,recur(ind+i+1,a,m,k,dp)+s-k);
        }
        return dp[ind] = n;
    }

    public static int sum(int ind, List<List<Integer>> list, Map<Integer, Integer> size) {
        if (size.containsKey(ind)) {
            return size.get(ind);
        }
        int s = 1;
        Collections.sort(list.get(ind));
        for (int i = 0; i < list.get(ind).size(); i++) {
            s += sum(list.get(ind).get(i), list, size);
        }
        size.put(ind, s);
        return s;
    }

    public static boolean four(char[] ch) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int g = 0; g < 4; g++) {
                        Set<Integer> set = new HashSet();
                        set.add(i);
                        set.add(j);
                        set.add(k);
                        set.add(g);
                        if (set.size() < 4) {
                            continue;
                        }
                        if (ch[i] == ch[j] && ch[k] == ch[g]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean two(char[] ch) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                if (ch[i] == ch[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int recur(int ind, int[] a, Integer[] dp) {
        if (ind == a.length) {
            return 0;
        }
        if (dp[ind] != null) {
            return dp[ind];
        }
        int n = recur(ind + 1, a, dp);
        if (ind >= 2 && ind + 3 < a.length) {
            n = Math.max(n, recur(ind + 3, a, dp) + (a[ind + 1] - a[ind]));
        }
        return dp[ind] = n;
    }

    public static long gcd(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}

class BIT16 {

    int[] bit;

    public BIT16(int size) {
        bit = new int[size];
    }

    public void update(int ind, int delta) {
        while (ind < bit.length) {
            bit[ind] += delta;
            ind = ind + (ind & (-1 * ind));
        }
    }

    public int sum(int ind) {
        int s = 0;
        while (ind > 0) {
            s += bit[ind];
            ind = ind - (ind & (-1 * ind));
        }
        return s;
    }

    public int query(int l, int r) {
        return sum(r) - sum(l);
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

class Reader {

    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int ni() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) {
            return -ret;
        }
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) {
            return -ret;
        }
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
        if (neg) {
            return -ret;
        }
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) {
            buffer[0] = -1;
        }
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null) {
            return;
        }
        din.close();
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
