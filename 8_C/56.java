import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class BetaRound8_C implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            }
            tok = new StringTokenizer("");
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long endTime = System.currentTimeMillis();
            long totalMemory = Runtime.getRuntime().totalMemory();
            long freeMemory = Runtime.getRuntime().freeMemory();
            System.err.println("Time = " + (endTime - startTime) + " ms");
            System.err.println("Memory = " + ((totalMemory - freeMemory) / 1024) + " KB");
        } catch (Throwable e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    public static void main(String[] args) {
        new Thread(null, new BetaRound8_C(), "", 256 * 1024 * 1024).start();
    }

    // ------------------------------------------------------------------------------

    final int INF = 1000 * 1000 * 1000;

    int x0, y0;
    int n;
    int[] x, y;

    int t(int i, int j) {
        int dx = x[i] - x[j];
        int dy = y[i] - y[j];
        return dx * dx + dy * dy;
    }

    int t0(int i) {
        int dx = x[i] - x0;
        int dy = y[i] - y0;
        return dx * dx + dy * dy;
    }

    int[] dp;
    int[] p;

    void solve() throws IOException {
        x0 = readInt();
        y0 = readInt();
        n = readInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = readInt();
            y[i] = readInt();
        }
        dp = new int[1 << n];
        p = new int[1 << n];
        Arrays.fill(dp, INF);
        dp[(1 << n) - 1] = 0;
        get(0);
        out.println(dp[0]);
        printPath();
    }

    int get(int mask) {
        if (dp[mask] != INF) {
            return dp[mask];
        }
        int res = INF;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0) { // порядок неважен, т.к. в i все равно идти, пойдем туда сразу
                int test = get(mask ^ (1 << i)) + 2 * t0(i);
                if (res > test) {
                    res = test;
                    p[mask] = mask ^ (1 << i);
                }
                for (int j = i + 1; j < n; j++) {
                    if (((1 << j) & mask) == 0) {
                        test = get(mask ^ (1 << i) ^ (1 << j)) + t0(i)
                                + t(i, j) + t0(j);
                        if (res > test) {
                            res = test;
                            p[mask] = mask ^ (1 << i) ^ (1 << j);
                        }
                    }
                }
                break;
            }
        }
        return dp[mask] = res;
    }

    void printPath() {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        int mask = 0;
        while (mask != (1 << n) - 1) {
            for (int i = 0; i < n; i++) {
                if (((mask ^ p[mask]) & (1 << i)) != 0) {
                    ans.add(i + 1);
                }
            }
            mask = p[mask];
            ans.add(0);
        }
        for (int x : ans) {
            out.print(x + " ");
        }
    }

}