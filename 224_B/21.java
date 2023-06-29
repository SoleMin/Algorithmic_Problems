import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solver {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        Solver solver = new Solver();
        solver.open();
        long time = System.currentTimeMillis();
        solver.solve();
        if (!"true".equals(System.getProperty("ONLINE_JUDGE"))) {
            System.out.println("Spent time: "
                    + (System.currentTimeMillis() - time));
        }
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
        int k = nextInt();
        
        int[] ar = new int[n];
        int[] ex = new int[100005];
        int dif = 0;
        
        for(int i=0;i<n;i++){
            int tmp = nextInt();
            ar[i] = tmp;
            if (ex[tmp]++==0){
                dif++;          
            }           
        }
        
        if (dif<k){
            out.println("-1 -1");
            return;
        }
        
        Arrays.fill(ex, 0);
        dif = 0;
        int right = 0;
        while(dif<k){
            int tmp = ar[right];
            if(ex[tmp]++==0){       
                dif++;
            }
            right++;
        }
        
        int left = 0;
        while (ex[ar[left]]-- > 1) left++;
        
        out.println((left+1)+" "+right);
    }

    public void close() {
        out.flush();
        out.close();
    }

}