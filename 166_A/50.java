import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solver {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException, IOException {
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

    public class result implements Comparable{
        public int t = 0;
        public int p = 0;
        
        public result(int p,int t){
            this.t = t;
            this.p = p;
        }

        @Override
        public int compareTo(Object o) {
            result r = (result)o;
            int out = r.p-p;
            if (out==0) out = t-r.t;
            return out;
        }
        
        
    }
    
    public void solve() throws NumberFormatException, IOException {
        int n = nextInt();
        int k = nextInt();
        
        result[] table = new result[n];
        
        for (int i=0;i<n;i++){
            int p = nextInt();
            int t = nextInt();
            
            table[i] = new result(p,t);
        }
        
        Arrays.sort(table);
        
        int result = 1;
        k--;
        
        for (int i=k-1;i>=0 && table[i].p==table[k].p && table[i].t==table[k].t;i--){
            result++;
        }
        for (int i=k+1;i<n && table[i].p==table[k].p && table[i].t==table[k].t;i++){
            result++;
        }
        out.println(result);
    }

    public void close() {
        out.flush();
        out.close();
    }

}