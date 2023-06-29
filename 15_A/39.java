import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    static class Pair implements Comparable<Pair> {
        int x, a;

        Pair(int x, int a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return 0;
        }
    }

    boolean isCross(double l1, double r1, double l2, double r2) {
        double r = min(r1, r2);
        double l = max(l1, l2);
        return r > l;
    }

    boolean check(double xl, double xr, double[] l, double[] r, int n) {
        boolean ok = false;
        for (int j = 0; j < n; ++j)
            ok |= isCross(xl, xr, l[j], r[j]);
        return ok;
    }

    void solve() throws IOException {
        int n = ni();
        double t = ni();
        double[] l = new double[n];
        double[] r = new double[n];
        for (int i = 0; i < l.length; i++) {
            double x = ni();
            double len = ni();
            l[i] = x - len / 2.0;
            r[i] = x + len / 2.0;
        }
        HashSet<Double> set = new HashSet<Double>();
        for (int i = 0; i < n; ++i) {
            double xl = l[i] - t;
            double xr = l[i];
            boolean ok = check(xl, xr, l, r, n);
            if (!ok)
                set.add(xl);
            xl = r[i];
            xr = r[i] + t;
            ok = check(xl, xr, l, r, n);
            if (!ok)
                set.add(xl);

        }
        out.println(set.size());
    }

    public Solution() throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    String ns() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int ni() throws IOException {
        return Integer.valueOf(ns());
    }

    long nl() throws IOException {
        return Long.valueOf(ns());
    }

    double nd() throws IOException {
        return Double.valueOf(ns());
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
