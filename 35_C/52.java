
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author igor_kz
 */
public class C35 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");
        int n = in.nextInt() , m = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[k];
        int[] y = new int[k];
        int res = 0;
        for (int i = 0 ; i < k ; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        int xx = 1 , yy = 1;
        for (int i = 1 ; i <= n ; i++)
            for (int j = 1 ; j <= m ; j++) {
                int cnt = Integer.MAX_VALUE;
                for (int l = 0 ; l < k ; l++) {
                    int time = Math.abs(i - x[l]) + Math.abs(j - y[l]);
                    cnt = Math.min(cnt , time);
                }
                if (cnt > res) {
                    res = cnt;
                    xx = i;
                    yy = j;
                }
                res = Math.max(res , cnt);
            }
        out.print(xx + " " + yy);
        out.close();
    }
}
