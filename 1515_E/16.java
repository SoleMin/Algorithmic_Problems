

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class phoenix_and_computers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		long[][] ncr = ncrcoll(405, 405, m);
		int[] p2 = new int[n + 1];
		p2[0] = 1;
		for (int i = 1; i < p2.length; i++) {
			p2[i] = 2 * p2[i - 1] % m;
		}

		long[][] dp = new long[405][405];
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				for (int k = 1; i + k <= n; k++) {
					dp[i + k + 1][j + k] += ((dp[i][j] * p2[k - 1]) % m * ncr[j + k][k]);
					dp[i + k + 1][j + k] %= m;
				}
			}
		}

		long ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = (ans + dp[n + 1][i]) % m;
		}

		System.out.println(ans);
	}

	static long[][] ncrcoll(int n, int k, int p) {
		long[][] arr = new long[n + 1][k + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= i && j < arr[0].length; j++) {
				if (i == 1 && j == 1) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % (p);
				}
			}
		}
		return arr;
	}

	public static long xpown(long x, long n) {
		long res = 1;
		while (n > 0) {
			if (n % 2 != 0) {
				res = (res * x) % 1000000007;
				n--;
			} else {
				x = (x * x) % 1000000007;
				n = n / 2;
			}
		}
		return res;
	}
}
