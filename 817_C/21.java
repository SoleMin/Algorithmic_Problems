import java.util.*;
import java.io.*;

@SuppressWarnings("Duplicates")
public class C817 {
    private FastScanner in;
    private PrintWriter out;

    private long calcSum(long x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }

    private long calcDiff(long x) {
        return x - calcSum(x);
    }

    private long binSearch(long n, long s) {
        long l = 0;
        long r = n + 1;

        while (r - l > 1) {
            long m = (r + l) >> 1;
            if (calcDiff(m) >= s) {
                r = m;
            } else {
                l = m;
            }
        }
        return l;
    }

    private void solve() throws IOException {
        long n = in.nextLong();
        long s = in.nextLong();

        long ans = binSearch(n, s);

        out.println(n - ans);
    }

    private void run() {
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

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] arg) {
        new C817().run();
    }
}