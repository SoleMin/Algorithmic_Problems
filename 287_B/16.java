import java.util.Scanner;

public class Pipeline {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		sc.close();

		if (k * (k - 1) / 2 + 1 < n) {
			System.out.println(-1);
		} else {
			long l = -1, r = k;
			while (r - l > 1) {
				long m = (r + l) / 2;
				if (cantidadPosible(k, m) >= n) {
					r = m;
				} else {
					l = m;
				}
			}
			System.out.println(r);
		}

	}

	private static long cantidadPosible(long k, long usadas) {
		return (k * (k - 1) / 2 + 1 - (k - usadas) * (k - usadas - 1) / 2);
	}
}
