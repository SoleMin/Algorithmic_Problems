import java.io.*;
import java.util.*;

public class Main {
	static int m;
	static long pow(long b, int p) {
		long ret = 1;
		while (p > 0) {
			if ((p&1) == 1) ret = b*ret%m;
			b = b*b%m;
			p >>= 1;
		}
		return ret;
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(); m = readInt();
		long[] fac = new long[n + 1], pow2 = new long[n + 1];
		long[][] C = new long[n + 1][n + 1], dp = new long[n + 1][n + 1];
		fac[0] = pow2[0] = 1;
		for (int i = 1; i <= n; ++i) {
			fac[i] = i*fac[i - 1]%m;
			pow2[i] = 2*pow2[i - 1]%m;
			for (int j = 0; j <= i; ++j)
				C[i][j] = fac[i]*(pow(fac[j], m - 2)*pow(fac[i - j], m - 2)%m)%m;
		}
		for (int i = 1; i <= n; ++i) {
			dp[i][i] = pow2[i - 1];
			for (int j = 0; j <= i; ++j)
				for (int k = 1; i + k + 1 <= n; ++k)
					dp[i + k + 1][j + k] = (dp[i + k + 1][j + k] + dp[i][j]*(C[j + k][k]*pow2[k - 1]%m))%m;
		}
		long ans = 0;
		for (int i = 1; i <= n; ++i)
			ans = (ans + dp[n][i])%m;
		System.out.println(ans);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}
