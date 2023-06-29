import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Contest {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
		BigInteger x = new BigInteger(s[0]);
		BigInteger k = new BigInteger(s[1]);

		BigInteger mod = new BigInteger(String.valueOf((int) (Math.pow(10, 9) + 7)));

		BigInteger two = new BigInteger("2");
		BigInteger interm = two.modPow(k, mod);

		BigInteger res = interm.multiply(two.multiply(x).subtract(BigInteger.ONE)).add(BigInteger.ONE).mod(mod);

		if(x.equals(BigInteger.ZERO)) {
			System.out.println("0");
			return;
		}
		System.out.println(res);
	}

}