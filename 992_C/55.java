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
 * @author kessido
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
            long MOD = MathExtentions.DEFAULT_MOD;
            long x = in.NextLong();
            long k = in.NextLong();
            if (x == 0) {
                out.println(0);
                return;
            }
            x %= MOD;
            long res = x * MathExtentions.powerMod(2, k + 1, MOD);
            res %= MOD;
            res -= MathExtentions.powerMod(2, k, MOD) - 1;
            res %= MOD;
            while (res < 0) res += MOD;
            while (res >= MOD) res -= MOD;
            out.println(res);

        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long NextLong() {
            return Long.parseLong(next());
        }

    }

    static class MathExtentions {
        public static final long DEFAULT_MOD = 1_000_000_007;

        public static long powerMod(final long x, final long y, final long m) {
            if (y == 0)
                return 1;

            long p = powerMod(x, y / 2, m) % m;
            p = (p * p) % m;

            if (y % 2 == 0)
                return p;
            else
                return (x * p) % m;
        }

    }
}

