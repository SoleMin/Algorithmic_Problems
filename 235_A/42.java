import java.util.Scanner;

public class A235 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		if (a % 2 == 0) {
			long result = cal(a);
			result = Math.max(result, cal(a + 1));
			result = Math.max(result, cal2(a));
			System.out.println(Math.max(result, a));
		}

		else {
			long result = (a - 1) * (a - 2) * (a - 0);
			System.out.println(Math.max(result, a));
		}
	}

	static long cal(long a) {
		long result = (a - 1) * (a - 2);
		result /= gcd(a - 1, a - 2);
		long gcd = gcd(result, a - 3);
		result *= (a - 3);
		result /= gcd;
		return result;
	}

	static long cal2(long a) {
		long result = (a) * (a - 1);
		result /= gcd(a - 1, a);
		long gcd = gcd(result, a - 3);
		result *= (a - 3);
		result /= gcd;
		return result;
	}

	private static long gcd(long l, long i) {
		if (l == 0 || i == 0) {
			return 1;
		}
		if (l % i == 0) {
			return i;
		}
		return gcd(i, l % i);
	}
}
