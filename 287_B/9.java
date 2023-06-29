import java.io.PrintWriter;
import java.util.*;

public class B {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		long K = sc.nextLong();

		if (N == 1) {
			out.println(0);
		} else if (N <= K) {
			out.println(1);
		} else if (N > ((K - 1) * (K)) / 2 + 1) {
			out.println(-1);
		} else {

			long lo = 1;
			long hi = Math.max(K - 2, 1);

			long big = ((K - 2) * (K - 1)) / 2;

			long prevmid = -1;

			for (int i = 0; i < 10000; i++) {
				long mid = (lo + hi) / 2;

				// K = 5
				// Start = K-2;
				// 1 = K-2;
				// 2 = K-3... etc.

				long tmp = ((K - 2 - mid) * (K - 2 - mid + 1)) / 2;
				//System.out.println(mid + " " + big + " " + tmp);

				if (K + big - tmp > N) {
					hi = mid;
				} else if (K + big - tmp < N) {
					lo = mid;
					if (prevmid == mid)
						lo++;
					lo = Math.min(lo, hi);
					prevmid = mid;
				} else {
					lo = mid;
					break;
				}
			}
			out.println((long) lo + 1);
		}
		sc.close();
		out.close();
	}
}
