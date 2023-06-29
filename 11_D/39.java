
import java.io.*;
import java.util.StringTokenizer;

/**
 * Codeforces 11D - A Simple Task
 * Created by Darren on 14-10-21.
 * O(2^n * n^2) time and O(2^n * n) space.
 *
 * Tag: dynamic programming, bitmask, graph
 */
public class D {
    Reader in = new Reader(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new D().run();
    }

    int n, m;
    boolean[][] adjacency;  // Adjacency matrix

    void run() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        adjacency = new boolean[n+1][n];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            adjacency[u-1][v-1] = adjacency[v-1][u-1] = true;   // Converted to 0-based
        }

        final int MASK_BOUND = (1 << n);

        // dp[i][j]: the number of Hamiltonian walks over the subgraph formed by
        // the mask i, starting at the smallest vertex and ending at vertex j
        // dp[1<<i][i] = 1;
        // dp[i][j] = sum_k{dp[i^j][k]} if j is within the mask i and (k,j) is an edge
        long[][] dp = new long[MASK_BOUND][n];
        for (int i = 0; i < n; i++)
            dp[1<<i][i] = 1;

        long sum = 0;
        for (int mask = 1; mask < MASK_BOUND; mask++) {
            int lowestVertex = (int) (Math.log(lowest(mask)) / Math.log(2));
            for (int i = 0; i < n; i++) {
                if (bit(i, mask) && i != lowestVertex) {
                    for (int j = 0; j < n; j++) {
                        if (adjacency[j][i]) {
                            dp[mask][i] += dp[mask^(1<<i)][j];
                        }
                    }

                    // A simple cycle with length not smaller than 3
                    if (count(mask) >= 3 && adjacency[lowestVertex][i])
                        sum += dp[mask][i];
                } else {
                    // dp[mask][i] = 0
                }
            }
        }

        out.println(sum / 2);   // A cycle is counted twice
        out.flush();
    }

    // Return the number of '1's in the binary representation of the mask
    int count(int mask) {
        int count = 0;
        while (mask > 0) {
            if ((mask & 1) == 1)
                count++;
            mask >>= 1;
        }
        return count;
    }

    // Return an integer with only one '1' in its binary form and the position of the
    // only '1' is the same with the lowest '1' in mask
    int lowest(int mask) {
        // mask = x1b where b is a sequence of zeros;
        // -mask = x'1b', where x' and b' is formed by reversing digits in x and b;
        // mask & (-mask) = 0...010...0, where the only 1 is the lowest 1 in mask
        return mask & (-mask);
    }

    // Check whether the digit at the given index of the mask is '1'
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
