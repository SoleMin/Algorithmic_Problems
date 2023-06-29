import java.util.Scanner;

public class SimpleTask {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		boolean[][] graph = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int u = scan.nextInt() - 1;
			int v = scan.nextInt() - 1;
			graph[u][v] = true;
			graph[v][u] = true;
		}

		long[][] dp = new long[1 << n][n];

		for (int i = 0; i < n; i++)
			dp[1 << i][i] = 1;

		for (int mask = 1; mask < (1 << n); mask++) {

			int first = Integer.numberOfTrailingZeros(mask);

			for (int i = 0; i < n; i++) {
				if ((mask & (1 << i)) == 0 || first == i)
					continue;

				for (int j = 0; j < n; j++) {
					if (graph[i][j])
						dp[mask][i] += dp[mask ^ 1 << i][j];
				}

			}
		}
		long answer = 0;
		for (int mask = 1; mask < (1 << n); mask++) {
			if (Integer.bitCount(mask) < 3)
				continue;

			int first = Integer.numberOfTrailingZeros(mask);
			for (int i = 0; i < n; i++) {
				if (graph[first][i])
					answer += dp[mask][i];
			}
		}

		System.out.println(answer / 2);
		scan.close();
	}
}
