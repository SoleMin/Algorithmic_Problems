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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int r = in.nextInt();
            int[] xs = new int[n];
            for (int i = 0; i < n; i++) xs[i] = in.nextInt();
            double[] ys = new double[n];
            for (int i = 0; i < n; i++) {
                int x = xs[i];
                double y = r;
                for (int j = 0; j < i; j++) {
                    y = Math.max(y, calc(xs[j], ys[j], x, r));
                }
                ys[i] = y;
            }
            for (int i = 0; i < n; i++) {
                out.printf("%.10f ", ys[i]);
            }
            out.println();
        }

        private double calc(int x, double y, int x1, int r) {
            int dx = Math.abs(x - x1);
            if (dx > 2 * r) return 0;
            double dy = Math.sqrt(4 * r * r - dx * dx);
            return y + dy;
        }

    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in), 32768);
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (st == null || !st.hasMoreTokens()) {
                String s = nextLine();
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        public String next() {
            hasNext();
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

