import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> cols;
    static int ans, n, a[][];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            ans = 0;
            n = sc.nextInt();
            int m = sc.nextInt();
            boolean[] taken = new boolean[m];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            a = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    int cur = sc.nextInt();
                    pq.add(new Pair(i, j, cur));
                    a[i][j] = cur;
                }
            cols = new ArrayList<>();
            while (!pq.isEmpty() && cols.size() < 8) {
                Pair cur = pq.remove();
                if (!taken[cur.j]) cols.add(cur.j);
                taken[cur.j] = true;
            }
            solve(0,new int [cols.size()]);
            out.println(ans);
        }
        out.flush();
        out.close();
    }

    static void solve(int i, int[] p) {
        if (i == cols.size()) {
            int[] max = new int[n];
            for (int k = 0; k < cols.size(); k++) {
                int j = cols.get(k);
                for (int ii = 0; ii < n; ii++) {
                    int idx = (ii + p[k]) % n;
                    max[idx] = Math.max(max[idx], a[ii][j]);
                }
            }
            int poss = 0;
            for (int x : max)
                poss += x;
            ans = Math.max(ans, poss);
            return;
        }
        for (int j = 0; j < n; j++) {
            p[i] = j;
            solve(i + 1, p);
        }
    }


    static class Pair implements Comparable<Pair> {
        int i, j, val;

        public Pair(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return o.val - val;
        }
    }


    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public Scanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }
    }
}