import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Main{

    static long MOD = 1_000_000_007L;
    //static long MOD = 998_244_353L;
    //static long MOD = 1_000_000_033L;
    static long inv2 = (MOD + 1) / 2;

    static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static long lMax = 0x3f3f3f3f3f3f3f3fL;
    static int iMax = 0x3f3f3f3f;
    static HashMap <Long, Long> memo = new HashMap();
    static MyScanner sc = new MyScanner();
    //static ArrayList <Integer> primes;

    static int nn = 300000;
    static long[] pow2;
    static long [] fac;
    static long [] pow;
    static long [] inv;
    static long [] facInv;
    static int[] base;
    static int[] numOfDiffDiv;
    static int[] numOfDiv;
    static ArrayList <Integer> primes;
    //static int[] primes;
    static int ptr = 0;
    static boolean[] isPrime;

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start writing your solution here. -------------------------------------



        /*fac = new long[nn + 1];
        fac[1] = 1;
        for(int i = 2; i <= nn; i++)
            fac[i] = fac[i - 1] * i % MOD;*/


        /*pow2 = new long[nn + 1];
        pow2[0] = 1L;
        for(int i = 1; i <= nn; i++)
            pow2[i] = pow2[i - 1] * 2L;*/


        /*inv = new long[nn + 1];
        inv[1] = 1;
        for (int i = 2; i <= nn; ++i)
            inv[i] = (MOD - MOD / i) * inv[(int)(MOD % i)] % MOD;*/

        /*facInv = new long[nn + 1];
        facInv[0] = facInv[1] = 1;
        for (int i = 2; i <= nn; ++i)
            facInv[i] = facInv[i - 1] * inv[i] % MOD;*/


        /*numOfDiffDiv = new int[nn + 1];
        for(int i = 2; i <= nn; i++)
            if(numOfDiffDiv[i] == 0)
                for(int j = i; j <= nn; j += i)
                    numOfDiv[j] ++;*/

        /*numOfDiv = new int[nn + 1];
        numOfDiv[1] = 1;
        for(int i = 2; i <= nn; i++) {
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    numOfDiv[i] = numOfDiv[i / j] + 1;
                    break;
                }
            }
        }*/

        //primes = sieveOfEratosthenes(100001);

        /*
        int t = 1;
        //t = sc.ni();
        while(t-- > 0) {
            //boolean res = solve();
            //out.println(res ? "YES" : "NO");
            long res = solve();
            out.println(res);
        }*/


        int t = 1, tt = 0;
        //t = sc.ni();
        for(int i = 1; i <40000; i++) squares.add(i * i);
        while(tt++ < t) {
            boolean res = solve();
            //out.println("Case #" + tt + ": " + res);
            //out.println(res ? "YES" : "NO");
        }
        out.close();
    }
    static HashSet <Integer> squares = new HashSet();

    static boolean solve() {
        /*String s = sc.nextLine();
        char[] c = s.toCharArray();
        int n = c.length;*/
        //int n = sc.ni();
        //long[] a =  new long[n];
        //for(int i = 0; i < n; i++) a[i] = sc.nl();
        long res = 0;
        int n = sc.ni();
        long m = sc.nl();
        long[][][] dp = new long[2][n + 3][n + 3];
        long[][][] dp2 = new long[2][n + 3][n + 3];
        dp[0][2][1] = dp[1][2][2] = dp2[0][1][1] = 1L;
        for(int i = 3; i <= n; i++) {
            long[][] bef = dp[0];
            long[][] aft = dp[1];
            long[][] nbef = new long[n + 3][n + 3];
            long[][] naft = new long[n + 3][n + 3];
            for(int len = 1; len <= i; len++) {
                for(int ind = 1; ind <= len; ind++) {
                    nbef[len + 1][1] += bef[len][ind];
                    nbef[len + 1][ind + 1] -= bef[len][ind];
                    naft[len + 1][ind + 1] += bef[len][ind];
                    //naft[len + 1][len + 2] -= bef[len][ind];
                    naft[len + 1][ind + 1] += aft[len][ind];
                    //naft[len + 1][len + 2] -= aft[len][ind];
                    nbef[len + 1][1] += dp2[0][len][ind] + dp2[1][len][ind];
                    //nbef[len + 1][len + 2] -= dp2[0][len][ind] + dp2[1][len][ind];
                }
            }
            for(int len = 1; len <= i; len++) {
                for(int ind = 1; ind <= len; ind ++) {
                    nbef[len][ind] = (nbef[len][ind] + nbef[len][ind - 1] + 10000000L * m) % m;
                    naft[len][ind] = (naft[len][ind] + naft[len][ind - 1] + 10000000L * m) % m;
                }
            }
            dp2 = dp;
            dp = new long[][][]{nbef, naft};
        }
        for(long[] row: dp[0])
            for(long i : row)
                res += i;
        for(long[] row: dp[1])
            for(long i : row)
                res += i;
            out.println(res % m);
        return false;
    }

    // edges to adjacency list by uwi
    public static int[][] packU(int n, int[] from, int[] to) {
        return packU(n, from, to, from.length);
    }

    public static int[][] packU(int n, int[] from, int[] to, int sup) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for (int i = 0; i < sup; i++) p[from[i]]++;
        for (int i = 0; i < sup; i++) p[to[i]]++;
        for (int i = 0; i < n; i++) g[i] = new int[p[i]];
        for (int i = 0; i < sup; i++) {
            g[from[i]][--p[from[i]]] = to[i];
            g[to[i]][--p[to[i]]] = from[i];
        }
        return g;
    }

    // tree diameter by uwi
    public static int[] diameter(int[][] g) {
        int n = g.length;
        int f0 = -1, f1 = -1, d01 = -1;
        int[] q = new int[n];
        boolean[] ved = new boolean[n];
        {
            int qp = 0;
            q[qp++] = 0; ved[0] = true;
            for(int i = 0;i < qp;i++){
                int cur = q[i];
                for(int e : g[cur]){
                    if(!ved[e]){
                        ved[e] = true;
                        q[qp++] = e;
                        continue;
                    }
                }
            }
            f0 = q[n-1];
        }
        {
            int[] d = new int[n];
            int qp = 0;
            Arrays.fill(ved, false);
            q[qp++] = f0; ved[f0] = true;
            for(int i = 0;i < qp;i++){
                int cur = q[i];
                for(int e : g[cur]){
                    if(!ved[e]){
                        ved[e] = true;
                        q[qp++] = e;
                        d[e] = d[cur] + 1;
                        continue;
                    }
                }
            }
            f1 = q[n-1];
            d01 = d[f1];
        }
        return new int[]{d01, f0, f1};
    }

    public static long c(int n, int k) {
        return (fac[n] * facInv[k] % MOD) * facInv[n - k] % MOD;
    }


    // SegmentTree range min/max query by uwi
    public static class SegmentTreeRMQ {
        public int M, H, N;
        public int[] st;

        public SegmentTreeRMQ(int n)
        {
            N = n;
            M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
            H = M>>>1;
            st = new int[M];
            Arrays.fill(st, 0, M, Integer.MAX_VALUE);
        }

        public SegmentTreeRMQ(int[] a)
        {
            N = a.length;
            M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
            H = M>>>1;
            st = new int[M];
            for(int i = 0;i < N;i++){
                st[H+i] = a[i];
            }
            Arrays.fill(st, H+N, M, Integer.MAX_VALUE);
            for(int i = H-1;i >= 1;i--)propagate(i);
        }

        public void update(int pos, int x)
        {
            st[H+pos] = x;
            for(int i = (H+pos)>>>1;i >= 1;i >>>= 1)propagate(i);
        }

        private void propagate(int i)
        {
            st[i] = Math.min(st[2*i], st[2*i+1]);
        }

        public int minx(int l, int r){
            int min = Integer.MAX_VALUE;
            if(l >= r)return min;
            while(l != 0){
                int f = l&-l;
                if(l+f > r)break;
                int v = st[(H+l)/f];
                if(v < min)min = v;
                l += f;
            }

            while(l < r){
                int f = r&-r;
                int v = st[(H+r)/f-1];
                if(v < min)min = v;
                r -= f;
            }
            return min;
        }

        public int min(int l, int r){ return l >= r ? 0 : min(l, r, 0, H, 1);}

        private int min(int l, int r, int cl, int cr, int cur)
        {
            if(l <= cl && cr <= r){
                return st[cur];
            }else{
                int mid = cl+cr>>>1;
                int ret = Integer.MAX_VALUE;
                if(cl < r && l < mid){
                    ret = Math.min(ret, min(l, r, cl, mid, 2*cur));
                }
                if(mid < r && l < cr){
                    ret = Math.min(ret, min(l, r, mid, cr, 2*cur+1));
                }
                return ret;
            }
        }
    }

    public static char[] rev(char[] a){char[] b = new char[a.length];for(int i = 0;i < a.length;i++)b[a.length-1-i] = a[i];return b;}

    public static double dist(double a, double b){
        return Math.sqrt(a * a + b * b);
    }

    public static long inv(long a){
        return quickPOW(a, MOD - 2);
    }

    public class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


    public static int lowerBound(int[] a, int v){ return lowerBound(a, 0, a.length, v); }
    public static int lowerBound(int[] a, int l, int r, int v)
    {
        if(l > r || l < 0 || r > a.length)throw new IllegalArgumentException();
        int low = l-1, high = r;
        while(high-low > 1){
            int h = high+low>>>1;
            if(a[h] >= v){
                high = h;
            }else{
                low = h;
            }
        }
        return high;
    }
    public static int rlowerBound(int[] a, int v){ return lowerBound(a, 0, a.length, v); }
    public static int rlowerBound(int[] a, int l, int r, int v)
    {
        if(l > r || l < 0 || r > a.length)throw new IllegalArgumentException();
        int low = l-1, high = r;
        while(high-low > 1){
            int h = high+low>>>1;
            if(a[h] <= v){
                high = h;
            }else{
                low = h;
            }
        }
        return high;
    }
    public static long C(int n, int m)
    {
        if(m == 0 || m == n) return 1l;
        if(m > n || m < 0) return 0l;
        long res = fac[n] * quickPOW((fac[m] * fac[n - m]) % MOD, MOD - 2) % MOD;

        return res;
    }
    public static long quickPOW(long n, long m)
    {
        long ans = 1l;
        while(m > 0)
        {
            if(m % 2 == 1)
                ans = (ans * n) % MOD;
            n = (n * n) % MOD;
            m >>= 1;
        }
        return ans;
    }
    public static long quickPOW(long n, long m, long mod)
    {
        long ans = 1l;
        while(m > 0)
        {
            if(m % 2 == 1)
                ans = (ans * n) % mod;
            n = (n * n) % mod;
            m >>= 1;
        }
        return ans;
    }

    public static int gcd(int a, int b)
    {
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    public static long gcd(long a, long b)
    {
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }

    static class Randomized {
        public static void shuffle(int[] data) {
            shuffle(data, 0, data.length - 1);
        }

        public static void shuffle(int[] data, int from, int to) {
            to--;
            for (int i = from; i <= to; i++) {
                int s = nextInt(i, to);
                int tmp = data[i];
                data[i] = data[s];
                data[s] = tmp;
            }
        }

        public static void shuffle(long[] data) {
            shuffle(data, 0, data.length - 1);
        }

        public static void shuffle(long[] data, int from, int to) {
            to--;
            for (int i = from; i <= to; i++) {
                int s = nextInt(i, to);
                long tmp = data[i];
                data[i] = data[s];
                data[s] = tmp;
            }
        }

        public static int nextInt(int l, int r) {
            return RandomWrapper.INSTANCE.nextInt(l, r);
        }
    }

    static class RandomWrapper {
        private Random random;
        public static final RandomWrapper INSTANCE = new RandomWrapper(new Random());

        public RandomWrapper() {
            this(new Random());
        }

        public RandomWrapper(Random random) {
            this.random = random;
        }

        public int nextInt(int l, int r) {
            return random.nextInt(r - l + 1) + l;
        }

    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
        long nl() {
            return Long.parseLong(next());
        }
        double nd() {
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //--------------------------------------------------------
}