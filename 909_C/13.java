import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author pandusonu
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public int mod = (int) Math.pow(10, 9) + 7;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // out.print("Case #" + testNumber + ": ");
            int n = in.readInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.readString().charAt(0) == 'f' ? 1 : 0;
            }
            long[][] ans = new long[n][n + 2];
            ans[0][0] = 1;
            int indent = 0;
            if (a[0] == 1) indent++;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] == 1) {
                    for (int j = indent - 1; j >= 1; j--) {
                        ans[i][j] = ans[i - 1][j - 1];
                    }
                    ans[i][indent] = 1;
                } else {
                    for (int j = indent; j >= 0; j--) {
                        ans[i][j] = (ans[i][j + 1] + ans[i - 1][j]) % mod;
                    }
                }
                indent += a[i];
            }/*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(ans[i][j]+" ");
            }
            out.println();
        }*/
            long aa = 0;
            for (int i = 0; i < n + 2; i++) {
                aa = (aa + ans[n - 1][i]) % mod;
            }
            out.println(aa);
        }

    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            try {
                if (curChar >= numChars) {
                    curChar = 0;
                    numChars = stream.read(buf);
                    if (numChars <= 0)
                        return -1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return buf[curChar++];
        }

        public int readInt() {
            return (int) readLong();
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) throw new RuntimeException();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return negative ? (-res) : (res);
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

