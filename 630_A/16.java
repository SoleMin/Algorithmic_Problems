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
 * @author ATailouloute
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        QuickScanner in = new QuickScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, QuickScanner in, PrintWriter out) {
            long n = in.nextLong();
            out.println(IntegerUtils.pow(5L, n, 100));
        }

    }

    static class QuickScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream is;

        public QuickScanner(InputStream stream) {
            is = stream;
            br = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

    }

    static class IntegerUtils {
        public static long pow(long a, long base, long mod) {
            if (base == 0) return 1;
            if (base == 1) return a;
            if ((base & 1) == 1)
                return (a * pow(a, base - 1, mod)) % mod;
            return pow((a * a) % mod, base / 2, mod);
        }

    }
}

