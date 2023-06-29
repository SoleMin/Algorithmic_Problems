//    A Computer is Like a mischievous genie.
//    It will give you exactly what you ask for,
//    but not always what you want
//    A code by Rahul Verma


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {


    static class Clock {

        protected long start, stop;

        public void start() {
            start = System.currentTimeMillis();
        }

        public void stop() {
            stop = System.currentTimeMillis();
        }

        public String getTime() {
            return ((stop - start) + " ms");
        }
    }


    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String[] nextSArray() {
            String sr[] = null;
            try {
                sr = br.readLine().trim().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sr;
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }


    static long powmodulo(long a, long p) {
        if (p == 0) {
            return 1 % mod;
        }
        if (p == 1) {
            return a % mod;
        }
        long ans = 1;
        while (p > 0) {
            if ((p & 1) > 0) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            p = p >> 1;
        }
        return ans % mod;
    }


    static long mod = 1000000007;

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static long fast_powerNumbers(long a, long n) {
        if (n == 1) {
            return a;
        }
        long ans = fast_powerNumbers(a, n / 2);
        if (n % 2 == 0) {
            return (ans * ans);
        } else {
            return ((ans * ans) * (a));
        }
    }


    static void dfs_helper(int[][] arr, int i, int j, int team, int n, int m) {
        arr[i][j] = team;
        if (i - 1 >= 0 && arr[i - 1][j] == 1) {
            dfs(arr, i - 1, j, team, n, m);
        }
        if (j - 1 >= 0 && arr[i][j - 1] == 1) {
            dfs(arr, i, j - 1, team, n, m);
        }
        if (i + 1 < n && arr[i + 1][j] == 1) {
            dfs(arr, i + 1, j, team, n, m);
        }
        if (j + 1 < m && arr[i][j + 1] == 1) {
            dfs(arr, i, j + 1, team, n, m);
        }

    }

    static void dfs(int[][] arr, int i, int j, int team, int n, int m) {
        dfs_helper(arr, i, j, team, n, m);

    }


    static int arr[];

    static void seive(int n) {
        arr = new int[n + 1];
        arr[0] = arr[1] = 1;
        for (int i = 4; i <= n; i = i + 2) {
            arr[i] = 1;
        }
        for (int i = 3; i * i <= n; i = i + 2) {
            if (arr[i] == 0) {
                for (int j = i * i; j <= n; j = j + i) {
                    arr[j] = 1;
                }

            }
        }


    }


    static int xx, yy;
    static int vis[][];

    public static void bfsm(int x, int y, int n, int m, char ch[][]) {
        vis[x][y] = 0;
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(x, y));
        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int i = p.a;
            int j = p.b;
            int xx = vis[i][j] + 1;
            if (i + 1 < n) {
                if (ch[i + 1][j] == '.') {
                    // vis[i+1][j]=Math.min(vis[i+1][j],vis[i][j]+1);
                    if (vis[i + 1][j] > xx) {
                        qu.add(new Pair(i + 1, j));
                        vis[i + 1][j] = xx;
                    }
                }
            }
            if (j + 1 < m) {
                if (ch[i][j + 1] == '.') {
                    //  vis[i][j+1]=Math.min(vis[i][j+1],vis[i][j]+1);
                    if (vis[i][j + 1] > xx) {
                        qu.add(new Pair(i, j + 1));
                        vis[i][j + 1] = xx;
                    }

                }
            }
            if (i - 1 >= 0) {
                if (ch[i - 1][j] == '.') {
                    // vis[i-1][j]=Math.min(vis[i-1][j],vis[i][j]+1);
                    if (vis[i - 1][j] > xx) {
                        qu.add(new Pair(i - 1, j));
                        vis[i - 1][j] = xx;
                    }

                }
            }
            if (j - 1 >= 0) {
                if (ch[i][j - 1] == '.') {
                    // vis[i][j-1]=Math.min(vis[i][j-1],vis[i][j]+1);
                    if (vis[i][j - 1] > xx) {
                        qu.add(new Pair(i, j - 1));
                        vis[i][j - 1] = xx;
                    }

                }
            }
        }
    }

    public static boolean bfs(int x, int y, int n, int m, char ch[][]) {
        vis[x][y] = 0;
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(x, y));
        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int i = p.a;
            int j = p.b;
            if (i + 1 < n) {
                if (ch[i + 1][j] == '.') {
                    if (vis[i][j] + 1 < vis[i + 1][j]) {
                        vis[i + 1][j] = vis[i][j] + 1;

                        if (i + 1 == n - 1) {
                            xx = i + 1;
                            ch[i + 1][j] = 'D';
                            yy = j;
                            return true;
                        }
                        ch[i + 1][j] = 'D';
                        qu.add(new Pair(i + 1, j));
                    }
                }
            }
            if (j + 1 < m) {
                if (ch[i][j + 1] == '.') {
                    if (vis[i][j] + 1 < vis[i][j + 1]) {
                        vis[i][j + 1] = vis[i][j] + 1;
                        if (j + 1 == m - 1) {
                            xx = i;
                            yy = j + 1;
                            ch[i][j + 1] = 'R';
                            return true;
                        }
                        ch[i][j + 1] = 'R';
                        qu.add(new Pair(i, j + 1));
                    }
                }
            }
            if (i - 1 >= 0) {
                if (ch[i - 1][j] == '.') {
                    if (vis[i][j] + 1 < vis[i - 1][j]) {
                        vis[i - 1][j] = vis[i][j] + 1;
                        if (i - 1 == 0) {
                            xx = i - 1;
                            yy = j;
                            ch[i - 1][j] = 'U';
                            return true;
                        }
                        ch[i - 1][j] = 'U';
                        qu.add(new Pair(i - 1, j));
                    }
                }
            }
            if (j - 1 >= 0) {
                if (ch[i][j - 1] == '.') {

                    if (vis[i][j] + 1 < vis[i][j - 1]) {
                        vis[i][j - 1] = vis[i][j] + 1;
                        if (j - 1 == 0) {
                            yy = j - 1;
                            xx = i;
                            ch[i][j - 1] = 'L';
                            return true;
                        }
                        ch[i][j - 1] = 'L';
                        qu.add(new Pair(i, j - 1));
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();

        Clock clock = new Clock();
        clock.start();
        int n=sc.nextInt();
        int k=sc.nextInt();
        long p[][]=new long[n][3];
        long c[]=new long[n];
        for (int i = 0; i <n ; i++) {
            p[i][0]=sc.nextLong();
        }
        for (int i = 0; i <n ; i++) {
            p[i][1]=sc.nextLong();
            p[i][2]=i;
        }
        Arrays.sort(p, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0],o2[0]);
            }
        });
        PriorityQueue<Long>pq=new PriorityQueue<>();
        long sum=0;
        long [][]ans=new long[n][2];
        for (int i = 0; i <n ; i++) {
            ans[i][1]= p[i][1]+sum;
            ans[i][0] = p[i][2];
            if(pq.size()<k)
            {
                sum+=p[i][1];
                pq.add(p[i][1]);
            }
            else
            {
                sum+=p[i][1];
                pq.add(p[i][1]);
                long ele =pq.poll();
                sum-=ele;

            }
        }
        Arrays.sort(ans, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0],o2[0]);
            }
        });
        for (int i = 0; i <n ; i++) {
            out.print(ans[i][1]+" ");
        }
        out.close();


    }
}


