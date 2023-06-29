import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prakharjain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        long maxk = (long) 1e18;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int t = in.nextInt();

            long maxn = 1;
            long val = 0;
            for (long i = 1; ; i++) {
                val = 1 + 4 * val;
                if (val >= maxk) {
                    maxn = i;
                    break;
                }
            }

            long[] vala = new long[(int) maxn + 1];

            vala[1] = 1;

            for (int i = 2; i <= maxn; i++) {
                vala[i] = 1 + 4 * vala[i - 1];
            }

            o:
            while (t-- > 0) {
                long n = in.nextInt();
                long k = in.nextLong();

                if (n - 1 >= maxn) {
                    out.println("YES " + (n - 1));
                    continue;
                }

                k--;

                if (k <= vala[(int) n - 1]) {
                    out.println("YES " + (n - 1));
                    continue;
                }

                long cs = n - 1;
                long cc = 3;
                int ind = 2;

                long end = -1;
                while (k > 0) {
                    if (k >= cc && cs > 0) {
                        k -= cc;
                        cc += (1l << ind);
                        cs--;
                        ind++;
                    } else {
//                    if (cs > 0 && k < cc) {
//                        out.println("YES " + cs);
//                        continue o;
//                    }
                        end = ind;
                        break;
                    }
                }

                long fcs = cs;

                if (k == 0) {
                    out.println("YES " + cs);
                    continue;
                }

                k -= vala[(int) n - 1];

                cs = n - 1;
                cc = 3;
                ind = 2;

                long rv = 5;

                long sind = 3;

                while (k > 0 && ind < end) {
                    k -= rv * vala[(int) cs - 1];
                    rv += (1l << sind);
                    sind++;
                    cs--;
                    ind++;
                }

                if (k <= 0) {
                    out.println("YES " + fcs);
                } else {
                    out.println("NO");
                }
            }
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

