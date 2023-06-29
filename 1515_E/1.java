
import java.io.*;
import java.util.*;

public class CF1515E{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		System.out.println(ans);
	}
}
