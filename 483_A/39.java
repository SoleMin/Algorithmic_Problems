import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger l = sc.nextBigInteger();
		BigInteger r = sc.nextBigInteger();
		BigInteger a = l.add(BigInteger.ZERO);
		while (a.compareTo(r) < 0) {
			BigInteger b = a.add(BigInteger.ONE);
			while (b.compareTo(r) < 0) {
				try {
					a.modInverse(b);
				} catch (ArithmeticException e) {
					b = b.add(BigInteger.ONE);
					continue;
				}
				BigInteger c = b.add(BigInteger.ONE);
				while (c.compareTo(r) <= 0) {
					try {
						b.modInverse(c);
						try {
							a.modInverse(c);
						} catch (ArithmeticException e) {
							System.out.printf("%s %s %s\n", a.toString(), b.toString(), c.toString());
							return;
						}
					} catch (ArithmeticException e) {
						
					}
					c = c.add(BigInteger.ONE);
				}
				b = b.add(BigInteger.ONE);
			}
			a = a.add(BigInteger.ONE);
		}
		System.out.println("-1");
	}
}

