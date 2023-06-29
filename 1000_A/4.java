import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author bacali
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ACodehorsesTShirts solver = new ACodehorsesTShirts();
        solver.solve(1, in, out);
        out.close();
    }

    static class ACodehorsesTShirts {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String ch = in.next();
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            int s = n;
            for (int i = 0; i < n; i++) {
                String ch = in.next();
                if (map.containsKey(ch)) {
                    if (map.get(ch) == 1) {
                        map.remove(ch);
                    } else {
                        map.put(ch, map.get(ch) - 1);
                    }
                    s--;
                }
            }
            out.println(s);
        }

    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

