import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static double[] dp;
    static double[][] P;
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        int n = r.nextInt();
        
        double[][] g = new double[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                g[i][j] = r.nextDouble();
        
        dp = new double[1 << n];
        P = new double[1 << n][n];
        for(int mask = 0; mask < 1 << n; mask++){
            for(int d = 0; d < n; d++)if((mask & (1 << d)) == 0)
                for(int i = 0; i < n; i++)if((mask & (1 << i)) == 0){
                    if(i == d)continue;
                    
                    P[mask][d] += g[i][d];
                }
        }
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dp, -1);
            
            double res = go(i, 0, g, n, n);
            System.out.println(res);
        }
    }

    private static double go(int a, int v, double[][] g, int cnt, int n) {
        if(dp[v] != -1)return dp[v];
        
        if(cnt == 1){
            return 1;
        }else{
            double ret = 0;
            for(int d = 0; d < n; d++)if((v & (1 << d)) == 0 && d != a){
                double current =  P[v][d] * go(a, v | 1 << d, g, cnt-1, n);
                ret += current;
            }
            
            return dp[v] = ret/(cnt * (cnt-1) /2);
        }  
    }
}
