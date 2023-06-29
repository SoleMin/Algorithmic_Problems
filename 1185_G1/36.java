import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class G1 {
    static final int mod = (int) (1e9 + 7);
    static final int UNCALC = -1;
    static int[][][] memo;
    static int n, t[], genre[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = sc.nextInt();
        t = new int[n];
        int T = sc.nextInt();
        genre = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            genre[i] = sc.nextInt();
        }
        memo = new int[4][1 << n][T+1];
        for (int[][] a : memo)
            for (int[] b : a)
                Arrays.fill(b, UNCALC);
        out.println(dp(0, 0, T));
        out.flush();
        out.close();
    }

    static int dp(int last, int mask, int rem) {
        if (rem==0) return 1;
        if (memo[last][mask][rem] != UNCALC) return memo[last][mask][rem];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (genre[i] == last || t[i] > rem || (mask & 1 << i) != 0) continue;
            cnt = (cnt + dp(genre[i], mask | 1 << i, rem - t[i]))%mod;
        }
        return memo[last][mask][rem] = cnt;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }


        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }


        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] ans = new double[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextDouble();
            return ans;
        }

        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }

    }

}