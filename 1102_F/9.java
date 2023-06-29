import java.io.*;
import java.util.*;

public class CF1102F {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] aa = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				aa[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][] dd = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				int d = Integer.MAX_VALUE;
				for (int h = 0; h < m; h++)
					d = Math.min(d, Math.abs(aa[i][h] - aa[j][h]));
				dd[i][j] = dd[j][i] = d;
			}
		int[][] dd_ = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				int d = Integer.MAX_VALUE;
				for (int h = 0; h < m - 1; h++)
					d = Math.min(d, Math.abs(aa[i][h] - aa[j][h + 1]));
				dd_[i][j] = d;
			}
		if (n == 1) {
			System.out.println(dd_[0][0]);
			return;
		}
		int[] ii = new int[1 << n];
		for (int i = 0; i < n; i++)
			ii[1 << i] = i;
		int[][][] dp = new int[1 << n][n][n];
		for (int b = 0; b < 1 << n; b++)
			for (int u = b; u > 0; u &= u - 1) {
				int i = ii[u & -u];
				for (int v = b ^ 1 << i; v > 0; v &= v - 1) {
					int j = ii[v & -v];
					if (b == (1 << i ^ 1 << j))
						dp[b][i][j] = dd[i][j];
					else {
						int x = 0;
						for (int w = b ^ 1 << i ^ 1 << j; w > 0; w &= w - 1) {
							int k = ii[w & -w];
							x = Math.max(x, Math.min(dp[b ^ 1 << j][i][k], dd[k][j]));
						}
						dp[b][i][j] = x;
					}
				}
			}
		int b = (1 << n) - 1;
		int x = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (i != j)
					x = Math.max(x, Math.min(dp[b][i][j], dd_[i][j]));
		System.out.println(x);
	}
}
