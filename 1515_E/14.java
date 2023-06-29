import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static final DecimalFormat DF_3 = new DecimalFormat("0.000");
    private static final long MOD = 1000000007;


    static int[] readArray(int size, InputReader in, boolean subOne) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = in.nextInt() + (subOne ? -1 : 0);
        }
        return a;
    }

    static long[] readLongArray(int size, InputReader in) {
        long[] a = new long[size];
        for (int i = 0; i < size; i++) {
            a[i] = in.nextLong();
        }
        return a;
    }

    static void sortArray(int[] a) {
        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            int randomPos = random.nextInt(a.length);
            int t = a[i];
            a[i] = a[randomPos];
            a[randomPos] = t;
        }
        Arrays.sort(a);
    }

    private static long[] allInvs(int n, long mod) {
        long[] inv = new long[n + 1];
        inv[1] = 1;
        for (int i = 2; i <= n; ++i) {
            inv[i] = subMod(mod, (mod / i) * inv[(int) (mod % i)] % mod, mod);
        }
        return inv;

    }

    private static long subMod(long x, long y, long mod) {
        long res = x - y;
        if (res < 0) {
            return res + mod;
        }
        return res;
    }

    private static long fastPow(long x, long y, long mod) {
        if (x == 1) {
            return 1;
        }
        if (y == 0) {
            return 1;
        }
        long p = fastPow(x, y / 2, mod) % mod;
        p = p * p % mod;
        if (y % 2 == 1) {
            p = p * x % mod;
        }
        return p;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        InputReader in = new InputReader(new FileInputStream("input.txt"));
//        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("milkvisits.out")));
//
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

//        long start = System.currentTimeMillis();
        int n = in.nextInt();
        long mod = in.nextLong();
        long[] invs = allInvs(n + 3, mod);
        long[] facts = new long[n + 2];
        facts[0] = 1;
        long[] invFacts = new long[n + 2];
        invFacts[0] = 1;
        for (int i = 1; i < n + 2; i++) {
            facts[i] = (facts[i - 1] * i) % mod;
            invFacts[i] = (invFacts[i - 1] * invs[i]) % mod;
        }
        long[] pow2 = new long[n+3];
        pow2[0] = 1;
        for (int i = 1; i < n+3; i++) {
            pow2[i] = pow2[i-1] * 2 % mod;
        }

        long[][] dp = new long[n + 2][n + 2];
        for (int i = 2; i <= n + 1; i++) {
            dp[i][1] = invFacts[i - 1] * pow2[i - 2] % mod;
            for (int k = 2; k <= n; k++) {
                for (int j = i - 2; j >= 1; j--) {
                    dp[i][k] = (dp[i][k] + dp[j][k - 1] * pow2[ i - j - 2] % mod * invFacts[i - j - 1] % mod) % mod;
                }
            }
        }

        long ans = 0;
        for (int k = 1; k <= n; k++) {

            ans = (ans + dp[n + 1][k] * facts[n - k + 1] % mod) % mod;
        }
        out.println(ans);

        out.close();
    }

    private static void outputArray(List<Long> ans, PrintWriter out, boolean addOne) {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < ans.size(); j++) {
            long i = ans.get(j);
            long an = i + (addOne ? 1 : 0);
            str.append(an);
            if (j < ans.size() - 1) {
                str.append(' ');
            }
        }
        out.println(str);
//        out.flush();
    }

    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextString() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextWord() {
            return next();
        }

        private List<Integer>[] readTree(int n) {
            return readGraph(n, n - 1);
        }

        private List<Integer>[] readGraph(int n, int m) {
            List<Integer>[] result = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                result[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = nextInt() - 1;
                int v = nextInt() - 1;
                result[u].add(v);
                result[v].add(u);
            }
            return result;
        }

    }
}