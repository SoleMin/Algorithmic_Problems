import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main implements Runnable {
    private BufferedReader br;
    private StringTokenizer tok;
    private PrintWriter out;

    static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    int[] a;
    int[] b;
    int[] p;

    int getCeils(int id, int step) {
        if (step > a[id] + b[id] - 1) {
            return 0;
        }
        if (a[id] < b[id]) {
            if (step < a[id]) {
                return step;
            }
            if (step >= a[id] && step <= b[id]) {
                return a[id];
            }
            ++p[id];
            return a[id] - p[id];
        } else {
            if (step < b[id]) {
                return step;
            }
            if (step >= b[id] && step <= a[id]) {
                return b[id];
            }
            ++p[id];
            return b[id] - p[id];
        }
    }

    void solve() throws IOException {
        int n = nextInt(), x = nextInt(), y = nextInt(), c = nextInt();
        long s = 1;
        int step = 0;
        a = new int[4];
        b = new int[4];
        p = new int[4];
        a[0] = x - 1; b[0] = n - y;
        a[1] = x - 1; b[1] = y - 1;
        a[2] = n - x; b[2] = y - 1;
        a[3] = n - x; b[3] = n - y;
        int xf = x + 1, xb = x - 1, yf = y + 1, yb = y - 1;
        while (s < c) {
            ++step;
            if (xf <= n) {
                ++s;
                ++xf;
            }
            if (xb > 0) {
                ++s;
                --xb;
            }
            if (yf <= n) {
                ++s;
                ++yf;
            }
            if (yb > 0) {
                ++s;
                --yb;
            }
            if (step == 1) {
                continue;
            }
            for (int i = 0; i < 4; ++i) {
                s += getCeils(i, step - 1);
            }
        }
        out.println(step);
    }

    public void run() {
        try {
            if (ONLINE_JUDGE) {
                br = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                br = new BufferedReader(new FileReader(new File("input.txt")));
                out = new PrintWriter(new File("output.txt"));
            }
            solve();
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens())
            tok = new StringTokenizer(br.readLine());
        return tok.nextToken();
    }

    String nextString() throws IOException {
        return nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }
}
