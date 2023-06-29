import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("1"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        solve();

        in.close();
        out.close();
    }

    private static void solve() throws Exception {
        int n = nextInt();
        boolean[] use = new boolean[500];
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int v = nextInt();
            if (!use[250 + v]) {
                use[250 + v] = true;
                a.add(v);
            }
        }
        Collections.sort(a);
        if (a.size() < 2) {
            out.println("NO");
        } else {
            out.println(a.get(1));
        }
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    static String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextString());
    }
}
