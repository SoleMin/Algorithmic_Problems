import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 29);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            BSearchingRectangles solver = new BSearchingRectangles();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class BSearchingRectangles {
        FastInput in;
        FastOutput out;
        int n;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            this.in = in;
            this.out = out;
            n = in.readInt();

            IntBinarySearch upDown = new IntBinarySearch() {

                public boolean check(int mid) {
                    return query(1, n, 1, mid) >= 1;
                }
            };

            IntBinarySearch leftRight = new IntBinarySearch() {

                public boolean check(int mid) {
                    return query(1, mid, 1, n) >= 1;
                }
            };
            int threshold = upDown.binarySearch(1, n);
            int[] r1;
            int[] r2;
            if (query(1, n, 1, threshold) == 1 &&
                    query(1, n, threshold + 1, n) == 1) {
                r1 = find(1, n, 1, threshold);
                r2 = find(1, n, threshold + 1, n);
            } else {
                threshold = leftRight.binarySearch(1, n);
                r1 = find(1, threshold, 1, n);
                r2 = find(threshold + 1, n, 1, n);
            }

            out.append("! ");
            output(r1);
            output(r2);
            out.flush();
        }

        public void output(int[] ans) {
            for (int x : ans) {
                out.append(x).append(' ');
            }
        }

        public int[] find(int l, int r, int d, int u) {
            IntBinarySearch downIBS = new IntBinarySearch() {

                public boolean check(int mid) {
                    return query(l, r, mid, u) == 0;
                }
            };
            int y1 = downIBS.binarySearch(d, u);
            if (query(l, r, y1, u) == 0) {
                y1--;
            }

            IntBinarySearch upIBS = new IntBinarySearch() {

                public boolean check(int mid) {
                    return query(l, r, d, mid) >= 1;
                }
            };
            int y2 = upIBS.binarySearch(d, u);

            IntBinarySearch leftIBS = new IntBinarySearch() {

                public boolean check(int mid) {
                    return query(mid, r, d, u) == 0;
                }
            };
            int x1 = leftIBS.binarySearch(l, r);
            if (query(x1, r, d, u) == 0) {
                x1--;
            }

            IntBinarySearch rightIBS = new IntBinarySearch() {

                public boolean check(int mid) {
                    return query(l, mid, d, u) >= 1;
                }
            };
            int x2 = rightIBS.binarySearch(l, r);

            return new int[]{x1, y1, x2, y2};
        }

        public int query(int l, int r, int d, int u) {
            if (l > r || d > u) {
                return 0;
            }
            out.printf("? %d %d %d %d", l, d, r, u).println().flush();
            return in.readInt();
        }

    }

    static class DigitUtils {
        private DigitUtils() {
        }

        public static int floorAverage(int x, int y) {
            return (x & y) + ((x ^ y) >> 1);
        }

    }

    static abstract class IntBinarySearch {
        public abstract boolean check(int mid);

        public int binarySearch(int l, int r) {
            if (l > r) {
                throw new IllegalArgumentException();
            }
            while (l < r) {
                int mid = DigitUtils.floorAverage(l, r);
                if (check(mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

    }

    static class FastInput {
        private final InputStream is;
        private byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(int c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            return this;
        }

        public FastOutput printf(String format, Object... args) {
            cache.append(String.format(format, args));
            return this;
        }

        public FastOutput println() {
            cache.append(System.lineSeparator());
            return this;
        }

        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public String toString() {
            return cache.toString();
        }

    }
}

