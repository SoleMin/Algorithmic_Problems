

import java.math.BigInteger;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        if (n == 1) {
            System.out.println(0);
        } else if (n <= k) {
            System.out.println(1);
        } else {
            n--;
            k--;
            BigInteger K = BigInteger.valueOf(k);
            BigInteger N = BigInteger.valueOf(n);
            BigInteger high = BigInteger.valueOf(k + 1);
            BigInteger low = BigInteger.valueOf(1);
            BigInteger mid;
            while (low.compareTo(high) < 0) {
                mid = low.add(high.subtract(low).shiftRight(1));
                BigInteger elemCnt = K.subtract(mid).add(BigInteger.ONE);
                BigInteger sum = elemCnt.multiply(
                        mid.shiftLeft(1).add(elemCnt.subtract(BigInteger.ONE)))
                        .shiftRight(1);
                if (sum.compareTo(N) > 0) {
                    low = mid.add(BigInteger.valueOf(1));
                } else {
                    high = mid;
                }
            }
            BigInteger elemCnt = K.subtract(low).add(BigInteger.ONE);
            BigInteger sum = elemCnt.multiply(
                    low.shiftLeft(1).add(elemCnt.subtract(BigInteger.ONE)))
                    .shiftRight(1);
            BigInteger rem = N.subtract(sum);
            if (rem.equals(BigInteger.ZERO)) {
                System.out.println(elemCnt);
            } else if (rem.compareTo(low) < 0) {
                System.out.println(elemCnt.add(BigInteger.ONE));
            } else {
                System.out.println(-1);
            }
        }
    }
}
