import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
    
    
    
    
    public void solve() throws Exception {
        int n = sc.nextInt();
        int a[] = new int[n];
        int s = 0;
        for (int i = 0;i < n; ++ i) {
            a[i] = sc.nextInt();
            s += a[i];
        }
        Arrays.sort(a);
        int s2 = 0;
        for (int i = n - 1;i >= 0; -- i) {
            s2 += a[i];
            if (s2 > s - s2) {
                out.println(n - i);
                break;
            }
        }
        
    }
    
    class Pair implements Comparable<Pair> {
        
        int x;
        int y;
        
        public Pair() {
            
        }
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair arg0) {
            if (x == arg0.x)
                return y - arg0.y;
            return x - arg0.x;
        }
    }
    
    
    
    
    /*--------------------------------------------------------------*/
    
    static String filename = "";
    static boolean fromFile = false;
    
    BufferedReader in;
    PrintWriter out;
    FastScanner sc;
    
    public static void main(String[] args) {
        new Thread(null, new Solution(), "", 1 << 25).start();
    }
   
    public void run() {
        try {
            init();
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
    }
    
    void init() throws Exception {
        if (fromFile) {
            in = new BufferedReader(new FileReader(filename+".in"));
            out = new PrintWriter(new FileWriter(filename+".out"));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        sc = new FastScanner(in);
    }
}

class FastScanner {
    
    BufferedReader reader;
    StringTokenizer strTok;
    
    public FastScanner(BufferedReader reader) {
        this.reader = reader;
    }
    
    public String nextToken() throws IOException {
        while (strTok == null || !strTok.hasMoreTokens()) {
            strTok = new StringTokenizer(reader.readLine());
        }
        
        return strTok.nextToken();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    
    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }
    
    public BigDecimal nextBigDecimal() throws IOException {
        return new BigDecimal(nextToken());
    }
}