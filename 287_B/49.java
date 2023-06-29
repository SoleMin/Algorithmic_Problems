import java.math.BigInteger;
import java.util.Scanner;
public class ehsan 
{
	public static BigInteger f(BigInteger m,BigInteger n){
		BigInteger s,l;
		s=n.multiply(m.add(BigInteger.valueOf(1)));
		l=m.multiply(m.add(BigInteger.valueOf(1)));
		l=l.divide(BigInteger.valueOf(2));
		s=s.subtract(l);
		s=s.subtract(m);
		return s;
	}
	public static BigInteger bs(BigInteger a,BigInteger b,BigInteger n,BigInteger d){
		BigInteger c,e;
		c=a.add(b);
		c=c.divide(BigInteger.valueOf(2));
		e=f(c,n);
		if(e.equals(d))
			return c.add(BigInteger.valueOf(1));
		if(a.equals(b.add(BigInteger.valueOf(-1))))
			return b.add(BigInteger.valueOf(1));
		if(e.compareTo(d)>0)
			return bs(a,c,n,d);
		return bs(c,b,n,d);
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
  		BigInteger bi1 = sc.nextBigInteger();
  		BigInteger bi2 = sc.nextBigInteger();
		BigInteger i,n=bi2;
		BigInteger i2=BigInteger.valueOf(1);
		BigInteger sum=BigInteger.valueOf(0);
		if(bi1.compareTo(bi2)<0){
			System.out.println(0);
			return;
		}
		if(bi1.compareTo(bi2)==0){
			System.out.println(1);
			return;
		}
		bi2=((n.multiply(n.add(BigInteger.valueOf(1)))).divide(BigInteger.valueOf(2))).subtract(n.subtract(BigInteger.valueOf(1)));
		if(bi1.compareTo(bi2)>0)
			System.out.println(-1);
		else{
			System.out.println(bs(BigInteger.valueOf(0),n.add(BigInteger.valueOf(-2)),n,bi1));
		}
  }
}