
import java.util.Scanner;

public class A {
    static long l, r, A, B, C;

    static long GCD(long a, long b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    static boolean gcd(long a, long b) {
        return GCD(a, b) == 1;
    }

    static boolean found(long a, long b, long c) {
        if (b <= a || c <= b)
            return false;
        if (a > r || b > r || c > r)
            return false;
        if (gcd(a, b) && gcd(b, c) && !gcd(a, c)) {
            A = a;
            B = b;
            C = c;
            return true;
        }
        if (found(a + 1, b + 1, c + 1))
            return true;
        if (found(a + 1, b, c + 1))
            return true;
        if (found(a + 1, b + 1, c))
            return true;
        if (found(a, b, c + 1))
            return true;
        if (found(a, b + 1, c + 1))
            return true;
        if (found(a, b + 1, c))
            return true;
        return found(a + 1, b, c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextLong();
        r = sc.nextLong();
        if (found(l, l + 1, l + 2))
            System.out.println(A + " " + B + " " + C);
        else
            System.out.println(-1);
    }
}
