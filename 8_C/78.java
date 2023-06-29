import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LookingForOrder {

	static int[] x, y;
	static int[] dp;
	static int n;

	static int dist(int i, int j) {
		return ((x[i] - x[j]) * (x[i] - x[j]))
				+ ((y[i] - y[j]) * (y[i] - y[j]));
	}

	static int solve(int mask) {
		if (mask == (1 << n) - 1)
			return 0;
		if (dp[mask] != -1)
			return dp[mask];
		int ans = Integer.MAX_VALUE;
		int j = 0;
		for (int i = 1; i < n; i++)
			if ((mask & (1 << i)) == 0) {
				if (j == 0) {
					ans = Math
							.min(ans, 2 * dist(0, i) + solve(mask | (1 << i)));
					j = i;
				} else
					ans = Math.min(ans, dist(0, i) + dist(i, j) + dist(j, 0)
							+ solve(mask | (1 << i) | (1 << j)));
			}
		return dp[mask] = ans;
	}

	static void prnt(int mask) {
		if (mask == (1 << n) - 1)
			return;
		int j = 0;
		for (int i = 1; i < n; i++)
			if ((mask & (1 << i)) == 0) {
				if (j == 0) {
					j = i;
					if (dp[mask] == 2 * dist(0, i) + solve(mask | (1 << i))) {
						out.print(" " + i + " 0");
						prnt(mask | (1 << i));
						return;
					}
				} else if (dp[mask] == dist(0, i) + dist(i, j) + dist(j, 0)
						+ solve(mask | (1 << i) | (1 << j))) {
					out.print(" " + i + " " + j + " 0");
					prnt(mask | (1 << i) | (1 << j));
					return;
				}
			}
	}

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());
		int a = nxtInt();
		int b = nxtInt();
		n = nxtInt() + 1;
		x = new int[n];
		y = new int[n];
		dp = new int[1 << n];
		Arrays.fill(dp, -1);
		x[0] = a;
		y[0] = b;
		for (int i = 1; i < n; i++) {
			x[i] = nxtInt();
			y[i] = nxtInt();
		}
		out.println(solve(1 << 0));
		out.print(0);
		prnt(1 << 0);
		out.println();
		br.close();
		out.close();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter out = new PrintWriter(System.out);

	static StringTokenizer sc;

	static String nxtTok() throws IOException {
		while (!sc.hasMoreTokens())
			sc = new StringTokenizer(br.readLine());
		return sc.nextToken();
	}

	static int nxtInt() throws IOException {
		return Integer.parseInt(nxtTok());
	}

	static long nxtLng() throws IOException {
		return Long.parseLong(nxtTok());
	}
}