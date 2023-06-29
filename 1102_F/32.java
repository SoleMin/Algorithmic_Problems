import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
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
        FElongatedMatrix solver = new FElongatedMatrix();
        solver.solve(1, in, out);
        out.close();
    }

    static class FElongatedMatrix {
        int[][] G;
        int[][] G1;

        public int findIt(int[] map, int n, int start) {
            int[][] mask = new int[1 << n][n];
            for (int i = 0; i < n; i++) mask[(1 << i)][i] = G[start][map[i]];
            for (int i = 1; i < (1 << n); i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k != j && (i & (1 << k)) == 0 && (i & (1 << j)) != 0) {
                            mask[(i | (1 << k))][k] = Math.max(mask[(i | (1 << k))][k], Math.min(mask[i][j], G[map[j]][map[k]]));
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) ans = Math.max(ans, Math.min(mask[(1 << n) - 1][i], G1[start][map[i]]));
            return ans;
        }

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            G = new int[n][n];
            G1 = new int[n][n];
            int[][] ar = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ar[i][j] = in.scanInt();
                }
            }
            if (n == 1) {
                int ans = Integer.MAX_VALUE;
                for (int i = 0; i < m - 1; i++) ans = Math.min(ans, Math.abs(ar[0][i] - ar[0][i + 1]));
                out.println(ans);
                return;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < m; k++) min = Math.min(min, Math.abs(ar[i][k] - ar[j][k]));
                    G[i][j] = G[j][i] = min;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    int min = Integer.MAX_VALUE;
                    for (int k = 1; k < m; k++) min = Math.min(min, Math.abs(ar[i][k] - ar[j][k - 1]));
                    G1[i][j] = min;

                }
            }
            int[] map;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                map = new int[n - 1];
                int tl = 0;
                for (int temp = 0; temp < n; temp++) {
                    if (temp == i) continue;
                    map[tl++] = temp;
                }
                ans = Math.max(ans, findIt(map, n - 1, i));

            }
            out.println(ans);


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

