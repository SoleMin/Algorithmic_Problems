import java.io.*;
import java.util.*;

public class Main {

    class IOManager {
        BufferedReader reader;
        PrintWriter writer;
        StringTokenizer tokenizer;

        IOManager() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(new BufferedOutputStream(System.out));
        }

        IOManager(String file) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(file));
            writer = new PrintWriter(new BufferedOutputStream(System.out));
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null)
                    throw new IOException("No lines left.");
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        public Integer nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public Double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public void writeSpace(Object obj) {
            writer.print(obj.toString() + " ");
        }

        public void writeLine(Object obj) {
            writer.println(obj.toString());
        }

        public void writeDouble(Double x, int n) {
            String format = "%." + n + "f";
            writer.printf(format, x);
        }

        public void write(Object obj) {
            writer.print(obj.toString());
        }

        public void close() {
            writer.close();
        }
    }

    class Pair implements Comparable {
        public long u, v;

        public Pair(long u, long v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Object o) {
            Pair that = (Pair) o;
            if (Long.compare(u, that.u) != 0)
                return Long.compare(u, that.u);
            return Long.compare(v, that.v);
        }
    }

    class Graph {
        public int n, m;
        public List<Integer>[] adj;

        public Graph(int n, int m) {
            this.n = n;
            this.m = m;
            adj = new List[n + 1];
            for (int i = 0; i <= n; ++i) {
                adj[i] = new ArrayList<>();
            }
        }

        public void add(int u, int v) {
            adj[u].add(v);
        }

        public void add2Ways(int u, int v) {
            add(u, v);
            add(v, u);
        }

        public void dfs(int i, boolean fr[]) {
            fr[i] = false;
            for (int j: adj[i]) {
                if (fr[j]) {
                    dfs(j, fr);
                }
            }
        }

        public boolean isConnected() {
            boolean fr[] = new boolean[n + 1];
            Arrays.fill(fr, true);
            dfs(1, fr);
            for (int i = 2; i <= n; ++i) {
                if (fr[i])
                    return false;
            }
            return true;
        }

        public boolean hasEuclideanPath() {
            if (!isConnected())
                return false;
            int cnt = 0;
            for (int i = 1; i <= n; ++i) {
                if (adj[i].size() % 2 == 1)
                    cnt++;
            }
            return cnt <= 2;
        }

        public boolean dfsHamiltonian(int i, boolean[] fr, int reached) {
            fr[i] = false;
            reached++;
            if (reached == n)
                return true;
            for (int j: adj[i]) {
                if (fr[j]) {
                    if (dfsHamiltonian(j, fr, reached))
                        return true;
                }
            }
            fr[i] = true;
            return false;
        }

        public boolean hasHamiltonianPathFrom(int st) {
            boolean fr[] = new boolean[n + 1];
            Arrays.fill(fr, true);
            return dfsHamiltonian(st, fr, 0);
        }
    }

    // Actually rooted forest
    class Tree extends Graph {

        public Tree(int n, int m) {
            super(n, m);
        }

        public int getHeight(int i) {
            int res = 0;
            for (Integer j: adj[i]) {
                res = Math.max(res, getHeight(j) + 1);
            }
            return res;
        }
    }

    class FenwickTree {
        int n;
        int tree[];

        public FenwickTree() {

        }

        public FenwickTree(int maxn) {
            n = maxn;
            tree = new int[maxn + 10];
        }

        public void add(int i, int x) {
            while (i <= n) {
                tree[i] += x;
                i += i & (-i);
            }
        }

        public void add(int i) {
            add(i, 1);
        }

        public int get(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= i & (-i);
            }
            return res;
        }
    }

    IOManager ioManager;

    Main() {
        ioManager = new IOManager();
    }

    Main(String file) throws FileNotFoundException {
        ioManager = new IOManager(file);
    }

    long n, s;
    int m, a[], sum[];
    long pow[];
    long f[][];

    void doi(long n) {
        m = 0;
        while (n > 0) {
            a[m++] = (int) (n % 10L);
            n /= 10L;
        }
    }

    int getsum(long n) {
        int res = 0;
        while (n > 0) {
            res += (int) (n % 10L);
            n /= 10L;
        }
        return res;
    }

    void solve() throws IOException {
        n = ioManager.nextLong();
        s = ioManager.nextLong();
        a = new int[100];
        pow = new long[100];
        pow[0] = 1;
        for (int i = 1; i < 100; ++i) {
            pow[i] = pow[i - 1] * 10L;
        }
        doi(n);
        sum = new int[m + 1];
        sum[m] = 0;
        for (int i = m - 1; i >= 0; --i)
            sum[i] = sum[i + 1] + a[i];


        long first = -1;
        for (long i = s + 1; i <= n; ++i) {
            if (i - getsum(i) >= s) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            ioManager.writeLine(0);
            return;
        }
        ioManager.writeLine(n - first + 1);
    }

    void close() {
        ioManager.close();
    }

    public static void main(String args[]) throws IOException {
        Main solver;
        if (!"true".equals(System.getProperty("ONLINE_JUDGE"))) {
            solver = new Main("input.txt");
        } else {
            solver = new Main();
        }
        solver.solve();
        solver.close();
    }
}