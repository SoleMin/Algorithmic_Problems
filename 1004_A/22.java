//package CodeforcesJava;

import java.io.*;
import java.util.*;

public class Main {

    public void solve(InputProvider input, PrintWriter output) throws IOException {
        int n = input.nextInt();
        int d = input.nextInt();
        int count = 1;
        int current = input.nextInt();
        for (int i = 1; i < n; i++) {
            int x = input.nextInt();
            if (x - current == d * 2) {
                count++;
            } else if (x - current > d * 2) {
                count += 2;
            }
            current = x;
        }
        count++;
        output.print(count);
    }

    public static void main(String[] args) throws Exception {
        try (InputProvider input = new InputProvider(System.in);
             PrintWriter output = new PrintWriter(System.out)) {
            new Main().solve(input, output);
        }
    }

    public static class InputProvider implements AutoCloseable {

        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputProvider(Reader reader) {
            this.reader = new BufferedReader(reader);
        }

        public InputProvider(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public String next() throws IOException {
            if (Objects.isNull(tokenizer) || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        @Override
        public void close() throws Exception {
            reader.close();
        }

    }

}
