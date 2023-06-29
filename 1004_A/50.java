
import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

    long b = 31;
    String fileName = "";


    //////////////////////    SOLUTION   SOLUTION  SOLUTION    //////////////////////////////
    int INF = Integer.MAX_VALUE / 10;
    long MODULO = 1000*1000*100;
    void solve() throws IOException {
        int n = readInt();
        int d = readInt();
        int[] arr = readIntArray(n);
        Arrays.sort(arr);
        int ans = 2;
        for (int i=0; i < n - 1; ++i){
            int cur = arr[i] + d;
            if (arr[i+1] - d == cur) ans++;
            if (arr[i+1] - d > cur) ans +=2;
        }
        out.println(ans);
    }

    class Number implements Comparable<Number>{
        int x, cost;
        Number(int x, int cost){
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    class Vertex implements Comparable<Vertex>{
        int num, depth, e, c;
        Vertex(int num, int depth, int e, int c){
            this.num = num;
            this.e = e;
            this.depth = depth;
            this.c = c;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.e, o.e);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    class Edge{
        int from, to, num;
        Edge(int to, int num){
            this.to = to;
            this.num = num;
        }
    }

    class SparseTable{
        int[][] rmq;
        int[] logTable;
        int n;
        SparseTable(int[] a){
            n = a.length;
            logTable = new int[n+1];
            for(int i = 2; i <= n; ++i){
                logTable[i] = logTable[i >> 1] + 1;
            }
            rmq = new int[logTable[n] + 1][n];
            for(int i=0; i<n; ++i){
                rmq[0][i] = a[i];
            }

            for(int k=1; (1 << k) < n; ++k){
                for(int i=0; i + (1 << k) <= n; ++i){
                    int max1 = rmq[k - 1][i];
                    int max2 = rmq[k-1][i + (1 << (k-1))];
                    rmq[k][i] = Math.max(max1, max2);
                }
            }
        }

        int max(int l, int r){
            int k = logTable[r - l];
            int max1 = rmq[k][l];
            int max2 = rmq[k][r - (1 << k) + 1];
            return Math.max(max1, max2);
        }
    }
    long checkBit(long mask, int bit){
        return (mask >> bit) & 1;
    }
    class Dsu{
        int[] parent;
        int countSets;
        Dsu(int n){
            countSets = n;
            parent = new int[n];
            for(int i=0; i<n; ++i){
                parent[i] = i;
            }
        }
        int findSet(int a){
            if(parent[a] == a) return a;
            parent[a] = findSet(parent[a]);
            return parent[a];
        }
        void unionSets(int a, int b){
            a = findSet(a);
            b = findSet(b);
            if(a!=b){
                countSets--;
                parent[a] = b;
            }
        }
    }
    static int checkBit(int mask, int bit) {
        return (mask >> bit) & 1;
    }
    boolean isLower(char c){
        return c >= 'a' && c <= 'z';
    }

    ////////////////////////////////////////////////////////////

    class SegmentTree{
        int[] t;
        int n;
        SegmentTree(int n){
            t = new int[4*n];
            build(new int[n+1], 1, 1, n);
        }
        void build (int a[], int v, int tl, int tr) {
            if (tl == tr)
                t[v] = a[tl];
            else {
                int tm = (tl + tr) / 2;
                build (a, v*2, tl, tm);
                build (a, v*2+1, tm+1, tr);
            }
        }

        void update (int v, int tl, int tr, int l, int r, int add) {
            if (l > r)
                return;
            if (l == tl && tr == r)
                t[v] += add;
            else {
                int tm = (tl + tr) / 2;
                update (v*2, tl, tm, l, Math.min(r,tm), add);
                update (v*2+1, tm+1, tr, Math.max(l,tm+1), r, add);
            }
        }

        int get (int v, int tl, int tr, int pos) {
            if (tl == tr)
                return t[v];
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                return t[v] + get (v*2, tl, tm, pos);
            else
                return t[v] + get (v*2+1, tm+1, tr, pos);
        }
    }
    class Fenwik {
        long[] t;
        int length;

        Fenwik(int[] a) {
            length = a.length + 100;
            t = new long[length];

            for (int i = 0; i < a.length; ++i) {
                inc(i, a[i]);
            }
        }

        void inc(int ind, int delta) {
            for (; ind < length; ind = ind | (ind + 1)) {
                t[ind] = Math.max(delta, t[ind]);
            }
        }

        long getMax(int r) {
            long sum = 0;
            for (; r >= 0; r = (r & (r + 1)) - 1) {
                sum = Math.max(sum, t[r]);
            }
            return sum;
        }
    }
    int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
    long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a%b);
    }
    long binPow(long a, long b, long m) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 1) {
            return ((a % m) * (binPow(a, b - 1, m) % m)) % m;
        } else {
            long c = binPow(a, b / 2, m);
            return (c * c) % m;
        }

    }
    int minInt(int... values) {
        int min = Integer.MAX_VALUE;
        for (int value : values) min = Math.min(min, value);
        return min;
    }

    int maxInt(int... values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) max = Math.max(max, value);
        return max;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        new Main().run();
    }

    void run() throws NumberFormatException, IOException {
        solve();
        out.close();
    };

    BufferedReader in;
    PrintWriter out;

    StringTokenizer tok;
    String delim = " ";
    Random rnd = new Random();

    Main() throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            if (fileName.isEmpty()) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader(fileName + ".in"));
                out = new PrintWriter(fileName + ".out");
            }

        }
        tok = new StringTokenizer("");
    }

    String readLine() throws IOException {
        return in.readLine();
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (null == nextLine) {
                return null;
            }

            tok = new StringTokenizer(nextLine);
        }
        return tok.nextToken();
    }

    int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(readString());
    }
    byte readByte() throws NumberFormatException, IOException {
        return Byte.parseByte(readString());
    }
    int[] readIntArray (int n) throws NumberFormatException, IOException {
        int[] a = new int[n];
        for(int i=0; i<n; ++i){
            a[i] = readInt();
        }
        return a;
    }

    Integer[] readIntegerArray (int n) throws NumberFormatException, IOException {
        Integer[] a = new Integer[n];
        for(int i=0; i<n; ++i){
            a[i] = readInt();
        }
        return a;
    }

    long readLong() throws NumberFormatException, IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(readString());
    }
}
