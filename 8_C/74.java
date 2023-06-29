import java.util.*;

import static java.lang.System.out;

public final class LookingForOrder {
    private static Map<Integer, Integer> es = new HashMap<Integer, Integer>();
    private static void init() { for (int i = 0; i <= 24; i++) es.put(1 << i, i); }
    private static int x, y;
    private static int[] xs, ys;
    private static int sqr(int i) { return i * i; }
    private static int dist(int i, int j) {
        return sqr(x - xs[i]) + sqr(y - ys[i]) + 
            sqr(xs[i] - xs[j]) + sqr(ys[i] - ys[j]) +
            sqr(x - xs[j]) + sqr(y - ys[j]);
    }

    private static int n;
    private static int[] tb, prevs;

    private static int recur(int j) {
        if (j == 0 || es.get(j) != null || tb[j] != 0) return tb[j];

        int bl = j & -j;
        int b = j ^ bl;
        tb[j] = recur(bl) + recur(b);
        prevs[j] = bl;

        for (int i = es.get(bl) + 1; i <25; i++) {
            if (((1 << i) & b) == 0) continue;

            int k = bl | 1 << i;
            int v = dist(es.get(bl), es.get(1 << i)) + recur(j ^ k);
            if (v >= tb[j]) continue;

            tb[j] = v;
            prevs[j] = k;
        }
        return tb[j];
    }

    public static void main(String[] args) {
        init();
        Scanner s = new Scanner(System.in);
        x = s.nextInt(); y = s.nextInt();
        n = s.nextInt();
        xs = new int[n]; ys = new int[n];
        tb = new int[1 << n]; prevs = new int[1 << n];

        for (int i = 0; i < n; i++) {
            xs[i] = s.nextInt(); ys[i] = s.nextInt();
            tb[1 << i] = sqr(x - xs[i]) + sqr(y - ys[i]) << 1;
        }

        int all = (1 << n) - 1;
        out.println(recur(all));
        StringBuilder sb = new StringBuilder();
        int p = prevs[all];
        int c = all;
        while(p != 0 && p != c) {
            if ((p ^ (p & -p)) == 0) sb.append("0 " + (es.get(p & -p) + 1) + " ");
            else sb.append("0 " + (es.get(p & -p) + 1) + " " + (es.get(p ^ (p & -p)) + 1) + " ");
            c = c ^ p;
            p = prevs[c];
        }

        if ((c ^ (c & -c)) == 0) sb.append("0 " + (es.get(c & -c) + 1) + " 0");
        else sb.append("0 " + (es.get(c & -c) + 1) + " " + (es.get(c ^ (c & -c)) + 1) + " 0");
        out.println(sb);
    }
}

