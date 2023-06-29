import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n;
		BigInteger il = new BigInteger("2");
		BigInteger e = new BigInteger("5");
		BigInteger sam = new BigInteger("13");

		while (scan.hasNextInt()) {
			n = scan.nextInt();
			BigInteger C[] = new BigInteger[1001];

			C[1] = il;
			C[2] = e;
			C[3] = sam;
			BigInteger result = cal(n, C);

			if (result.equals(BigInteger.ZERO)) {
				System.out.println(C[n]);
			} else {
				System.out.println(result);
			}
		}
	}

	public static BigInteger cal(int n, BigInteger C[]) {
		BigInteger pl = new BigInteger("2");

		if (n <= 3) {
			return BigInteger.ZERO;
		}
		for (int i = 4; i <= 1000; i++) {
			C[i] = C[i - 1].multiply(pl).add(C[i - 2]).add(C[i - 3]);
		}
		return C[n];
	}

}