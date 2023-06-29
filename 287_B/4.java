import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		if ((k - 1) * k / 2 + 1 < n) {
			System.out.println(-1);
			return;
		}
		long left = 0;
		long right = k;
		while (left < right) {
			long m = (left + right) / 2;
			if (k * (k - 1)/2 - (k - m) * (k - m - 1) / 2 +1 < n)
				left = m + 1;
			else
				right = m;
		}
		System.out.println(left);
	}
}