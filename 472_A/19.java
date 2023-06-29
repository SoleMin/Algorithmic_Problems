import java.io.*;
import java.util.*;

public class Main {
    private static PrintWriter out;
    private static FastReader in;

    private static class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastReader(InputStream inputStream) {
            reader = new BufferedReader(
                    new InputStreamReader(inputStream), 1 << 16);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);

        int n = in.nextInt();
        int a = ((n & 1) == 0) ? a = 6 : 9;
        int b = n - a;
        out.println(a + " " + b);

        out.flush();
    }
}