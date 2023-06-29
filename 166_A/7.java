import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
    
    
    
    
    class Pair implements Comparable<Pair> {

        int col;
        int time;
        int place;
        
        public Pair() {
            
        }
        
        public Pair(int col, int time) {
            this.col = col;
            this.time = time;
        }
        
        @Override
        public int compareTo(Pair arg0) {
            if (col == arg0.col) {
                return time - arg0.time;
            }
            return arg0.col - col;
        }
        
        
    }
    
    public void solve() throws Exception {
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        ArrayList<Pair> a = new ArrayList<Pair>();
        
        for (int i = 0;i < n; ++ i) {
            a.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        
        int place = 1;
        int placex = 0;
        int ans2 = 0;
        int ans1 = 0;
        
        for (int i = 0;i < n; ++ i) {
            if (i > 0 && a.get(i).compareTo(a.get(i - 1)) != 0) {
                ++ place;
                ++ placex;
            } else {
                ++ placex;
            }
            a.get(i).place = place;
            if (placex == k) {
                ans1 = place;
            }
        }
        
        for (int i = 0;i < n; ++ i) {
            if (a.get(i).place == ans1) {
                ++ ans2;
            }
        }
        
        out.println(ans2);      
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