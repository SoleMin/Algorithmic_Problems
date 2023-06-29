import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("input.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        CFireAgain solver = new CFireAgain();
        solver.solve(1, in, out);
        out.close();
    }

    static class CFireAgain {
        private int n;
        private int m;
        private int K;
        private boolean[][] vis;
        private Queue<Util.Pair<Integer>> queue = new LinkedList<>();
        private Util.Pair<Integer> p;

        private boolean isValid(int x, int y) {
            return x >= 1 && x <= n && y >= 1 && y <= m && !vis[x][y];
        }

        private void bfs() {
            while (!queue.isEmpty()) {
                p = queue.poll();
                if (isValid(p.x + 1, p.y)) {
                    queue.offer(new Util.Pair<>(p.x + 1, p.y));
                    vis[p.x + 1][p.y] = true;
                }
                if (isValid(p.x - 1, p.y)) {
                    queue.offer(new Util.Pair<>(p.x - 1, p.y));
                    vis[p.x - 1][p.y] = true;
                }
                if (isValid(p.x, p.y + 1)) {
                    queue.offer(new Util.Pair<>(p.x, p.y + 1));
                    vis[p.x][p.y + 1] = true;
                }
                if (isValid(p.x, p.y - 1)) {
                    queue.offer(new Util.Pair<>(p.x, p.y - 1));
                    vis[p.x][p.y - 1] = true;
                }
            }
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            K = in.nextInt();
            vis = new boolean[n + 1][m + 1];
            for (int i = 0; i < K; i++) {
                int a = in.nextInt(), b = in.nextInt();
                vis[a][b] = true;
                queue.offer(new Util.Pair<>(a, b));
            }
            bfs();
            out.println(p.x + " " + p.y);
            out.flush();
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;
        private ArrayList<String> res = new ArrayList<>();
        private StringBuilder sb = new StringBuilder("");

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                sb.append(objects[i]);
            }
            res.add(sb.toString());
            sb = new StringBuilder("");
        }

        public void close() {
//        writer.flush();
            writer.close();
        }

        public void flush() {
            for (String str : res) writer.printf("%s\n", str);
            res.clear();
            sb = new StringBuilder("");
        }

    }

    static class Util {
        public static class Pair<T> {
            public T x;
            public T y;

            public Pair(T x, T y) {
                this.x = x;
                this.y = y;
            }

            public boolean equals(Object obj) {
                if (obj == this) return true;
                if (!(obj instanceof Util.Pair)) return false;
                Util.Pair<T> pair = (Util.Pair<T>) obj;
                return this.x == pair.x && this.y == pair.y;
            }

            public String toString() {
                return ("(" + this.x + "," + this.y + ")");
            }

            public int hashCode() {
                return Objects.hash(x, y);
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public InputReader(FileInputStream file) {
            this.stream = file;
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
                res = (res << 3) + (res << 1) + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

