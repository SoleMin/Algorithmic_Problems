import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception { 
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(System.out);
        
        in.nextToken();
        int n = (int) in.nval;
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                in.nextToken();
                a[i][j] = in.nval;
            }
        }
        
        double[] dp = new double[1 << n];
        dp[(1 << n) - 1] = 1.0;
        
        for (int mask = (1 << n) - 2; mask > 0; mask--) {
            int count = Integer.bitCount(mask);
            double pPair = 2.0 / ((double) count * (count + 1));
            double ans = 0.0;
            
            for (int j = 0; j < n; j++) {
                int jj = 1 << j;
                if ((jj & mask) != 0) continue;
                double p = dp[mask | jj];
                double s = 0;
                for (int k = 0; k < n; k++) {
                    int kk = 1 << k;
                    if ((kk & mask) == 0) continue;
                    s += a[k][j];
                }
                ans += s * pPair * p;
            }
            dp[mask] = ans;
        }
        
        for (int i = 0; i < n; i++) {
            pw.print(dp[1 << i]);
            pw.print(' ');
        }
        
        pw.close();
    }
}
