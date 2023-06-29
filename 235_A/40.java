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
 * @author Nasko
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int N = in.nextInt();


            if (N == 1) {
                out.println(1);
            } else if (N == 2) {
                out.println(2);
            } else if (N == 3) {
                out.println(6);
            } else {

                long best = Long.MIN_VALUE;
                best = Math.max(best, lcm(N, lcm(N - 1, N - 2)));
                best = Math.max(best, lcm(N, lcm(N - 2, N - 3)));
                best = Math.max(best, lcm(N, lcm(N - 1, N - 3)));
                best = Math.max(best, lcm(N - 1, lcm(N - 2, N - 3)));

                out.println(best);
            }
        }

        private long lcm(long a, long b) {
            return a * (b / gcd(a, b));
        }

        private long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

    }

    static class InputReader {
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

