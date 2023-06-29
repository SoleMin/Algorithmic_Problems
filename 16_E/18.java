
import java.util.Arrays;
import java.util.Scanner;

public class P16E {
    int n;
    double [][]prob;
    double []dp;
    public P16E() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        prob = new double [n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                prob[i][j] = sc.nextDouble();
            }
        }
        sc.close();

        dp = new double[(1<<n)];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            int a = 1 << i;
            System.out.print(compute(a) + " ");
        }
    }

    double compute (int mask){
        if (mask == (1<<n) - 1){
            return 1;
        }
        if (dp[mask] != -1){
            return dp[mask];
        }
        double result = 0;
        int c = 0;       
        for (int i = 0; i < n; i++) {
            int a = 1 << i;
            if ((a & mask) != 0) {
                c++;
                for (int j = 0; j < n; j++) {
                    int b = 1 << j;
                    if ((b & mask) == 0) {
                        result += (prob[i][j] * compute(mask | b));
                    }
                }
            }
        }

        int nC2 = (c + 1) * c / 2;
        dp[mask] = result / nC2;
        return dp[mask];

    }

    public static void main (String []args){
        new P16E();
    }
}
