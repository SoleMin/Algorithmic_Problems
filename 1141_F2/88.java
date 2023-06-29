import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        F2BlokiRavnoiSummiUslozhnennayaRedakciya solver = new F2BlokiRavnoiSummiUslozhnennayaRedakciya();
        solver.solve(1, in, out);
        out.close();
    }

    static class F2BlokiRavnoiSummiUslozhnennayaRedakciya {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] sum = new int[n];
            int prev = 0;
            for (int i = 0; i < n; i++) {
                sum[i] = in.nextInt() + prev;
                prev = sum[i];
            }

            HashMap<Integer, List<Pair<Integer, Integer>>> blocks = new HashMap<>();

            int max = 0;
            int maxS = 0;
            for (int i = 0; i < n; i++) {
                for (int h = i; h >= 0; h--) {
                    int s = sum[i];
                    if (h > 0) {
                        s -= sum[h - 1];
                    }
                    blocks.putIfAbsent(s, new ArrayList<>());
                    List<Pair<Integer, Integer>> l = blocks.get(s);
                    if (l.isEmpty() || l.get(l.size() - 1).sc < h) {
                        l.add(new Pair<>(h, i));
                    }
                    if (l.size() > max) {
                        max = l.size();
                        maxS = s;
                    }
                }
            }

            out.println(max);
            for (int i = 0; i < max; i++) {
                out.println(String.format("%d %d", blocks.get(maxS).get(i).fs + 1, blocks.get(maxS).get(i).sc + 1));
            }
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

    static class Pair<T, K> {

        T fs;
        K sc;

        public Pair(T fs, K sc) {
            this.fs = fs;
            this.sc = sc;
        }
    }
}

