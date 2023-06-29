import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger l = new BigInteger(scanner.next());
		BigInteger r = new BigInteger(scanner.next());
		if(r.subtract(l).intValue() < 2) {
			System.out.println(-1);
			return;
		}
		BigInteger a = l.abs(),b,c;
		
		BigInteger toothless = r.subtract(BigInteger.valueOf(1));
		while(a.compareTo(toothless) == -1) {
			b = l.add(BigInteger.valueOf(1));
			while(b.compareTo(r) == -1) {
				c = l.add(BigInteger.valueOf(2));
				while(c.compareTo(r) == -1 || c.compareTo(r) == 0) {
					if(gcd(a,b) == 1 && gcd(b,c) == 1 && gcd(a,c) != 1) {
						System.out.println(a + " " + b + " " + c);
						return;
					}
					
					c = c.add(BigInteger.valueOf(1));
				}
				b = b.add(BigInteger.valueOf(1));
			}
			a = a.add(BigInteger.valueOf(1));
		}
		System.out.println(-1);
	}
	private static int gcd(BigInteger a, BigInteger b) {
		return a.gcd(b).intValue();
	}
}