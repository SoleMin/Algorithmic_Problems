import java.io.*;
import java.util.*;

public class B {

    int n, k, a;
    int[] b, l;

    double best;

    double calc(int i, int r, int c, double p) {
        if (i == n) {
            if (c <= n / 2) {
                p *= 1.0 * a / (a + r);
            }
            return p;
        } else {
            return calc(i + 1, r, c + 1, p * l[i] / 10.0) + calc(i + 1, r + b[i], c, p * (10 - l[i]) / 10.0);
        }
    }

    void go(int i, int k) {
        if (i == n) {
            double p = calc(0, 0, 0, 1.0);
            if (p > best) best = p;
        } else {
            for (int c = 0; c <= k && l[i] + c <= 10; ++c) {
                l[i] += c;
                go(i + 1, k - c);
                l[i] -= c;
            }
        }
    }

    void solve() throws IOException {
        in("__std"); out("__std");

        n = readInt();
        k = readInt();
        a = readInt();
        b = new int[n];
        l = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i] = readInt();
            l[i] = readInt() / 10;
        }

        go(0, k);

        println("%.10f", best);

        exit();
    }

    void in(String name) throws IOException {
        if (name.equals("__std")) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(name));
        }
    }

    void out(String name) throws IOException {
        if (name.equals("__std")) {
            out = new PrintWriter(System.out);
        } else {
            out = new PrintWriter(name);
        }
    }

    void exit() {
        out.close();
        System.exit(0);
    }

    int readInt() throws IOException {
        return Integer.parseInt(readToken());
    }

    long readLong() throws IOException {
        return Long.parseLong(readToken());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readToken());
    }

    String readLine() throws IOException {
        st = null;
        return in.readLine();
    }

    String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    boolean eof() throws IOException {
        return !in.ready();
    }

    void print(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void println(String format, Object ... args) {
        out.println(new Formatter().format(format, args));
    }

    void print(Object value) {
        out.print(value);
    }

    void println(Object value) {
        out.println(value);
    }

    void println() {
        out.println();
    }

    StringTokenizer st;

    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new B().solve();
    }
}
