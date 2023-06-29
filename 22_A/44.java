import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/* Template for TopCoder and ACMonline. */
public class A {
    private static StreamTokenizer in = null;
    private static PrintWriter out = null;
    
    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
    
    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    static double nextDouble() throws IOException {
        in.nextToken();
        return (double) in.nval;
    }
    
    static String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }
    
    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        // Here is the solution:
        new A().solve();
        out.flush();
    }
    
    public void solve() throws IOException {
        int n = nextInt();
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i=0; i<n; ++i) {
            int d = nextInt();
            if (d<min) {
                res = min;
                min = d;
            } else if (d>min && d<res)
                res = d;
        }
        if (res == Integer.MAX_VALUE)
            out.println("NO");
        else
            out.println(res);
    }
}