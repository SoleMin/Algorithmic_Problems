import java.io.*;
import java.util.*;

public class Main {
	private void run() throws IOException {
		int cx = in.nextInt();
		int cy = in.nextInt();
		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; ++i) {
			x[i] = in.nextInt() - cx;
			y[i] = in.nextInt() - cy;
		}
		int[] dp = new int[1 << n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] prev = new int[1 << n];
		for (int mask = 0; mask < (1 << n); ++mask) {
			if (dp[mask] == Integer.MAX_VALUE) {
				continue;
			}
			for (int i = 0; i < n; ++i) {
				if (((mask >> i) & 1) == 0) {
					if (dp[mask | (1 << i)] > dp[mask] + dist(x[i], y[i])) {
						dp[mask | (1 << i)] = dp[mask] + dist(x[i], y[i]);
						prev[mask | (1 << i)] = mask;
					}
					for (int j = i + 1; j < n; ++j) {
						if (((mask >> j) & 1) == 0) {
							if (dp[mask | (1 << i) | (1 << j)] > dp[mask] + dist(x[i], y[i], x[j], y[j])) {
								dp[mask | (1 << i) | (1 << j)] = dp[mask] + dist(x[i], y[i], x[j], y[j]);
								prev[mask | (1 << i) | (1 << j)] = mask;
							}
						}
					}
					break;
				}
			}
		}
		out.println(dp[(1 << n) - 1]);
		int mask = (1 << n) - 1;
		out.print(0);
		while (mask != 0) {
			int p = prev[mask];
			int cur = p ^ mask;
			List<Integer> who = new ArrayList<Integer>();
			for (int i = 0; i < n; ++i) {
				if (((cur >> i) & 1) != 0) {
					who.add(i + 1);
				}
			}
			for (int t : who) {
				out.print(" " + t);
			}
			out.print(" " + 0);
			mask = p;
		}
		out.flush();
	}

	private int dist(int x, int y, int x2, int y2) {
		return x * x + y * y + x2 * x2 + y2 * y2 + (x2 - x) * (x2 - x) + (y2 - y) * (y2 - y);
	}

	private int dist(int x, int y) {
		return 2 * (x * x + y * y);
	}

	private class Scanner {
		private StringTokenizer tokenizer;
		private BufferedReader reader;

		public Scanner(Reader in) {
			reader = new BufferedReader(in);
			tokenizer = new StringTokenizer("");
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean hasNext() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				String next = reader.readLine();
				if (next == null)
					return false;
				tokenizer = new StringTokenizer(next);
			}
			return true;
		}

		public String next() throws IOException {
			hasNext();
			return tokenizer.nextToken();
		}

		public String nextLine() throws IOException {
			tokenizer = new StringTokenizer("");
			return reader.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}
	Scanner in = new Scanner(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}
