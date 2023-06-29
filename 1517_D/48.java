import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.run();
        m.out.close();
    }

    void run() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        long[][] r = new long[n][m - 1];
        long[][] d = new long[n - 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                r[i][j] = nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = nextInt();
            }
        }
        if (k % 2 != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(-1+" ");
                }
                out.println();
            }
            return;
        }
        long[][][] dp = new long[n][m][k + 1];
        for (int kk = 2; kk <= k; kk += 2)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long ans = (long) 1e18;
                    if (i + 1 < n) {
                        ans = Math.min(ans, dp[i + 1][j][kk - 2] + d[i][j]*2);
                    }
                    if (i - 1 > -1) ans = Math.min(ans, dp[i - 1][j][kk - 2] + d[i - 1][j]*2);
                    if (j + 1 < m) ans = Math.min(ans, dp[i][j + 1][kk - 2] + r[i][j]*2);
                    if (j - 1 > -1) ans = Math.min(ans, dp[i][j - 1][kk - 2] + r[i][j - 1]*2);
                    dp[i][j][kk] = ans;
                }
            }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(dp[i][j][k] + " ");
            }
            out.println();
        }
    }


    int gcd(int a, int b) {
        while (a % b != 0) {
            int h = a % b;
            a = b;
            b = h;
        }
        return b;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer in = new StringTokenizer("");


    // pairs
    class pil implements Comparable<pil> {
        int first;
        long second;

        pil(int f, long s) {
            this.first = f;
            this.second = s;
        }

        public int compareTo(pil o) {
            if (first != o.first) return Integer.compare(first, o.first);
            return Long.compare(second, o.second);
        }
    }

    class pii implements Comparable<pii> {
        int fi;
        int se;

        pii(int f, int s) {
            se = s;
            fi = f;
        }

        public int compareTo(pii o) {
            if (fi != o.fi) return Integer.compare(fi, o.fi);
            return Integer.compare(se, o.se);
        }
    }

    class pis implements Comparable<pis> {
        int fi;
        String s;

        pis(int f, String s) {
            this.s = s;
            fi = f;
        }

        public int compareTo(pis o) {
            return Integer.compare(fi, o.fi);
        }
    }

    class vert {
        int to;
        int iter;
        int idx;
        int ed;

        vert(int s, int f, int zz, int gg) {
            to = s;
            iter = f;
            idx = zz;
            ed = gg;
        }
    }


    class pll implements Comparable<pll> {
        long first;
        long second;

        pll(long f, long s) {
            this.first = f;
            this.second = s;
        }

        public int compareTo(pll o) {
            if (first != o.first) return Long.compare(first, o.first);
            return Long.compare(second, o.second);
        }
    }

    class pli implements Comparable<pli> {
        long first;
        int second;

        pli(long f, int s) {
            this.first = f;
            this.second = s;
        }

        public int compareTo(pli o) {
            if (first != o.first) return Long.compare(first, o.first);
            return Integer.compare(second, o.second);
        }
    }

    boolean hasNext() throws IOException {
        if (in.hasMoreTokens()) return true;
        String s;
        while ((s = br.readLine()) != null) {
            in = new StringTokenizer(s);
            if (in.hasMoreTokens()) return true;
        }
        return false;
    }

    String nextToken() throws IOException {
        while (!in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

}