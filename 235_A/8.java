import java.math.BigInteger;
import java.util.Scanner;

public class A235 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextInt();
        BigInteger res = null;
        if (n >= 3) {
            if (n % 2 != 0) {
                res = BigInteger.valueOf(n * (n - 1) * (n - 2));
            } else if (n % 3 == 0) {
                res = BigInteger.valueOf((n - 1) * (n - 2) * (n - 3));
            } else {
                res = BigInteger.valueOf(n * (n - 1) * (n - 3));
            }
        } else {
            res = BigInteger.valueOf(n);
        }
        System.out.println(res);
    }
}
