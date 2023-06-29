import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.Random;
import java.util.Comparator;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */

public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        E2RotateColumnsHardVersion solver = new E2RotateColumnsHardVersion();
        int testCount = in.scanInt();
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class E2RotateColumnsHardVersion {
        int[][] dp;
        int[] cur;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int[][] ar = new int[n][m];
            int[][] max = new int[m][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) ar[i][j] = in.scanInt();
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    max[i][0] = Math.max(max[i][0], ar[j][i]);
                }
                max[i][1] = i;
            }
            CodeHash.shuffle(max);
            Arrays.sort(max, new Comparator<int[]>() {

                public int compare(int[] o1, int[] o2) {
                    return -o1[0] + o2[0];
                }
            });
            dp = new int[2][1 << n];
            cur = new int[1 << n];
            for (int i = 0; i < Math.min(m, n); i++) {
                Arrays.fill(cur, 0);
                Arrays.fill(dp[i & 1], 0);
                for (int j = 0; j < 1 << n; j++) {
                    for (int k = 0; k < n; k++) {
                        int sum = 0;
                        for (int l = 0; l < n; l++) {
                            if ((j & (1 << l)) != 0) {
                                sum += (ar[(k + l) % n][max[i][1]]);
                            }
                        }
                        cur[j] = Math.max(cur[j], sum);
                    }
                }
                for (int j = 0; j < (1 << n); j++) {
                    for (int k = j; ; k = (k - 1) & j) {
                        dp[i & 1][j] = Math.max(dp[i & 1][j], dp[(i - 1) & 1][k] + cur[j ^ k]);
                        if (k == 0) break;
                    }
                }
            }
            out.println(dp[Math.min(n, m) & 1 ^ 1][(1 << n) - 1]);
        }

    }

    static class CodeHash {
        public static void shuffle(int[][] ar) {
            Random rd = new Random(new Random().nextInt());
            for (int i = 0; i < ar.length; i++) {
                int index = rd.nextInt(ar.length);
                int[] temp = ar[i];
                ar[i] = ar[index];
                ar[index] = temp;
            }
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

