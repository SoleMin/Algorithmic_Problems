import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = scanner.nextLong();
		long l = 0, r = n + 1;
		while(r - l > 1) {
			long mid = (l + r) / 2;
			long k = mid, sum = 0;
			while(k != 0) {
				sum += k % 10;
				k /= 10;
			}
			if(mid - sum >= s) r = mid; else l = mid;
		}
		System.out.print(n - r + 1);
	}
}
