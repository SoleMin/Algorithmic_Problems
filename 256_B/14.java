import java.util.Scanner;
import java.math.BigInteger;
import java.io.*;

public class Main{

	/**
	 * @param args
	 */
	static BigInteger n, x, y, c;
	static BigInteger mk[] = new BigInteger[8];
	public static BigInteger f(BigInteger t) {
		return t.multiply(t);
	}
	
	public static BigInteger g(BigInteger t) {
		return t.multiply(t.add(BigInteger.ONE)).shiftRight(1);
	}
	
	public static int solve(BigInteger z) {
		BigInteger ret = z.multiply(z.add(BigInteger.ONE)).shiftLeft(1);
		ret = ret.add(BigInteger.ONE);
		//System.out.println(z + " " + ret);
		for(int i = 0; i < 8; i += 2) {
			if(z.compareTo(mk[i]) > 0) {
				ret = ret.subtract(f(z.subtract(mk[i])));
			}
		}
		for(int i = 1; i < 8; i += 2) {
			if(z.compareTo(mk[i]) > 0) {
				ret = ret.add(g(z.subtract(mk[i])));
			}
		}
		//System.out.println(z + " " + ret);
		if(ret.compareTo(c) >= 0) return 1;
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			n = cin.nextBigInteger();
			x = cin.nextBigInteger();
			y = cin.nextBigInteger();
			c = cin.nextBigInteger();
			mk[0] = x.subtract(BigInteger.ONE);
			mk[2] = n.subtract(y);
			mk[4] = n.subtract(x);
			mk[6] = y.subtract(BigInteger.ONE);
			mk[1] = mk[0].add(mk[2]).add(BigInteger.ONE);
			mk[3] = mk[2].add(mk[4]).add(BigInteger.ONE);
			mk[5] = mk[4].add(mk[6]).add(BigInteger.ONE);
			mk[7] = mk[6].add(mk[0]).add(BigInteger.ONE);
			BigInteger beg = BigInteger.ZERO, end = mk[0], mid;
			for(int i = 1; i < 8; ++i) if(end.compareTo(mk[i]) < 0) end = mk[i];
			while(beg.compareTo(end) < 0) {
				mid = beg.add(end).shiftRight(1);
				if(solve(mid) == 1) end = mid;
				else beg = mid.add(BigInteger.ONE);
			}
			System.out.println(end);
		}

	}

}
