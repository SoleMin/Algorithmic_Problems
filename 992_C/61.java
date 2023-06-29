import java.math.BigInteger;
import java.util.Scanner;

public class TaskC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger x = new BigInteger(sc.next());
		BigInteger k = new BigInteger(sc.next());

		BigInteger mod = new BigInteger(String.valueOf((int) (Math.pow(10, 9) + 7)));

		BigInteger two = new BigInteger("2");
		BigInteger interm = two.modPow(k, mod);

		BigInteger res = interm.multiply(x).add(interm.multiply(x)).subtract(interm).add(BigInteger.ONE).mod(mod);

		if(x.equals(BigInteger.ZERO)) {
			System.out.println("0");
			return;
		}
		System.out.println(res);
	}

}
