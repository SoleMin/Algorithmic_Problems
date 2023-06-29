/**
 * @author derrick20
 */
import java.io.*;
import java.util.*;

public class PetyaSpiders implements Runnable {
    public static void main(String[] args) throws Exception {
        new Thread(null, new PetyaSpiders(), ": )", 1 << 28).start();
    }

    public void run() {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        N = sc.nextInt();
        M = sc.nextInt();
        if (N > M) {
            int temp = N;
            N = M;
            M = temp;
        }
        // if the max is 1, then 1x1. Else, one dimension is at least 2, so
        // our idea of sliding forward a 2xN window works
        if (M == 1) {
            out.println(0);
        } else {
            int[][][] dp = new int[M][1 << N][1 << N];
            // N, M are at least 2. N <= 6
            // base case: try all prev and curr masks, let next = 0
            for (int prev = 0; prev < 1 << N; prev++) {
                // we cannot allow the previous to have anything except for 0's.
                // this matters for M = 2, since at the end of the dp we are
                // doing a special case for the final column where we need to
                // ensure both curr AND next are validly covered
                if (prev == 0) {
                    for (int curr = 0; curr < 1 << N; curr++) {
                        // all of these will satisfy the nonexistent columns, of course
                        dp[0][prev][curr] = Integer.bitCount(curr);
                    }
                } else {
                    // not allowed to have nonzero previous spiders
                    Arrays.fill(dp[0][prev], oo);
                }
            }
            for (int prev = 0; prev < 1 << N; prev++) {
                for (int curr = 0; curr < 1 << N; curr++) {
                    if (isValid(0, prev, curr)) {
                        dp[1][prev][curr] = Integer.bitCount(prev) + Integer.bitCount(curr);
                    } else {
                        dp[1][prev][curr] = oo;
                    }
                }
            }
            for (int col = 2; col <= M - 2; col++) {
                for (int next = 0; next < 1 << N; next++) {
                    for (int curr = 0; curr < 1 << N; curr++) {
                        dp[col][curr][next] = oo;
                        for (int prev = 0; prev < 1 << N; prev++) {
                            if (dp[col - 1][prev][curr] != oo && isValid(prev, curr, next)) {
                                dp[col][curr][next] = Math.min(dp[col][curr][next], dp[col - 1][prev][curr] + Integer.bitCount(next));
                            }
                        }
                    }
                }
            }
            // to get the answer, we need to act on the last column by trying to
            // ensure that both the prev row AND the current row are valid
            // basically, isValid(prev, curr, next) && isValid(curr, next, 0)
            int ans = oo;
            for (int next = 0; next < 1 << N; next++) {
                for (int curr = 0; curr < 1 << N; curr++) {
                    dp[M - 1][curr][next] = oo;
                    for (int prev = 0; prev < 1 << N; prev++) {
                        if (dp[M - 2][prev][curr] != oo && isValid(prev, curr, next) && isValid(curr, next, 0)) {
                            dp[M - 1][curr][next] = Math.min(dp[M - 1][curr][next], dp[M - 2][prev][curr] + Integer.bitCount(next));
                            ans = Math.min(ans, dp[M - 1][curr][next]);
                        }
                    }
                }
            }
//            for (int c = 1; c < M; c++) {
//                System.out.println("For col = " + c);
//                for (int prev = 0; prev < 1 << N; prev++) {
//                    System.out.println("Prev = " + Integer.toBinaryString(prev));
//                    for (int curr = 0; curr < 1 << N; curr++) {
//                        System.out.println("Curr = " + Integer.toBinaryString(curr) + " gives " + dp[c][prev][curr] + " ");
//                    }
//                }
//            }
            out.println(N * M - ans);
        }
        out.close();
    }

    static int N, M;
    static int oo = 999;
    static int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};

    static boolean isValid(int prev, int curr, int next) {
        boolean[][] grid = new boolean[N][3];
        int[] subsets = {prev, curr, next};
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < 3; c++) {
                if ((subsets[c] & 1) > 0) {
                    grid[r][c] = true;
                    for (int k = 0; k < 4; k++) {
                        int r2 = r + dr[k];
                        int c2 = c + dc[k];
                        if (0 <= r2 && r2 <= N - 1 && 0 <= c2 && c2 <= 2) {
                            grid[r2][c2] = true;
                        }
                    }
                }
                subsets[c] >>= 1;
            }
        }
        for (int r = 0; r < N; r++) {
            if (!grid[r][1]) {
                // we only need to ensure the middle is safe
                return false;
            }
        }
        return true;
    }

    static class FastScanner {
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }

    static void ASSERT(boolean assertion, String message) {
        if (!assertion) throw new AssertionError(message);
    }

    static void ASSERT(boolean assertion) {
        if (!assertion) throw new AssertionError();
    }
}