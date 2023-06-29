import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Vadim
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int T = in.ni();
            for (int t = 0; t < T; t++) {
                long n = in.nl(), k = in.nl();
                if (n == 2 && k == 3) {
                    out.println("NO");
                    continue;
                }

                boolean possible = false;
                long size = n;
                long rem = k;
                for (int i = 0; i <= 31 && size > 0 && rem > 0; i++) {
                    long splits = 1L << (i * 2);
                    //System.out.println("splits = " + splits);
                    rem -= splits;
                    size--;
                }
                if (rem > 0) {
                    //System.out.println("rem = " + rem);
                    out.println("NO");
                    continue;
                }
                long path = 1;
                long i = 0;
                size = n;
                long ans = 0;

                while (path <= k && size > 0) {
                    //System.out.printf("path=%d k=%d size=%d%n", path, k, size);
                    k -= path;
                    path = (1L << i + 2) - 1;
                    size--;
                    i++;
                }

                //System.out.printf("size=%d k=%d%n", size, k);
                out.println("YES " + size);


            }
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

        public long nl() {
            return Long.parseLong(ns());
        }

    }
}

