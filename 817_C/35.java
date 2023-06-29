import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
//        InputStream inputStream = new FileInputStream("dijkstra.in");
        OutputStream outputStream = System.out;
//        OutputStream outputStream = new FileOutputStream("dijkstra.out");
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Answer solver = new Answer();
        solver.solve(in, out);
        out.close();
    }
}

class Answer {
    private int sumd(long x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    private long bin(long l, long r, long s) {
        if (l > r) {
            return -1;
        }
        long x = (l + r) >> 1;
        int sum = sumd(x);
        if (x - sum < s) {
            return bin(x + 1, r, s);
        }
        long t = bin(l, x - 1, s);
        if (t != -1) {
            return t;
        }
        return x;
    }

    public void solve(InputReader in, PrintWriter out) throws IOException {
        long n = in.nextLong();
        long s = in.nextLong();
        long t = bin(1, n, s);
        if (t == -1) {
            out.print("0");
        } else {
            long ans = n - t + 1;
            out.print(ans);
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    InputReader(InputStream stream) {
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

    public long nextLong() {
        return Long.parseLong(next());
    }
}
