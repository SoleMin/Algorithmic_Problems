import java.io.*;
import java.util.*;
import java.math.*;

public class Teams {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;
    Random rnd;
    
    class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Pair p) {
            if(a != p.a) {
                return -(a - p.a);
            }
            
            return (b - p.b);
        }
    }

    void solve() throws IOException {
        int n = nextInt(), k = nextInt();
        
        Pair[] ps = new Pair[n];
        
        for(int i = 0; i < n; i++)
            ps[i] = new Pair(nextInt(), nextInt());
        
        Arrays.sort(ps);
        
        int curPlace = 1, res = 0;
        
        int[] places = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(i - 1 >= 0 && ps[i].compareTo(ps[i - 1]) != 0)
                ++curPlace;
            
            places[i] = curPlace;
        }
        
        for(int i = 0; i < n; i++) {
            if(places[i] == places[k - 1])
                ++res;
        }
        
        out.println(res);
    }

    public static void main(String[] args) {
        new Teams().run();
    }

    public void run() {
        try {
            final String className = this.getClass().getName().toLowerCase();

            try {
                in = new BufferedReader(new FileReader(className + ".in"));
                out = new PrintWriter(new FileWriter(className + ".out"));
            } catch (FileNotFoundException e) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            }

            rnd = new Random();

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(42);
        }
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();

            if (line == null)
                return null;

            st = new StringTokenizer(line);
        }

        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}