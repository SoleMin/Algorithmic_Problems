import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintWriter;
import java.io.OutputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Alex
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskC {
        int BAD = 11111;
        int rows;
        int cols;
        HashMap<IntIntPair, Integer>[] mem;

        boolean contains(int mem, int index) {
            if(index < 0) return false;
            return ((mem >> index) & 1) == 1;
        }

        int add(int mem, int index) {
            if(((mem >> index) & 1) == 0) {
                mem += (1 << index);
            }
            return mem;
        }

        int size(int mem) {
            int res = 0;
            while(mem > 0) {
                if(mem % 2 == 1) res++;
                mem /= 2;
            }
            return res;
        }

        void test() {
            if(contains(5, 0) == false) throw new RuntimeException();
            if(contains(5, 1) == true) throw new RuntimeException();
            if(contains(5, -1) == true) throw new RuntimeException();
            if(contains(5, 2) == false) throw new RuntimeException();
            if(contains(5, 3) == true) throw new RuntimeException();
            if(add(0, 2) != 4) throw new RuntimeException();
            if(add(4, 0) != 5) throw new RuntimeException();
            if(add(5, 0) != 5) throw new RuntimeException();
            if(size(5) != 2) throw new RuntimeException();
        }

        int dp(int row, int remabove, int squareabove) {
            if(row == rows) {
                if(remabove == 0) return 0;
                return BAD;
            }
            if(mem[row].containsKey(new IntIntPair(remabove, squareabove)))
                return mem[row].get(new IntIntPair(remabove, squareabove));
            int res = BAD;
            int possibilities = 1 << cols;
            for(int poss = 0; poss < possibilities; poss++) {
                int have = 0;
                for(int j = 0; j < cols; j++)
                    if(((poss >> j) & 1) == 1) {
                        have += 1 << j;
                    }
                boolean works = true;
                for(int above = 0; above < cols; above++)
                    if(((remabove >> above) & 1) == 1) {
                        if(((have >> above) & 1) == 0) {
                            works = false;
                            break;
                        }
                    }
                if(works) {
                    int remhere = 0;
                    for(int j = 0; j < cols; j++) {
                        if(!contains(have, j - 1) && !contains(have, j) && !contains(have, j + 1) && !contains(squareabove, j)) {
                            remhere = add(remhere, j);
                        }
                    }
                    res = Math.min(res, size(have) + dp(row + 1, remhere, have));
                }
            }
            mem[row].put(new IntIntPair(remabove, squareabove), res);
            return res;
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            test();
            int n = in.readInt(), m = in.readInt();
            cols = Math.min(n, m);
            rows = Math.max(n, m);
            mem = new HashMap[rows];
            for(int i = 0; i < mem.length; i++) mem[i] = new HashMap<>();
            int res = dp(0, 0, 0);
            out.printLine(cols * rows - res);
        }

    }

    static class IntIntPair implements Comparable<IntIntPair> {
        public final int first;
        public final int second;

        public IntIntPair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;

            IntIntPair pair = (IntIntPair) o;

            return first == pair.first && second == pair.second;

        }


        public int hashCode() {
            int result = Integer.hashCode(first);
            result = 31 * result + Integer.hashCode(second);
            return result;
        }


        public String toString() {
            return "(" + first + "," + second + ")";
        }

        @SuppressWarnings({"unchecked"})
        public int compareTo(IntIntPair o) {
            int value = Integer.compare(first, o.first);
            if(value != 0) {
                return value;
            }
            return Integer.compare(second, o.second);
        }

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

        public int read() {
            if(numChars == -1)
                throw new InputMismatchException();
            if(curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch(IOException e) {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while(!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if(filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public void printLine(int i) {
            writer.println(i);
        }

    }
}

