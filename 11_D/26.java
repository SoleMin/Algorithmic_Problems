import java.util.*;
import java.io.*;

public class Main implements Runnable {
	private void solution() throws IOException {
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[][] adj = new boolean[n][n];
		long res = 0;
		for (int i = 0; i < m; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			adj[x - 1][y - 1] = true;
			adj[y - 1][x - 1] = true;
		}
		final long[][] dp = new long[1 << n][n];
		for (int i = 0; i < n; ++i) {
			for (int mask = 0; mask < (1 << (n - i)); ++mask) {
				for (int j = 0; j < n - i; ++j) {
					dp[mask][j] = 0;
				}
			}
			dp[0][0] = 1;
			for (int mask = 0; mask < (1 << (n - i)); ++mask) {
				for (int j = 0; j < n - i; ++j) {
					if (dp[mask][j] != 0) {
						long am = dp[mask][j];
						for (int k = 0; k < n - i; ++k) {
							if (((mask >> k) & 1) == 0 && adj[j + i][k + i]) {
								dp[mask | (1 << k)][k] += am;
							}
						}
					}
				}
				if (((mask >> 0) & 1) != 0) {
					res += dp[mask][0];
				}
			}
		}
		out.println((res - m) / 2);
	}

	public void run() {
		try {
			solution();
			in.reader.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private class Scanner {
		BufferedReader reader;
		StringTokenizer tokenizer;

		public Scanner(Reader reader) {
			this.reader = new BufferedReader(reader);
			this.tokenizer = new StringTokenizer("");
		}

		public boolean hasNext() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				String next = reader.readLine();
				if (next == null) {
					return false;
				}
				tokenizer = new StringTokenizer(next);
			}
			return true;
		}

		public String next() throws IOException {
			hasNext();
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public String nextLine() throws IOException {
			tokenizer = new StringTokenizer("");
			return reader.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) throws IOException {
		new Thread(null, new Main(), "", 1 << 28).start();
	}
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	Scanner in = new Scanner(new InputStreamReader(System.in));
}
