
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 11815 on 2017/7/1.
 */
public class Main {
    private static int[] x = new int[26], y = new int[26], dp = new int[1<<24], pre = new int[1<<24];
    private static int dis(int i, int j) {
        return (x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt(), y0 = in.nextInt(), n = in.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        x[n] = x0;
        y[n] = y0;
        int[][] gra = new int[26][26];
        for (int i = 0; i < n + 1; i++) {
            for (int j = i+1; j < n+1; j++) {
                gra[i][j] = gra[j][i] = dis(i,j);
            }
        }
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (dp[i] != -1) {
                for (int j = 0; j < n; j++) {
                    if (((1<<j)&i) == 0) {
                        int t = i | (1<<j), tmp = dp[i] + 2*gra[j][n];
                        if (dp[t] == -1 || dp[t] > tmp) {
                            dp[t] = tmp;
                            pre[t] = i;
                        }
                        for (int k = 0; k < n; k++) {
                            if ((t&(1<<k)) == 0) {
                                int t2 = t | (1<<k), tmp2 = dp[i] + gra[n][j] + gra[j][k] + gra[k][n];
                                if (dp[t2] == -1 || dp[t2] > tmp2) {
                                    dp[t2] = tmp2;
                                    pre[t2] = i;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        int end = (1<<n)-1, cnt = 0;
        int[] ans = new int[60];
        System.out.println(dp[end]);
        while (end != 0) {
            int pr = pre[end];
            int tem = pr^end;
            int a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                if (((1<<i)&tem)!=0) {
                    b=a;
                    a=i+1;
                }
            }
            ans[cnt++] = 0;
            ans[cnt++] = a;
            if (b>0) {
                ans[cnt++] = b;
            }
            end = pr;
        }
        ans[cnt++] = 0;
        for (int i = cnt-1; i >= 0; i--) {
            System.out.print(ans[i] + " ");
        }
        System.out.print("\n");
    }
}
