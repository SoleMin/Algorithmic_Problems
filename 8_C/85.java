import java.util.*;
import java.io.*;

public class Main {
    
    static final int MAXN = 24;
    int[] x = new int[MAXN];
    int[] y = new int[MAXN];
    int[][] dist = new int[MAXN][MAXN];
    int[] single = new int[MAXN];
    
    int sqr(int x) { return x * x; }
    
    void run(int nT) {
        int xs = cin.nextInt();
        int ys = cin.nextInt();
        int n = cin.nextInt();
        for (int i = 0; i < n; ++i) {
            x[i] = cin.nextInt();
            y[i] = cin.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dist[i][j] = sqr(x[i] - xs) + sqr(y[i] - ys)
                    + sqr(x[i] - x[j]) + sqr(y[i] - y[j]) + sqr(x[j] - xs) + sqr(y[j] - ys);
            }
        }
        for (int i = 0; i < n; ++i) {
            single[i] = (sqr(x[i] - xs) + sqr(y[i] - ys)) * 2;
        }
        int[] dp = new int[1 << n];
        int[] pre = new int[1 << n];
        int tot = 1 << n;
        for (int s = 1; s < tot; ++s) {
            int i;
            for (i = 0; i < n; ++i) {
                if ((s & (1 << i)) != 0) break;
            }
            dp[s] = dp[s^(1<<i)] + single[i];
            pre[s] = i + 1;
            for (int j = i + 1; j < n; ++j) {
                if ((s & (1 << j)) != 0) {
                    int cur = dp[s^(1 << i) ^(1<<j)] + dist[i][j];
                    if (cur < dp[s]) {
                        dp[s] = cur;
                        pre[s] = (i + 1) * 100 + (j + 1);
                    }
                }
            }
        }
        out.println(dp[tot - 1]);
        int now = tot - 1;
        out.print("0");
        while (now > 0) {
            int what = pre[now];
            int px = what % 100 - 1;
            int py = what / 100 - 1;
            if (px >= 0) {
                out.print(" ");
                out.print(px + 1);
                now ^= 1 << px;
            }
            if (py >= 0) {
                out.print(" ");
                out.print(py + 1);
                now ^= 1 << py;
            }
            out.print(" ");
            out.print("0");
        }
        out.println("");
    }

    public static void main(String[] argv) {
        Main solved = new Main();
        int T = 1;
        // T = solved.cin.nextInt();
        for (int nT = 1; nT <= T; ++nT) {
            solved.run(nT);
        }
        solved.out.close();
    }

    InputReader cin = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}