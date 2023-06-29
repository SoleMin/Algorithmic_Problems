import java.io.*;
import java.util.*;

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
        boolean[] k = new boolean[n];

        for (int r = 0; r < n; r++) {
            k[r] = sc.next().charAt(0) == 'f';
        }
        if (k[n - 1]) {
            out.println(0);
            return;
        }
        long[][] res = new long[n + 1][n + 1];
        res[0][0] = 1;
        for (int t = 0; t < n; t++) {

            boolean pl = t != 0 && k[t - 1];
            if (pl) {
                System.arraycopy(res[t], 0, res[t + 1], 1, n);
            } else {
                long last = 0;
                for (int f = n; f >= 0; f--) {
                    last += res[t][f];
                    last %= M2;
                    res[t + 1][f] = last;
                }
            }
        }
        long pp = 0;
        for (long kk : res[n]) {
            pp += kk;
            pp %= M2;
        }
        out.println(pp);
    }

    private static void initData() {


    }

    static char[][] data;
    static String cmd;

    private static final class STree {
        private final Comparator<Integer> comparator;
        int[] val1;
        int[] from1;
        int[] to1;
        int[] max1;

        public STree(int c, Comparator<Integer> comparator) {
            this.comparator = comparator;
            int size = Integer.highestOneBit(c);
            if (size != c) {
                size <<= 1;
            }
            int rs = size << 1;
            val1 = new int[rs];
            from1 = new int[rs];
            max1 = new int[rs];
            to1 = new int[rs];

            Arrays.fill(from1, Integer.MAX_VALUE);
            for (int r = rs - 1; r > 1; r--) {
                if (r >= size) {
                    from1[r] = r - size;
                    to1[r] = r - size;
                }
                from1[r / 2] = Math.min(from1[r / 2], from1[r]);
                to1[r / 2] = Math.max(to1[r / 2], to1[r]);
            }
        }

        public int max(int from, int to) {
            return max(1, from, to);
        }

        private int max(int cur, int from, int to) {
            if (cur >= val1.length) return -1;
            if (from <= from1[cur] && to1[cur] <= to) {
                return max1[cur];
            }
            if (from1[cur] > to || from > to1[cur]) {
                return -1;
            }
            cur <<= 1;

            return max0(max(cur, from, to), max(cur + 1, from, to));
        }


        public void put(int x, int val) {
            x += val1.length >> 1;
            val1[x] = val;
            max1[x] = val;
            addToParent(x);
        }


        private void addToParent(int cur) {
            while (cur > 1) {
                cur >>= 1;
                max1[cur] = max0(max1[cur << 1], max1[1 + (cur << 1)]);
            }
        }

        private int max0(int i, int i1) {
            if (i == -1) return i1;
            if (i1 == -1) return i;
            return comparator.compare(i, i1) > 0 ? i1 : i;
        }
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