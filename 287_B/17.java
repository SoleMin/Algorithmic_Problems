import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long k = scan.nextLong();
		long total = k * (k - 1) / 2 + 1;
		if (total < n) {
			System.out.println(-1);
			return;
		}
		
		long left = total - n;
		long low = 1;
		long high = k - 1;
		while (low < high) {
			long mid = (low + high) / 2;
			long temp = mid * (mid + 1) / 2;
			if (temp < left) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		long temp = low * (low + 1) / 2;
		if (temp == left) {
			System.out.println(k - 1 - low);
		} else {
			System.out.println(k - low);
		}
	}
}
