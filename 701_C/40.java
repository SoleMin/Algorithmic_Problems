import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
            int N = in.nextInt();
            String word = in.next();

            int cnt[] = new int[1000];

            int let = 0;
            Set<Character> set = new TreeSet<>();
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
            int uniq = set.size();
            int i = 0, j = -1;
            int ans = Integer.MAX_VALUE;
            while (i < N && j < N) {
                while (j + 1 < N && let < uniq) {
                    j++;
                    if (cnt[word.charAt(j)] == 0) {
                        let++;
                    }
                    cnt[word.charAt(j)]++;
                }
                if (let == uniq)
                    ans = Math.min(ans, j - i + 1);
                cnt[word.charAt(i)]--;
                if (cnt[word.charAt(i)] == 0) let--;
                i++;
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

