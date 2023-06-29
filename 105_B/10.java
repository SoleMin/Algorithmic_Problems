import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D {
    static int n, KA, A;
    static int[] b;
    static int[] l;
    static double ans = 0;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        KA = in.nextInt();
        A = in.nextInt();
        b = new int[n];
        l = new int[n];

        for (int i = 0; i < l.length; i++) {
            b[i] = in.nextInt();
            l[i] = in.nextInt();
        }
        dp = new double[n + 2][n + 2][n * 9999 + 2];
        go(0, KA);
        System.out.printf("%.6f\n", ans);
    }

    public static void go(int at, int k) {
        if (at == n) {
            ans = Math.max(ans, solve(0, 0, 0));
            return;
        }
        for (int i = 0; i <= k; i++) {
            if (l[at] + i * 10 <= 100) {
                l[at] += i * 10;
                go(at + 1, k - i);
                l[at] -= i * 10;
            }
        }
    }

    static double dp[][][];

    public static double solve(int at, int ok, int B) {
        if (at == n) {
            if (ok > n / 2) {
                return 1;
            } else {
                return (A * 1.0) / (A * 1.0 + B);
            }
        }
        double ret = ((l[at]) / 100.0) * solve(at + 1, ok + 1, B)
                + (1.0 - ((l[at]) / 100.0)) * solve(at + 1, ok, B + b[at]);
        return ret;
    }

    // 3 0 31
    // 10 60
    // 12 60
    // 15 0
    static class InputReader {
        BufferedReader in;
        StringTokenizer st;

        public InputReader() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(in.readLine());
        }

        public String next() throws IOException {
            while (!st.hasMoreElements())
                st = new StringTokenizer(in.readLine());
            return st.nextToken();
        }

        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }
    }
}