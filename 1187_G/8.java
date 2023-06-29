import java.io.*;
import java.util.*;
public class G{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.flush();out.close();
    }
        static class TaskE {
        class MinCostMaxFlow{
                ArrayList<Edge> al[];
                Edge ja[][]; 
                int d[]; // shortest distances
                int N , S , T , maxFlow ; int minCost;
                final int gmax = Integer.MAX_VALUE / 100;
                
                int edges = 0;

                class Edge{
                    int u , flow, rid, cost;
                    Edge(int a, int b, int c, int d){u = a; flow = b; cost = c; rid = d;}
                }
                
                void addEdge(int u , int v , int flow , int cost){
                    int lu = al[u].size(), lv = al[v].size();
                    al[u].add(new Edge(v, flow, cost, lv)); 
                    al[v].add(new Edge(u, 0, -cost, lu));   
                }
                
                void convertToArray(){
                    ja = new Edge[N][];
                    for(int i = 0; i < N; i++){
                        int sz = al[i].size();
                        ja[i] = new Edge[sz];
                        for(int j = 0; j < sz; j++){
                            ja[i][j] = al[i].get(j);
                        }
                        al[i].clear();
                    }
                }
                
                MinCostMaxFlow(int n , int source , int sink){
                    N = n; S = source; T = sink; maxFlow = 0; minCost = 0;
                    al = new ArrayList[N];
                    d = new int[N];
                    for(int i = 0; i < N; i++){
                        al[i] = new ArrayList<>();
                    }
                }
                
                boolean BellmanFord(boolean check){
                    d[0] = 0;
                    for(int i = 0; i < N - 1; i++){
                        for(int j = 0; j < N; j++){
                            for(Edge e : ja[j]){
                                if(e.flow == 0)continue; // not to consider reverse edges
                                d[e.u] = Math.min(d[e.u] , d[j] + e.cost);
                            }
                        }
                    }
                    if(check){// check for negative cycles
                        for(int j = 0; j < N; j++){
                            for(Edge e : ja[j]){
                                if(e.flow == 0)continue;
                                if(d[j] + e.cost < d[e.u]) return false;
                            }
                        }   
                    }return true;
                }

                int node[]; // present node 

                int visit[]; // 0 -> not added 1 -> not removed 2 -> removed
                int prv[], prve[]; // previous node for augmentation
                int dist[]; // min dist

                boolean simple(){
                    node = new int[N]; 
                    visit = new int[N]; 
                    prv = new int[N];
                    prve = new int[N];
                    dist = new int[N];   Arrays.fill(dist , gmax);

                    node[0] = S; dist[0] = 0;
                    int front = 1, back = 0;
                    while(front != back){
                        int u = node[back++]; int distu = dist[u];
                        if(back == N)back = 0;
                        visit[u] = 2;
                        for(int i = 0; i < ja[u].length; i++){
                            Edge e = ja[u][i];
                            if(e.flow == 0)continue;
                            int cdist = distu + e.cost; // no need of reduced cost
                            if(cdist < dist[e.u]){
                                if(visit[e.u] == 0){
                                    node[front] = e.u; 
                                    if(++front == N)front = 0;
                                }else if(visit[e.u] == 2){
                                    if(--back == -1)back += N;
                                    node[back] = e.u;
                                }
                                visit[e.u] = 1;
                                prve[e.u] = i; prv[e.u] = u; dist[e.u] = cdist;
                            }
                        }
                    }
                    return visit[T] != 0;
                }

                class pair{
                    int F; int S;
                    pair(int a, int b){F = a; S = b;}
                }

                boolean dijkstra(){
                    visit = new int[N];
                    prv = new int[N];
                    prve = new int[N];
                    dist = new int[N]; Arrays.fill(dist, gmax);
                    PriorityQueue<pair> pq = new PriorityQueue<>((A, B) -> Double.compare(A.S , B.S));

                    pq.add(new pair(S , 0)); dist[0] = 0;
                    o : while(!pq.isEmpty()){
                        pair p = pq.poll();
                        while(dist[p.F] < p.S){
                            if(pq.isEmpty()) break o; // had a better val 
                            p = pq.poll();
                        }
                        visit[p.F] = 2;
                        for(int i = 0; i < ja[p.F].length; i++){
                            Edge e = ja[p.F][i];
                            if(e.flow == 0)continue; // important
                            int cdist = p.S + (e.cost + d[p.F] - d[e.u]); // reduced cost
                            if(cdist < dist[e.u]){ 
                                if(visit[e.u] == 2) return false;
                                pq.add(new pair(e.u , cdist));
                                dist[e.u] = cdist; prv[e.u] = p.F; prve[e.u] = i;
                                visit[e.u] = 1;
                            }
                        }
                    }
                    return visit[T] != 0;
                }
                
                int augment(){
                    int p = T; int min = gmax;
                    while(p != 0){
                        int pp = prv[p], pe = prve[p];
                        int val = ja[pp][pe].flow;
                        min = Math.min(min , val);
                        p = pp;
                    }
                    p = T;
                    while(p != 0){
                        int pp = prv[p], pe = prve[p];
                        ja[pp][pe].flow -= min;
                        ja[p][ja[pp][pe].rid].flow += min;
                        p = pp;
                    }
                    maxFlow += min;
                    return min;
                }

                // if(dist[T] >= 0)return true; // non contributing flow
                boolean calSimple(){
                    // uncomment to check for negative cycles
                    /* boolean possible = BellmanFord(true); 
                     if(!possible) return false; */
                    while(simple()){
                        /*if(dist[T] >= 0)return true;*/ 
                        minCost += dist[T] * augment();
                    }
                    return true;
                }

                void updPotential(){
                    for(int i = 0; i < N; i++){
                        if(visit[i] != 0){
                            d[i] += dist[i] - dist[S];
                        }
                    }
                }
                boolean calWithPotential(){
                    // set true to check for negative cycles
                    // boolean possible = BellmanFord(false); 
                    // if(!possible) return false;
                    while(dijkstra()){
                        int min = dist[T] + d[T] - d[S]; // getting back the original cost
                        /*if(dist[T] >= 0)return true;*/
                        minCost += min * augment();
                        updPotential();
                    }
                    return true;   
                }
            }
            int n , m, k, c, d, a[], f[];
           public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt(); m = in.nextInt(); k = in.nextInt(); c = in.nextInt(); d= in.nextInt();
            // S + n
            int maxl = n + k, T = n * maxl + 1;
            MinCostMaxFlow ans = new MinCostMaxFlow(T + 1, 0, T);
            a = new int[k + 1]; f = new int[n + 1];
            for(int i = 1; i <= k; i++){
                a[i] = in.nextInt();
                f[a[i]]++;
            }
            for(int i = 1; i <= n; i++){
                if(f[i] == 0)continue;
                ans.addEdge(0 , i , f[i], 0);
            }
            for(int i = 2; i <= n; i++){
                for(int l = 0; l < maxl - 1; l++){
                    ans.addEdge(l * n + i , (l + 1) * n + i, k, c);
                }
            }
            for(int i = 1; i <= m; i++){
                int a = in.nextInt(), b = in.nextInt();
                for(int l = 0; l < maxl - 1; l++){
                    for(int p = 1; p <= k; p++){
                        if(a != 1)
                            ans.addEdge(n * l + a, n * (l + 1) + b, 1, d * (2 * p - 1) + c);
                        if(b != 1)
                            ans.addEdge(n * l + b, n * (l + 1) + a, 1, d * (2 * p - 1) + c);
                    }
                } 
            }
            for(int l = 1; l < maxl; l++){
                ans.addEdge(l * n + 1, T, k, 0);
            }
            ans.convertToArray();
            // ans.calWithPotential();
            ans.calSimple();
            if(ans.maxFlow != k){
                out.println("BUG");
            }else{
                out.println((int)ans.minCost);
            }
          }
    }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}