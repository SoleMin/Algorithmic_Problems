import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        final int P = (int) 1e9 + 7;
        int n;
        char[] commands;
        int[][] memo;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            commands = new char[n];
            memo = new int[n][12345];
            for (int i = 0; i < n; i++) {
                commands[i] = in.next().charAt(0);
                for (int j = 0; j < 12345; j++) {
                    memo[i][j] = -1;
                }
            }
            out.print(solve(1, 0));
        }

        int add(int a, int b) {
            return ((a % P) + (b % P)) % P;
        }

        int solve(int i, int indents) {
            if (i == n) return 1;
            if (memo[i][indents] != -1) return memo[i][indents];
            int answer;
            if (commands[i - 1] == 'f') {
                answer = solve(i + 1, indents + 1);
            } else {
                if (indents == 0) {
                    answer = solve(i + 1, indents);
                } else {
                    answer = add(solve(i, indents - 1), solve(i + 1, indents));
                }
            }
            return memo[i][indents] = answer;
        }

    }

    static class InputReader {
        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private void fillTokenizer() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            fillTokenizer();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

