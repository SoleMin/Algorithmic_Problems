import java.util.Scanner;

public class C {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		long n = scan.nextLong();
		long s = scan.nextLong();
		long low = 0;
		long high = n + 1;
		while (high-low>1) {
			long sum = 0;
			long mid = (high + low) / 2;
			long value = findSum(mid, sum);
			if (mid - value >= s)
				high = mid;
			else
				low = mid;
		}
		
		System.out.println(n - high + 1);

		scan.close();
	}

	public static long findSum(long n, long sum) {
		if (n == 0)
			return sum;
		return findSum(n / 10, sum + n % 10);
	}

}