import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author bacali
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CNastyaAndAWardrobe solver = new CNastyaAndAWardrobe();
        solver.solve(1, in, out);
        out.close();
    }

    static class CNastyaAndAWardrobe {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            long mod = (long) (1e9 + 7);
            long n = in.nextLong();
            long k = in.nextLong();
            if (n == 0) {
                out.println(0);
                return;
            }
            long c = (((2 * n - 1) % mod) * pow(2L, k, mod)) % mod + 1;
            c %= mod;
            out.println(c);
        }

        public long pow(long a, long b, long mod) {
            long result = 1;
            while (b > 0) {
                if (b % 2 != 0) {
                    result *= a;
                    result %= mod;
                    b--;
                }
                a *= a;
                a %= mod;
                b /= 2;
            }

            return result % mod;

        }

    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

