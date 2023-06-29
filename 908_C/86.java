import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class GB_A {
    FastScanner in;
    PrintWriter out;

    public static void main(String[] arg) {
        new GB_A().run();
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        int r = in.nextInt();
        int[] a = new int[n];
        double[] ans = new double[n];
        a[0] = in.nextInt();
        ans[0] = r;
        for (int i = 1; i < n; i++) {
            a[i] = in.nextInt();
            double max = r;
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(a[i] - a[j]) <= 2 * r) {
                    double d = Math.sqrt(4 * r * r - (a[i]- a[j]) * (a[i] - a[j])) + ans[j];
                    max = Math.max(max, d);
                }

            }
            ans[i] = max;
        }
        for (int i = 0; i < n; i++) {
            out.println(ans[i]);
        }
    }


    public void run() {
        try {
            in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(BufferedReader bufferedReader) {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        long nextLong() {
            return Long.parseLong(next());
        }



    }
}
