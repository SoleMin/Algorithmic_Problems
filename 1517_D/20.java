import java.io.*;
import java.util.*;

public class CF1517D extends PrintWriter {
	CF1517D() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1517D o = new CF1517D(); o.main(); o.flush();
	}

	static final int INF = 0x3f3f3f3f;
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		if (k % 2 == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					print("-1 ");
				println();
			}
			return;
		}
		k /= 2;
		int[][] hh = new int[n][m - 1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m - 1; j++)
				hh[i][j] = sc.nextInt();
		int[][] vv = new int[n - 1][m];
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < m; j++)
				vv[i][j] = sc.nextInt();
		int[][] dp = new int[n][m];
		int[][] dq = new int[n][m];
		while (k-- > 0) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					int x = INF;
					if (i > 0)
						x = Math.min(x, dp[i - 1][j] + vv[i - 1][j]);
					if (j > 0)
						x = Math.min(x, dp[i][j - 1] + hh[i][j - 1]);
					if (i + 1 < n)
						x = Math.min(x, dp[i + 1][j] + vv[i][j]);
					if (j + 1 < m)
						x = Math.min(x, dp[i][j + 1] + hh[i][j]);
					dq[i][j] = x;
				}
			int[][] tmp = dp; dp = dq; dq = tmp;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				print(dp[i][j] * 2 + " ");
			println();
		}
	}
}
