import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FElongatedMatrix solver = new FElongatedMatrix();
        solver.solve(1, in, out);
        out.close();
    }

    static class FElongatedMatrix {
        int n;
        int m;
        int[][] arr;
        int[][] memo;
        int[][][] memo2;
        int first;

        public void readInput(Scanner sc) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = sc.nextInt();
        }

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int tc = 1;
            while (tc-- > 0) {
                readInput(sc);
                int max = 0;
                memo2 = new int[2][n][n];
                for (int[][] x : memo2)
                    for (int[] y : x)
                        Arrays.fill(y, -1);
                for (int i = 0; i < n; i++) {
                    memo = new int[n][1 << n];
                    for (int[] y : memo)
                        Arrays.fill(y, -1);
                    first = i;
                    max = Math.max(max, dp(1 << i, i));
                }
                pw.println(max);
            }
        }

        private int dp(int msk, int prev) {
            if (msk == (1 << n) - 1)
                return getLast(first, prev);
            if (memo[prev][msk] != -1)
                return memo[prev][msk];
            int max = 0;
            for (int i = 0; i < n; i++) {
                if ((msk & 1 << i) == 0)
                    max = Math.max(max, Math.min(getDiff(prev, i), dp(msk | 1 << i, i)));
            }
            return memo[prev][msk] = max;
        }

        private int getLast(int i, int j) {
            if (memo2[0][i][j] != -1)
                return memo2[0][i][j];
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < m - 1; k++)
                min = Math.min(min, Math.abs(arr[i][k] - arr[j][k + 1]));
            return memo2[0][i][j] = min;
        }

        private int getDiff(int i, int j) {
            if (memo2[1][i][j] != -1)
                return memo2[1][i][j];
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < m; k++)
                min = Math.min(min, Math.abs(arr[i][k] - arr[j][k]));
            return memo2[1][i][j] = min;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

