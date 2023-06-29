import java.util.Scanner;

public class ReallyBigNumbers {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong(); // max
		long s = sc.nextLong(); // differential
		long bigNums = 0;
		long inARow = 0;
		for (long i = s; i <= n; i++) {
			if (inARow == 9) {
				bigNums += (n - i+1);
				break;
			} else {
				if (i >= s + digitSum(i)) {
					bigNums++;
					inARow++;
				} else {
					inARow = 0;
				}
			}
		}
		System.out.println(bigNums);
	}

	public static long digitSum(long a) {
		long sum = a % 10;
		if (9 < a) {
			a /= 10;
			sum += digitSum(a);
		}
		return sum;
	}
}
