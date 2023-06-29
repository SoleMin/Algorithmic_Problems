
import java.io.*;
import java.util.*;

public class B {

    public void solve() throws IOException {
        long n = nextInt(), k = nextInt();
        long c = 2 * (n + k);
        long l = -1, r = 200000;
        while (r - l > 1) {
            long m = l + (r - l) / 2;
            if (m * m + 3 * m >= c) {
                r = m;
            } else {
                l = m;
            }
        }
        out.print(n - r);
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public int[] nextArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new B().run();
    }
}