import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            Debug debug = new Debug(out);
            int n = in.nextInt();
            TaskC.Circle[] c = new TaskC.Circle[n];
            double rr = in.nextInt();
            for (int i = 0; i < n; ++i) {
                c[i] = new TaskC.Circle();
                c[i].x = in.nextInt();
            }
            ArrayList<TaskC.Circle> done = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TaskC.Circle cur = c[i];
                double ans = Double.MIN_VALUE;
                for (int j = 0; j < done.size(); ++j) {
                    TaskC.Circle dd = done.get(j);
                    if (Double.compare(2 * rr, Math.abs(dd.x - cur.x)) < 0) continue;
                    double temp = Math.sqrt(4 * rr * rr - (cur.x - dd.x) * (cur.x - dd.x)) + dd.y;
                    ans = Math.max(ans, temp);
                }
                if (ans == Double.MIN_VALUE)
                    ans = rr;
                cur.y = ans;
                done.add(cur);
            }
            for (TaskC.Circle cc : done) {
                out.printf("%.12f ", cc.y);
            }
        }

        static class Circle implements Comparable<TaskC.Circle> {
            double x;
            double y;


            public boolean equals(Object o) {
                if (o == null) return false;
                if (o == this) return true;
                if (o.getClass() != this.getClass()) return false;

                TaskC.Circle c = (TaskC.Circle) o;
                return Double.compare(x, c.x) == 0 && Double.compare(y, c.y) == 0;
            }


            public int compareTo(TaskC.Circle o) {
                if (Double.compare(o.x, x) != 0) {
                    return Double.compare(x, o.x);
                }
                return Double.compare(y, o.y);
            }

        }

    }

    static class Debug {
        PrintWriter out;
        boolean oj;
        long timeBegin;
        Runtime runtime;

        public Debug(PrintWriter out) {
            oj = System.getProperty("ONLINE_JUDGE") != null;
            this.out = out;
            this.timeBegin = System.currentTimeMillis();
            this.runtime = Runtime.getRuntime();
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

