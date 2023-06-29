import java.util.Scanner;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] DP = new int[n][n + 1];
        DP[0][0] = 1;

        for (int i = 0; i < n - 1; i++) {
            if (in.next().charAt(0) == 'f') {
                for (int j = 1; j < n; j++)
                    DP[i+1][j] = DP[i][j-1];
            } else {
                for (int j = n - 1; j >= 0; j--)
                    DP[i+1][j] = (DP[i][j] + DP[i+1][j+1]) % MOD;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++)
            answer = (answer + DP[n-1][i]) % MOD;
        System.out.println(answer);
    }

}
