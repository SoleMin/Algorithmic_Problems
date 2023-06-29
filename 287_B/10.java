import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: horikawa
 * Date: 3/23/13
 * Time: 1:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class B {
    public static void main (String[] argv) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long max = ((k*(k-1))/2L)+1L;
        long ans = -1;
        if (n == 1) {
            System.out.println(0);
            return;
        }
        if (max < n) {
            ans = -1;
        } else if (max == n) {
            ans = k-1;
        } else {
            if (k >= n) {
                ans = 1;
            } else {
                long low = 1;
                long high = k-1;
                while (high > low+1) {
                    long mid = (low+high)/2;
                    long sum = (((mid+(k-1)) * (k-mid)) / 2) + 1;
                    if (sum >= n) {
                        low = mid;
                    } else {
                        high = mid;
                    }
                }
                ans = (k - low);
            }
        }
        System.out.println(ans);
        return;
    }
}
