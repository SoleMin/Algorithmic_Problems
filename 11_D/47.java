import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Template implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }

    class GraphBuilder {
        int n, m;
        int[] x, y;
        int index;
        int[] size;


        GraphBuilder(int n, int m) {
            this.n = n;
            this.m = m;
            x = new int[m];
            y = new int[m];
            size = new int[n];
        }

        void add(int u, int v) {
            x[index] = u;
            y[index] = v;
            size[u]++;
            size[v]++;
            index++;
        }

        int[][] build() {
            int[][] graph = new int[n][];
            for (int i = 0; i < n; i++) {
                graph[i] = new int[size[i]];
            }
            for (int i = index - 1; i >= 0; i--) {
                int u = x[i];
                int v = y[i];
                graph[u][--size[u]] = v;
                graph[v][--size[v]] = u;
            }
            return graph;
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    int[] readIntArray(int size) throws IOException {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readLongArray(int size) throws IOException {
        long[] res = new long[size];
        for (int i = 0; i < size; i++) {
            res[i] = readLong();
        }
        return res;
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    <T> List<T>[] createGraphList(int size) {
        List<T>[] list = new List[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }
        return list;
    }

    public static void main(String[] args) {
        new Template().run();
        // new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    long memoryTotal, memoryFree;

    void memory() {
        memoryFree = Runtime.getRuntime().freeMemory();
        System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10)
                + " KB");
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            memoryTotal = Runtime.getRuntime().freeMemory();
            init();
            solve();
            out.close();
            if (System.getProperty("ONLINE_JUDGE") == null) {
                time();
                memory();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        int max = 1 << n;
        long[][] dp = new long[n][max];
        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 1;
        }
        GraphBuilder gb = new GraphBuilder(n, m);
        for (int i = 0; i < m; i++) {
            gb.add(readInt() - 1, readInt() - 1);
        }
        int[][] graph = gb.build();
        for (int mask = 1; mask < max; mask++) {
            int firstBit = -1;
            for (int i = 0; i < n; i++) {
                if (hasBit(mask, i)) {
                    firstBit = i;
                    break;
                }
            }
            for (int last = 0; last < n; last++) {
                if (dp[last][mask] == 0) continue;
                for (int y : graph[last]) {
                    if (!hasBit(mask, y) && y > firstBit) {
                        dp[y][mask | (1 << y)] += dp[last][mask];
                    }
                }
            }
        }
        long answer = 0;
        for (int i = 1; i < max; i++) {
            if (Integer.bitCount(i) < 3) continue;
            int firstBit = -1;
            for (int j = 0; j < n; j++) {
                if (hasBit(i, j)) {
                    firstBit = j;
                    break;
                }
            }
            for (int y : graph[firstBit]) {
                answer += dp[y][i];
            }
        }
        out.println(answer / 2);
    }

    boolean hasBit(int mask, int bit) {
        return (mask & (1 << bit)) != 0;
    }

}