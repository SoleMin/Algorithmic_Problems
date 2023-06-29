import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CFC {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    void solve() throws IOException {
        long x = nextLong();
        long k = nextLong();
        if (x == 0) {
            outln(0);
            return;
        }
        x %= MOD;
        long two = powMod(2, k, MOD);
        long res = two;
        res *= 2;
        res %= MOD;
        res *= x;
        res %= MOD;
        res -= two - 1;
        while (res < 0) {
            res += MOD;
        }
        while (res >= MOD) {
            res -= MOD;
        }

        outln(res);
    }

    public long powMod(long N, long M, long MOD){//N^M % MOD
        if(M == 0L)
            return 1L;
        long[] hp = new long[64];
        boolean[] bp = new boolean[64];
        hp[0] = N;
        for(int i = 1; i < hp.length; i++) {
            hp[i] = (hp[i - 1] * hp[i - 1]) % MOD;
        }
        for(int j = 0; j < hp.length; j++) {
            if((M & (1L << j)) != 0)
                bp[j] = true;
        }
        long res = 1;
        for(int i = 0;i < bp.length; i++){
            if(bp[i]) {
                res = (res * hp[i]) % MOD;
            }
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
    public CFC() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFC();
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