import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Main implements Runnable {

    class Home implements Comparable<Home> {
        @Override
        public int compareTo(Home arg0) {
            return st - arg0.st;
        }

        int st, end;
        
    }
    
    public void solve() throws IOException {
        int n = nextInt(), t = nextInt() * 2;
        Home[] h = new Home[n];
        for(int i = 0; i < n; ++i) {
            int x = nextInt() * 2, a = nextInt() * 2;
            h[i] = new Home();
            h[i].st = x - a / 2;
            h[i].end = x + a / 2;           
        }             
        Arrays.sort(h);
        int ans = 2;
        for(int i = 0; i + 1 < n; ++i) {
            int delta = h[i + 1].st - h[i].end;
            if (delta == t)
                ans++;
            if (delta > t)
                ans += 2;
        }
        pw.println(ans);
    }
    
    static final String filename = "A";
    static final boolean fromConsole = true;

    public void run() {
        try {
            if (!fromConsole) {
                in = new BufferedReader(new FileReader(filename + ".in"));
                pw = new PrintWriter(filename + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            long st = System.currentTimeMillis();
            solve();            
            //pw.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - st);            
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        } 
    }
    
    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw; 
    
    boolean hasNext() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return false;
            }
            st = new StringTokenizer(line);
        }
        return st.hasMoreTokens();
    }
    
    String next() throws IOException {
        return hasNext() ? st.nextToken() : null;
    }
    
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }
    
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    
    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    
    public static void main(String[] args) {
        new Thread(new Main()).start();
    }   
}
