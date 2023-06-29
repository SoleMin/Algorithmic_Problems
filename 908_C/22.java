import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.io.BufferedOutputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aeroui
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Kattio in = new Kattio(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Kattio in, PrintWriter out) {
            int n = in.nextInt();
            int r = in.nextInt();

            double[] xs = new double[n];
            double[] ys = new double[n];
            TreeSet<TaskC.Pair> set = new TreeSet<>();
            for (int i = 0; i < n; ++i) {
                xs[i] = in.nextDouble();
                ys[i] = (double) Integer.MIN_VALUE;

                if (i == 0) { // the first one
                    out.printf("%f", (double) r);
                    ys[i] = (double) r;
                    set.add(new TaskC.Pair(xs[i], ys[i]));
                } else {
                    for (TaskC.Pair p : set) {
                        double maximum = p.x;
                        double diffX = (xs[i] - maximum) * (xs[i] - maximum);

                        if (diffX <= r * r * 4.0) {
                            ys[i] = Math.max(ys[i], p.y + Math.sqrt(r * r * 4.0 - diffX));
                            continue;
                        }
                    }

                    if (ys[i] < 0)
                        ys[i] = (double) r;

                    set.add(new TaskC.Pair(xs[i], ys[i]));
                    out.printf(" %f", ys[i]);
                }
            }

        }

        private static class Pair implements Comparable<TaskC.Pair> {
            double x;
            double y;

            public Pair(double x, double y) {
                this.x = x;
                this.y = y;
            }


            public int compareTo(TaskC.Pair p) {
                if (this.y - p.y < 0)
                    return 1;

                return -1;
            }

        }

    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }

    }
}

