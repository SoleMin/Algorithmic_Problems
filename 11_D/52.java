import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	private int n;
	private int m;
	private boolean[][] g;
	private long[][] dp;
	private int[] count;
	private int[] first;

	private void solve() throws IOException {
		n = nextInt();
		m = nextInt();

		g = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int a = nextInt() - 1;
			int b = nextInt() - 1;
			g[a][b] = true;
			g[b][a] = true;
		}

		count = new int[1 << n];
		first = new int[1 << n];
		dp = new long[1 << n][n];
		for (int mask = 0; mask < (1 << n); mask++) {
			count[mask] = bitCount(mask);
			for (int i = 0; i < n; i++) {
				if (bit(i, mask) == 1) {
					first[mask] = i;
					break;
				}
			}
		}

		for (int mask = 0; mask < (1 << n); mask++) {
			for (int i = 0; i < n; i++) {
				if ((count[mask] == 1) && (bit(i, mask) == 1)) {
					dp[mask][i] = 1;
				} else {
					for (int j = 0; j < n; j++) {
						if (g[j][i] && (count[mask] > 1) && (bit(i, mask) == 1)
								&& (first[mask] != i)) {
							dp[mask][i] += dp[mask ^ (1 << i)][j];
						}
					}
				}
			}
		}

		long ans = 0;
		for (int i = 0; i < n; i++) {
			for (int mask = 0; mask < (1 << n); mask++) {
				if ((count[mask] >= 3) && (first[mask] != i)
						&& (g[i][first[mask]])) {
					ans += dp[mask][i];
				}
			}
		}

		if (ans % 2 != 0) {
			throw new RuntimeException("SHIT!!!");
		}
		out.println(ans / 2);
	}

	private final int bit(int i, int mask) {
		return (mask & (1 << i)) != 0 ? 1 : 0;
	}

	private final int bitCount(int mask) {
		int ret = 0;
		while (mask != 0) {
			ret++;
			mask -= mask & (-mask);
		}
		return ret;
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private Main() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		eat("");
		solve();
		in.close();
		out.close();
	}

	private void eat(String s) {
		st = new StringTokenizer(s);
	}

	String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

}
