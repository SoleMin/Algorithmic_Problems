import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author triveni
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		F solver = new F();
		solver.solve(1, in, out);
		out.close();
	}

	static class F {
		private Long[][] lastX = new Long[2010][2010];
		private long mod = 998244353;
		private long p = 0;
		private long[] pPow = new long[2010];
		private long[] qPow = new long[2010];
		private long[] strong = new long[2010];
		private Long[] dp = new Long[2010];

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int a = in.nextInt(), b = in.nextInt();
			p = MathUtils.powMod(b, mod - 2, mod) * a % mod;
			pPow[0] = 1;
			qPow[0] = 1;
			for (int i = 1; i < 2010; ++i) {
				pPow[i] = pPow[i - 1] * p % mod;
				qPow[i] = qPow[i - 1] * (1 - p + mod) % mod;
			}
			strong[1] = 1;
			for (int i = 2; i <= n; ++i) {
				long ans = 0;
				for (int j = 1; j < i; ++j) {
					ans += strong[j] * computeLastX(i, j) % mod;
					if (ans >= mod) ans -= mod;
				}
				strong[i] = 1 - ans;
				if (strong[i] < 0) strong[i] += mod;
			}
			long ans = dp(n);
			out.println(ans);
		}

		private long computeLastX(int n, int i) {
			if (lastX[n][i] != null) return lastX[n][i];
			if (n == i || i == 0) return lastX[n][i] = 1L;
			long ans = qPow[i] * computeLastX(n - 1, i) % mod + pPow[n - i] * computeLastX(n - 1, i - 1) % mod;
			return lastX[n][i] = ans % mod;
		}

		private long dp(int n) {
			if (dp[n] != null) return dp[n];
			if (n < 2) return dp[n] = 0L;
			if (n < 3) return dp[n] = 1L;
			long ans = strong[n] * (n * (n - 1) / 2) % mod;
			for (int x = 1; x < n; ++x) {
				long tmp = computeLastX(n, x) * strong[x] % mod;
				tmp *= (x * (x - 1) / 2 + x * (n - x) + dp(n - x) + dp(x)) % mod;
				ans += tmp % mod;
			}
			ans %= mod;
			ans *= MathUtils.powMod(1 + mod - strong[n], mod - 2, mod);
			return dp[n] = ans % mod;
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputStream) {
			reader = new BufferedReader(new InputStreamReader(inputStream));
			tokenizer = null;
		}

		public InputReader(String inputFile) throws FileNotFoundException {
			reader = new BufferedReader(new FileReader(inputFile));
			tokenizer = null;
		}

		public String nextLine() {
			String curr = "";
			try {
				curr = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return curr;
		}

		public String nextString() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(nextLine());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextString());
		}

	}

	static class MathUtils {
		public static long powMod(long a, long b, long m) {
			long ans = 1;
			while (b > 0) {
				if (b % 2 == 1) ans = ans * a % m;
				b >>= 1;
				a = a * a % m;
			}
			return ans % m;
		}

	}
}

