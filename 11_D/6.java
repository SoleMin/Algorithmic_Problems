import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}


	boolean[][] graph;
	public void run() {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		graph = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			graph[a][b] = true;
			graph[b][a] = true;
		}


		long res = 0;
		for (int i = 3; i <= n; i++) {
			res += solve(i);
		}
		System.out.println(res);

	}

	long solve(int n) {
		// [0, n)の頂点だけで、n-1 スタートだけ考える
		long[][] dp = new long[1 << n][n];
		dp[1 << (n-1)][n-1] = 1;

		for (int i = 0; i < (1 << n); ++i) {
			for (int l = 0; l < n; ++l) if (dp[i][l] > 0) {
				for (int x = 0; x < n - 1; ++x) if (graph[l][x] && (i >> x & 1) == 0) {
					dp[i | (1 << x)][x] += dp[i][l];
				}
			}
		}

		long res = 0;
		for (int i = 0; i < (1 << n); ++i) if (Integer.bitCount(i) >= 3) {
			for (int l = 0; l < n; ++l) {
				if (graph[l][n-1]) res += dp[i][l];
			}
		}
		return res / 2; // n-1 を含むサイクルを右回りと左回り数えてしまったので２で割る
	}

}