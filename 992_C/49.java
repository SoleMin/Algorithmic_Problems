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
 * @author Vadim Semenov
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

    static final class TaskC {
        private static final int MODULO = 1_000_000_000 + 7;

        public void solve(int __, InputReader in, PrintWriter out) {
            long qty = in.nextLong();
            long months = in.nextLong();
            if (qty == 0) {
                out.println(0);
                return;
            }
            qty %= MODULO;
            long pow = pow(2, months + 1);
            qty = (qty * pow) % MODULO;
            long sub = (pow - 2 + MODULO) % MODULO * pow(2, MODULO - 2) % MODULO;
            qty = (qty - sub + MODULO) % MODULO;
            out.println(qty);
        }

        private long pow(long base, long power) {
            long result = 1;
            while (power > 0) {
                if ((power & 1) != 0) {
                    result = (result * base) % MODULO;
                }
                base = (base * base) % MODULO;
                power >>>= 1;
            }
            return result;
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

