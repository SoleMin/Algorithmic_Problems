import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
    
    boolean hasBit(long n, int pos) {
        return (n & (1L << pos)) != 0;
    }
    
    public void solve() throws Exception {
        long l = sc.nextLong(), r = sc.nextLong();
        int bit = 62;
        while (bit >= 0 && (hasBit(l, bit) == hasBit(r, bit))) {
            bit--;
        }
        out.println((1L << (bit + 1)) - 1);
    }
    
    static Throwable uncaught;
    
    BufferedReader in;
    FastScanner sc;
    PrintWriter out;
    
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            solve();
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }
    
    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread (null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }

}

class FastScanner {
    
    BufferedReader in;
    StringTokenizer st;
    
    public FastScanner(BufferedReader in) {
        this.in = in;
    }
    
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
    
}