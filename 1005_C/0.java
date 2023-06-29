import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        OutputWriter out = new OutputWriter(outputStream);
        CSummarizeToThePowerOfTwo solver = new CSummarizeToThePowerOfTwo();
        solver.solve(1, in, out);
        out.close();
    }

    static class CSummarizeToThePowerOfTwo {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int ntc = 1;
//        ntc = in.nextInt();
            while ((ntc--) > 0) {
                int n = in.nextInt();
                ArrayList<Integer> arr = in.nextIntArrayList(n);
                HashMap<Integer, Integer> hm = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    hm.put(arr.get(i), hm.getOrDefault(arr.get(i), 0) + 1);
                }
                int count = 0;
                for (int i = 0; i < n; i++) {
                    int x = arr.get(i);
                    boolean found = false;
                    for (long p = 0; p <= 31; p++) {
                        long pow = 1 << p;
                        long req = pow - x;
                        if (req < 0) continue;
                        ;
                        if (req == x) {
                            if (hm.getOrDefault(x, 0) > 1) {
                                found = true;
                                break;
                            }
                        } else {
                            if (hm.getOrDefault((int) req, 0) > 0) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) {
                        count++;
                    }
                }
                out.println(count);
            }
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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public ArrayList<Integer> nextIntArrayList(int n) {
            return nextIntArrayList(n, 0);
        }

        public ArrayList<Integer> nextIntArrayList(int n, int startFrom) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < startFrom; i++) {
                list.add(0);
            }
            for (int i = startFrom; i < n; ++i) list.add(nextInt());
            return list;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

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

        public void close() {
            writer.close();
        }

        public void println(long i) {
            writer.println(i);
        }

    }
}

