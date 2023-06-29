import java.io.*;
import java.util.*;

public class A implements Runnable {
    private MyScanner in;
    private PrintWriter out;

    private void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        int max = -1, maxp = -1;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            if (a[i] > max) {
                max = a[i];
                maxp = i;
            }
        }
        if (max == 1) {
            for (int i = 0; i < n - 1; ++i) {
                out.print(1 + " ");
            }
            out.println(2);
            return;
        }
        a[maxp] = 1;
        Arrays.sort(a);
        for (int i = 0; i < n; ++i) {
            out.print(a[i] + " ");
        }
        out.println();
    }

    @Override
    public void run() {
        in = new MyScanner();
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        new A().run();
    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String next() {
            return nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}