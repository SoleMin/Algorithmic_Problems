import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong(), k = sc.nextLong();
		// BufferedReader rd = new BufferedReader(new
		// InputStreamReader(System.in));
		// StringTokenizer t = new StringTokenizer(rd.readLine(), " ");
		// int n = Integer.parseInt(rd.readLine());
		if (n == 1) {
			System.out.println(0);
			return;
		}
		if (n <= k) {
			System.out.println(1);
			return;
		}
		long seg = (((k + 1) * (k) / 2) - 1);
		seg += (2 - k);
		if (seg < n) {
			System.out.println(-1);
			return;
		}
		// long sum = k;
		// long out = 0l;
		long s = 1, f = k;
		long mid = (s + f) / 2;
		while (s + 1 < f) {
			long seg_m = (((mid + k - 1) * (k - mid) / 2));
			// seg += (2 - mid);
			// long sum_m = seg - seg_m;
			if (seg_m >= n - 1) {
				// if (n - mid < out || out == 0) {
				// out = n - mid - 1;
				// }
				s = mid;
			} else
				f = mid;
			mid = (s + f) / 2;
		}
		// for (long i = k - 1; sum < n && i >= 2; i--) {
		// sum += i - 1;
		// out++;
		// // if (sum >= n)
		// // break;
		// }
		System.out.println(k - s);
	}
}
