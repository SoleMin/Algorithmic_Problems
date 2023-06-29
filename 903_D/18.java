import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    static Map<BigInteger, BigInteger> mp = new HashMap<BigInteger, BigInteger>();

    public static void main(String[] args) {
        mp.clear();
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        BigInteger n = cin.nextBigInteger();
        BigInteger x = cin.nextBigInteger();
        mp.put(x, BigInteger.ONE);
        BigInteger sum = x;
        BigInteger ans = BigInteger.ZERO;
        for (int i = 2;i <= n.intValue(); i++) {
            x=cin.nextBigInteger();
            BigInteger tmp = x.multiply(BigInteger.valueOf(i-1)).subtract(sum);
            if (mp.containsKey(x.subtract(BigInteger.ONE))) tmp = tmp.subtract(mp.get(x.subtract(BigInteger.ONE)));
            if (mp.containsKey(x.add(BigInteger.ONE))) tmp = tmp.add(mp.get(x.add(BigInteger.ONE)));
            ans = ans.add(tmp);
            sum = sum.add(x);
            BigInteger xx;
            if (mp.containsKey(x)) xx = mp.get(x);
            else xx = BigInteger.ZERO;
            mp.put(x, xx.add(BigInteger.ONE));
        }
        System.out.println(ans);
    }
}
