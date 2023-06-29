

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class Solution {


    static MyScanner sc;
    private static PrintWriter out;
    static long M2 = 1_000_000_000L + 7;

    private static HashMap<Long, Long>[] mods;

    public static void main(String[] s) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

//        stringBuilder.append("7 3\n" +
//                "1 5 2 6 3 7 4\n" +
//                "2 5 3\n" +
//                "4 4 1\n" +
//                "1 7 3");

//
//        Random r = new Random(5);
//        stringBuilder.append("100000 5000 ");
//        for (int i = 0; i < 100000; i++) {
//            stringBuilder.append(" " + (r.nextInt(2000000000) - 1000000000) + " ");
//
//        }
//        for (int k = 0; k < 5000; k++) {
//            stringBuilder.append(" 1 100000 777 ");
//        }
        if (stringBuilder.length() == 0) {
            sc = new MyScanner(System.in);
        } else {
            sc = new MyScanner(new BufferedReader(new StringReader(stringBuilder.toString())));
        }

        out = new PrintWriter(new OutputStreamWriter(System.out));

        initData();
        solve();

        out.flush();
    }

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int[] data = sc.na(n);
        boolean ev = true;
        for (int t = 0; t < n - 1; t++) {
            for (int x = t + 1; x < n; x++) {
                if (data[t] > data[x]) {
                    ev = !ev;
                }
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int dd = -sc.nextInt() + sc.nextInt();

            int dm = (dd + 1) * dd / 2;
            if (dm % 2 == 1) {
                ev = !ev;
            }
            out.println(ev ? "even" : "odd");
        }


    }


    private static void initData() {


    }


    private static boolean isset(long i, int k) {
        return (i & (1 << k)) > 0;
    }

    private static void solveT() throws IOException {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }


    private static long gcd(long l, long l1) {
        if (l > l1) return gcd(l1, l);
        if (l == 0) return l1;
        return gcd(l1 % l, l);
    }

    private static long pow(long a, long b, long m) {
        if (b == 0) return 1;
        if (b == 1) return a;
        long pp = pow(a, b / 2, m);
        pp *= pp;
        pp %= m;
        return (pp * (b % 2 == 0 ? 1 : a)) % m;
    }


    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(BufferedReader br) {
            this.br = br;
        }

        public MyScanner(InputStream in) {
            this(new BufferedReader(new InputStreamReader(in)));
        }

        void findToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        String next() {
            findToken();
            return st.nextToken();
        }

        Integer[] nab(int n) {
            Integer[] k = new Integer[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.fi();
            }
            return k;
        }

        int[] na(int n) {
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.fi();
            }
            return k;
        }

        long[] nl(int n) {
            long[] k = new long[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextLong();
            }
            return k;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int fi() {
            String t = next();
            int cur = 0;
            boolean n = t.charAt(0) == '-';
            for (int a = n ? 1 : 0; a < t.length(); a++) {
                cur = cur * 10 + t.charAt(a) - '0';
            }
            return n ? -cur : cur;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }


}