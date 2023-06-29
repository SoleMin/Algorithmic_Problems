import javax.naming.PartialResultException;
import java.util.*;

import static java.util.Arrays.binarySearch;

public class codechef {
    private static Scanner sc = new Scanner(System.in);
    private static int hit = 0;
    private static int[] f = new int[10000002];

    public static void main(String[] args) {
        int i;
        f[0] = 0;
        f[1] = 1;
        for (i = 2; i < f.length; i++)
            f[i] = f[i - 1] + f[i - 2];
//        int t = 0;
//        if (sc.hasNext())
//            t = sc.nextInt();
//        for (int i = 1; i <= t; i++) {
        solve();
//        }
    }

    public static void solve() {
        int n = sc.nextInt();
        if (n==0){
            System.out.println("0 0 0");
            return;
        }
        if (n==1){
            System.out.println("0 0 1");
            return;
        }
        int index = -1;
        for (int j = 0; j < f.length; j++) {
            if (f[j] == n) {
                index = j;
                break;
            }
        }
        System.out.println("0 " + f[index - 1] + " " + f[index - 2]);
    }
}