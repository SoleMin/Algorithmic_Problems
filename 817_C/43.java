import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long s = scan.nextLong();
		scan.close();
		long start = s - s % 10;
		while (start <= n && !isBig(start, s)) {
			start += 10;
		}
		if (start > n) {
			System.out.println(0);
		} else {
			System.out.println(n - start + 1);
		}
	}

	private static boolean isBig(long a, long s) {
		char[] digits = ("" + a).toCharArray();
		int counter = 0;
		for (int i = 0; i < digits.length; i++) {
			counter += digits[i] - '0';
		}
		return a - counter >= s;
	}

}
