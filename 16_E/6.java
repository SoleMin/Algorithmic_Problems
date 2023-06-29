import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Main{
    public static int n;
    public static double [] dp;
    public static double [][] p;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dp = new double[1<<n];
        p = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j]= in.nextDouble();                
            }
        }
        for (int i = 0; i <(1<<n); i++) {
            dp[i] = -1;            
        }
        dp[(1<<n)-1]=1;
        DecimalFormat d = new DecimalFormat("0.000000");
        System.out.print(d.format(f(1<<0)));
        for (int i = 1; i < n; i++) {
            System.out.print(" "+d.format(f(1<<i)));
        }
    }
    
    public static double f(int mask) {
        if(dp[mask]>-0.5) return dp[mask];
        dp[mask] = 0;
        int vivos = 1;
        for (int i = 0; i < n; i++) 
            if((mask>>i)%2==1) vivos++;
        double pares = (vivos*(vivos-1))/2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if((mask&(1<<i))!=0&&(mask&(1<<j))==0){
                    dp[mask]+=f(mask|(1<<j))*p[i][j]/pares;
                }
            }
            
        }
        return dp[mask];
                
    }
       
}
