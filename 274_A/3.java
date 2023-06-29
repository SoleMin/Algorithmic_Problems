
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
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        boolean[] ok = new boolean[n];
        Arrays.fill(ok, true);
        Arrays.sort(a);
        if (k != 1) {
            for (int i = 0; i < n; i++) {
                if (a[i] % k == 0) {
                    int x = a[i] / k;
                    int ind = Arrays.binarySearch(a, x);
                    if (ind >= 0 && ok[ind]) {
                        ok[i] = false;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ok[i]) {
                ans++;
            }
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Template().run();
    }
}
