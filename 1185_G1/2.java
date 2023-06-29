import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class G1 {
    static int n, T, duration[], type[];
    static long dp[][][], mod = (long) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    solveIt();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "Main", 1 << 28).start();
    }

    public static void solveIt() throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = in.nextInt();
        T = in.nextInt();
        dp = new long[3][T + 1][1 << n];
        duration = new int[n];
        type = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = in.nextInt();
            type[i] = in.nextInt() - 1;
        }
        for (long a[][] : dp) for (long b[] : a) Arrays.fill(b, -1);
        pw.println(solve(0, T, 0));

        pw.close();
    }

    static long solve(int lastType, int rem, int mask) {
        if (rem == 0) return 1;
        if (rem < 0) return 0;
        if (dp[lastType][rem][mask] != -1) return dp[lastType][rem][mask];
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (!check(mask, i) && (lastType != type[i] || mask == 0) && rem - duration[i] >= 0) {
                res += solve(type[i], rem - duration[i], set(mask, i));
                if (res >= mod) res -= mod;
            }
        }
        return dp[lastType][rem][mask] = res;
    }

    static boolean check(int N, int pos) {
        return (N & (1 << pos)) != 0;
    }

    static int set(int N, int pos) {
        return N = N | (1 << pos);
    }

    static int reset(int N, int pos) {
        return N = N & ~(1 << pos);
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}