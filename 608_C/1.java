import java.util.Scanner;

public class ChainReaction {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int m = 1000001;
        int[] b = new int[m];
        for (int i = 0; i < num; i++){
            int p = scan.nextInt();
            b[p] = scan.nextInt();
        }
        int [] dp = new int[m];
        if (b[0] > 0){
            dp[0] = 1;
        }
        int max = 0;
        for (int i = 1; i < m; i++){
            if (b[i] == 0){
                dp[i] = dp[i-1];
            }
            else if (b[i] >= i){
                dp[i] = 1;
            }
            else {
                dp[i] = dp[i - b[i] - 1] + 1;
            }

            if (dp[i] > max){
                max = dp[i];
            }
        }

        System.out.println(num - max);
        scan.close();
    }
}
