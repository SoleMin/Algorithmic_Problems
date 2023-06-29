import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long x = in.nextLong();
            long k = in.nextLong();
            long max2 = (((x % 1_000_000_007) * (pb(k))) % 1_000_000_007) % 1_000_000_007;
            long min2 = ((((x - 1) % 1_000_000_007) * pb(k)) % 1_000_000_007 + 1) % 1_000_000_007;
            if (x == 0) min2 = 0;
            out.println((max2 + min2) % 1_000_000_007);
        }

        long pb(long a) {
            if (a == 0) return 1;
            if (a == 1) return 2;
            long tmp = pb(a / 2);
            if (a % 2 == 0) return (tmp * tmp) % 1_000_000_007;
            return (((tmp * tmp) % 1_000_000_007) * 2) % 1_000_000_007;
        }

    }

    static class InputReader {
        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private void fillTokenizer() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            fillTokenizer();
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

