import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author beginner1010
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            TreeSet<Integer> set = new TreeSet<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                set.add(x);
            }
            int ans = 0;
            while (!set.isEmpty()) {
                ans++;
                int minimal = set.first();
                int cur = minimal;
                while (cur <= 100) {
                    set.remove(cur);
                    cur += minimal;
                }
            }
            out.println(ans);
        }

    }

    static class InputReader {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputStream stream;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isWhitespace(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isWhitespace(c));
            return res * sgn;
        }

    }
}

