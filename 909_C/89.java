import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author phantom11
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        long MOD = (long) 1e9 + 7;
        long[][] dp;
        int[] a;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            a = new int[N];
            dp = new long[N][N];
            int i;
            for (i = 0; i < N; i++) {
                char c = in.nextChar();
                if (c == 'f') {
                    a[i] = 1;
                }
            }

            out.printLine(iterative());
//        for(i=0;i<=N;i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        out.printLine(recur(0, 0));
        }

        public long iterative() {
            int i, j, N = a.length, lastLevel = 0;
            dp[0][0] = 1;
            for (i = 1; i < N; i++) {
                if (a[i - 1] == 1) {
                    lastLevel++;
                    for (j = 1; j <= lastLevel; j++) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][N - 1] = dp[i - 1][N - 1];
                    for (j = N - 2; j >= 0; j--) {
                        dp[i][j] = (dp[i][j + 1] + dp[i - 1][j]) % MOD;
                    }
                }
            }
            long ans = 0;
            for (i = 0; i < N; i++) {
                ans += dp[N - 1][i];
            }
            return ans % MOD;
        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tokenizer = null;

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

