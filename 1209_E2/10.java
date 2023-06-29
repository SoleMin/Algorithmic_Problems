import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
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
        E1RotateColumnsEasyVersion solver = new E1RotateColumnsEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class E1RotateColumnsEasyVersion {
        int n;
        int m;
        int[][] arr;
        int[][] mskValue;
        int[][] memo;

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = sc.nextInt();
            while (q-- > 0) {
                n = sc.nextInt();
                m = sc.nextInt();
                arr = new int[n][m];
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        arr[i][j] = sc.nextInt();
                int[][] temp = new int[m][n];
                for (int i = 0; i < m; i++)
                    for (int j = 0; j < n; j++)
                        temp[i][j] = arr[j][i];
                Arrays.sort(temp, (a, b) -> getMax(b) - getMax(a));
                for (int i = 0; i < m; i++)
                    for (int j = 0; j < n; j++)
                        arr[j][i] = temp[i][j];
                mskValue = new int[n][1 << n];
                for (int i = 0; i < Math.min(n, m); i++) {
                    for (int j = 0; j < 1 << n; j++) {
                        int max = 0;
                        for (int shift = 0; shift < n; shift++) {
                            int sum = 0;
                            for (int k = 0; k < n; k++)
                                if ((j & 1 << k) != 0)
                                    sum += arr[(k + shift) % n][i];
                            max = Math.max(max, sum);
                        }
                        mskValue[i][j] = max;
                    }
                }
                memo = new int[Math.min(n, m)][1 << n];
                for (int[] x : memo)
                    Arrays.fill(x, -1);
                pw.println(dp(0, 0));
            }
        }

        private int getMax(int[] a) {
            int max = 0;
            for (int x : a)
                max = Math.max(max, x);
            return max;
        }

        private int dp(int idx, int msk) {
            if (msk == (1 << n) - 1)
                return 0;
            if (idx == Math.min(n, m))
                return (int) -1e9;
            int max = Integer.MIN_VALUE;
            if (memo[idx][msk] != -1)
                return memo[idx][msk];
            int availableBits = msk ^ ((1 << n) - 1);
            for (int colMask = availableBits; colMask != 0; colMask = (colMask - 1) & availableBits) {

                max = Math.max(max, mskValue[idx][colMask] + dp(idx + 1, msk | colMask));

            }
            return memo[idx][msk] = max;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

