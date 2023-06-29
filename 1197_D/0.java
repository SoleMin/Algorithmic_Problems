
import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class D {
    static Scanner scan = new Scanner(System.in);

    public static void slove() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        int[] a = new int[n + 10];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int[] b = new int[n + 10];
        long[] sum = new long[n+10];
        long res = 0;
        for (int s = 0; s < m; s++) {
            for(int i=0;i<n;i++){
                b[i] = a[i];
                if(i%m==s) b[i] -= k;
            }
            long mi = 0;
            for(int i=1;i<=n;i++){
                sum[i] = sum[i-1] + b[i-1];
                if((i-1)%m == s){
                    res = Math.max(res,sum[i] - mi);
                }
                mi = Math.min(mi,sum[i]);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        //int T = scan.nextInt();
        //while (T-- > 0) {
            slove();
       // }
    }
}
 