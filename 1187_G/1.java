//package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static class Task {

        public class Maxflow {
            class Edge {
                int t, rev;
                long cap, f;
                public Edge(int t, int rev, long cap) {
                    this.t = t;
                    this.rev = rev;
                    this.cap = cap;
                }
            }
            public Maxflow(int n) {
                graph = new List[n];
                for (int i = 0; i < n; i++) {
                    graph[i] = new ArrayList<>();
                }
            }
            List<Edge>[] graph;
            void addEdge(int s, int t, long cap) {
                graph[s].add(new Edge(t, graph[t].size(), cap));
                graph[t].add(new Edge(s, graph[s].size() - 1, 0));
//                System.err.println(s + " " + t + " " + cap);
            }

            boolean dinicBFS(int src, int dest, int[] dist) {
                Arrays.fill(dist, -1);
                dist[src] = 0;
                int[] Q = new int[graph.length];
                int sizeQ = 0;
                Q[sizeQ++] = src;
                for (int i = 0; i < sizeQ; i++) {
                    int u = Q[i];
                    for (Edge e: graph[u]) {
                        if (dist[e.t] < 0 && e.f < e.cap) {
                            dist[e.t] = dist[u] + 1;
                            Q[sizeQ++] = e.t;
                        }
                    }
                }
                return dist[dest] >= 0;
            }

            long dinicDFS(int[] ptr, int[] dist, int dest, int u, long f) {
                if (u == dest) return f;
                for (;ptr[u] < graph[u].size(); ++ptr[u]) {
                    Edge e =  graph[u].get(ptr[u]);
                    if (dist[e.t] == dist[u] + 1 && e.f < e.cap) {
                        long df = dinicDFS(ptr, dist, dest, e.t, Math.min(f, e.cap - e.f));
                        if (df > 0) {
                            e.f += df;
                            graph[e.t].get(e.rev).f -= df;
                            return df;
                        }
                    }
                }
                return 0;
            }

            long maxFLow(int src, int dest) {
                long flow = 0;
                int[] dist = new int[graph.length];
                while (dinicBFS(src, dest, dist)) {
                    int[] ptr = new int[graph.length];
                    while (true) {
                        long df = dinicDFS(ptr, dist, dest, src, Long.MAX_VALUE);
                        if (df == 0) break;
                        flow += df;
                    }
                }
                return flow;
            }
        }

        public class MinCostFlowBF {
            List<Edge>[] graph;
            class Edge {
                int to, f, cap, cost, rev;

                Edge(int v, int cap, int cost, int rev) {
                    this.to = v;
                    this.cap = cap;
                    this.cost = cost;
                    this.rev = rev;
                }
            }

            public MinCostFlowBF(int n) {
                graph = new List[n];
                for (int i = 0; i < n; i++)
                    graph[i] = new ArrayList<Edge>();
            }

            public void addEdge(int s, int t, int cap, int cost) {
                graph[s].add(new Edge(t, cap, cost, graph[t].size()));
                graph[t].add(new Edge(s, 0, -cost, graph[s].size() - 1));
            }

            void bellmanFord(int s, int[] dist, int[] prevnode, int[] prevedge, int[] curflow) {
                int n = graph.length;
                Arrays.fill(dist, 0, n, Integer.MAX_VALUE);
                dist[s] = 0;
                curflow[s] = Integer.MAX_VALUE;
                boolean[] inqueue = new boolean[n];
                int[] q = new int[n];
                int qt = 0;
                q[qt++] = s;
                for (int qh = 0; (qh - qt) % n != 0; qh++) {
                    int u = q[qh % n];
                    inqueue[u] = false;
                    for (int i = 0; i < graph[u].size(); i++) {
                        Edge e = graph[u].get(i);
                        if (e.f >= e.cap)
                            continue;
                        int v = e.to;
                        int ndist = dist[u] + e.cost;
                        if (dist[v] > ndist) {
                            dist[v] = ndist;
                            prevnode[v] = u;
                            prevedge[v] = i;
                            curflow[v] = Math.min(curflow[u], e.cap - e.f);
                            if (!inqueue[v]) {
                                inqueue[v] = true;
                                q[qt++ % n] = v;
                            }
                        }
                    }
                }
            }

            public int[] minCostFlow(int s, int t, int maxf) {
                int n = graph.length;
                int[] dist = new int[n];
                int[] curflow = new int[n];
                int[] prevedge = new int[n];
                int[] prevnode = new int[n];

                int flow = 0;
                int flowCost = 0;
                while (flow < maxf) {
                    bellmanFord(s, dist, prevnode, prevedge, curflow);
                    if (dist[t] == Integer.MAX_VALUE)
                        break;
                    int df = Math.min(curflow[t], maxf - flow);
                    flow += df;
                    for (int v = t; v != s; v = prevnode[v]) {
                        Edge e = graph[prevnode[v]].get(prevedge[v]);
                        e.f += df;
                        graph[v].get(e.rev).f -= df;
                        flowCost += df * e.cost;
                    }
                }
                return new int[]{flow, flowCost};
            }
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int[] pos = new int[n];
            for (int i = 0; i < k; i++) {
                pos[sc.nextInt() - 1]++;
            }
            int T = 100;
            MinCostFlowBF mf = new MinCostFlowBF((T + 1) * n + 2);
            for (int i = 0; i < n; i++) {
                if (pos[i] > 0)
                    mf.addEdge(0, i + 1, pos[i], 0);
            }
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < n; j++) {
                    mf.addEdge(1 + i * n + j, 1 + (i + 1) * n + j, k, 0);
                }
            }
            for (int i = 0; i <= T; i++) {
                for (int j = 1; j <= k; j++) {
                    mf.addEdge(1 + i * n, (T + 1) * n + 1, 1, c * i);
                }
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                for (int j = 0; j < T; j++) {
                    int cost = 0;
                    for (int l = 1; l <= k; l++) {
                        mf.addEdge(1 + j * n + a, 1 + (j + 1) * n + b, 1, l * l * d - cost);
                        mf.addEdge(1 + j * n + b, 1 + (j + 1) * n + a, 1, l * l * d - cost);
                        cost = l * l * d;
                    }
                }
            }
            int[] flowAndCost = mf.minCostFlow(0, (T + 1) * n + 1, k);
            System.err.println(flowAndCost[0]);
            pw.println(flowAndCost[1]);
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("output"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
