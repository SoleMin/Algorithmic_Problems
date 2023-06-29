import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

public class Main implements Runnable {
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new Main(), "Main", 1 << 27).start();
    }

    static class Pair {
        int f;
        int s;
        int p;
        PrintWriter w;

        // int t;

        Pair(int f, int s) {
            // Pair(int f,int s, PrintWriter w){
            this.f = f;
            this.s = s;
            // this.p = p;
            // this.w = w;
            // this.t = t;

        }

        public static Comparator<Pair> wc = new Comparator<Pair>() {
            public int compare(Pair e1, Pair e2) {

                // 1 for swap
                if (Math.abs(e1.f) - Math.abs(e2.f) != 0) {
                    // e1.w.println("**"+e1.f+" "+e2.f);
                    return -1 * (Math.abs(e1.f) - Math.abs(e2.f));
                } else {
                    // e1.w.println("##"+e1.f+" "+e2.f);
                    return (Math.abs(e1.s) - Math.abs(e2.s));
                }

            }
        };
    }

    public Integer[] sort(Integer[] a) {
        Arrays.sort(a);
        return a;
    }

    public Long[] sort(Long[] a) {
        Arrays.sort(a);
        return a;
    }

    public void yesOrNo(boolean f) {
        if (f) {
            w.println("YES");
        } else {
            w.println("NO");
        }
    }

    public static ArrayList<Integer> sieve(int N) {
        int i, j, flag;

        ArrayList<Integer> p = new ArrayList<Integer>();

        for (i = 1; i < N; i++) {

            if (i == 1 || i == 0)
                continue;

            flag = 1;

            for (j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                p.add(i);
            }
        }
        return p;
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    //// recursive dfs
    public int dfs(int s, ArrayList<Integer>[] g, long[] dist, boolean[] v, int p) {
        v[s] = true;
        int ans = 1;
        // int n = dist.length - 1;
        int t = g[s].size();
        // int max = 1;
        for (int i = 0; i < t; i++) {
            int x = g[s].get(i);
            if (!v[x]) {
                // dist[x] = dist[s] + 1;
                ans = Math.min(ans, dfs(x, g, dist, v, s));
            } else if (x != p) {
                // w.println("* " + s + " " + x + " " + p);
                ans = 0;
            }
        }
        // max = Math.max(max,(n-p));
        return ans;
    }

    //// iterative BFS
    public int bfs(int s, ArrayList<Integer>[] g, long[] dist, boolean[] b, int p) {
        b[s] = true;
        int siz = 1;
        // dist--;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (q.size() != 0) {
            int i = q.poll();
            Iterator<Integer> it = g[i].listIterator();
            int z = 0;
            while (it.hasNext()) {
                z = it.next();
                if (!b[z]) {
                    b[z] = true;
                    // dist--;
                    dist[z] = dist[i] + 1;
                    // siz++;
                    q.add(z);
                } else if (z != p) {
                    siz = 0;
                }
            }

        }
        return siz;
    }

    public static int lower(int a[], int x) { // x is the target value or key
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= x)
                r = m;
            else
                l = m;
        }
        return r;
    }

    public static int upper(int a[], int x) {// x is the key or target value
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x)
                l = m;
            else
                r = m;
        }
        return l + 1;
    }

    public static int lower(ArrayList<Integer> a, int x) { // x is the target value or key
        int l = -1, r = a.size();
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) >= x)
                r = m;
            else
                l = m;
        }
        return r;
    }

    public static int upper(ArrayList<Integer> a, int x) {// x is the key or target value
        int l = -1, r = a.size();
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) <= x)
                l = m;
            else
                r = m;
        }
        return l + 1;
    }

    public static long power(long x, long y, long m) {
        if (y == 0)
            return 1;

        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        if (y % 2 == 0)
            return p;
        else
            return (x * p) % m;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // code here
    int oo = (int) 1e9;
    int[] parent;
    int[] dist;
    int[] height;
    boolean[][][][] vis;
    // ArrayList<Integer>[] g;
    int[] col;
    long[][] dp;
    char[][] g;
    // boolean[][] v;
    int[] a;
    // ArrayList<Integer[]> a;
    // int[][] ans;
    long mod;
    int n;
    int m;
    // StringBuilder[] a;
    // StringBuilder[] b;
    PrintWriter w = new PrintWriter(System.out);

    public void run() {

        InputReader sc = new InputReader(System.in);

        int defaultValue = 0;
        mod = 1000000007;

        int test = 1;
        // test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt();
            int q = sc.nextInt();
            int[][] ans = new int[n][2];
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }
            int f = a.get(0);
            a.remove(0);
            for (int i = 1; i < n; i++) {
                int z = a.get(0);
                a.remove(0);
                ans[i - 1][0] = f;
                ans[i - 1][1] = z;
                a.add(Math.min(f, z));
                f = Math.max(f, z);

            }
            // Arrays . so r t (a);
            // for (int i = 0; i < a.size(); i++) {
            // w.println(a.get(i));
            // }
            for (int i = 0; i < q; i++) {
                long x = sc.nextLong() - 1;
                if (x > n - 2) {
                    x = x % (n - 1);
                    w.println(f + " " + a.get((int) x));
                } else {
                    w.println(ans[(int) x][0] + " " + ans[(int) x][1]);
                }
            }

        }

        w.flush();
        w.close();

    }

}
