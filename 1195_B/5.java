import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class B {
    static long n, k;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = in.nextLong();
        k = in.nextLong();
        long ans = n - TernarySearch(0, n);
        pw.println(ans);
        pw.close();
    }

    static long cal(long m) {
        long x = (m * (m + 1)) / 2;
        long y = x - (n - m);
        return abs(k - y);
    }

    static long TernarySearch(long l, long r) {
        long m1, m2;
        while (r - l > 5) {
            m1 = (2 * l + r) / 3;
            m2 = (l + 2 * r) / 3;
            if (cal(m1) > cal(m2)) l = m1;
            else r = m2;
        }
        long min = cal(l), i = l;
        for (; l <= r; l++) {
            long t = cal(l);
            if (t < min) {
                min = t;
                i = l;
            }
        }
        return i;
    }


    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}