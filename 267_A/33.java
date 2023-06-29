import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subtractions {
    public static void main(String[] args) {
        InputReader r = new InputReader(System.in);
        int n = r.nextInt();
        while (n-- > 0) {
            int a = r.nextInt();
            int b = r.nextInt();
            int res = 0;
            while (a > 0 && b > 0) {
                if (a > b) {
                    int div = a / b;
                    a -= div * b;
                    res += div;
                } else {
                    int div = b / a;
                    b -= div * a;
                    res += div;
                }
            }
            System.out.println(res);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
