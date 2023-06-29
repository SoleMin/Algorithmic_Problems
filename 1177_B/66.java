import java.util.Scanner;
 
public class Main {
 
	public static Character solve(long a, long b, long c) {
		long min = a;
		long max;
		long xth = 0;
		long index;
 
		for (index = String.valueOf(a).length() - 1;; index++) {
			long numOfDigits = 0;
			max = (long) Math.pow(10, index + 1) - 1;
			long count = (max - min) / b + 1;
			numOfDigits += count * (index + 1);
 
			if (c - numOfDigits <= 0) {
				break;
			}
			c -= numOfDigits;
			min = min + count * b;
 
		}
 
		// find xth
		if (c % (index + 1) == 0) {
			xth = c / (index + 1);
		} else {
			xth = c / (index + 1) + 1;
		}
		long lastNum = min + b * (xth - 1);
 
		int pos = (int) (c % (index + 1));
 
		// here is the output
		if (pos == 0) {
			return String.valueOf(lastNum).charAt((int) index);
		} else {
			return String.valueOf(lastNum).charAt(pos - 1);
		}
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long tc;
		tc = sc.nextLong();
		System.out.println(solve(1, 1, tc));
		}
 
}