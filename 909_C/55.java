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
        char[] n = in.next().toCharArray(), s = in.next().toCharArray();
        out.print(n[0]);
        for (int i = 1; i < n.length && n[i] < s[0]; i++)
            out.print(n[i]);
        out.print(s[0]);
    }

    private void solveB() throws IOException {
        int n = in.nextInt();
        long dp[] = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i + (i < 3 ? 0 : dp[i - 2]);
        }
        out.print(dp[n]);
    }

    private void solveC() throws IOException {
        int n = in.nextInt(), prev = -1;

        long sum, mod = (long) 1e9 + 7, p;

        long[] deep = new long[n + 10];
        deep[0] = 1;
        char c;
        for (int cur = 0; cur < n; cur++) {
            c = in.nextLine().charAt(0);
            if (prev + 1 != cur) {
                sum = 0;
                if (c == 'f') {
                    for (int i = deep.length - 1; i > 0; i--) {
                        sum += deep[i - 1];
                        sum %= mod;
                        deep[i] = sum;
                    }
                    deep[0] = 0;
                } else {
                    for (int i = deep.length - 1; i >= 0; i--) {
                        sum += deep[i];
                        sum %= mod;
                        deep[i] = sum;
                    }
                }
            }

            if (c != 's') {
                if (cur == prev + 1) {
                    for (int i = deep.length - 1; i > 0; i--) {
                        deep[i] = deep[i - 1];
                    }
                    deep[0] = 0;
                }
                prev = cur;
            }

            //out.println(Arrays.toString(deep));
        }

        long ans = 0;
        for (int i = 0; i < deep.length; i++) {
            ans += deep[i];
            ans %= mod;
        }
        out.println(ans);
    }

    private void solveD() throws IOException {

    }

    private void solveE() throws IOException {

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
