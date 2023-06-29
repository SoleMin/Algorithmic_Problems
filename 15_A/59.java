import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author burdakovd
 * 
 */
public class A {

	static class House {
		int x, a;
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final Scanner in = new Scanner(System.in);
		final PrintWriter out = new PrintWriter(System.out);

		try {
			final int n = in.nextInt();
			final int t = in.nextInt();

			final House[] h = new House[n];
			for (int i = 0; i < h.length; ++i) {
				h[i] = new House();
				h[i].x = in.nextInt();
				h[i].a = in.nextInt();
			}

			Arrays.sort(h, new Comparator<House>() {

				@Override
				public int compare(final House o1, final House o2) {
					return Integer.valueOf(o1.x).compareTo(o2.x);
				}
			});

			int ans = 2;
			for (int i = 1; i < n; ++i) {
				final int dspace = 2 * h[i].x - h[i].a
						- (2 * h[i - 1].x + h[i - 1].a);
				if (dspace == 2 * t) {
					++ans;
				} else if (dspace > 2 * t) {
					ans += 2;
				}
			}

			out.println(ans);

		} finally {
			in.close();
			out.close();
		}
	}
}
