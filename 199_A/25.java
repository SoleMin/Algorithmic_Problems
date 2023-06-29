import java.io.*;
import java.util.StringTokenizer;

/**
 * Author: Maksim Novik
 * Date: 30.06.12
 * Time: 22:34
 */
public class Round125ProblemA {

    public static void main(String[] args) {
        InputStream in = System.in;
        OutputStream out = System.out;
        InputReader reader = new InputReader(in);
        PrintWriter writer = new PrintWriter(out);
        solve(reader, writer);
        writer.close();
    }

    static void solve(InputReader in, PrintWriter out) {
        long fib = in.nextLong();
        out.write("" + 0  + " " + 0 + " " + fib);
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
