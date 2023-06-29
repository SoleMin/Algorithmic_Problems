import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Comparator.*;

public class Main {
    FastScanner in;
    PrintWriter out;

    private void solve() throws IOException {
        solveB();
    }

    private void solveA() throws IOException {
        int n = in.nextInt(), k = in.nextInt();
        int[] cnt = new int[k];
        for (int i = 0; i < n; i++)
            cnt[in.nextInt() - 1] ^= 1;
        int ans = 0;
        for (int i = 0; i < k; i++)
            ans += cnt[i];
        out.println(n - ans + (ans + 1) / 2);
    }

    private void solveB() throws IOException {
        long n = in.nextLong();
        long c = (n + in.nextLong()) * 2;
        long l = 0, r = (long) 1e9;
        while (l + 1 < r) {
            long m = (l + r) / 2;
            if (m * m + 3 * m >= c)
                r = m;
            else
                l = m;
        }
        out.println(n-r);
    }

    private void solveC() throws IOException {
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

        for (int t = 1; t-- > 0; )
            solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}