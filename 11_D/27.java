
import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Darren on 14-10-21.
 */
public class D {
    Reader in = new Reader(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new D().run();
    }

    int n, m;
    boolean[][] adjacency;

    void run() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        adjacency = new boolean[n+1][n];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            adjacency[u-1][v-1] = adjacency[v-1][u-1] = true;
        }

        final int MAX_MASK = (1 << n) - 1;
        long[][] dp = new long[MAX_MASK+1][n];
        for (int i = 0; i < n; i++)
            dp[1<<i][i] = 1;
        long sum = 0;
        for (int mask = 1; mask <= MAX_MASK; mask++) {
            int lowestBit = first(mask);
            for (int i = 0; i < n; i++) {
                if (bit(i, mask) && i != lowestBit) {
                    for (int j = 0; j < n; j++) {
                        if (adjacency[j][i]) {
                            dp[mask][i] += dp[mask^(1<<i)][j];
                        }
                    }
                    if (count(mask) >= 3 && adjacency[lowestBit][i])
                        sum += dp[mask][i];
                } else {
                    // dp[mask][i] = 0
                }
            }
        }

        out.println(sum / 2);
        out.flush();
    }

    int count(int mask) {
        int count = 0;
        while (mask > 0) {
            if ((mask & 1) == 1)
                count++;
            mask >>= 1;
        }
        return count;
    }

    int first(int mask) {
        int index = 0;
        while (mask > 0) {
            if ((mask & 1) == 1)
                return index;
            mask >>= 1;
            index++;
        }
        return -1;
    }

    boolean bit(int index, int mask) {
        return ((1 << index) & mask) > 0;
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public Reader(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        String nextToken() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer( reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        String readLine() throws IOException {
            return reader.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt( nextToken() );
        }

        long nextLong() throws IOException {
            return Long.parseLong( nextToken() );
        }

        double nextDouble() throws IOException {
            return Double.parseDouble( nextToken() );
        }
    }
}
