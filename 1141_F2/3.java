import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author revanth
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        F2SameSumBlocksHard solver = new F2SameSumBlocksHard();
        solver.solve(1, in, out);
        out.close();
    }

    static class F2SameSumBlocksHard {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            long[] a = in.nextLongArray(n);
            HashMap<Long, ArrayList<Pair>> hm = new HashMap<>();
            long sum;
            for (int j = 0; j < n; j++) {
                sum = 0;
                for (int i = j; i >= 0; i--) {
                    sum += a[i];
                    if (!hm.containsKey(sum))
                        hm.put(sum, new ArrayList<>());
                    hm.get(sum).add(new Pair(i + 1, j + 1));
                }
            }
            ArrayList<Pair> al1 = new ArrayList<>();
            ArrayList<Pair> al2 = new ArrayList<>();
            int prev;
            for (ArrayList<Pair> al : hm.values()) {
                prev = 0;
                al1.clear();
                for (Pair p : al) {
                    if (p.x > prev) {
                        al1.add(p);
                        prev = p.y;
                    }
                }
                if (al1.size() > al2.size())
                    al2 = new ArrayList<>(al1);
            }
            out.println(al2.size());
            for (Pair p : al2)
                out.println(p.x + " " + p.y);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
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

    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (obj == this)
                return true;
            if (!(obj instanceof Pair))
                return false;
            Pair o = (Pair) obj;
            return o.x == this.x && o.y == this.y;
        }

        public int hashCode() {
            return this.x + this.y;
        }

        public int compareTo(Pair p) {
            if (x == p.x)
                return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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
}

