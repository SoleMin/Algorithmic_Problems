
import java.util.Scanner;

public class CF489_C {
	static long mod = 1000000007;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long x = s.nextLong(), k = s.nextLong();
		if (x == 0) {
			System.out.println(0);
			return;
		}
		long max = x % mod;
		long temp = power(2, k, mod);
		temp %= mod;
		max = (max % mod) * (temp % mod);
		max %= mod;
		long min = max % mod;
		min = mod(min - (temp - 1));
		min %= mod;
		long num = mod(max - min + 1);
		long n = num % mod;
		n = (n % mod) * (min % mod + max % mod);
		n = n % mod;
		n %= mod;
		long ans = n % mod * modInverse(num, mod);
		System.out.println(ans % mod);

	}

	static long modInverse(long a, long m) {
		long m0 = m;
		long y = 0, x = 1;

		if (m == 1)
			return 0;

		while (a > 1) {
			// q is quotient
			long q = a / m;
			long t = m;

			// m is remainder now, process same as
			// Euclid's algo
			m = a % m;
			a = t;
			t = y;

			// Update y and x
			y = x - q * y;
			x = t;
		}

		// Make x positive
		if (x < 0)
			x += m0;

		return x;
	}

	static long mod(long val) {
		val %= mod;
		if (val < 0)
			val += mod;
		return val;
	}

	static long power(long x, long y, long p) {
		// Initialize result
		long res = 1;

		// Update x if it is more
		// than or equal to p
		x = x % p;

		while (y > 0) {
			// If y is odd, multiply x
			// with result
			if ((y & 1) == 1)
				res = (res * x) % p;

			// y must be even now
			// y = y / 2
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

}