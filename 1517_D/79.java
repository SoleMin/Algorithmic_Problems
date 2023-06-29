import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.util.function.Predicate;

public class Main{
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long MOD = (long) (1e9 + 7);
    //    static long MOD = 998244353;
    static long MOD2 = MOD * MOD;
    static FastReader sc = new FastReader();
    static int pInf = Integer.MAX_VALUE;
    static int nInf = Integer.MIN_VALUE;
    static long ded = (long)(1e17)+9;
    public static void main(String[] args) throws Exception {
        int test = 1;
//        test = sc.nextInt();
        for (int i = 1; i <= test; i++){
//            out.print("Case #"+i+": ");
            solve();
        }
        out.flush();
        out.close();
    }
    static int n,m;
    static int[][] hor,ver;
    static Long[][][] dp;
    static void solve(){
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        dp = new Long[n+1][m+1][k+1];
        hor = new int[n][m-1];
        ver = new int[n-1][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m-1; j++){
                hor[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m; j++){
                ver[i][j] = sc.nextInt();
            }
        }
        if(k%2==1){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    out.print(-1+" ");
                }
                out.println();
            }
            return;
        }
        k = k/2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                long ans = cal(i,j,k);
                out.print((2*ans)+" ");
            }
            out.println();
        }
    }
    static long cal(int i, int j,int k){
        if(k==0)return 0;
        if(dp[i][j][k]!=null)return dp[i][j][k];
        long ans = ded;
        for(int h = 0; h < 4; h++){
            int ni = i+di[h];
            int nj = j+dj[h];
            if(e(ni,nj)){
                int cost = 0;
                if(ni==i){
                    if(nj>j){
                        cost = hor[i][j];
                    }else{
                        cost = hor[i][nj];
                    }
                }if(nj==j){
                    if(ni>i){
                        cost = ver[i][j];
                    }else{
                        cost = ver[ni][j];
                    }
                }
                ans = Math.min(ans,(cost)+cal(ni,nj,k-1));
            }
        }
        return dp[i][j][k] =  ans;
    }
    static int[] di = new int[]{0,-1,0,1};
    static int[] dj = new int[]{-1,0,1,0};
    static boolean e(int i, int j){
        return i>=0&&j>=0&&i<n&&j<m;
    }
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o){
            return this.x-o.x;
        }

        @Override
        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
        }

        public boolean equals(Pair o){
            return this.x==o.x&&this.y==o.y;
        }
    }
    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public static long add(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    public static long c2(long n) {
        if ((n & 1) == 0) {
            return mul(n / 2, n - 1);
        } else {
            return mul(n, (n - 1) / 2);
        }
    }
    //Shuffle Sort
    static final Random random = new Random();
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n); int temp= a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    //Brian Kernighans Algorithm
    static long countSetBits(long n) {
        if (n == 0) return 0;
        return 1 + countSetBits(n & (n - 1));
    }
    //Euclidean Algorithm
    static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
    //Modular Exponentiation
    static long fastExpo(long x, long n) {
        if (n == 0) return 1;
        if ((n & 1) == 0) return fastExpo((x * x) % MOD, n / 2) % MOD;
        return ((x % MOD) * fastExpo((x * x) % MOD, (n - 1) / 2)) % MOD;
    }
    //AKS Algorithm
    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }
    public static long modinv(long x) {
        return modpow(x, MOD - 2);
    }
    public static long modpow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long x = modpow(a, b / 2);
        x = (x * x) % MOD;
        if (b % 2 == 1) {
            return (x * a) % MOD;
        }
        return x;
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
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
}