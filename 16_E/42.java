import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main16E {

    private FastScanner in;
    private PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextDouble();
            }
        }
        int k = 1 << n;
        double[] p = new double[k];
        int[][] b = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            b[i] = new int[comb(i, n)];
        }
        int[] bl = new int[n + 1];
        for(int i = 0; i < k; i++) {
            int c = c2(i);
            b[c][bl[c]] = i;
            bl[c]++;
        }
        p[k - 1] = 1;
        for (int i = n; i >= 2; i--) {
            for (int j = 0; j < b[i].length; j++) {
                int t = b[i][j];
                double pm = 1;
                pm /= (i * (i - 1) / 2);
                for (int x = 0; x < n; x++) {
                    for (int y = x + 1; y < n; y++) {
                        if ((t & (1 << x)) > 0 && (t & (1 << y)) > 0) {
                            p[t & ~(1 << x)] += p[t] * pm * a[y][x];
                            p[t & ~(1 << y)] += p[t] * pm * a[x][y];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(p[1 << i] + " ");
        }
    }

    int comb(int n, int m) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * (m - i + 1);
            res /= i;
        }
        return res;
    }

    int c2(int k) {
        int res = 0;
        while (k > 0) {
            if (k % 2 == 1) {
                res ++;
            }
            k /= 2;
        }
        return res;
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] arg) {
        new Main16E().run();
    }
}