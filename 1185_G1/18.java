import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author khokharnikunj8
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        G1playlist solver = new G1playlist();
        solver.solve(1, in, out);
        out.close();
    }

    static class G1playlist {
        int mod = 1000000007;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int T = in.scanInt();
            int[][] song = new int[n][2];
            for (int i = 0; i < n; i++) {
                song[i][0] = in.scanInt();
                song[i][1] = in.scanInt() - 1;
            }
            int[][][] dp = new int[T + 1][(1 << n)][3];
            for (int i = 0; i < n; i++)
                if (song[i][0] <= T) {
                    dp[song[i][0]][(1 << i)][song[i][1]] = 1;
                }
            for (int t = 0; t <= T; t++) {
                for (int i = 0; i < (1 << n); i++) {
                    for (int j = 0; j < 3; j++) {
                        if (dp[t][i][j] == 0) continue;
                        for (int k = 0; k < n; k++) {
                            if (((1 << k) & i) == 0 && t + song[k][0] <= T && song[k][1] != j)
                                dp[t + song[k][0]][(1 << k) | i][song[k][1]] = (dp[t + song[k][0]][(1 << k) | i][song[k][1]] + dp[t][i][j]) % mod;
                        }
                    }
                }
            }
            long ans = 0;
            for (int i = 0; i < (1 << n); i++) {
                for (int j = 0; j < 3; j++) {
                    ans = (ans + dp[T][i][j]) % mod;
                }
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

