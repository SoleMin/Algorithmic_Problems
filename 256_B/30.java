import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class taskB {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        taskB solver = new taskB();
        solver.open();
        long time = System.currentTimeMillis();
        solver.solve();
        if (!"true".equals(System.getProperty("ONLINE_JUDGE"))) {
            System.out.println("Spent time: "
                    + (System.currentTimeMillis() - time));
            System.out.println("Memory: "
                    + (Runtime.getRuntime().totalMemory() - Runtime
                    .getRuntime().freeMemory()));
        }
        solver.close();
    }

    public void open() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null)
                return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    long n, x, y, c;

    long sq(long n) {
        if (n <= 0) return 0;
        return n * n;
    }

    long lrsp(long len, long max) {
        long cnt = Math.min(len, max);
        long arpr = (1 + cnt) * cnt / 2;
        if (len > max) arpr += (len - max) * max;
        return arpr;
    }

    long onn(long len) {
        long up, down, left, right;
        long toup = x - 1, todown = n - x, toleft = y - 1, toright = n - y;
        left = Math.min(toleft, len);
        right = Math.min(toright, len);
        down = up = sq(len);
        up -= sq(len - toup);
        down -= sq(len - todown);
        len--;
        if (toright < len) {
            up -= lrsp(len - toright, toup);
            down -= lrsp(len - toright, todown);
        }
        if (toleft < len) {
            up -= lrsp(len - toleft, toup);
            down -= lrsp(len - toleft, todown);
        }

        return 1 + up + down + left + right;
    }

    public void solve() throws NumberFormatException, IOException {
        n = nextInt();
        x = nextInt();
        y = nextInt();
        c = nextInt();
        long down = 0, up = 2 * n + 13;
        while (up - down > 2) {
            long tmp = (up + down) / 2;
            if (onn(tmp) >= c) up = tmp;
            else down = tmp;
        }
        if (onn(down) >= c) out.println(down);
        else if (onn(down + 1) >= c) out.println(down + 1);
        else if (onn(down + 2) >= c) out.println(down + 2);
        else out.println(down + 3);
    }

    public void close() {
        out.flush();
        out.close();
    }
}