import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
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

    static
    @SuppressWarnings("Duplicates")
    class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int MAX = 6000;
            int MOD = 1000000007;

            int n = in.nextInt();
            int[][] dp = new int[n][MAX];
            dp[0][0] = 1;

            char next;
            int current;
            for (int i = 0; i < n; i++) {
                next = in.next().charAt(0);
                if (i == n - 1) continue;

                current = 0;
                for (int j = MAX - 1; j >= 0; j--) {
                    if (dp[i][j] != 0) {
                        if (next == 'f') {
                            if (j < MAX - 1) dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % MOD;
                        } else {
                            current = (current + dp[i][j]) % MOD;
                        }
                    }

                    if (next == 's') dp[i + 1][j] = current;
                }
            }

            int res = 0;
            for (int i = 0; i < MAX; i++) {
                res = (res + dp[n - 1][i]) % MOD;
            }

            out.print(res);
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

