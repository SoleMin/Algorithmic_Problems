import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class GeorgeInterestingGraph {
    
    int N = 505;
    int INF = (int) 1e9;
    
    List<Integer>[] G = new List[N];
    int[] match = new int[N];
    int[] used = new int[N];
    int cur = 0;
    
    {
        for (int i = 0; i < N; i++) G[i] = new ArrayList<>(1);
    }
    
    void solve() {
        int n = in.nextInt(), m = in.nextInt();
        int[] fr = new int[m], to = new int[m];
        for (int i = 0; i < m; i++) {
            fr[i] = in.nextInt() - 1;
            to[i] = in.nextInt() - 1;
        }
        
        int ans = INF;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                G[j].clear();
                match[j] = -1;
            }
            for (int j = 0; j < m; j++) {
                if (fr[j] == i || to[j] == i) {
                    cnt++;
                } else {
                    G[fr[j]].add(to[j]);
                }
            }
            
            int other = m - cnt;
            
            int max = 0;
            for (int j = 0; j < n; j++) {
                cur++;
                augment(j);
            }
            for (int j = 0; j < n; j++) if (match[j] >= 0) max++;
            
            ans = Math.min(ans, 2 * (n - 1) + 1 - cnt + other - max + (n - 1) - max);
        }
        out.println(ans);
    }
    
    boolean augment(int u) {
        if (used[u] == cur) return false;
        used[u] = cur;
        for (int v : G[u]) {
            if (match[v] < 0 || augment(match[v])) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new GeorgeInterestingGraph().solve();
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
