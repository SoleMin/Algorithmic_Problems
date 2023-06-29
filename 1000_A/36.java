import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author palayutm
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.next();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.next();
            }
            int ans = 0;
            for (int i = 1; i < 5; i++) {
                int a1 = 0, b1 = 0, c1 = 0;
                for (int j = 0; j < n; j++) {
                    if (a[j].length() == i) {
                        if (a[j].charAt(i - 1) == 'M') {
                            a1++;
                        } else if (a[j].charAt(i - 1) == 'S') {
                            b1++;
                        } else {
                            c1++;
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (b[j].length() == i) {
                        if (b[j].charAt(i - 1) == 'M') {
                            a1--;
                        } else if (b[j].charAt(i - 1) == 'S') {
                            b1--;
                        } else {
                            c1--;
                        }
                    }
                }
                if (a1 > 0) ans += a1;
                if (b1 > 0) ans += b1;
                if (c1 > 0) ans += c1;
            }
            out.println(ans);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0;
        private int ptrbuf = 0;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int readByte() {
            if (lenbuf == -1) throw new UnknownError();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = stream.read(inbuf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

    }

    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {
            super(out);
        }

        public OutputWriter(Writer out) {
            super(out);
        }

        public void close() {
            super.close();
        }

    }
}

