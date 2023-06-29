import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class D {
    static boolean[][] adj;
    static int n;
    static int first;

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        n = in.nextInt();
//       n = 19;?
        int m = in.nextInt();
        adj = new boolean[n][n];
//       for (int i = 0; i < n; i++) {
//       for (int j = 0; j < n; j++) {
//       adj[i][j] = true;
//       }
//       }
        dp = new long[1 << n][n];
        for (int i = 0; i < m; i++) {
            int f = in.nextInt() - 1;
            int t = in.nextInt() - 1;
            adj[f][t] = adj[t][f] = true;
        }

        boolean[] v = new boolean[1 << n];
        long res = 0;
        for (int f = 0; f < n; f++) {
            first = f;
            int cnt;
            for (int i = 0; i < 1 << n; i+=(1<<first))
                if ((i & (1 << first)) == 0)
                    for (int j = 0; j < n; j++)
                        dp[i][j] = -1;
            
            for (int i = 0; i < 1 << n; i+= (1<<first)) {
                cnt = Integer.bitCount(i);
                if ((i & (1 << first)) == 0 && !v[i | (1 << first)] && cnt > 1) {
                    v[i | (1 << first)] = true;
                    res += solve(i, first, cnt);
                }
            }
        }
        System.out.println(res / 2);
    }

    static long[][] dp;

    public static long solve(int msk, int lst, int cnt) {
        if (cnt == 0)
            return (adj[lst][first]) ? 1 : 0;
        if (dp[msk][lst] != -1)
            return dp[msk][lst];
        long res = 0;
        for (int i = 0; i < n; i++)
            if (adj[lst][i] && (msk & (1 << i)) > 0)
                res += solve(msk ^ (1 << i), i, cnt - 1);
        return dp[msk][lst] = res;
    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer st;

        public InputReader() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(in.readLine());
        }

        public String next() throws IOException {
            while (!st.hasMoreElements())
                st = new StringTokenizer(in.readLine());
            return st.nextToken();
        }

        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }
    }
}