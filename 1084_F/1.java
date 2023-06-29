import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        try (Input input = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            int n = input.nextInt();
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = input.nextInt();
            }
            int[] parent = new int[n + 1];
            int[] childrenCount = new int[n + 1];
            for (int u = 2; u <= n; u++) {
                parent[u] = input.nextInt();
                childrenCount[parent[u]]++;
            }
            int[][] g = new int[n + 1][];
            for (int i = 1; i <= n; i++) {
                g[i] = new int[childrenCount[i]];
                childrenCount[i] = 0;
            }
            for (int u = 2; u <= n; u++) {
                int v = parent[u];
                g[v][childrenCount[v]++] = u;
            }
            class Path {
                final int v1, v2, lca;

                Path(int v1, int v2, int lca) {
                    this.v1 = v1;
                    this.v2 = v2;
                    this.lca = lca;
                }

                private boolean isVertical() {
                    return lca == v1 || lca == v2;
                }

                private int getLeft() {
                    return v1 == lca ? v2 : v1;
                }

                private int getRight() {
                    return v2;
                }

                @Override
                public String toString() {
                    if (lca == v1) {
                        return String.format("%d->%d", v1, v2);
                    }
                    return String.format("%d->(%d)->%d", v1, lca, v2);
                }
            }
            class LCA {
                private final int[] enter = new int[n + 1];
                private final int[] leave = new int[n + 1];
                private final int[] timeline = new int[2 * n];
                private int time = 0;

                private void dfs(int u) {
                    enter[u] = time;
                    timeline[time++] = u;
                    for (int v : g[u]) {
                        dfs(v);
                        timeline[time++] = u;
                    }
                    leave[u] = time;
                }

                {
                    dfs(1);
                }

                class SegmentTree {
                    int size = 1;
                    {
                        while (size <= timeline.length) {
                            size *= 2;
                        }
                    }
                    final int[] a = new int[2 * size];
                    {
                        enter[0] = Integer.MAX_VALUE;
                        System.arraycopy(timeline, 0, a, size, time);
                        for (int i = size - 1; i > 0; i--) {
                            int left = a[2 * i];
                            int right = a[2 * i + 1];
                            a[i] = enter[left] < enter[right] ? left : right;
                        }
                    }

                    int getLCA(int v1, int v2) {
                        int from = Math.min(enter[v1], enter[v2]);
                        int to = enter[v1] + enter[v2] - from;
                        int lca = 0;
                        for (from += size, to += size; from < to; from /= 2, to /= 2) {
                            if (from % 2 == 1) {
                                if (enter[a[from]] < enter[lca]) {
                                    lca = a[from];
                                }
                                from++;
                            }
                            if (to % 2 == 1) {
                                --to;
                                if (enter[a[to]] < enter[lca]) {
                                    lca = a[to];
                                }
                            }
                        }
                        return lca;
                    }
                }

                private boolean isParent(int p, int u) {
                    return enter[p] <= enter[u] && leave[p] >= leave[u];
                }

                private SegmentTree st = new SegmentTree();

                Path unitePaths(Path p1, Path p2) {
                    if (p1 == null || p2 == null) {
                        return null;
                    }
                    if (!p1.isVertical() && !p2.isVertical()) {
                        if (p1.lca != p2.lca) {
                            return null;
                        }
                        int v1 = isParent(p1.v1, p2.v1) ? p2.v1 : p1.v1;
                        int v2 = isParent(p1.v2, p2.v2) ? p2.v2 : p1.v2;
                        for (int u : new int[]{p1.v1, p1.v2, p2.v1, p2.v2}) {
                            if (!isParent(u, v1) && !isParent(u, v2)) {
                                return null;
                            }
                        }
                        return new Path(v1, v2, p1.lca);
                    }
                    int lca = 0;
                    if (!p1.isVertical()) {
                        lca = p1.lca;
                    }
                    if (!p2.isVertical()) {
                        lca = p2.lca;
                    }
                    for (int u : new int[]{p1.v1, p1.v2}) {
                        for (int v : new int[]{p2.v1, p2.v2}) {
                            if (isParent(u, v) || isParent(v, u)) {
                                continue;
                            }
                            int l = st.getLCA(u, v);
                            if (lca == 0) {
                                lca = l;
                            }
                            if (l != lca) {
                                return null;
                            }
                        }
                    }
                    if (lca == 0) {
                        int v1 = isParent(p1.v1, p2.v1) ? p1.v1 : p2.v1;
                        int v2 = isParent(p1.v2, p2.v2) ? p2.v2 : p1.v2;
                        return new Path(v1, v2, v1);
                    }
                    int v1 = leave[p2.getLeft()] < leave[p1.getLeft()] ? p2.getLeft() : p1.getLeft();
                    int v2 = enter[p2.getRight()] > enter[p1.getRight()] ? p2.getRight() : p1.getRight();
                    for (int u : new int[]{p1.v1, p1.v2, p2.v1, p2.v2}) {
                        if (!isParent(u, v1) && !isParent(u, v2)) {
                            return null;
                        }
                        if (enter[u] < enter[lca]) {
                            return null;
                        }
                    }
                    return new Path(v1, v2, lca);
                }
            }
            final LCA lca = new LCA();
            int[] pReverse = new int[n];
            for (int i = 1; i <= n; i++) {
                pReverse[p[i]] = i;
            }
            class SegmentTree {
                private int size = 1;
                {
                    while (size <= n) {
                        size *= 2;
                    }
                }
                private Path[] a = new Path[2 * size];
                {
                    for (int i = 0; i < n; i++) {
                        a[size + i] = new Path(pReverse[i], pReverse[i], pReverse[i]);
                    }
                    for (int i = size - 1; i > 0; i--) {
                        a[i] = lca.unitePaths(a[2 * i], a[2 * i + 1]);
                    }
                }

                private void swap(int u, int v) {
                    int pu = p[u];
                    int pv = p[v];
                    p[u] = pv;
                    p[v] = pu;
                    pReverse[pv] = u;
                    pReverse[pu] = v;
                    Path pathU = a[size + pu];
                    Path pathV = a[size + pv];
                    a[size + pu] = pathV;
                    a[size + pv] = pathU;
                    for (pu = pu + size >> 1, pv = pv + size >> 1; pu > 0; pu /= 2, pv /= 2) {
                        a[pu] = lca.unitePaths(a[2 * pu], a[2 * pu + 1]);
                        if (pv != pu) {
                            a[pv] = lca.unitePaths(a[2 * pv], a[2 * pv + 1]);
                        }
                    }
                }

                private int getMex() {
                    int i = 1, l = size;
                    while (a[i] == null) {
                        i *= 2;
                        l /= 2;
                    }
                    Path p = a[i];
                    int mex = l;
                    i = 2 * i + 2;
                    while (l > 1) {
                        Path r = lca.unitePaths(p, a[i]);
                        l /= 2;
                        if (r == null) {
                            i *= 2;
                            continue;
                        }
                        i = 2 * i + 2;
                        p = r;
                        mex += l;
                    }
                    return mex;
                }
            }
            SegmentTree st = new SegmentTree();
            int q = input.nextInt();
            for (int i = 0; i < q; i++) {
                if (input.nextInt() == 2) {
                    writer.println(st.getMex());
                } else {
                    st.swap(input.nextInt(), input.nextInt());
                }
            }
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}