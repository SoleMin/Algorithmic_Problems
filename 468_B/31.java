
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    
    private PrintWriter out;
    private Map<Integer, Integer> map;
    
    private int arr[], ans[];
    int n, a, b;
 
    class DSU {
        private int[] p, size;
        
        public DSU(int n) {
            p = new int[n];
            size = new int[n];
            
            for (int i=0; i<n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int i) {
            if (p[i] == i) {
                return i;
            }
            return p[i] = find(p[i]);
        }
        
        public void union (int a, int b) {
            a = find(a); b = find(b);
            if (size[a] > size[b]) {
                p[b] = a;
                size[a] += size[b];
            } else {
                p[a] = b;
                size[b] += size[a];
            }
        }
    }
    
    private void solve() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        
        n = Integer.valueOf(st.nextToken());
        a = Integer.valueOf(st.nextToken());
        b = Integer.valueOf(st.nextToken());
        map = new HashMap<Integer, Integer>(n);
        
        String line = in.readLine();
        StringTokenizer st1 = new StringTokenizer(line);
        
        arr = new int[n];
        ans = new int[n];
        DSU dsu = new DSU(n);
        
        for (int i=0; i<n; i++) {
            arr[i] = Integer.valueOf(st1.nextToken());
            map.put(arr[i], i);
        }
        in.close();
        
        for (int i=0; i<n; i++) {
            boolean f = false;
            if (map.get(a - arr[i]) != null) {
                f = true;
                dsu.union(i, map.get(a - arr[i]));
            }
            
            if (map.get(b - arr[i]) != null) {
                f = true;
                dsu.union(i, map.get(b - arr[i]));
            }
            
            if (!f) {
                out.println("NO");
                out.flush();
                return;
            }
        }
        
        for (int i=0; i<n; i++) {
            int p = dsu.find(i);
            if (map.get(a - arr[i]) == null) {
                ans[p] = 1;
            } else if (map.get(b - arr[i]) == null) {
                ans[p] = 0;
            }
        }
        
        for (int i=0; i<n; i++) {
            int p = dsu.find(i);
            if (ans[p] == 0 && map.get(a - arr[i]) == null) {
                out.println("NO");
                out.flush();
                return;
            } 
            
            if (ans[p] == 1 && map.get(b - arr[i]) == null) {
                out.println("NO");
                out.flush();
                return;
            }
        }
        
        out.println("YES");
        for (int i=0; i<n; i++) {
            out.print(ans[dsu.find(i)] + " ");
        }
                
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}