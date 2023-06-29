import java.io.*;
import java.util.*;

public class CF1515E extends PrintWriter {
	CF1515E() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1515E o = new CF1515E(); o.main(); o.flush();
	}

	int[] ff, gg; int md;
	long ch(int n, int k) {
		return (long) ff[n] * gg[k] % md * gg[n - k] % md;
	}
	long inv(int a) {
		return a == 1 ? 1 : inv(a - md % a) * (md / a + 1) % md;
	}
	void main() {
		int n = sc.nextInt();
		md = sc.nextInt();
		int[] p2 = new int[n];
		for (int p = 1, i = 0; i < n; i++) {
			p2[i] = p;
			p = p * 2 % md;
		}
		ff = new int[n + 1];
		gg = new int[n + 1];
		long f = 1;
		for (int i = 0; i <= n; i++) {
			gg[i] = (int) inv(ff[i] = (int) f);
			f = f * (i + 1) % md;
		}
		int[][] dp = new int[n + 1][n + 1]; dp[1][1] = 1; dp[2][2] = 2;
		for (int u = 3; u <= n; u++)
			for (int v = 1; v <= u; v++) {
				long x = v == u ? p2[u - 1] : 0;
				for (int k = 1; k < v && k <= u - 2; k++)
					x += dp[u - k - 1][v - k] * ch(v, k) % md * p2[k - 1] % md;
				dp[u][v] = (int) (x % md);
			}
		int ans = 0;
		for (int v = 1; v <= n; v++)
			ans = (ans + dp[n][v]) % md;
		println(ans);
	}
}
