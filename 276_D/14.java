
// @author Sanzhar
import java.io.*;
import java.util.*;
import java.awt.Point;

public class Template {

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

    public void solve() throws Exception {
        long l = nextLong();
        long r = nextLong();
        long[] x = new long[100];
        int kx = 0;
        while (r > 0) {
            x[kx++] = r % 2;
            r /= 2;
        }
        long[] y = new long[100];
        int ky = 0;
        while (l > 0) {
            y[ky++] = l % 2;
            l /= 2;
        }
        long[] ans = new long[100];
        boolean ok = false;
        for (int k = kx - 1; k >= 0; k--) {
            if (ok) {
                ans[k] = 1;
                continue;
            }
            if (x[k] > y[k]) {
                ans[k] = 1;
                ok = true;
            }
        }
        long a = 0;
        long p2 = 1;
        for (int i = 0; i < kx; i++) {
            a += p2 * ans[i];
            p2 *= 2;
        }
        out.println(a);
    }

    public static void main(String[] args) throws Exception {
        new Template().run();
    }
}
