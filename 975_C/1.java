import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

public class Contest {

	static final Random random = new Random();

	static PrintWriter out = new PrintWriter(System.out);

	static long[] p;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), q = sc.nextInt();

		long[] a = new long[n];
		p = new long[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			p[i] = a[i];
			if (i != 0)
				p[i] += p[i - 1];
		}
		int l = 0, r = n - 1;
		long arrows_left = 0;
		int soldiers = n;
		for (int i = 0; i < q; i++) {
			long ki = sc.nextLong() + arrows_left;
			int bs = bs(l, r, ki);

			if (bs == n - 1) {
				out.println(n);
				soldiers = n;
				arrows_left = 0;
				l = 0;
				continue;
			}

			if (bs == -1) {
				out.println(soldiers);
				arrows_left = ki;
				continue;
			}

			long sub = 0;

			if (l != 0)
				sub = p[l - 1];

			arrows_left = (ki - (p[bs] - sub));

			l = bs + 1;

			soldiers = n - (bs + 1);
			out.println(n - (bs + 1));
		}

		out.flush();
	}

	static int bs(int l, int r, long x) {
		int ans = -1;
		int L = l;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			long cmp = p[mid];
			if (L != 0)
				cmp -= p[L - 1];
			if (cmp <= x) {
				ans = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}
		return ans;
	}

	static void Arrayssort(int[] a) {
		int n = a.length;// shuffle, then sort
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n);
			int temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		java.util.Arrays.sort(a);
	}

	private static class Scanner {
		public BufferedReader reader;
		public StringTokenizer st;

		public Scanner(InputStream file) throws FileNotFoundException {
			reader = new BufferedReader(new InputStreamReader(file));
			st = null;
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = reader.readLine();
					if (line == null)
						return null;
					st = new StringTokenizer(line);
				} catch (Exception e) {
					throw (new RuntimeException());
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}
	}

}