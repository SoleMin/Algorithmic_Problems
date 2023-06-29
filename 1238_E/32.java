import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class E_fast {
    static int g[][];
    static int n, m;
    static char[] s;
    static int dp[], inf = (int) 2e9;
    static int cost[][];

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = in.nextInt();
        m = in.nextInt();
        s = in.next().toCharArray();
        g = new int[m][m];
        for (int i = 1; i < n; i++) {
            int x = s[i - 1] - 'a', y = s[i] - 'a';
            if (x != y) {
                g[x][y]++;
                g[y][x]++;
            }
        }
        cost = new int[m][1 << m];
        for (int i = 0; i < m; i++) {
            int w = 0;
            for (int j = 0; j < m; j++) w += g[i][j];
            pre(i, 0, 0, -w);
        }
        dp = new int[1 << m];
        Arrays.fill(dp, -1);
        pw.println(solve(0, 0));

        pw.close();
    }

    static void pre(int x, int pos, int mask, int w) {
        if (pos >= m) {
            cost[x][mask] = w;
            return;
        }
        pre(x, pos + 1, mask, w);
        pre(x, pos + 1, set(mask, pos), w + 2 * g[x][pos]);
    }

    static int solve(int pos, int mask) {
        if (pos >= m) return 0;
        if (dp[mask] != -1) return dp[mask];
        int min = inf;
        for (int i = 0; i < m; i++) {
            if (!check(mask, i)) {
                int res = cost[i][mask] * pos + solve(pos + 1, set(mask, i));
                min = min(min, res);
            }
        }
        return dp[mask] = min;
    }

    static boolean check(int N, int pos) {
        return (N & (1 << pos)) != 0;
    }

    static int set(int N, int pos) {
        return N = N | (1 << pos);
    }

    static int reset(int N, int pos) {
        return N = N & ~(1 << pos);
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
    
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }
    
        public String next() throws Exception {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }
    
        public String nextLine() throws Exception {
            String line = null;
            tokenizer = null;
            line = reader.readLine();
            return line;
        }
    
        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    
        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }
    
        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }
    
    }
}