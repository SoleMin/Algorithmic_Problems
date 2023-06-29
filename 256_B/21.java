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
 * @author Alex
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        int n;
        int startrow;
        int startcol;
        long want;

        boolean check(long time) {
            long max = (long) 2 * time * (time + 1) + 1;
            long highest = startrow - time;
            if(highest < 0) {
                max -= Math.abs(highest) * Math.abs(highest);
            }
            long lowest = startrow + time;
            if(lowest >= n) {
                max -= Math.abs(lowest - n + 1) * Math.abs(lowest - n + 1);
            }
            long leftmost = startcol - time;
            if(leftmost < 0) {
                max -= Math.abs(leftmost) * Math.abs(leftmost);
            }
            long rightmost = startcol + time;
            if(rightmost >= n) {
                max -= Math.abs(rightmost - n + 1) * Math.abs(rightmost - n + 1);
            }
            long upperright = time - (startrow + 1) - (n - startcol);
            if(upperright >= 0) {
                max += (upperright + 1) * (upperright + 2) / 2;
            }
            long lowerright = time - (n - startrow) - (n - startcol);
            if(lowerright >= 0) {
                max += (lowerright + 1) * (lowerright + 2) / 2;
            }
            long upperleft = time - (startrow + 1) - (startcol + 1);
            if(upperleft >= 0) {
                max += (upperleft + 1) * (upperleft + 2) / 2;
            }
            long lowerleft = time - (n - startrow) - (startcol + 1);
            if(lowerleft >= 0) {
                max += (lowerleft + 1) * (lowerleft + 2) / 2;
            }
            return max >= want;
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.readInt();
            startrow = in.readInt() - 1;
            startcol = in.readInt() - 1;
            want = in.readLong();
            long low = 0, high = 2 * n;
            while(low < high) {
                long mid = (low + high) / 2;
                if(check(mid)) high = mid;
                else low = mid + 1;
            }
            out.printLine(low);
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

        public long readLong() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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

        public void printLine(long i) {
            writer.println(i);
        }

    }
}

