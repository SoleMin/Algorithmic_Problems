
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

    public int sub(int a, int b) {
        int res = 0;
        while (b > 0) {
            res += a / b;
            int m = a % b;
            a = b;
            b = m;
        }
        return res;
    }

    public void solve() throws Exception {
        int n = nextInt();
        while (n-- > 0) {
            out.println(sub(nextInt(), nextInt()));
        }
    }

    public static void main(String[] args) throws Exception {
        new Template().run();
    }
}
