import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.TreeMap;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
import static java.util.Collections.reverse;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class Main {
    private FastScanner in;
    private PrintWriter out;

    private void solve() throws IOException {
        solveC();
    }

    private void solveA() throws IOException {
        HashSet<Character> set = new HashSet<>();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', '1', '3', '5', '7', '9'})
            set.add(c);
        int cnt = 0;
        for (char c : in.nextLine().toCharArray())
            if (set.contains(c))
                cnt++;
        out.println(cnt);
    }

    int n, m, cl;
    char a[][];
    int[] b;
    int fromi, fromj, toi, toj;

    private void solveB() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        char[] c;
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = in.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'S') {
                    fromi = i;
                    fromj = j;
                }
                if (a[i][j] == 'E') {
                    toi = i;
                    toj = j;
                }
            }
        }

        c = in.next().toCharArray();
        cl = c.length;
        b = new int[cl];
        for (int i = 0; i < cl; i++) {
            b[i] = c[i] - '0';
        }

        ArrayList<Long> ar1 = new ArrayList<>(), ar2 = new ArrayList<>(), ar3 = new ArrayList<>(), ar4 = new ArrayList<>();
        ar1.add((long) 12);
        ar1.add((long) 10);
        ar1.add((long) 01);
        ar1.add((long) 21);
        long[] str = new long[4];
        int ans = 0;
        for (long i : ar1) {
            str[0] = i;
            ar2.clear();
            ar2.addAll(ar1);
            ar2.remove(i);

            for (long j : ar2) {
                str[1] = j;
                ar3.clear();
                ar3.addAll(ar2);
                ar3.remove(j);

                for (long k : ar3) {
                    str[2] = k;
                    ar4.clear();
                    ar4.addAll(ar3);
                    ar4.remove(k);

                    str[3] = ar4.get(0);
                    if (bfs(str))
                        ans++;
                }
            }
        }
        out.println(ans);
    }

    private boolean bfs(long[] str) {
        int[][] steps = {{(int) str[0] / 10 - 1, (int) str[0] % 10 - 1},
                {(int) str[1] / 10 - 1, (int) str[1] % 10 - 1},
                {(int) str[2] / 10 - 1, (int) str[2] % 10 - 1},
                {(int) str[3] / 10 - 1, (int) str[3] % 10 - 1}};

        for (int i = 0, ci = fromi, cj = fromj; i < cl; i++) {
            ci += steps[b[i]][0];
            cj += steps[b[i]][1];

            if (ci >= n || ci < 0 || cj >= m || cj < 0 || a[ci][cj] == '#')
                return false;

            if (a[ci][cj] == 'E')
                return true;
        }

        return false;
    }

    private void solveC() throws IOException {
        int n = in.nextInt();
        int r = in.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }

        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = r;
            for (int j = 0; j < i; j++) {
                if (abs(x[i] - x[j]) <= 2 * r) {
                    y[i] = max(y[i], y[j] + sqrt(4.0 * r * r - (x[i] - x[j]) * (x[i] - x[j])));
                }
            }
        }

        for (double ty : y)
            out.print(ty + " ");
        out.println();

    }

    private void solveD() throws IOException {

    }

    private void solveE() throws IOException {

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
            return Double.parseDouble(next());
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
