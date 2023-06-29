import java.io.*;
import java.util.*;

public class Example {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(in.readLine());
            } catch (Exception e) {
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    public void run() throws Exception {
        //in = new BufferedReader(new FileReader("input.txt"));
        //out = new PrintWriter(new FileWriter("output.txt"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();
        in.close();
    }
    long n, x, y, c;

    boolean check(long z) {
        long res = 1 + 2 * z * (z + 1);
        long bx1 = z - x + 1;
        long by1 = z - y + 1;
        long bxn = z - n + x;
        long byn = z - n + y;

        if (bx1 > 0) {
            res -= bx1 * bx1;
        }
        if (bxn > 0) {
            res -= bxn * bxn;
        }
        if (by1 > 0) {
            res -= by1 * by1;
        }
        if (byn > 0) {
            res -= byn * byn;
        }

        if (z > x + y - 1) {
            long m = z - x - y + 1;
            res += m * (m + 1) / 2;
        }
        if (z > x + n - y) {
            long m = z - x - n + y;
            res += m * (m + 1) / 2;
        }
        if (z > n - x + y) {
            long m = z - n - y + x;
            res += m * (m + 1) / 2;
        }
        if (z > n - x + n - y + 1) {
            long m = z - 2 * n + x + y - 1;
            res += m * (m + 1) / 2;
        }
        
        return res >= c;
    }

    public void solve() throws Exception {
        n = nextLong();
        x = nextLong();
        y = nextLong();
        c = nextLong();
        long l = 0;
        long r = 2 * n;
        while (r > l) {
            long mid = (r + l) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        out.println(r);
    }

    public static void main(String[] args) throws Exception {
        new Example().run();
    }
}