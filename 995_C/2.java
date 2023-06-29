import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author kessido
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CLeavingTheBar solver = new CLeavingTheBar();
        solver.solve(1, in, out);
        out.close();
    }

    static class CLeavingTheBar {
        private double[] p11 = new double[2];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.NextInt();
            long[][] vector = in.NextLongMatrix(n, 2);
            ArrayList<Integer> order = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                order.add(i);
            }
            long[] origin = new long[2];
            int run = 0;
            while (true) {
                long[] cur = new long[2];
                Collections.shuffle(order);
                if (run == 0) order.sort(Comparator.comparingDouble(o -> -dist(vector[o], origin)));
                int[] result = new int[n];
                for (int i : order) {
                    result[i] = choose(cur, vector[i]);
                }
                run++;
                if (dist(cur, origin) > 1.5 * 1e6) {
                    continue;
                }

                for (int i = 0; i < n; i++) {
                    out.print(result[i] + " ");
                }
                out.println();
                break;
            }
        }

        int choose(long[] cur, long[] v) {
            double m1, m2;
            m1 = dist(cur, v);
            v[0] *= -1;
            v[1] *= -1;
            m2 = dist(cur, v);
            if (m1 < m2) {
                cur[0] -= v[0];
                cur[1] -= v[1];
                return 1;
            } else {
                cur[0] += v[0];
                cur[1] += v[1];
                return -1;
            }
        }

        private double dist(long[] cur, long[] v) {
            p11[0] = cur[0] + v[0];
            p11[1] = cur[1] + v[1];
            p11[0] *= p11[0];
            p11[1] *= p11[1];
            return Math.sqrt(p11[0] + p11[1]);
        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int NextInt() {
            return Integer.parseInt(next());
        }

        public long NextLong() {
            return Long.parseLong(next());
        }

        public long[][] NextLongMatrix(int n, int m) {
            return NextLongMatrix(n, m, 0);
        }

        public long[][] NextLongMatrix(int n, int m, int offset) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = NextLong() + offset;
                }
            }
            return a;
        }

    }
}

