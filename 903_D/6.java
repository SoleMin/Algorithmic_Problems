import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.math.BigInteger;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static
    @SuppressWarnings("Duplicates")
    class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] a = in.nextLongArray(n);
            HashMap<Integer, Integer> count = new HashMap<>();

            BigInteger res = BigInteger.ZERO;
            long prev = 0;
            count.put((int) a[0], 1);

            long temp;
            long nextRes;
            for (int i = 1; i < n; i++) {
                temp = ((a[i] - a[i - 1]) * i + prev);
                nextRes = temp - count.getOrDefault((int) a[i] - 1, 0) + count.getOrDefault((int) a[i] + 1, 0);
                res = res.add(new BigInteger(String.valueOf(nextRes)));
                count.put((int) a[i], count.getOrDefault((int) a[i], 0) + 1);
                prev = temp;
            }

            out.print(res);
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; ++i) {
                array[i] = nextLong();
            }
            return array;
        }

        public int nextInt() {
            return Integer.parseInt(next());
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

