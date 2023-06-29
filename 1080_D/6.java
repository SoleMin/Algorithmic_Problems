import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<BigInteger> bs = new ArrayList<>();

    static void getBs(int n, BigInteger k) {
        BigInteger four = BigInteger.valueOf(4);
        BigInteger tmp4 = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(tmp4);
            bs.add(sum);
            if (sum.compareTo(k) >= 0) break;
            tmp4 = tmp4.multiply(four);
        }
    }

    static int ss(int n, BigInteger k) {
        bs = new ArrayList<>();
        BigInteger two = BigInteger.valueOf(2);
        BigInteger s1;
        BigInteger ts = BigInteger.ZERO;
        getBs(n - 1, k);
        int idx = bs.size() - 1;
        BigInteger tx = BigInteger.valueOf(-1);
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            two = two.shiftLeft(1);
            s1 = two.add(BigInteger.valueOf(-i - 2));
            if (idx >= 0) {
                tx = tx.add(BigInteger.ONE).multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
                ts = ts.add(tx.multiply(bs.get(idx--)));
            }
            if (k.compareTo(s1) >= 0) {
                if (k.subtract(s1).compareTo(ts) <= 0) {
                    ans = n - i;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            BigInteger k = sc.nextBigInteger();
            int ans = ss(n, k);
            if (ans == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES " + ans);
            }
        }
    }
}