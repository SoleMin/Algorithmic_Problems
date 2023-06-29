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
            int n = in.nextInt();
            char[] poks = in.next().toCharArray();
            boolean[] was = new boolean[52];
            for (int i = 0; i < n; i++) {
                if (Character.isLowerCase(poks[i])) {
                    was[poks[i] - 'a'] = true;
                } else {
                    was[poks[i] - 'A' + 26] = true;
                }
            }
            int count = 0;
            for (int i = 0; i < 52; i++) {
                count += was[i] ? 1 : 0;
            }
            int[] vis = new int[52];
            int pre = 0;
            int chr = 0;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int pos = poks[i] - 'a';
                if (Character.isUpperCase(poks[i])) {
                    pos = poks[i] - 'A' + 26;
                }

                if (vis[pos] == 0) {
                    chr++;
                }
                vis[pos]++;
                while (chr == count) {
                    ans = Math.min(ans, i - pre + 1);
                    pos = poks[pre] - 'a';
                    if (Character.isUpperCase(poks[pre])) {
                        pos = poks[pre] - 'A' + 26;
                    }
                    vis[pos]--;
                    if (vis[pos] == 0) chr--;
                    pre++;
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

