import java.io.IOException;
import java.io.InputStream;
import java.util.SortedSet;
import java.util.TreeSet;

public class A274 {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        int N = reader.readInt();
        int K = reader.readInt();
        if (K == 1) {
            System.out.println(N);
            return;
        }
        SortedSet<Integer> set = new TreeSet<Integer>();
        for (int n=0; n<N; n++) {
            int value = reader.readInt();
            set.add(value);
        }
        int count = 0;
        while (!set.isEmpty()) {
            count++;
            Integer value = set.first();
            set.remove(value);
            long multiple = K*(long)value;
            if (multiple <= 1000000000L) {
                set.remove((int)multiple);
            }
        }
        System.out.println(count);
    }

    static final class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public final int readInt() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return negative ? -res : res;
        }

        public final long readLong() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return negative ? -res : res;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

}
