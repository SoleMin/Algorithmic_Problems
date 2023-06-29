import java.io.*;
import java.util.*;


public class test {
    static boolean DEBUG_FLAG = false;
    int INF = (int)1e9;
    long MOD = 1000000007;
    
    static void debug(String s) {
        if(DEBUG_FLAG) {
            System.out.print(s);
        }
    }
    
    long pow(long a, long n, long mod) {
        if (n == 0) {
            return 1;
        }
        long rs = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                rs *= a;
            }
            rs %= mod;
            n >>= 1;
            a *= a;
            a %= mod;
        }
        return rs;
    }
    
    void solve(InputReader in, PrintWriter out) throws IOException {
        long x = in.nextLong();
        long k = in.nextLong();
        if(x==0) {
            out.println(0);
            return;
        }
        long a = (2 * x - 1) % MOD;
        long b = pow(2, k, MOD);
        a = (a * b) % MOD;
        a += 1;
        a %= MOD;
        out.println(a);
    }
    
    
    public static void main(String[] args) throws IOException {
        if(args.length>0 && args[0].equalsIgnoreCase("d")) {
            DEBUG_FLAG = true;
        }
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;//in.nextInt();
        long start = System.nanoTime();
        while(t-- >0) {
            new test().solve(in, out);
        }
        long end = System.nanoTime();
        debug("\nTime: " + (end-start)/1e6 + " \n\n");
        out.close();
    }
    
    static class InputReader {
        static BufferedReader br;
        static StringTokenizer st;
    
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}