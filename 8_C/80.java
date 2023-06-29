import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.awt.Point;
import java.io.IOException;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Point bag = new Point(in.ni(), in.ni());
            int n = in.ni();
            Point[] arr = new Point[n];
            for (int i = 0; i < n; ++i)
                arr[i] = new Point(in.ni(), in.ni());
            int[] dist = new int[n];
            for (int i = 0; i < n; ++i) {
                int dx = arr[i].x - bag.x;
                int dy = arr[i].y - bag.y;
                dist[i] = dx * dx + dy * dy;
            }
            int[][] d = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int dx = arr[i].x - arr[j].x;
                    int dy = arr[i].y - arr[j].y;
                    d[i][j] = dx * dx + dy * dy + dist[i] + dist[j];
                }
            }
            int lim = (1 << n);
            int[] dp = new int[lim];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            int[] p = new int[lim];
            Arrays.fill(p, -1);
            for (int mask = 0; mask < lim; ++mask) {
                if (dp[mask] == Integer.MAX_VALUE)
                    continue;
                int minBit = -1;
                for (int bit = 0; bit < n; ++bit) {
                    if (checkBit(mask, bit))
                        continue;
                    if (minBit == -1 || (dist[minBit] > dist[bit]))
                        minBit = bit;
                }
                if (minBit == -1)
                    continue;
                for (int bit = 0; bit < n; ++bit) {
                    if (checkBit(mask, bit))
                        continue;
                    int newMask = (mask | (1 << minBit) | (1 << bit));
                    if (dp[newMask] > dp[mask] + d[minBit][bit]) {
                        dp[newMask] = dp[mask] + d[minBit][bit];
                        p[newMask] = minBit * n + bit;
                    }
                }
            }
            out.println(dp[lim - 1]);

            int curMask = lim - 1;
            while (p[curMask] != -1) {
                out.print("0 ");
                int first = p[curMask] / n;
                int second = p[curMask] % n;
                out.print(first + 1 + " ");
                curMask ^= (1 << first);
                if (first != second) {
                    out.print(second + 1 + " ");
                    curMask ^= (1 << second);
                }
            }
            out.println(0);
        }

        boolean checkBit(int mask, int bitNumber) {
            return (mask & (1 << bitNumber)) != 0;
        }

    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String n() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(n());
        }

    }
}

