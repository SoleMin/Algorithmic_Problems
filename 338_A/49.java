import java.math.BigInteger;
import java.util.*;

public class A {
	private static Scanner in;
	
	final int M = 1000000009;

	public void run() {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int z = n - m;
		if (z >= n / k) {
			System.out.println(m);
			return;
		}
		int f = n - k * z;
		int last = f % k + (k - 1) * z;
		f /= k;
		int ans = BigInteger.ONE.shiftLeft(f + 1).remainder(BigInteger.valueOf(M)).intValue();
		System.out.println(((ans + M - 2L) * k + last) % M);
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		in = new Scanner(System.in);
		new A().run();
		in.close();
	}
}
