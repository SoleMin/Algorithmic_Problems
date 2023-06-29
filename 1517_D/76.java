import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class D {

    private static void run() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][][] map = new int[n][m][4];

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                int len = in.nextInt();
                edges.add(new Edge(new Point[]{new Point(i, j), new Point(i, j + 1)}, len));
                map[i][j][2] = map[i][j + 1][3] = len;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int len = in.nextInt();
                edges.add(new Edge(new Point[]{new Point(i, j), new Point(i + 1, j)}, len));
                map[i][j][0] = map[i + 1][j][1] = len;
            }
        }
        if (p % 2 != 0) {
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                ans[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                print_array(ans);
            }
            return;
        }

        edges.sort(Comparator.comparingInt(o -> o.len));

        int[][][] dp = new int[2][n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 4; k++) {
                    if (map[i][j][k] == 0) continue;
                    min = Math.min(min, map[i][j][k]);
                }
                dp[1][i][j] = min * 2;
            }
        }

        for (int k = 2; k <= p / 2; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[k & 1][i][j] = Integer.MAX_VALUE;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                        dp[k & 1][i][j] = Math.min(dp[(k - 1) & 1][nx][ny] + map[i][j][d] * 2, dp[k&1][i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            print_array(dp[(p / 2) & 1][i]);
        }
    }

    static class Edge {
        Point[] points;
        int len;

        public Edge(Point[] points, int len) {
            this.points = points;
            this.len = len;
        }
    }

    static class Point {
        final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        in = new Reader();
        out = new PrintWriter(new OutputStreamWriter(System.out));

//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//        }
        run();

        out.flush();
        in.close();
        out.close();
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        while (b != 0) {
            int tmp;
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    static final long mod = 1000000007;

    static long pow_mod(long a, long b) {
        long result = 1;
        while (b != 0) {
            if ((b & 1) != 0) result = (result * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }

    private static long multiplied_mod(long... longs) {
        long ans = 1;
        for (long now : longs) {
            ans = (ans * now) % mod;
        }
        return ans;
    }

    @SuppressWarnings("FieldCanBeLocal")
    private static Reader in;
    private static PrintWriter out;

    private static void print_array(int[] array) {
        for (int now : array) {
            out.print(now);
            out.print(' ');
        }
        out.println();
    }

    private static void print_array(long[] array) {
        for (long now : array) {
            out.print(now);
            out.print(' ');
        }
        out.println();
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            final byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextSign() throws IOException {
            byte c = read();
            while ('+' != c && '-' != c) {
                c = read();
            }
            return '+' == c ? 0 : 1;
        }

        private static boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() throws IOException {
            int b;
            // noinspection ALL
            while ((b = read()) != -1 && isSpaceChar(b)) {
                ;
            }
            return b;
        }

        public char nc() throws IOException {
            return (char) skip();
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }

    }
}