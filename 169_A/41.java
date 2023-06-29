import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solver {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;
    
    public long result = 0;
    public int k = 0;

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        Solver solver = new Solver();
        solver.open();
        solver.solve();
        solver.close();
    }

    public void open() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    public void solve() throws NumberFormatException, IOException {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        
        int[] ar = new int[n];
        
        for(int i=0;i<n;i++){
            ar[i] = nextInt();
        }
        
        Arrays.sort(ar);
        
        out.println(ar[b]-ar[b-1]);
    }

    public void close() {
        out.flush();
        out.close();
    }

}