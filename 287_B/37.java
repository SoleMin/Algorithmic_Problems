import java.util.*;
import java.math.*;
public class B2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        BigInteger n = new BigInteger(scan.next());
        BigInteger k = new BigInteger(scan.next());
        BigInteger a = k.subtract(bi(1));
        BigInteger lim = k.multiply(a).divide(bi(2));
        lim = lim.add(bi(1));
        //System.out.println("lim: "+lim);
        if (n.compareTo(lim)>0){
            System.out.println(-1);
        }
        else {
            if (n.equals(1)){
                System.out.println(0);
            }
            else {
                BigInteger remain2 = lim.subtract(n).add(bi(1));
                remain2 = remain2.multiply(bi(2));
                //System.out.println(remain2);
                double temp = remain2.doubleValue();
                //System.out.println(temp);
                long flr = (long)Math.sqrt(temp);
                //System.out.println(flr);
                BigInteger flr2 = bi(flr);
                BigInteger rnd2 = remain2.subtract(flr2.multiply(flr2));
                long rnd = remain2.longValue()-flr*flr;
                //System.out.println("rnd "+rnd);
                /*
                if (rnd<=flr){
                    System.out.println(k.intValue()-flr);
                }
                else {
                    System.out.println(k.intValue()-(flr+1));
                }
                */
                if (rnd2.compareTo(flr2)<=0){
                    System.out.println(k.subtract(flr2) );
                }
                else {
                    System.out.println(k.subtract(flr2.add(bi(1) ) ) );
                }
            }
        }
    }
    public static BigInteger bi(int n1){
        return new BigInteger(""+n1);
    }
    public static BigInteger bi(long n1){
        return new BigInteger(""+n1);
    }

}
