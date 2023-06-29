/**
 * author: derrick20
 * created: 11/11/20 1:03 PM
 */
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class OnTheBench {
    public static void main(String[] args) {
        setupCombo(301);
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
        int N = sc.nextInt();
        long[] a = sc.nextLongs(N);
        boolean[] vis = new boolean[N];
        int[] groups = new int[N + 1];
        int G = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                vis[i] = true;
                int elems = 1;
                for (int j = i + 1; j < N; j++) {
                    long prod = a[i] * a[j];
                    long root = (long) Math.sqrt(prod);
                    if (!vis[j] && prod == root * root) {
                        vis[j] = true;
                        elems++;
                    }
                }
                groups[++G] = elems;
            }
        }

        long[][] dp = new long[G + 1][N + 1];
        // dp[g][bad] = ways to interleave first g groups for a given # of bad pairs
        dp[0][0] = 1;
        // dp[0][k] = 0, k != 0
        int total = 0;
        for (int prefix = 1; prefix <= G; prefix++) {
            int amt = groups[prefix];
            for (int prevBad = 0; prevBad <= max(0, total - 1); prevBad++) {
                for (int fixed = 0; fixed <= min(prevBad, amt); fixed++) {
                    for (int slots = max(1, fixed); slots <= min(amt, total + 1); slots++) {
                        int introduced = amt - slots;
                        long ways = mult(
                                choose[prevBad][fixed],
                                choose[total + 1 - prevBad][slots - fixed],
                                choose[amt - 1][slots - 1],
                                fact[amt],
                                dp[prefix - 1][prevBad]
                        );
                        int currBad = prevBad + introduced - fixed;
                        dp[prefix][currBad] = (dp[prefix][currBad] + ways) % mod;
                    }
                }
            }
            total += amt;
//            System.out.println(Arrays.toString(dp[prefix]));
        }
        out.println(dp[G][0]);
        out.close();
    }

    static long mod = (long) 1e9 + 7;
    static long[][] choose;
    static long[] fact;

    static long mult(long... multiplicands) {
        long ans = 1;
        for (long v : multiplicands) {
            ans = (ans * v) % mod;
        }
        return ans;
    }

    static void setupCombo(int MAX) {
        choose = new long[MAX + 1][MAX + 1];
        fact = new long[MAX + 1];
        choose[0][0] = 1;
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (long) i * fact[i - 1] % mod;
            choose[i][0] = 1;
            for (int j = 1; j < i; j++) {
                choose[i][j] = (choose[i - 1][j - 1] + choose[i - 1][j]) % mod;
            }
            choose[i][i] = 1;
        }
    }

    static class FastScanner {
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }
    static void ASSERT(boolean assertion, String message) {
        if (!assertion) throw new AssertionError(message);
    }
    static void ASSERT(boolean assertion) {
        if (!assertion) throw new AssertionError();
    }
}