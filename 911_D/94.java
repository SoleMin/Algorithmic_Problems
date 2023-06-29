
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Template {

    String fileName = "";
    long INF = Long.MAX_VALUE / 3;
    int MODULO = 1000*1000*1000+7;
    long[] fenwik;
    int BORDER = 1000*1000+100;
    void solve() throws IOException {
        int n = readInt();
        int[] a = new int[n];
        for(int i=0; i<n; ++i){
            a[i] = readInt();
        }
        fenwik = new long[BORDER];
        long ans = 0;
        for(int i=n-1;i>=0;--i){
            ans+=sumFenwik(a[i]);
            incFenwik(a[i],1);
        }
        boolean even = ans % 2 == 0;
        int m = readInt();
        for(int i=0; i<m; ++i){
            int l = readInt();
            int r = readInt();

            if(((r-l+1)/2)%2==1){
                even = !even;
            }

            out.println(even?"even":"odd");
        }
    }

    void incFenwik(int i, int delta){
        for(;i<BORDER;i = i|(i+1)){
            fenwik[i]+=delta;
        }
    }

    long sumFenwik(int r){
        long sum = 0;
        for(;r>=0;r = (r&(r+1))-1){
            sum+=fenwik[r];
        }
        return sum;
    }

    int gcd(int a, int b){
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
                t[ind] += delta;
            }
        }

        long getSum(int r) {
            long sum = 0;
            for (; r >= 0; r = (r & (r + 1)) - 1) {
                sum += t[r];
            }
            return sum;
        }
    }

    class SegmentTree {
        int[] t;

        SegmentTree(int[] a) {
            int n = a.length - 1;
            t = new int[n * 4];
            build(a, 1, 1, n);
        }

        void build(int[] a, int v, int tl, int tr) {
            if (tl == tr) {
                t[v] = a[tl];
                return;
            }

            int mid = (tr + tl) / 2;

            build(a, 2 * v, tl, mid);
            build(a, 2 * v + 1, mid + 1, tr);

            t[v] = Math.max(t[2 * v], t[2 * v + 1]);
        }

        void update(int v, int tl, int tr, int pos, int value) {
            if (tl == tr) {
                t[v] = value;
                return;
            }

            int mid = (tl + tr) / 2;

            if (pos <= mid) {
                update(2 * v, tl, mid, pos, value);
            } else {
                update(2 * v + 1, mid + 1, tr, pos, value);
            }

            t[v] = Math.max(t[2 * v], t[2 * v + 1]);
        }

        int getMax(int v, int tl, int tr, int l, int r) {
            if (l > r) {
                return -1000 * 1000;
            }
            if (tl == tr) {
                return t[v];
            }

            if (l == tl && r == tr) {
                return t[v];
            }

            int mid = (tl + tr) / 2;

            int max1 = getMax(2 * v, tl, mid, l, Math.min(mid, r));
            int max2 = getMax(2 * v + 1, mid + 1, tr, Math.max(mid + 1, l), r);

            return Math.max(max1, max2);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        new Template().run();
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

    Template() throws FileNotFoundException {
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

    long readLong() throws NumberFormatException, IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(readString());
    }
}
