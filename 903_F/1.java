import java.util.*;
import java.io.*;
import java.math.*;

public class f {

    static int n;
    static long a1, a2, a3, a4, oo = 1000000000000000L;
    static long[][] memo;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        n = in.nextInt();
        a1 = in.nextLong();
        a2 = in.nextLong();
        a3 = in.nextLong();
        a4 = in.nextLong();
        
        memo = new long[625][n];
        for (long[] a : memo) Arrays.fill(a, -1);
        
        arr = new char[4][n];
        for (int i = 0; i < 4; i++) {
            arr[i] = in.next().toCharArray();
        }
        long ans = go(0, 0, 0, 0, 0);
        
        out.println(ans);
        
        
        out.close();
    }

    static long go(int h0, int h1, int h2, int h3, int r) {
        if (r == n) return 0;
        int key = h0 * 125 + h1 * 25 + h2 * 5 + h3;
        if (memo[key][r] != -1) return memo[key][r];
        long min = oo;
        
        for (int g0 = 0; g0 <= 4; g0++) {
            int nh0 = Math.max(h0, g0);
            long c0 = getCost(g0);
            if (nh0 == 0 && arr[0][r] == '*') continue;
            for (int g1 = 0; g1 <= 3; g1++) {
                int nh1 = Math.max(h1, g1);
                if (g0 > 1)
                    nh1 = Math.max(nh1, g0);
                long c1 = getCost(g1);
                if (nh1 == 0 && arr[1][r] == '*') continue;
                for (int g2 = 0; g2 <= 2; g2++) {
                    int nh2 = Math.max(h2, g2);
                    if (g1 > 1)
                        nh2 = Math.max(nh2, g1);
                    if (g0 > 2)
                        nh2 = Math.max(nh2, g0);
                    long c2 = getCost(g2);
                    if (nh2 == 0 && arr[2][r] == '*') continue;
                    for (int g3 = 0; g3 <= 1; g3++) {
                        int nh3 = Math.max(h3, g3);
                        if (g2 > 1)
                            nh3 = Math.max(nh3, g2);
                        if (g1 > 2)
                            nh3 = Math.max(nh3, g1);
                        if (g0 > 3)
                            nh3 = Math.max(nh3, g0);
                        long c3 = getCost(g3);
                        if (nh3 == 0 && arr[3][r] == '*') continue;
                        
                        long cost = c0 + c1 + c2 + c3;
                        cost += go(Math.max(0, nh0 - 1),
                                   Math.max(0, nh1 - 1),
                                   Math.max(0, nh2 - 1),
                                   Math.max(0, nh3 - 1),
                                   r + 1);
                        min = Math.min(min, cost);
                    }
                }
            }
        }
        
        return memo[key][r] = min;
    }
    
    
    static long getCost(int a) {
        if (a == 0) return 0;
        if (a == 1) return a1;
        if (a == 2) return a2;
        if (a == 3) return a3;
        return a4;
    }

    static Random rand = new Random();
    static void sort(int[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static void sort(long[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            long tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static void sort(double[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            double tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; }
    static long[] eEuclid(long a, long b) {
        if (b == 0) return new long[] { a, 1, 0 };
        long[] ans = eEuclid(b, a % b);
        long temp = ans[1] - ans[2] * (a / b);
        ans[1] = ans[2];  ans[2] = temp;
        return ans;
    }
    static long modInverse(long a, long m) {
        return ((eEuclid(a, m)[1] % m) + m) % m;
    }
    static class IntList {
        static int[] EMPTY = {};
        int[] a = EMPTY;
        int n = 0;
        void add(int v) {
            if (n >= a.length)
                a = Arrays.copyOf(a, (n << 2) + 8);
            a[n++] = v;
        }
        int get(int idx) {
            return a[idx];
        }
        int size() {
            return n;
        }
    }
    static class DisjointSet {
        int[] s, r;	
	public DisjointSet(int n) {
            s = new int[n]; r = new int[n];
            for (int i = 0; i < n; i++) s[i] = i;
        }	
        public int find(int i) { return s[i] == i ? i : (s[i] = find(s[i])); }
	public void union(int a, int b) {
            if(r[a = find(a)] == r[b = find(b)]) r[a]++;
            if(r[a] >= r[b]) s[b] = a; else s[a] = b;
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }
        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        public int[] nextOffsetIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt() - 1;
            return arr;
        }
        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
        public int[][] nextIntArray(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }
        public long[][] nextLongArray(int n, int m) throws IOException {
            long[][] arr = new long[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextLong();
            return arr;
        }
        public double[] nextDoubleArray(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextDouble();
            return arr;
        }
        public double[][] nextDoubleArray(int n, int m) throws IOException {
            double[][] arr = new double[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextDouble();
            return arr;
        }
        public char[][] nextCharArray(int n, int m) throws IOException {
            char[][] arr = new char[n][];
            for (int i = 0; i < n; i++)
                arr[i] = next().toCharArray();
            return arr;
        }
    }
}
