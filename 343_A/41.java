import java.io.*;
import java.math.*;
import java.util.*;

import static java.lang.Math.*;

public class Main implements Runnable {
    
    
    
    public void solve() throws Throwable {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ans = 0;
        while (a > 0 && b > 0) {
            if (a > b) {
                ans += a/b;
                a %= b;
            } else {
                ans += b/a;
                b %= a;
            }
        }
        out.println(ans);
    }
    
    static Throwable t;
    
    BufferedReader reader;
    FastScanner sc;
    PrintWriter out;
    
    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Main(), "", 1 << 26);
        thread.start();
        thread.join();
        if (Main.t != null)
            throw t;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(reader);
            solve();
        } catch (Throwable t) {
            Main.t = t;
        } finally {
            out.close();
        }
    }
}

class FastScanner {
    BufferedReader reader;
    StringTokenizer strtok;
    public FastScanner(BufferedReader reader) {
        this.reader = reader;           
    }
    
    public String nextToken() throws IOException{
        while (strtok == null || !strtok.hasMoreTokens()) {
            strtok = new StringTokenizer(reader.readLine());
        }
        return strtok.nextToken();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
}
