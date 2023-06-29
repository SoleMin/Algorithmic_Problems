import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        DPairOfLines solver = new DPairOfLines();
        solver.solve(1, in, out);
        out.close();
    }

    static class DPairOfLines {
        int n;
        Point[] arr;

        public void readInput(Scanner sc) {
            n = sc.nextInt();
            arr = new Point[n];
            for (int i = 0; i < n; i++)
                arr[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = 1;
            while (q-- > 0) {
                readInput(sc);
                if (n <= 4) {
                    pw.println("YES");
                    return;
                }
                boolean f = false;
                for (int i = 0; i < 150; i++) {
                    int rand = (int) (Math.random() * n);
                    int rand2 = (int) (Math.random() * n);
                    if (rand == rand2)
                        continue;
                    boolean[] out = new boolean[n];
                    int c = 0;
                    int first = -1, second = -1;
                    for (int j = 0; j < n; j++) {
                        if (j == rand || j == rand2)
                            continue;
                        if (!arr[j].onLine(arr[rand], arr[rand2])) {
                            c++;
                            out[j] = true;
                            if (first == -1)
                                first = j;
                            else if (second == -1)
                                second = j;
                        }
                    }
                    if (c <= 2)
                        f = true;
                    else {
                        boolean ff = true;
                        for (int j = 0; j < n; j++) {
                            if (!out[j])
                                continue;
                            if (j == first || j == second)
                                continue;
                            if (!arr[j].onLine(arr[first], arr[second]))
                                ff = false;
                        }
                        f |= ff;
                    }
                }
                pw.println(f ? "YES" : "NO");
            }
        }

        public class Point implements Comparable<Point> {
            static final double EPS = 1e-9;
            long x;
            long y;

            Point(long a, long b) {
                x = a;
                y = b;
            }

            public int compareTo(Point p) {
                if (Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
                if (Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
                return 0;
            }

            boolean onLine(Point a, Point b) {
                if (a.compareTo(b) == 0) return compareTo(a) == 0;
                Point temp = new Point(b.x - a.x, b.y - a.y);
                Point temp2 = new Point(this.x - a.x, this.y - a.y);
                return Math.abs(temp.x * temp2.y - temp.y * temp2.x) < EPS;
            }

        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

