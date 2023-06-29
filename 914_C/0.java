import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }


    int[] x;
    int K;
    void run(FastScanner in, PrintWriter out) {

        // all numbers under 2^(1000) have <= 1000 bits
        // compute all transitions from 1000 to 1
        // for numbers > 1000, use binomial coeff to get count
        int[] transitions = new int[1001];

        for (int i = 2; i < transitions.length; i++) {
            int bitCount = Integer.bitCount(i);
            transitions[i] = transitions[bitCount]+1;
        }

        // for each number t for 1-1000, how many numbers < N go to t in one move

        x = in.next().chars().map(xx -> xx-'0').toArray();
        K = in.nextInt();

        if (K == 0) {
            out.println(1);
            return;
        }

        if (x.length == 1) {
            out.println(0);
            return;
        }

        for (int i = 1; i < transitions.length; i++) {
            if (transitions[i] == K-1) {
                go(0, i);
                if (K == 1) ret = (ret - 1) % mod;
            }
        }

        out.println(ret);

    }

    long ret = 0;

    void go(int i, int set) {

        if (set == 0) {
            ret = (ret+1)%mod;
            return;
        }
        if (i == x.length) return;

        if (x[i] == 0) go(i+1, set);
        else {
            // if 1, try to put a zero here, and choose 1s from the suffix
            int remaining = x.length-1-i;
            ret = (ret + choose(remaining, set)) % mod;
            go(i+1, set-1);
        }

    }

    public static int mod = 1_000_000_007;
    static long[] f = new long[1001];
    static {
        f[0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = (f[i-1] * i) % mod;
        }
    }

    long choose(int n, int k) {
        if (k > n) return 0;
        long ret = f[n];
        ret = (ret * modinv(f[n-k])) % mod;
        ret = (ret * modinv(f[k])) % mod;
        return ret;
    }

    long modinv(long a) {
        long ret = 1;
        int pow = mod-2;
        while (pow > 0) {
            if ((pow&1) > 0) ret = (ret * a) % mod;
            a = (a*a)%mod;
            pow>>=1;
        }
        return ret;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
