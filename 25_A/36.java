import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        int co = 0, ce = 0;
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (v[i] % 2 == 0) {
                co++;
            } else {
                ce++;
            }
        }
        if (co == 1) {
            for (int i = 0; i < n; i++) {
                if (v[i] % 2 == 0) {
                    out.println(i + 1);
                    return;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (v[i] % 2 != 0) {
                    out.println(i + 1);
                    return;
                }
            }
        }
    }

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer st;

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