class Pair {

    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}


class Graph {

    HashMap<Integer, ArrayList<Integer>> hm;

    Graph() {
        hm = new HashMap<>();
    }

    Graph(int n) {

        hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(i, new ArrayList<Integer>());
        }
    }

    // function for adding an edge.................................................
    public void addEdge(int a, int b, boolean isDir) {
        if (isDir) {
            if (hm.containsKey(a)) {
                hm.get(a).add(b);
            } else {
                hm.put(a, new ArrayList<>(Arrays.asList(b)));
            }
        } else {
            if (hm.containsKey(a)) {
                hm.get(a).add(b);
            } else if (!hm.containsKey(a)) {
                hm.put(a, new ArrayList<>(Arrays.asList(b)));
            }

            if (hm.containsKey(b)) {
                hm.get(b).add(a);
            } else if (!hm.containsKey(b)) {
                hm.put(b, new ArrayList<>(Arrays.asList(a)));
            }
        }
    }


}


class DSU {

    int parent[], rank[];

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            rank[i] = 1;
        }
    }

    int find(int s1) {
        if (parent[s1] == -1) {
            return s1;
        }

        parent[s1] = find(parent[s1]);
        return parent[s1];
    }

    void unite(int s1, int s2) {
        int p1 = find(s1);
        int p2 = find(s2);

        if (p1 != p2) {
            if (rank[p1] > rank[p2]) {
                parent[p2] = find(p1);
                rank[p1] += rank[p2];
            } else {
                parent[p1] = find(p2);
                rank[p2] += rank[p1];
            }
        }
    }
}

// out.println(al.toString().replaceAll("[\\[|\\]|,]",""));

