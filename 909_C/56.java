import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        static final int modular = (int) (1e9 + 7);

        public void solve(int testNum, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int ans = 0;
            String[] g = new String[n];
            int[][] dp = new int[2][n];
            for(int i = 0; i < n; i++) {
                g[i] = in.next();
            }
            if(n == 1) {
                out.println(1);
                return;
            }
            dp[0][0] = 1;
            for(int i = 1; i < n; i++) {
                if(g[i - 1].equals("f")) {
                    dp[1][0] = 0;
                    for(int j = 1; j < n; j++) {
                        dp[1][j] = dp[0][j - 1];
                    }
                }
                else {
                    dp[1][n - 1] = dp[0][n - 1];
                    for(int j = n - 2; j >= 0; j--) {
                        dp[1][j] = dp[1][j + 1] + dp[0][j];
                        dp[1][j] = dp[1][j] % modular;
                    }
                }
                for(int j = 0; j < n; j++) {
                    dp[0][j] = dp[1][j];
                }
                if(i == n - 1) {
                    for(int j = 0; j < n; j++) {
                        ans = ans + dp[1][j];
                        ans = ans % modular;
                    }
                }
            }
            out.println(ans);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
