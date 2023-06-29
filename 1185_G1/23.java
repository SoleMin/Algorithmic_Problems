import java.io.*;
import java.util.*;

public class G1_PlaylistForPolycarp {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inp = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(inp, out);
        out.close();
    }

    private static class Solver {
        private void solve(InputReader inp, PrintWriter out) {
            int n = inp.nextInt(), t = inp.nextInt();
            int[][] tracks = new int[n][2];
            long MOD = 1000000007;
            for (int i = 0; i < n; i++) {
                tracks[i][0] = inp.nextInt();
                tracks[i][1] = inp.nextInt() - 1;
            }
            long[][] dp = new long[2 << n][4];
            dp[0][3] = 1;

            // amount of 1's in the mask
            int curr = 1;
            while (curr <= n) {
                int mask = 0;
                for (int i = 0; i < curr; i++) mask |= (1 << i);

                // while it is a possible mask
                while (mask < 2 << n) {
                    // for each track
                    for (int i = 0; i < n; i++) {
                        // if mask contains track i
                        if ((mask & (1 << i)) != 0) {
                            // for each genre
                            for (int j = 0; j < 4; j++) {
                                if (j == tracks[i][1]) continue;
                                dp[mask][tracks[i][1]] += dp[mask - (1 << i)][j];
                            }
                        }
                    }

                    // update mask
                    mask = nextNumberXBits(mask);
                }
                curr++;
            }

            long res = 0;
            for (int i = 0; i < (2 << n); i++) {
                int time = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) time += tracks[j][0];
                }
                if (time == t) {
                    for (int j = 0; j < 4; j++) {
                        res += dp[i][j];
                    }
                    res %= MOD;
                }
            }
            out.print(res);
        }

        private static int nextNumberXBits(int mask) {
            int c = mask & -mask;
            int r = mask + c;
            return (((r ^ mask) >> 2) / c) | r;
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
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
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}