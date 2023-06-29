import java.util.*;
import java.io.*;

public class solve {
	Scanner in;
	PrintWriter out;

	public void solve() throws IOException {
		int n = in.nextInt();
		long k = in.nextLong();
		int[] a = new int[n];
		Set<Long> b = new TreeSet<Long>();
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (!b.contains((long) k * a[i])) {
				ans++;
				b.add((long) a[i]);
			}
		}
		out.print(ans);
	}

	public void run() {
		try {
			in = new Scanner(System.in);
			out = new PrintWriter(System.out);

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] arg) {
		new solve().run();
	}
}
