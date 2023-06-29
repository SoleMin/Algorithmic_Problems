import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }

        int csa[] = new int[n];
        for (int i = 0; i < n; i++) {
            csa[i] = getCs(csa, i - 1) + a[i];
        }
        int cst[] = new int[n];
        for (int i = 0; i < n; i++) {
            cst[i] = getCs(cst, i - 1) + (a[i] * t[i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - k + 1; i++) {
            int l = i;
            int r = l + k - 1;
            int profit = (getCs(csa, r) - getCs(csa, l - 1)) - (getCs(cst, r) - getCs(cst, l - 1));
            if (profit > max) {
                max = profit;
            }
        }
        int totalProfit = max;
        for (int i = 0; i < n; i++) {
            int ti = t[i];
            if (ti != 0) {
                totalProfit += a[i];
            }
        }
        System.out.println(totalProfit);
    }

    private static int getCs(int[] cs, int i) {
        if (i < 0) {
            return 0;
        }
        return cs[i];
    }


    private static class in {

        private static BufferedReader reader;
        private static StringTokenizer tokenizer;

        static {
            reader = new BufferedReader(
                    new InputStreamReader(System.in));
            tokenizer = new StringTokenizer(" ");
        }

        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer(" ");
        }

        static void prevLine(String line) {
            tokenizer = new StringTokenizer(line);
        }

        static String nextLine() throws IOException {
            return reader.readLine();
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static boolean hasNext() {
            return tokenizer.hasMoreTokens();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static int nextShort() throws IOException {
            return Short.parseShort(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }


    }
}

