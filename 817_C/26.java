import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Fuad
 */
public class Codeforces {

    private static boolean greater(long mid, long s) {

        int sum = 0;
        long num = mid;

        while (num != 0) {
            sum += (num % 10);
            num /= 10;

        }

        return mid - sum >= s;
    }

    static class pair {

        int first;
        int second;

        pair(int f, int s) {
            first = f;
            second = s;
        }

        pair() {

        }

    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n, s;

        String arr[] = br.readLine().split(" ");

        n = Long.parseLong(arr[0]);
        s = Long.parseLong(arr[1]);

        long l = 1;
        long h = n;

        while (l < h) {
            long mid = (l + h) / 2;
            if (greater(mid, s)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(greater(h, s) ? n - h + 1 : 0);

    }

}
