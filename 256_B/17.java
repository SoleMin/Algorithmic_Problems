import java.util.*;
import java.math.BigInteger;

import javax.naming.BinaryRefAddr;

public class acm
{
    public static BigInteger n;
    public static BigInteger TWO = new BigInteger("2");
    public static BigInteger solve(BigInteger x, BigInteger y, BigInteger c)
    {
        BigInteger res = (c.add(BigInteger.ONE)).multiply(c.add(BigInteger.ONE));
        res = res.add(c.multiply(c));
        BigInteger k;
        
        //up
        k = c.subtract(x.subtract(BigInteger.ONE)); 
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.subtract(k.multiply(k));

        //left
        k = c.subtract(y.subtract(BigInteger.ONE)); 
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.subtract(k.multiply(k));

        //down
        k = c.subtract(n.subtract(x)); 
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.subtract(k.multiply(k));


        //right
        k = c.subtract(n.subtract(y));
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.subtract(k.multiply(k));


        //upleft
        k = c.subtract(x.add(y).subtract(BigInteger.ONE));
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.add(k.multiply(k.add(BigInteger.ONE)).divide(TWO));


        //upright
        k = c.subtract(x.add(n).subtract(y));
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.add(k.multiply(k.add(BigInteger.ONE)).divide(TWO));


        //dwleft
        k = c.subtract(y.add(n).subtract(x));
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.add(k.multiply(k.add(BigInteger.ONE)).divide(TWO));


        //dwleft
        k = c.subtract(n.subtract(x).add(n.subtract(y)).add(BigInteger.ONE));
        if(k.compareTo(BigInteger.ZERO) > 0)
            res = res.add(k.multiply(k.add(BigInteger.ONE)).divide(TWO));



        return res;
    }
    
    public static void main(String[] args)
    {TWO = new BigInteger("2");
        Scanner in = new Scanner(System.in);
        n = new BigInteger(in.next());
        BigInteger x = new BigInteger(in.next());
        BigInteger y = new BigInteger(in.next());
        BigInteger c = new BigInteger(in.next());

        
        BigInteger left = new BigInteger("0");
        BigInteger right = new BigInteger("1000000000000");
        while(left.compareTo(right) < 0)
        {
            BigInteger val = left.add(right).divide(TWO);

            if(solve(x, y, val).compareTo(c) >= 0)
                right = val;
            else
                left = val.add(BigInteger.ONE);
        }

        System.out.println(left);
    } 
}