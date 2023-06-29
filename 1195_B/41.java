import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException ignored) {
                }
            }
            return stringTokenizer.nextToken();
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

    static class Node implements Comparable {
        Node left;
        Node right;
        private int value;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.value, ((Node) o).value);
        }
    }

    private static int fib(int n, int m) {
        if (n < 2) return n;
        int a = 0;
        int b = 1;
        for (int i = 0; i < n - 2; i++) {
            int c = (a + b) % m;
            a = b;
            b = c;
        }
        return (a + b) % m;
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    static class DSU {
        private int[] p;
        private int[] r;

        DSU(int n) {
            p = new int[n];
            r = new int[n];
            Arrays.fill(p, -1);
            Arrays.fill(r, 0);
        }

        int find(int x) {
            if (p[x] < 0) {
                return x;
            }
            return p[x] = find(p[x]);
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (r[a] < r[b]) {
                p[a] = b;
            } else {
                p[b] = a;
            }
            if (r[a] == r[b]) {
                r[a]++;
            }
        }
    }

    private static boolean isPrime(long n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static double med(Integer[] a) {
        Arrays.sort(a);
        if (a.length % 2 == 0) {
            int r = a.length / 2;
            int l = r - 1;
            double s = a[l] + a[r];
            return s / 2.0;
        }
        int m = a.length / 2;
        return a[m];
    }

    static Map<Integer, ArrayList<Integer>> g;
    static Map<Integer, Integer> color;

    static void dfs(int v, int c) {
        color.put(v, c);
        for (int i = 0; i < g.get(v).size(); i++) {
            int u = g.get(v).get(i);
            if (!color.containsKey(u)) {
                dfs(u, c);
            }
        }
    }

    static void reverse(Integer[] a) {
        Collections.reverse(Arrays.asList(a));
    }

    static boolean next(Integer[] a) {
        int i = a.length - 1;
        while (a[i] == 0) i--;
        int c = 0;
        while (i >= 0 && a[i] == 1) {
            c++;
            i--;
        }
        if (i < 0) return false;
        a[i] = 1;
        for (int j = i + 1; j < a.length; j++) {
            a[j] = 0;
        }
        c--;
        for (int j = 0; j < c; j++) {
            a[a.length - 1 - j] = 1;
        }
        return true;
    }

    private static int bin(Integer[] a, int l, int r, int x) {
        if (l >= r) return l;
        int m = (l + r) / 2;
        if (a[m] > x) {
            return bin(a, l, m, x);
        } else if (a[m] < x || (m < a.length - 1 && a[m + 1] == x)) {
            return bin(a, m + 1, r, x);
        }
        return m + 1;
    }

    private static class SegmentTree {
        private long[] d;
        private long[] a;

        SegmentTree(int n) {
            a = new long[n];
            d = new long[5 * n];
        }

        void update(int v, int l, int r, int pos, long val) {
            if (l == r) {
                d[v] += val;
                a[l] += val;
            } else {
                int mid = (l + r) / 2;
                if (pos <= mid) {
                    update(v * 2, l, mid, pos, val);
                } else {
                    update(v * 2 + 1, mid + 1, r, pos, val);
                }
                d[v] = d[v * 2] + d[v * 2 + 1];
            }
        }

        int find(int v, int l, int r, long w) {
            if (v >= d.length) return -1;
            int mid = (l + r) / 2;
            if (d[v] <= w) return r;
            long o = w - d[v * 2];
            if (mid + 1 < a.length && o >= a[mid + 1]) {
                return find(v * 2 + 1, mid + 1, r, o);
            }
            if (w >= a[l])
                return find(v * 2, l, mid, w);
            return -1;
        }

        int iterFind(long w) {
            if (a[0] > w) return -1;
            int l = 0, r = a.length - 1;
            int v = 1;
            while (d[v] > w) {
                int mid = (l + r) / 2;
                long o = w - d[v * 2];
                if (mid + 1 < a.length && o >= a[mid + 1]) {
                    l = mid + 1;
                    v = v * 2 + 1;
                    w = o;
                } else {
                    v = v * 2;
                    r = mid;
                }
            }
            return r;
        }

        int get(int v, int vl, int vr, long w) {
            // cout << t[v] << "  "<< v << " " << vl << " " << vr<<" " << w << endl;
            if (d[v] < w) return -1;
            if (vl > vr) return -1;
            if (vl == vr) {
                if (d[v] > w) return vl - 1;
                else return -1;
            }
            if (d[v * 2] > w) return get(v * 2, vl, (vl + vr) / 2, w);
            else return get(v * 2 + 1, (vl + vr + 2) / 2, vr, w - d[v * 2]);
        }
    }

    private static class FenwickTree {
        long[] t;

        FenwickTree(int n) {
            t = new long[n];
        }

        long sum(int r) {
            long result = 0;
            for (; r >= 0; r = (r & (r + 1)) - 1)
                result += t[r];
            return result;
        }

        void inc(int i, long delta) {
            int n = t.length;
            for (; i < n; i = (i | (i + 1)))
                t[i] += delta;
        }
    }

    void insert(List<Long> list, Long element) {
        int index = Collections.binarySearch(list, element);
        if (index < 0) {
            index = -index - 1;
        }
        list.add(index, element);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter printer = new PrintWriter(System.out);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long l = 1;
        long r = n;
        while(true){
            long m = (l + r) / 2;
            long x = (m * (m + 1)) / 2;
            x -= n - m;
            if (x == k) {
                printer.println(n - m);
                break;
            } else if (x < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        printer.flush();
        printer.close();
    }
}
/*
4 2
1 1 4
0 2 3

5 3
1 2 4
0 4 5
0 3 5

4 3
1 2 3
1 1 2
0 1 3
NO
 */