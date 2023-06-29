import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class A {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    class Pointd implements Comparable<Pointd>{
        int x, in;

        @Override
        public int compareTo(Pointd o) {
            if(x > o.x) return 1;
            if(x < o.x) return -1;
            if(in < o.in) return -1;
            if(in > o.in) return 1;
            return 0;
        }

        public Pointd(int x, int in) {
            super();
            this.x = x;
            this.in = in;
        }
    }
    
    void solve() throws IOException {
        int n = readInt();
        Pointd[] a = new Pointd[n];
        for(int i = 0; i < n; i++){
            a[i] = new Pointd(readInt(), i);
        }
        Arrays.sort(a);
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(a[i].x != a[a[i].in].x) count++;
        }
        if(count == 0 || count == 2) out.println("YES");
        else out.println("NO");
    }
    

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    int[] readArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readArrL(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public static void main(String[] args) {
        new A().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
}