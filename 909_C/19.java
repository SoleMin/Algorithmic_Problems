import java.util.Scanner;

public class Main3 implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new Main3(), "", 128 * 1024 * 1024).start();
    }

    private static Scanner in = new Scanner(System.in);

    public void run() {
        int n = in.nextInt();
        int m = 1_000_000_007;
        boolean[] state = new boolean[n];
        for (int i = 0; i < n; i++) {
            state[i] = in.next().equals("f");
        }
        // 使うのは[n][n]だけど、j+1==nのときif分岐せずに済むようにn+1にしてる
        long[][] dp = new long[n][n + 1];
        dp[0][0] = 1;
        // iは既に埋まっていてi+1に書き込んでいくから、i<n-1まででいい
        for (int i = 0; i < n - 1; i++) {
            if (state[i]) {
                // 右下にコピーしていくから溢れないようにj<n-1
                for (int j = 0; j < n - 1; j++) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            } else {
                // 何通りかというのを右から埋めていくからj--で進める
                for (int j = n - 1; j >= 0; j--) {
                    // 足していくと大きくなるからこの時点でもう%mしておく
                    dp[i + 1][j] = (dp[i][j] + dp[i + 1][j + 1]) % m;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[n - 1][i] % m;
        }
        System.out.println(sum % m);
    }
}