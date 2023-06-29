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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String[] response = {"even", "odd"};
            int n = in.nextInt();
            int[] arr = in.nextIntArray(0, n);
            int swaps = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) swaps = (swaps + 1) % 2;
                }
            }
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                int l = in.nextInt(), r = in.nextInt(), combinaisons = ((r - l) * (r - l + 1)) / 2;
                if (combinaisons % 2 == 1) {
                    swaps ^= 1;
                }
                out.println(response[swaps]);
            }
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int offset, int length) {
            int[] arr = new int[offset + length];
            for (int i = offset; i < offset + length; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

    }
}

