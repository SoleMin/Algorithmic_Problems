import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main implements Runnable {
    PrintWriter out;
    BufferedReader in;
    StringTokenizer st;
    
    void solve() throws Exception {
        int n = nextInt();
        int[] a = new int[n];
        int sum = 0;
        for(int i = 0; i < n; ++i) {
            a[i] = nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        int ans = 0, csum = 0;
        for(int i = n - 1; csum <= sum - csum && i >= 0; i--) {
            csum += a[i];
            ans++;
        }
        out.println(ans);
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
//          in = new BufferedReader(new FileReader("input.txt"));
//          out = new PrintWriter("output.txt");
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static public void main(String args[]) throws Exception {
        (new Main()).run();
    }
    
    int nextInt() {
        return Integer.parseInt(nextToken());
    }
    
    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
    
    String nextToken() {
        while(st == null || !st.hasMoreTokens()) {
            try {
                String line = in.readLine();
                st = new StringTokenizer(line);
            } catch(Exception e) {
                return null;
            }
        }
        return st.nextToken();
    }
}
