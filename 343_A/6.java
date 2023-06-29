import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    long solve(long a, long b) {
        if (a == 0) {
            return 0;
        }
        long answer = a / b;
        a %= b;
        if (a != 0) {
            answer += 1 + solve(b - a, a);
        }
        return answer;
    }

    public void run() {
        try {
            long a = reader.nextLong();
            long b = reader.nextLong();
            writer.println(solve(a, b));
        } catch (IOException ex) {
        }
        writer.close();
    }

    InputReader reader;
    PrintWriter writer;

    Main() {
        reader = new InputReader();
        writer = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        new Main().run();
    }

}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    InputReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    Integer nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    Long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
