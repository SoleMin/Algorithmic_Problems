import java.util.*;
import java.io.*;

public class C0008 {

    public static void main(String args[]) throws Exception {
        new C0008();
    }

    int n;
    int target;
    int pow[];
    int dp[];
    int next[];
    int dist[][];

    C0008() throws Exception {
        PandaScanner sc = null;
        PrintWriter out = null;
        try {
            sc = new PandaScanner(System.in);
            out = new PrintWriter(System.out);
        } catch (Exception ignored) {
        }

        pow = new int[26];
        for (int i = 0; i < 26; i++) {
            pow[i] = 1 << i;
        }

        dist = new int[26][26];
        int[][] p = new int[26][];
        p[25] = new int[] {sc.nextInt(), sc.nextInt()};
        n = sc.nextInt();
        target = (1 << n) - 1;

        for (int i = 0; i < n; i++) {
            p[i] = new int[] {sc.nextInt(), sc.nextInt()};
            dist[i][25] = getDist(p[i], p[25]);
            for (int j = 0; j < i; j++) {
                dist[j][i] = getDist(p[j], p[i]);
            }
        }

        next = new int[1 << n];

        dp = new int[1 << n];
        Arrays.fill(dp, -1);

        out.println(go(0));

        ArrayList<Integer> paths = new ArrayList<Integer>();
        paths.add(0);
        int curr = 0;
        while (curr != target) {
            for (Integer i: getBits(next[curr], true)) {
                paths.add(i + 1);
            }
            paths.add(0);
            curr |= next[curr];
        }
        out.println(paths.toString().replaceAll("[^ 0-9]", ""));

        out.close();
        System.exit(0);
    }

    int go(int mask) {
        if (mask == target) {
            return 0;
        }
        if (dp[mask] != -1) {
            return dp[mask];
        }

        ArrayList<Integer> notDone = getBits(mask, false);

        dp[mask] = Integer.MAX_VALUE;

        for (Integer i: notDone) {
            int oneD = (dist[i][25] << 1) + go(mask | pow[i]);
            if (dp[mask] > oneD) {
                dp[mask] = oneD;
                next[mask] = 1 << i;
            }
            for (Integer j: notDone) {
                if (j == i) continue;
                int d = (dist[j][25] + dist[i][j] + dist[i][25]) + go(mask | pow[i] | pow[j]);
                if (dp[mask] > d) {
                    dp[mask] = d;
                    next[mask] = (1 << i) | (1 << j);
                }
            }
            break;
        }

        return dp[mask];
    }

    int getDist(int[] p1, int[] p2) {
        return sq(p1[0] - p2[0]) + sq(p1[1] - p2[1]);
    }

    int sq(int a) {
        return a * a;
    }

    ArrayList<Integer> getBits(int mask, boolean on) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (((mask & (1 << i)) == 0) ^ on) {
                res.add(i);
            }
        }
        return res;
    }

    //The PandaScanner class, for Panda fast scanning!
    public class PandaScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream in;

        PandaScanner(InputStream in) throws Exception {
            br = new BufferedReader(new InputStreamReader(this.in = in));
        }

        public String next() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine().trim());
                return next();
            }
            return st.nextToken();
        }

        public boolean hasNext() throws Exception {
            return (st != null && st.hasMoreTokens()) || in.available() > 0;
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
