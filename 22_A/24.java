import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    void solve() throws IOException {
        int n = ni();
        int[] v = new int[n];
        for (int i = 0; i < n; ++i)
            v[i] = ni();
        Arrays.sort(v);
        int mn = v[0];
        for (int i = 1; i < n; ++i)
            if (v[i] > mn) {
                out.println(v[i]);
                return;
            }
        out.println("NO");
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
