import java.util.Scanner;

public class RationalResistance {
	static long n = 0;

	static void R(long a, long b) {
		n += a / b;
		a %= b;
		if (a == 0) {
			return;
		}
		R(b, a);
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		long a = cin.nextLong();
		long b = cin.nextLong();
		cin.close();
		R(a, b);
		System.out.println(n);
	}
}