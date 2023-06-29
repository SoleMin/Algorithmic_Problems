
import java.util.Arrays;
import java.util.Scanner;

public class E {
    static int n;
    static int m;
    static int[][][] DP;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int inf = 1000000;

    public static int get(int x, int current, int last) {
        if (x == n) {
            if (last == 0)
                return 0;
            else
                return -inf;
        }
        if (DP[x][current][last] != -1)
            return DP[x][current][last];
        int max = 0;
        for (int mask = 0; mask < (1 << m); mask++) {
            int tempLast = last;
            int tempCurrent = current;
            int tempNext = (1 << m) - 1;
            for (int i = 0; i < m; i++)
                if ((mask & (1 << i)) != 0) {
                    if (i > 0)
                        tempCurrent &= ~(1 << (i - 1));
                    if (i < m - 1)
                        tempCurrent &= ~(1 << (i + 1));
                    tempNext &= ~(1 << (i));
                    tempLast &= ~(1 << (i));
                }
            if (tempLast != 0)
                continue;
            max = Math.max(
                    max,
                    m - Integer.bitCount(mask)
                            + get(x + 1, tempNext, tempCurrent & ~mask));
        }
        return DP[x][current][last] = max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        n = Math.max(x, y);
        m = Math.min(x, y);
        DP = new int[n][1 << m][1 << m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < (1 << m); j++)
                Arrays.fill(DP[i][j], -1);
        System.out.println(get(0, (1 << m) - 1, 0));
    }
}
