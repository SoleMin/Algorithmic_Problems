import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
// import static java.util.Collections.sort;
import static java.util.Comparator.comparingInt;

public class Main {
    FastScanner in;
    PrintWriter out;

    private void solve() throws IOException {
        solveA();
        // solveB();
        // solveC();
        // solveD();
        // solveE();
        // solveF();
    }

    private void solveA() throws IOException {
        int n = in.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            String s = in.next();
            map.put(s, map.getOrDefault(s, 0) - 1);
        }
        long ans = 0;
        for (String i : map.keySet())
            ans += abs(map.get(i));
        out.println(ans / 2);
    }

    private void solveB() throws IOException {
        int n = in.nextInt();
        int time = (int) 1e9, ans = -1;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt() - i;
            if ((a + (n - 1)) / n < time) {
                time = (a + (n - 1)) / n;
                ans = i;
            }
        }
        out.println(ans + 1);
    }

    class PairC {
        int i, j;

        PairC(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return "(" + i + ", " + j + ")";
        }
    }

    private void solveC() throws IOException {
        int n = in.nextInt(), k = in.nextInt();
        int[][] a = new int[4][n];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = in.nextInt() - 1;

        int[] empty = new int[4];

        PairC[] from = new PairC[k];
        for (int i = 1; i < 3; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] != -1)
                    from[a[i][j]] = new PairC(i, j);
                else
                    empty[i]++;

        PairC[] to = new PairC[k];
        for (int i = 0; i < 4; i += 3)
            for (int j = 0; j < n; j++)
                if (a[i][j] != -1)
                    to[a[i][j]] = new PairC(i, j);

        out.println(Arrays.toString(from));
        out.println(Arrays.toString(to));

        ArrayList<int[]> ans = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if (abs(from[i].i - to[i].i) == 1) {
                if (from[i].j == to[i].j) {
                    ans.add(new int[]{i, to[i].i, to[i].j});
                    a[from[i].i][from[i].j] = 0;
                    empty[from[i].i]++;
                    cnt++;
                }
            } else if (from[i].j == to[i].j && a[(from[i].i + to[i].i) / 2][to[i].j] == 0) {
                ans.add(new int[]{i, (from[i].i + to[i].i) / 2, to[i].j});
                ans.add(new int[]{i, to[i].i, to[i].j});
                a[from[i].i][from[i].j] = 0;
                empty[from[i].i]++;
                cnt++;
            }
        }

        for (int i = 1; i < 3; i++) {
            if (empty[i] > 0) {
                for (int j = 0; j < k; j++) {
                    if (from[j].i == i && true) {

                    }
                }
            }
        }


        while (true) {
            boolean flag = false;

            for (int i = 0; i < k; i++) {
                if (abs(from[i].i - to[i].i) == 1 && abs(from[i].j - to[i].j) <= empty[i]) {

                }
            }

            if (!flag)
                break;
        }

        if (cnt == k) {
            out.println(ans.size());
            for (int[] i : ans) {
                for (int j : i)
                    out.print(j + 1 + " ");
                out.println();
            }
        } else
            out.println(-1);
    }

    private void solveD() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n * 2];
        for (int i = 0; i < n * 2; i++)
            a[i] = in.nextInt();
        long ans = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            int j = i + 1;
            while (a[i] != a[j])
                j++;
            ans += j - i - 1;
            while (j > i + 1)
                a[j] = a[--j];
        }
        out.println(ans);
    }

    class PairE implements Comparable<PairE> {
        long x, y;
        int id;
        boolean b;

        PairE(long x, long y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
            b = false;
        }

        @Override
        public int compareTo(PairE o) {
            return x != o.x ? Long.compare(x, o.x) : Long.compare(y, o.y);
        }
    }

    private void solveE() throws IOException {
        int n = in.nextInt();
        PairE[] p = new PairE[n];
        for (int i = 0; i < n; i++)
            p[i] = new PairE(in.nextLong(), in.nextLong(), i);

        shuffle(p);
        sort(p);

        long X = 0, Y = 0;
        long max = 225 * (long) 1e10;
        for (int i = 0; i < n; i++) {
            if ((X + p[i].x) * (X + p[i].x) + (Y + p[i].y) * (Y + p[i].y) < (X - p[i].x) * (X - p[i].x) + (Y - p[i].y) * (Y - p[i].y)) {
                p[i].b = true;
                X += p[i].x;
                Y += p[i].y;
            } else {
                p[i].b = false;
                X -= p[i].x;
                Y -= p[i].y;
            }
        }

        sort(p, comparingInt(o -> o.id));
        for (int i = 0; i < n; i++) {
            out.print(p[i].b ? 1 : -1);
            if (i + 1 < n)
                out.print(" ");
        }
        out.println();
    }

    void shuffle(PairE[] a) {
        PairE b;
        Random r = new Random();
        for (int i = a.length - 1, j; i > 0; i--) {
            j = r.nextInt(i + 1);
            b = a[j];
            a[j] = a[i];
            a[i] = b;
        }
    }

    private void solveF() throws IOException {

    }

    class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        boolean hasNext() throws IOException {
            return br.ready() || (st != null && st.hasMoreTokens());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next().replace(',', '.'));
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        boolean hasNextLine() throws IOException {
            return br.ready();
        }
    }

    private void run() throws IOException {
        in = new FastScanner(System.in); // new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out); // new PrintWriter(new FileOutputStream(".out"));

        solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}