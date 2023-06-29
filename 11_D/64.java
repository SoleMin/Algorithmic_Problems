import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SimpleTask {

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] g = new int[n];
        long[][] dp = new long[1 << n][n];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            g[a] |= (1 << b);
            g[b] |= (1 << a);
        }
        int all = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            int l = (1 << i);
            int left = all ^ (l - 1) ^ l;
            for (int j = left; j > 0; j = (j - 1) & left)
                if ((j & (j - 1)) != 0) {
                    dp[j | l][i] = 1;
                }
        }
        for (int i = (1 << n) - 1; i > 0; i--) {
            int last = i & -i;
            for (int j = 0; j < n; j++) {
                if (((1 << j) == last && (i & (i - 1)) != 0)
                        || ((1 << j) & i) == 0)
                    continue;
                for (int k = 0; k < n; k++) {
                    if ((1 << k) >= last && ((1 << k) & g[j]) != 0
                            && ((1 << k) == last || ((1 << k) & i) == 0)) {
                        dp[i][j] += dp[i | (1 << k)][k];
                    }

                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++)
            res += dp[(1 << i)][i];
        System.out.println(res / 2);
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
    }
}
