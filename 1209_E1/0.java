import java.util.*;

public class Main {
    static int N = 205;
    static int[][] a = new int[N][N];
    static int[][] dp = new int[N][20];
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t, n, m;
        t = reader.nextInt();
        while(t-- > 0){
            dp = new int[N][20];
            n = reader.nextInt();
            m = reader.nextInt();
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    a[i][j] = reader.nextInt();
                }
            }
            for(int i = 1; i <= m; i++){
                for(int s = 0; s < (1 << n); s++){
                    for(int k = 1; k <= n; k++){
                        int c = 0;
                        for(int j = 1; j <= n; j++){
                            if((s & (1 << j - 1)) != 0) c += a[j][i];
                        }
                        for(int p = 0; p < (1 << n); p++){
                            if((s & p) == 0) dp[i][s | p] = Math.max(dp[i][s | p], dp[i - 1][p] + c);
                        }
                        for(int j = 1; j <= n; j++){
                            a[j - 1][i] = a[j][i];
                        }
                        a[n][i] = a[0][i];
                    }
                }
            }
            System.out.println(dp[m][(1 << n) - 1]);
        }
    }
}
  	 	  	 		     					 	  		 			