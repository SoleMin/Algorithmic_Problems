import java.io.*;
import java.util.*;
import java.math.*;

public class p481a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        if (r - l <= 1) {
            System.out.println("-1");
        } else if (r - l >= 3) {
            if (l % 2 == 0) {
                System.out.println(l + " " + (l + 1) + " " + (l + 2));
            } else {
                System.out.println((l + 1) + " " + (l + 2) + " " + (l + 3));
            }
        } else {
            long g1 = GCD(l, (l + 1));
            long g2 = GCD((l + 1), (l + 2));
            long g3 = GCD(l, r);
            if (g1 == 1 && g2 == 1 && g3 != 1) {
                System.out.println(l + " " + (l + 1) + " " + r);
            } else {
                System.out.println("-1");
            }
        }
    }

    public static long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}