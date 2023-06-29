import java.io.*;
import java.util.*;

public class A implements Runnable {
    private MyScanner in;
    private PrintWriter out;

    private void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        int all = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            all += a[i];
        }
        Arrays.sort(a);
        int sum = 0, ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            sum += a[i];
            ++ans;
            if (sum > all - sum) {
                break;
            }
        }
        out.println(ans);
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

        public String next() {
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
                st = null;
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public boolean hasNext() {
            if (st != null && st.hasMoreTokens()) {
                return true;
            }
            try {
                while (br.ready()) {
                    st = new StringTokenizer(br.readLine());
                    if (st != null && st.hasMoreTokens()) {
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}