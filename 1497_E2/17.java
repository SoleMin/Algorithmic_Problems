import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SolutionE extends Thread {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                                            InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static final FastReader scanner = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Thread(null, new SolutionE(), "Main", 1 << 26).start();
    }

    static final int[] primeFactors = getSmallestPrimeFactorInIntervalInclusive(10_000_000);

    public void run() {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
        out.close();
    }

    //runs in roughly O(maxN * lg^2(maxN)))
    public static int[] getSmallestPrimeFactorInIntervalInclusive(int maxN) {
        int[] result = new int[maxN + 1];

        result[1] = 1;
        for (int i = 2; i <= maxN; i++) {
            if (result[i] == 0) {
                for (int j = i; j <= maxN; j += i) {
                    result[j] = (result[j / i] % i == 0) ? (result[j/i]/i) : (result[j/i]*i);
                }
            }
        }
        return result;
    }


    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = primeFactors[scanner.nextInt()];
        }

        Map<Integer, Integer> lastSeenIndex = new HashMap<>();
        int[] revertPointers = new int[n];
        for (int i = 0; i < n; i++) {
            if (lastSeenIndex.get(a[i]) != null) {
                revertPointers[i] = lastSeenIndex.get(a[i]);
            } else {
                revertPointers[i] = -1;
            }
            lastSeenIndex.put(a[i], i);
        }

        int[][] maxSegment = new int[n][k+1];
        for (int j = 0; j <= k; j++) {
            int pointerLeft = 0;
            int pointerRight = 0;
            boolean[] changed = new boolean[n];
            int amountChanged = 0;
            while (pointerLeft < n) {
                if (pointerRight < n && revertPointers[pointerRight] < pointerLeft) {
                    pointerRight++;
                } else if (pointerRight < n && revertPointers[pointerRight] >= pointerLeft && amountChanged < j) {
                    changed[revertPointers[pointerRight]] = true;
                    pointerRight++;
                    amountChanged++;
                } else {
                    if (changed[pointerLeft]) {
                        amountChanged--;
                    }
                    maxSegment[pointerLeft][j] = pointerRight;
                    pointerLeft++;
                }
            }
        }

        int[][] dp = new int[n+1][k+1];

        for (int j = 0; j <= k; j++) {
            dp[n][j] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = n + 1;
                for (int x = 0; x <= j; x++) {
                    int nextJumpTo = maxSegment[i][x];
                    dp[i][j] = Math.min(dp[i][j], dp[nextJumpTo][j - x] + 1);
                }
            }
        }

        out.println(dp[0][k]);
    }

    //REMINDERS:
    //- CHECK FOR INTEGER-OVERFLOW BEFORE SUBMITTING

    //- CAN U BRUTEFORCE OVER SOMETHING, TO MAKE IT EASIER TO CALCULATE THE SOLUTION
}