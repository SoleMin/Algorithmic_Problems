import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	PrintWriter out = new PrintWriter(System.out);
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tok = new StringTokenizer("");
    String next() throws IOException {
        if (!tok.hasMoreTokens()) { tok = new StringTokenizer(in.readLine()); }
        return tok.nextToken();
    }
    int ni() throws IOException { return Integer.parseInt(next()); }
    long nl() throws IOException { return Long.parseLong(next()); }
  
    void solve() throws IOException {
        int n=ni(),k=ni();
        int puts=(int)Math.sqrt(2*k);
        int t=(puts*(puts+1))/2;
        puts++;
        while (t<k) { t+=puts; puts++; }
        
        int turns=puts-1;
        while (t-k!=n-turns) {
            t+=puts;
            puts++;
            turns++;
        }
        System.out.println(t-k);
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}