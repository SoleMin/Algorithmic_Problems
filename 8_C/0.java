import java.util.*;

public class Main {

    static int[] dp, x, y;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);


        int xs = sc.nextInt();
        int ys = sc.nextInt();
        n = sc.nextInt();
        x = new int[n + 1];
        y = new int[n + 1];

        x[0] = xs;
        y[0] = ys;

        for (int i = 1; i <= n; ++i) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        dp = new int[1 << (n + 1)];
        Arrays.fill(dp, -1);
        int ans = f(0);
        sb = new StringBuilder();
        trace(0);
        sb.append(0);

        System.out.println(ans);
        System.out.println(sb);
    }

    private static void trace(int mask) {
        if (mask == (1 << (n + 1)) - 2) return;

        for (int i = 1; i <= n; i++) {

            for (int j = i; j <= n && (mask & (1 << i)) == 0; j++) {
                if ((mask & (1 << j)) == 0) {

                    int newM = mask | (1 << i);
                    newM |= (1 << j);
                    int d1 = dis(0, i) + dis(i, j) + dis(j, 0);
                    int d2 = dis(0, j) + dis(j, i) + dis(i, 0);
                    if (f(mask) == f(newM) + Math.min(d1, d2)) {

                        if (i == j) sb.append("0 " + i + " ");
                        else if (d1 < d2) sb.append("0 " + i + " " + j + " ");
                        else sb.append("0 " + j + " " + i + " ");

                        trace(newM);
                        return;
                    }
                }
            }
        }
    }

    private static int f(int mask) {
        if (mask == (1 << (n + 1)) - 2) return 0; // 1 based indexing ( 111...10)
        if (dp[mask] != -1) return dp[mask];

        int ans = Integer.MAX_VALUE / 10;
        boolean found = false;

        for (int i = 1; i <= n && !found; i++) {
            if ((mask & (1 << i)) != 0) continue;
            ans = Math.min(ans, f(mask | (1 << i)) + 2 * dis(0, i)); // pick one
            for (int j = i; j <= n; j++) {
                if ((mask & (1 << j)) == 0) {
                    found = true;
                    int newM = mask | (1 << i);
                    newM |= 1 << j;
                    // pick two 
                    ans = Math.min(ans, f(newM) + dis(0, i) + dis(i, j) + dis(j, 0));
                }
            }
        }
        return dp[mask] = ans;
    }

    private static int dis(int i, int j) {
        int dx = x[i] - x[j];
        int dy = y[i] - y[j];
        return dx * dx + dy * dy;
    }

}