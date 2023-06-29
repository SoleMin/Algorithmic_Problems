import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class MaxMex {
    
    int N = (int) 2e5 + 10;
    int LOG = 20;
    
    int n;
    int[] val = new int[N], par = new int[N], deg = new int[N];
    int[][] chd = new int[N][];
    int[] val_to_nid = new int[N];
    
    int timer = 0;
    int[] tin = new int[N], tout = new int[N];
    int[][] anc = new int[N][LOG];
    
    Node[] tree = new Node[N * 4];
    
    int ans;
    Node prev;
    
    void solve() {
        n = in.nextInt();
        for (int i = 0; i < n; i++) val[i] = in.nextInt();
        par[0] = -1;
        for (int i = 1; i < n; i++) {
            par[i] = in.nextInt() - 1;
            deg[par[i]]++;
        }
        for (int i = 0; i < n; i++) chd[i] = new int[deg[i]];
        for (int i = 1; i < n; i++) chd[par[i]][--deg[par[i]]] = i;
        for (int i = 0; i < n; i++) val_to_nid[val[i]] = i;
        
        dfs(0, 0);
        
        build_tree(0, 0, n);
        
        int Q = in.nextInt();
        while (Q-- > 0) {
            int type = in.nextInt();
            if (type == 1) {
                // swap the values and do point updates in the segment tree
                int i = in.nextInt() - 1, j = in.nextInt() - 1;
                if (i == j) continue;
                swap(i, j);
                update(0, 0, n, val[i]);
                update(0, 0, n, val[j]);
            } else {
                // query the segment tree to find the MEX
                ans = 1;
                prev = new Node(val_to_nid[0], val_to_nid[0], val_to_nid[0]);
                find_mex(0, 0, n);
                out.println(ans);
            }
        }
    }
    
    void swap(int i, int j) {
        int tmp = val[i];
        val[i] = val[j];
        val[j] = tmp;
        val_to_nid[val[i]] = i;
        val_to_nid[val[j]] = j;
    }
    
    void find_mex(int k, int l, int r) {
        Node res = merge(prev, tree[k]);
        if (!res.bad()) {
            ans = r;
            prev = res;
            return;
        }
        
        if (r - l > 1) {
            int m = (l + r) >> 1;
            find_mex(2 * k + 1, l, m);
            if (ans == m) {
                find_mex(2 * k + 2, m, r);
            }
        }
    }
    
    void update(int k, int l, int r, int i) {
        if (r - l == 1) {
            tree[k].g = tree[k].a = tree[k].b = val_to_nid[i];
            return;
        }
        
        int m = (l + r) >> 1;
        if (i < m) update(2 * k + 1, l, m, i);
        else update(2 * k + 2, m, r, i);
        tree[k] = merge(tree[2 * k + 1], tree[2 * k + 2]);
    }
    
    void build_tree(int k, int l, int r) {
        if (r - l == 1) {
            tree[k] = new Node(val_to_nid[l], val_to_nid[l], val_to_nid[l]);
            return;
        }
        
        int m = (l + r) >> 1;
        build_tree(2 * k + 1, l, m);
        build_tree(2 * k + 2, m, r);
        tree[k] = merge(tree[2 * k + 1], tree[2 * k + 2]);
    }
    
    Node merge(Node u, Node v) {
        if (u.bad() || v.bad()) {
            return new Node(-1, -1, -1);
        }
        Node res = new Node(u.a, u.b, u.g);
        res.add(v.a);
        res.add(v.b);
        return res;
    }
    
    int lca(int u, int v) {
        if (ancestor(u, v)) return u;
        if (ancestor(v, u)) return v;
        for (int i = LOG - 1; i >= 0; i--) {
            if (!ancestor(anc[u][i], v)) u = anc[u][i];
        }
        return anc[u][0];
    }
    
    boolean ancestor(int u, int v) {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }
    
    void dfs(int u, int p) {
        tin[u] = timer++;
        anc[u][0] = p;
        for (int i = 1; i < LOG; i++) anc[u][i] = anc[anc[u][i - 1]][i - 1];
        for (int v : chd[u]) {
            dfs(v, u);
        }
        tout[u] = timer++;
    }
    
    boolean is_vertical(int a, int b, int c) {
        return ancestor(a, b) && ancestor(b, c);
    }
    
    class Node {
        int a, b;
        int g;
        
        Node(int a, int b, int g) {
            this.a = a;
            this.b = b;
            this.g = g;
        }
        
        boolean bad() {
            return a < 0 || b < 0;
        }
        
        void markBad() {
            a = b = -1;
        }
        
        void add(int x) {
            if (bad()) return;
            if (a == b) {
                b = x;
                g = lca(a, b);
                if (a == g) {
                    int tmp = a; a = b; b = tmp;
                }
            } else {
                if (ancestor(a, x)) {
                    a = x;
                    return;
                }
                if (b == g) {
                    if (is_vertical(b, x, a)) {
                        return;
                    }
                    if (is_vertical(x, b, a)) {
                        g = b = x;
                        return;
                    }
                    g = lca(a, x);
                    if (ancestor(g, b)) {
                        b = x;
                        return;
                    }
                    markBad();
                    return;
                }
                if (ancestor(b, x)) {
                    b = x;
                    return;
                }
                if (is_vertical(g, x, a) || is_vertical(g, x, b)) {
                    return;
                }
                markBad();
            }
        }
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new MaxMex().solve();
        out.close();
    }
    
    static FastScanner in;
    static PrintWriter out;
    
    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;
        
        public FastScanner(BufferedReader in) {
            this.in = in;
        }
        
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(nextToken());
        }
        
        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
