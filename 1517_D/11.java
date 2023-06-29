import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter pw;
    static _Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new _Scanner(System.in);
        pw = new PrintWriter(System.out);
        //long startTime = System.currentTimeMillis();
        //int t = sc.nextInt();
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        pw.flush();
        //System.out.println("time: " + (System.currentTimeMillis() - startTime));
    }

    private static void solve() throws Exception {
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();

        int[][] h = new int[n][m - 1];
        int[][] v = new int[n - 1][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m - 1; ++j) {
                h[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < m; ++j) {
                v[i][j] = sc.nextInt();
            }
        }

        if (k % 2 == 1) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (j > 0) {
                        pw.print(" ");
                    }
                    pw.print(-1);
                }
                pw.println();
            }
            return;
        }

        k = k / 2;

        long[][] d = new long[n][m];
        for (int ki = 0; ki < k; ++ki) {
            long[][] dk = new long[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    long val = Integer.MAX_VALUE;

                    if (j < m - 1) {
                        val = Math.min(val, d[i][j + 1] + h[i][j]);
                    }

                    if (i < n - 1) {
                        val = Math.min(val, d[i + 1][j] + v[i][j]);
                    }

                    if (j > 0) {
                        val = Math.min(val, d[i][j - 1] + h[i][j - 1]);
                    }

                    if (i > 0) {
                        val = Math.min(val, d[i - 1][j] + v[i - 1][j]);
                    }

                    dk[i][j] = val;
                }
            }
            d = dk;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j > 0) {
                    pw.print(" ");
                }
                pw.print(d[i][j] * 2);
            }
            pw.println();
        }
    }

    static class Shuffle {
        static void run(int[] in) {
            for (int i = 0; i < in.length; i++) {
                int idx = (int) (Math.random() * in.length);
                int tmp = in[i];
                in[i] = in[idx];
                in[idx] = tmp;
            }
        }

        static void run(long[] in) {
            for (int i = 0; i < in.length; i++) {
                int idx = (int) (Math.random() * in.length);
                long tmp = in[i];
                in[i] = in[idx];
                in[idx] = tmp;
            }
        }

        static <T> void run(List<T> in) {
            for (int i = 0; i < in.size(); i++) {
                int idx = (int) (Math.random() * in.size());
                T tmp = in.get(i);
                in.set(i, in.get(idx));
                in.set(idx, tmp);
            }
        }
    }

    static class _Scanner {
        StringTokenizer st;
        BufferedReader br;

        _Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        _Scanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        String nextToken() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int[] intArr(int n) throws IOException {
            int[] in = new int[n];
            for (int i = 0; i < n; i++) in[i] = nextInt();
            return in;
        }

        long[] longArr(int n) throws IOException {
            long[] in = new long[n];
            for (int i = 0; i < n; i++) in[i] = nextLong();
            return in;
        }

        int[] intArrSorted(int n) throws IOException {
            int[] in = new int[n];
            for (int i = 0; i < n; i++) in[i] = nextInt();
            Shuffle.run(in);
            Arrays.sort(in);
            return in;
        }

        long[] longArrSorted(int n) throws IOException {
            long[] in = new long[n];
            for (int i = 0; i < n; i++) in[i] = nextLong();
            Shuffle.run(in);
            Arrays.sort(in);
            return in;
        }

        Integer[] IntegerArr(int n) throws IOException {
            Integer[] in = new Integer[n];
            for (int i = 0; i < n; i++) in[i] = nextInt();
            return in;
        }

        Long[] LongArr(int n) throws IOException {
            Long[] in = new Long[n];
            for (int i = 0; i < n; i++) in[i] = nextLong();
            return in;
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        char nextChar() throws IOException {
            return nextToken().charAt(0);
        }

        long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}
