import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.math.BigDecimal;

public class Main {

    static class Task {

        void solve(int test, FastScanner in, PrintWriter out) throws IOException {
            int n = in.nextInt();
            int d = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            Arrays.sort(a);

            int ans = 2;
            for (int i = 0; i < n - 1; i++) {
                if (a[i + 1] - d > a[i] + d) {
                    ans += 2;
                } else if (a[i + 1] - d >= a[i] + d) {
                    ans++;
                }
            }

            out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        FastScanner in = new FastScanner("input.txt");
//        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        new Task().solve(1, in, out);
        out.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer token;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String nextToken() {
            while (token == null || !token.hasMoreTokens()) {
                try {
                    token = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return token.nextToken();
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