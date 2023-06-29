import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;

public class Contest {

	static final Random random = new Random();

	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<Integer> xn = new ArrayList<>(), xm = new ArrayList<>();

		for (int i = 0; i < n; i++)
			xn.add(sc.nextInt());

		for (int i = 0; i < m; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			sc.nextInt();
			if (x1 != 1)
				continue;
			xm.add(x2);
		}

		Collections.sort(xn);
		Collections.sort(xm);

		int p = 0;
		int min = Integer.MAX_VALUE;
		m = xm.size();
		int next = 0;
		if (n == 0) {
			next = (int) 1e9;
		} else {
			next = xn.get(0);
		}
		p = bs(xm, next);
		if (p == -1)
			p = m;
		min = m - p;
		for (int i = 0; i < n; i++) {
			if (n - 1 == i)
				next = (int) 1e9;
			else
				next = xn.get(i + 1);
			p = bs(xm, next);
			if (p == -1)
				p = m;
			min = Math.min(min, i + 1 + m - p);
		}

		out.println(min);

		out.flush();
	}

	static int bs(ArrayList<Integer> a, int x) {
		int l = 0, r = a.size() - 1, ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (a.get(mid) >= x) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
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