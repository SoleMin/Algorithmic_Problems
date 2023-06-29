import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        setup();
        xuly();
    }

    private static long dp[][] = new long[20][170];

    private static void setup() {
        dp[0][0] = 1;
        for (int i = 1; i < 20; i ++)
            for (int j = 0; j < 170; j ++)
                for (int k = Math.max(j - 9, 0); k <= j; k ++)
                    dp[i][j] += dp[i - 1][k];
    }

    private static int sumD(long x) {
        int ret = 0;
        while(x > 0) {
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }

    private static long numSatisfy(long limit, int sumDigit) {
        long ret = 0;
        int curSum = sumD(limit);
        if (curSum == sumDigit)
            ret ++;

        for (int i = 0; i < 20; i ++) {
            int bound = (int) (limit % 10);
            curSum -= bound;
            for (int d = 0; d < bound && curSum + d <= sumDigit; d ++)
                ret += dp[i][sumDigit - curSum - d];
            limit /= 10;
        }

        return ret;
    }

    private static void xuly() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = scanner.nextLong();
        long ans = 0;
        for (int sum = 1; sum < 170; sum ++)
            if (n >= s + sum)
                ans += numSatisfy(n, sum) - numSatisfy(s + sum - 1, sum);
        System.out.print(ans);
    }
}
