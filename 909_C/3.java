import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class C {
	static final long MOD = 1_000_000_007;
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt();
		long[][] dp = new long[N][N];
		dp[0][0] = 1L;
		for(int i = 0; i < N-1; i++) {
			char oper = sc.next().charAt(0);
			if(oper == 'f') {
				dp[i+1][0] = 0L;
				for(int j = 1; j < N; j++) {
					dp[i+1][j] = dp[i][j-1];
				}
			}
			else {
				dp[i+1][N-1] = dp[i][N-1];
				for(int j = N-2; j >= 0; j--) {
					dp[i+1][j] = (dp[i+1][j+1] + dp[i][j]) % MOD;
				}
			}
		}
		long res = 0;
		for(int i = 0; i < N; i++) {
			res += dp[N-1][i];
			res %= MOD;
		}
		out.println(res);
		out.flush();
	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
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

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
}