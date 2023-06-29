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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        int N;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            N = in.nextInt();
            int low = 1;
            int lowVal = getval(1, out, in);
            int high = N / 2 + 1;
            int highVal = -lowVal;
            if (Math.abs(lowVal) % 2 == 1) {
                out.println("! -1");
                out.flush();
            } else {
                while (low < high) {
                    int mid = (low + high) / 2;
                    int a = getval(mid, out, in);
                    if (Integer.signum(a) == 0) {
                        out.println("! " + mid);
                        out.flush();
                        return;
                    } else {
                        if (Integer.signum(a) == Integer.signum(lowVal)) {
                            low = mid + 1;
                        } else {
                            high = mid;
                        }
                    }
                }
                out.println("! " + low);
                out.flush();
            }
        }

        int getval(int i, PrintWriter out, InputReader in) {
            out.println("? " + i);
            out.flush();
            int a = in.nextInt();
            out.println("? " + (i + N / 2));
            out.flush();
            int b = in.nextInt();
            return a - b;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
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

    }
}

