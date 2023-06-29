import java.io.*;
import java.util.*;

/**
 * Road to 1600 raiting
 */
public class Main {
    static class Task {
        PrintWriter out;

        int[] num = new int[3];

        public void solve(MyScanner in, PrintWriter out) {
            this.out = out;

            long n = in.nextLong();
            long s = in.nextLong();

            long l = 1;

            long r = n;

            while (r - l > 5) {
                long x = (l + r) / 2;

                long ans = ans(x);

                if (ans >= s) {
                    r = x;
                } else {
                    l = x;
                }
            }

            for (long i = l; i <= r; i++) {
                if (ans(i) >= s) {
                    out.println((n - i + 1));
                    return;
                }
            }

            out.println(0);

        }

        long ans(long n) {
            long res = n;

            while (n > 9) {
                res -= n % 10;
                n /= 10;
            }

            res -= n;

            return res;
        }

    }

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

