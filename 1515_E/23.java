
import java.io.*;
import java.util.*;

public class CF1515E extends PrintWriter {
	CF1515E() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1515E o = new CF1515E(); o.main(); o.flush();
	}

	void main() {
		int n = sc.nextInt();
		int md = sc.nextInt();
		int k = (n + 1) / 2;
		int[][] dp = new int[k + 1][n + 1]; dp[0][0] = 1;
		for (int h = 1; h <= k; h++)
			for (int l = h; l <= n - h + 1; l++)
				dp[h][l] = (int) ((dp[h][l - 1] * 2L + dp[h - 1][l - 1]) * h % md);
		int ans = 0;
		for (int h = 1; h <= k; h++)
			ans = (ans + dp[h][n - h + 1]) % md;
		println(ans);
	}
}
