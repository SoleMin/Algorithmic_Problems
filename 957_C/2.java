import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class ll {
    public static void main(String[] args) throws Exception {
        gg g = new gg();
    }

}

class gg {
    int[] p;
    int[] rank;
    int[] umsg, rmsg;
    boolean[] g;
    int[] hui;
    int n;
    long k;
    int[] sended;
    PrintWriter pw;
    int lead;
    int[] mas;
    TreeSet<Integer> fiiq;
    ArrayList<int[]> ans;
    TreeSet<Integer> sset[];
    long dp[][];
    boolean[] checked;
    int mo;
    ArrayList<Integer>[] tree;

    gg() throws Exception {
        //         FScanner fs = new FScanner(new FileReader("sequences.in"));
        //  pw = new PrintWriter("sequences.out");
        FScanner fs = new FScanner(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int n = fs.nextInt();
        int U = fs.nextInt();
        int[] mas = fs.iarr(n);
        int left = 0;
        int right = 0;
        double max = 0;
        for (; left < n; left++) {
            while (right <n && mas[right]-mas[left]<=U) {
                right++;
            }
            right--;
            if (right - left <= 1) {
                continue;
            }
            max = Math.max((1.0*mas[right]-mas[left+1])/(mas[right]-mas[left]), max);
        }
        if (max == 0)
            pw.println(-1);
        else pw.println(max);
        pw.close();
    }

    long[][] pow(long[][] mat, long val) {
        if (val == 1)
            return mat;
        if (val % 2 == 0) {
            long[][] m = pow(mat, val / 2);
            return mul(m, m);
        } else {
            val--;
            long[][] ss = mat.clone();
            return mul(pow(mat, val), ss);
        }
    }

    long[][] mul(long[][] m1, long[][] m2) {
        int a1 = m1.length, a2 = m1[0].length, a3 = m2[0].length;
        long[][] ff = new long[a1][a3];
        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a3; j++)
                for (int s = 0; s < a2; s++)
                    ff[i][j] = (ff[i][j] + m1[i][s] * m2[s][j]) % mo;
        }
        return ff;
    }

    void dfs(int cur, long[] a, long[] b, long[] c) {
        checked[cur] = true;
        for (int i = 0; i < tree[cur].size(); i += 2) {
            if (!checked[tree[cur].get(i)]) {
                dfs(tree[cur].get(i), a, b, c);
                a[cur] = Math.max(a[cur], b[tree[cur].get(i)] + tree[cur].get(i + 1) - c[tree[cur].get(i)]);
                b[cur] += c[tree[cur].get(i)];
            }
        }
        a[cur] += b[cur];
        c[cur] = Math.max(a[cur], b[cur]);

    }

    void find(int i, int j, ArrayList<Integer> ans, int[][] dp, int[] w) {
        if (dp[i][j] == 0)
            return;
        if (dp[i - 1][j] == dp[i][j])
            find(i - 1, j, ans, dp, w);
        else {
            ans.add(i);
            find(i - 1, j - w[i - 1], ans, dp, w);
        }
    }

    void next(int[] bitmask) {
        int r = 0;
        while (bitmask[r] == 1)
            bitmask[r++] = 0;
        bitmask[r] = 1;
    }


}

class Pair implements Comparable<Pair> {
    long a;
    int x;

    Pair(long x1, int y1) {
        a = x1;
        a = y1;
    }

    @Override
    public int compareTo(Pair o) {
        if (a == o.a)
            return Integer.compare(x, o.x);
        else return Long.compare(a, o.a);
    }
}


class FScanner {
    StringTokenizer st;
    BufferedReader reader;

    FScanner(InputStreamReader isr) throws IOException {
        reader = new BufferedReader(isr);
    }

    String nextLine() throws IOException {
        return reader.readLine();
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = reader.readLine();
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    char nextChar() throws IOException {
        return (char) reader.read();
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    int[] iarr(int n) throws IOException {
        int[] mas = new int[n];
        for (int i = 0; i < n; i++)
            mas[i] = nextInt();
        return mas;
    }

    double[] darr(int n) throws IOException {
        double[] mas = new double[n];
        for (int i = 0; i < n; i++)
            mas[i] = nextDouble();
        return mas;
    }

    char[][] cmas2(int n, int m) throws IOException {
        char[][] mas = new char[n][m];
        for (int i = 0; i < n; i++)
            mas[i] = nextLine().toCharArray();
        return mas;
    }

    long[] larr(int n) throws IOException {
        long[] mas = new long[n];
        for (int i = 0; i < n; i++)
            mas[i] = nextLong();
        return mas;
    }
}

class PairP implements Comparable<PairP> {
    int l, r;

    PairP(int l1, int r1) {
        l = l1;
        r = r1;
    }

    @Override
    public int compareTo(PairP o) {
        if (l == o.l)
            return Integer.compare(r, o.r);
        else return Integer.compare(l, o.l);
    }
}
