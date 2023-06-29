/*
Keep solving problems.
*/

import java.util.*;
import java.io.*;

public class CFA {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000 * 1000 * 1000 + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    void solve() throws IOException {
        int n = nextInt();
        String[] arr1 = new String[n];
        String[] arr2 = new String[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = nextString();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = nextString();
        }
        Map<String, Integer> m1 = getMap(arr1);
        Map<String, Integer> m2 = getMap(arr2);
        int res = 0;
        for (Map.Entry<String, Integer> entry : m2.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (m1.containsKey(key)) {
                int v2 = m1.get(key);
                if (val > v2) {
                    res += val - v2;
                }
            }
            else {
                res += val;
            }
        }

        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (m2.containsKey(key)) {
                int v2 = m2.get(key);
                if (val > v2) {
                    res += val - v2;
                }
            }
            else {
                res += val;
            }
        }

        outln(res / 2);
    }

    Map<String, Integer> getMap(String[] arr) {
        Map<String, Integer> res = new HashMap<>();
        for (String str : arr) {
            res.put(str, res.getOrDefault(str, 0) + 1);
        }

        return res;
    }

    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    long gcd(long a, long b) {
        while(a != 0 && b != 0) {
            long c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }

    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    private void formatPrint(double val) {
        outln(String.format("%.9f%n", val));
    }
    public CFA() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFA();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}