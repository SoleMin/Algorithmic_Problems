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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int MOD = 1000000007;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            long x = in.nextLong();
            long k = in.nextLong();
            if (x == 0) {
                out.print(0);
                return;
            }
            long b = fast_expo(2, k);
            long a = (b * 2) % MOD;

            long u = ((x % MOD) * a) % MOD;
            long v = (b - 1 + MOD) % MOD;
            out.print((u - v + MOD) % MOD);
        }

        private long fast_expo(long a, long b) {
            long res = 1L;
            a = a % MOD;
            while (b > 0) {
                if ((b & 1) != 0) {
                    res = (res * a) % MOD;
                }
                b = b >> 1;
                a = (a * a) % MOD;
            }
            return res % MOD;
        }

    }

    static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

