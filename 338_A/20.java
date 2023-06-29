import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Quiz {
    public static long pow(long base, long power) {
        if (power == 0)
            return 1;
        long half = pow(base, power / 2) % mod;
        half *= half;
        half %= mod;
        if (power % 2 == 1)
            half *= base;
        return half % mod;
    }

    static long mod = (long) (1e9 + 9);

    public static void main(String[] args) {
        InputReader r = new InputReader(System.in);
        int n = r.nextInt();
        int m = r.nextInt();
        int k = r.nextInt();
        int buckets = n / k;
        int rem = n - buckets * k;
        long low = 0, high = buckets, itr = 30;
        while (itr-- > 0) {
            long mid = (low + high) / 2;
            long correct = mid * k + rem + (buckets - mid) * (k - 1);
            if (correct < m)
                low = mid;
            else
                high = mid;
        }
        long pow = (pow(2, high + 1) - 2 + mod) % mod;
        pow *= k;
        pow %= mod;
        long res = m - (high * k) + pow + 10 * mod;
        res %= mod;
        System.out.println(res);
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
