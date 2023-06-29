import java.math.BigInteger;
import java.util.*;
public class C {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long s = sc.nextLong();
        
        BigInteger k = findFirst(BigInteger.valueOf(s));
        if (BigInteger.valueOf(n).compareTo(k) >= 0)
        {
            System.out.println(n - k.longValue() + 1);
        }
        else
        {
            System.out.println("0");
        }
    }
    
    public static BigInteger findFirst(BigInteger s) // first number where sum of digs >= s
    {
        BigInteger b = BigInteger.ZERO;
        while (cd(b).compareTo(b.subtract(s)) > 0)
        {
            BigInteger c = BigInteger.ONE;
            while (cd(b.add(c)).compareTo(b.add(c).subtract(s)) > 0) {
                c = c.multiply(BigInteger.TEN);
            }
            // possibly overshot
            c = c.divide(BigInteger.TEN);
            if (c.compareTo(BigInteger.TEN) < 0) c = BigInteger.TEN; // always add at least 10
            b = b.add(c);
        }
        return b;
    }
    
    public static BigInteger cd(BigInteger n)
    {
        BigInteger t = BigInteger.ZERO;
        while (n.compareTo(BigInteger.ZERO) > 0)
        {
            t = t.add(n.mod(BigInteger.TEN));
            n = n.divide(BigInteger.TEN);
        }
        return t;
    }
}
