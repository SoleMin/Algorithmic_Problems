import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {
    
    static StringTokenizer st;
    static BufferedReader in;
    static PrintWriter pw;
    
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int n1 = n/10;
        int s = n % 10;
        int n2 = n / 100 * 10+s;
        System.out.println(Math.max(n, Math.max(n1, n2)));
        pw.close();
    }
    private static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    
    private static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    
    private static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    
    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
