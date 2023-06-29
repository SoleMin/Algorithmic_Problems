import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Ok_Simple {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static boolean am[][];
	static long dp[][];
	static int n;
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		int m;
		n = NextInt();
		m = NextInt();
		am = new boolean[n][n];
		dp = new long[n][1 << n];
		for (int i = 0; i < n; ++i)
			Arrays.fill(dp[i], -1);
		for (int i = 0; i < m; ++i) {
			int a = NextInt() - 1;
			int b = NextInt() - 1;
			am[a][b] = am[b][a] = true;
		};
		long res = 0;
		for (int a = 0; a < n; ++a)
			res += solve(a, (1 << a));
		System.out.println(res / 2);
	}
	private static long solve(int b, int mask) {
		int a = 0;
		for (int i = 0 ;i < n; ++i)
			if (((mask >> i) & 1) != 0)
			{
				a = i;
				break;
			}
		if (dp[b][mask] >= 0)
			return dp[b][mask];
		long res = 0;
		if (am[b][a] && Integer.bitCount(mask) > 2)
			res = 1;
		for (int i = a + 1; i < n; ++i)
			if (((mask >> i) & 1) == 0 && am[b][i])
				res += solve(i, mask ^ (1 << i));
		return dp[b][mask] = res;
	}
	static int NextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(NextToken());
	}
	static double NextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(NextToken());
	}
	static long NextLong() throws NumberFormatException, IOException {
		return Long.parseLong(NextToken());
	}
	static String NextToken() throws IOException {
		while(tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}
