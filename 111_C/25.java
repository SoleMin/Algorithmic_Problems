import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Author -
 * User: kansal
 * Date: 9/3/11
 * Time: 5:28 PM
 */
public class CF85C {
    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));

        int height = nextInt(), width = nextInt();
        if (width > height) {
            int t = width;
            width = height;
            height = t;
        }

        final int INF = height * width + 10;
        final int ALL_BITS = (1 << width)  - 1;
        int[][][] dp = new int[height + 1][1 << width][1 << width];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, INF);
            }
        }

        dp[0][0][0] = 0;
        for(int r = 0; r < height; ++r) {
            for(int uncovered = 0; uncovered < (1 << width); ++uncovered) {
                for(int mask = 0; mask < (1 << width); ++mask) {
                    if (dp[r][uncovered][mask] == INF) {
                        continue;
                    }

                    for(int curMask = uncovered; curMask < (1 << width); curMask = (curMask + 1) | uncovered) {
                        int curCovered = (mask | curMask);
                        curCovered |= (curMask >> 1);
                        curCovered |= (ALL_BITS & (curMask << 1));

                        int curUncovered = ALL_BITS ^ curCovered;
                        dp[r+1][curUncovered][curMask] = Math.min(dp[r+1][curUncovered][curMask], dp[r][uncovered][mask] + Integer.bitCount(curMask));
                    }
                }
            }
        }

        int res = INF;
        for(int x: dp[height][0]) res = Math.min(res, x);

        System.out.println(height * width - res);
    }

    public static BufferedReader reader;

    public static StringTokenizer tokenizer = null;

    static String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    static public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static public long nextLong() {
        return Long.parseLong(nextToken());
    }

    static public String next() {
        return nextToken();
    }

    static public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
