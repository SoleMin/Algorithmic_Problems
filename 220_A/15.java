import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.Line2D;
import java.awt.Point;
import static java.lang.reflect.Array.*;

public class LittleElephantAndProblem {

    boolean DEBUG = true;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();
    StringTokenizer st = null;

    String s() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int i() throws IOException {
        return Integer.parseInt(s());
    }

    int i(String s) throws IOException {
        return Integer.parseInt(s);
    }

    long l() throws IOException {
        return Long.parseLong(s());
    }

    long l(String s) throws IOException {
        return Long.parseLong(s);
    }

    double d() throws IOException {
        return Double.parseDouble(s());
    }

    double d(String s) throws IOException {
        return Double.parseDouble(s);
    }

    void D(Object a) {
        if (DEBUG) {
            int len = getLength(a);
            for (int i = 0; i < len; ++i) {
                System.out.print(get(a, i) + " ");
            }
            System.out.println();
        }
    }

    void D(Object[] a) {
        if (DEBUG) {
            int R = getLength(a), C = getLength(get(a, 0));
            for (int i = 0; i < R; ++i) {
                for (int j = 0; j < C; ++j) {
                    System.out.print(get(get(a, i), j) + " ");
                }
                System.out.println();
            }
        }
    }

    void D(String args) {
        if (DEBUG) {
            System.out.print(args);
        }
    }

    void D(String format, Object... args) {
        if (DEBUG) {
            System.out.printf(format, args);
        }
    }

    void fl() {
        System.out.print(out);
    }
    int n = i();

    public LittleElephantAndProblem() throws IOException {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = i();
            a.add(x);
            b.add(x);
        }
        sort(b);
        int d = 0;
        for (int i = 0; i < n; ++i) {
            if ((int)a.get(i) != (int)b.get(i)) {
                ++d;
            }
        }
        if (d > 2) {
            out.append("NO\n");
        } else {
            out.append("YES\n");
        }
        fl();
    }

    public static void main(String[] args) throws IOException {
        new LittleElephantAndProblem();
    }
}