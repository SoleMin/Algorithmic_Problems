import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

/**
 * Created by hama_du on 2014/09/21.
 */
public class ProblemB {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextLong();
        }

        Map<Long,Integer> idxmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxmap.put(x[i], i);
        }
        if (a == b) {
            solve1(x, a, idxmap, out);
            return;
        }

        int[] mark = new int[n];
        Arrays.fill(mark, -1);
        boolean isok = true;
        for (int i = 0 ; i < n ; i++) {
            if (mark[i] != -1) {
                continue;
            }
            long w = x[i];
            long aw = a - w;
            long bw = b - w;
            if (idxmap.containsKey(aw) && idxmap.containsKey(bw)) {
                continue;
            } else if (idxmap.containsKey(bw)) {
                long w1 = w;
                long w2 = bw;
                while (true) {
                    if (!idxmap.containsKey(w1) || !idxmap.containsKey(w2)) {
                        break;
                    }
                    int i1 = idxmap.get(w1);
                    int i2 = idxmap.get(w2);
                    if (mark[i1] == 0 || mark[i2] == 0) {
                        isok = false;
                    }
                    mark[i1] = 1;
                    mark[i2] = 1;
                    if (w1 + a - b == w2) {
                        break;
                    }
                    w1 += (a - b);
                    w2 += (b - a);
                }
            } else if (idxmap.containsKey(aw)){
                long w1 = w;
                long w2 = aw;
                while (true) {
                    if (!idxmap.containsKey(w1) || !idxmap.containsKey(w2)) {
                        break;
                    }
                    int i1 = idxmap.get(w1);
                    int i2 = idxmap.get(w2);
                    if (mark[i1] == 1 || mark[i2] == 1) {
                        isok = false;
                    }
                    mark[i1] = 0;
                    mark[i2] = 0;
                    if (w1 + b - a == w2) {
                        break;
                    }
                    w1 += (b - a);
                    w2 += (a - b);
                }
            }
        }
        for (int i = 0 ; i < n ; i++) {
            if (mark[i] == -1) {
                isok = false;
                break;
            }
        }
        if (isok) {
            printAnswer(mark, out);
        } else {
            out.println("NO");
        }
        out.flush();
    }

    private static void printAnswer(int[] mark, PrintWriter out) {
        out.println("YES");
        StringBuilder ln = new StringBuilder();
        for (int m : mark) {
            ln.append(' ').append(m);
        }
        out.println(ln.substring(1));
    }

    private static void solve1(long[] x, long a, Map<Long, Integer> idxmap, PrintWriter out) {
        int[] mark = new int[x.length];
        for (int i = 0 ; i < x.length ; i++) {
            if (mark[i] == 1) {
                continue;
            }
            long w = x[i];
            long wp = a - w;
            if (idxmap.containsKey(wp)) {
                mark[i] = mark[idxmap.get(wp)] = 1;
            }
        }
        boolean isok = true;
        for (int i = 0 ; i < x.length ; i++) {
            if (mark[i] == 0) {
                isok = false;
                break;
            }
        }
        if (isok) {
            printAnswer(mark, out);
        } else {
            out.println("NO");
        }
        out.flush();
    }

    public static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int next() {
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
            int c = next();
            while (isSpaceChar(c))
                c = next();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = next();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = next();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = next();
            while (isSpaceChar(c))
                c = next();
            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = next();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = next();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
