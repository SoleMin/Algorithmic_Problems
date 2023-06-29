import java.io.*;
import java.util.*;

public class CF909C extends PrintWriter {
	CF909C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF909C o = new CF909C(); o.main(); o.flush();
	}

	static final int MD = 1000000007;
	void main() {
		int n = sc.nextInt();
		boolean[] ss = new boolean[n];
		for (int i = 0; i < n; i++)
			ss[i] = sc.next().charAt(0) == 's';
		int[] kk = new int[n];
		for (int k = 0, i = 0; i < n; i++)
			if (ss[i]) {
				kk[i] = k; k = 0;
			} else
				k++;
		int[][] dp = new int[n + 1][n + 1]; dp[0][0] = 1;
		long[] dd = new long[n + 1];
		for (int m = 1; m <= n; m++)
			if (ss[m - 1]) {
				int k = kk[m - 1];
				Arrays.fill(dd, 0);
				for (int h = 0; h + k < n; h++) {
					// [k, h + k]
					int x = dp[m - 1 - k][h];
					dd[k] += x;
					dd[h + k + 1] -= x;
				}
				for (int x = 0, h = 0; h < n; h++)
					dp[m][h] = x = (int) ((x + dd[h]) % MD);
			}
		int ans = 0;
		for (int h = 0; h < n; h++)
			ans = (ans + dp[n][h]) % MD;
		if (ans < 0)
			ans += MD;
		println(ans);
	}
}
