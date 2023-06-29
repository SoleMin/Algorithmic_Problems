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
        int n=ni();
        int[]A=new int[n];
        for (int x=0;x<n;x++) A[x]=ni();
        Arrays.sort(A);
        ArrayList<Integer>B=new ArrayList();
        B.add(A[0]);
        int ans=1;
        
        Outer:
        for (int x=1;x<n;x++) {
            for (int y=0;y<B.size();y++) {
                if (A[x]%B.get(y)==0) continue Outer;
            }
            ans++;
            B.add(A[x]);
        }
        System.out.println(ans);   
        
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }
}