import java.util.*;
import java.math.*;

public class Counterexample {
    public static void main(String[] args) {
        System.out.println(new Counterexample().solve());
    }

    String solve() {
        Scanner sc = new Scanner(System.in);

        final long l = sc.nextLong();
        final long r = sc.nextLong();

        if ((r - l) > 1) {
            long a = l;
            long b = l + 1;
            long c = l + 2;

            while (a < (r - 1)) {
                while (b < r) {
                    while (c <= r) {
                        if (gcd(a,b) == 1
                                && gcd(b,c) == 1
                                && gcd(a,c) > 1) {
                            return Long.toString(a)
                                + " "
                                + Long.toString(b)
                                + " "
                                + Long.toString(c);
                                }
                        c += 1;
                    }
                    c = b + 1;
                    b += 1;
                }
                b = a + 1;
                a += 1;
            }
        }
        return "-1";
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
