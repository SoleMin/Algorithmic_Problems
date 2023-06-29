import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A {
    private static BufferedReader in;
    private static StringTokenizer st;
    private static PrintWriter out;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int max = n;
        max = Math.max(max, n / 10);
        max = Math.max(max, (n / 100) * 10 + n % 10);
        System.out.println(max);
    }
    

    static String next() throws IOException{
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    static int nextInt() throws NumberFormatException, IOException{
        return Integer.parseInt(next());
    }
    static long nextLong() throws NumberFormatException, IOException{
        return Long.parseLong(next());
    }
    
    static double nextDouble() throws NumberFormatException, IOException{
        return Double.parseDouble(next());
    }

}
