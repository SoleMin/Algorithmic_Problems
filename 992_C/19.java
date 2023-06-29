
import java.util.*;
import java.io.*;

public class Solution1 {

    private void solve() throws IOException {
        long MOD = 1_000_000_007;
        long x = in.nextLong();
        long k = in.nextLong();
        if (x == 0) {
            System.out.println(0);
            return;
        }
        long val = binpow(2, k + 1, MOD) % MOD;
        long kek = (binpow(2, k, MOD) - 1 + MOD) % MOD;
        x = (val % MOD) * (x % MOD) % MOD;
        long ans = (x % MOD - kek % MOD + MOD) % MOD;
        System.out.println(ans % MOD);
    }

    private long binpow(long a, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1)
                res = (res % mod) * (a % mod) % mod;
            a = (a % mod) * (a % mod) % mod;
            n >>= 1;
        }
        return res % mod;
    }



    private PrintWriter out;
    private MyScanner in;

    private void run() throws IOException {
        in = new MyScanner();
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    private class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() throws IOException {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyScanner(String fileTitle) throws IOException {
            this.br = new BufferedReader(new FileReader(fileTitle));
        }

        public String nextLine() throws IOException {
            String s = br.readLine();
            return s == null ? "-1" : s;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return "-1";
                }
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public Integer nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }

        public Double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }

        public void close() throws IOException {
            this.br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Solution1().run();
    }
}




