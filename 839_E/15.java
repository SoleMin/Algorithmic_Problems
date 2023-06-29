import java.io.*;
import java.util.*;

public class Solution {

	private static StringTokenizer st;
	private static int n;
	private static int k;

	private static boolean[][] graph;
	private static int[] dp;
	private static int maxCliqueSize;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		graph = new boolean[n][n];
		dp = new int[1 << (n / 2)];

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(reader.readLine());

			for (int j = 0; j < n; ++j)
				graph[i][j] = st.nextToken().equals("1");
		}

		reader.close();

		/* fill dp for first subset */
		int size1 = n / 2;
		int border = 1 << size1;
		for (int mask = 1; mask < border; ++mask) {
			/* check if mask is complete graph */

			boolean isComplete = true;
			for (int i = 0; i < size1; ++i) {
				if (((mask >> i) & 1) == 0)
					continue;

				for (int j = i + 1; j < size1; ++j) {
					if (((mask >> j) & 1) == 0)
						continue;

					if (!graph[i][j]) {
						isComplete = false;
						break;
					}
				}

				if (!isComplete)
					break;
			}

			if (isComplete)
				dp[mask] = Integer.bitCount(mask);
		}

		for (int mask = 1; mask < border; ++mask) {
			for (int i = 0; i < size1; ++i) {
				if (((mask >> i) & 1) == 0) {
					dp[mask | (1 << i)] = Math.max(dp[mask | (1 << i)], dp[mask]);
				}
			}
		}


		/* process second subset */
		maxCliqueSize = 1;
		int size2 = n - n /2;
		border = (1 << size2);

		for (int mask = 0; mask < border; ++mask) {

			boolean isComplete = true;
			for (int i = 0; i < size2; ++i) {
				if (((mask >> i) & 1) == 0)
					continue;

				for (int j = i + 1; j < size2; ++j) {
					if (((mask >> j) & 1) != 0 && !graph[i + size1][j + size1]) {
						isComplete = false;
						break;
					}
				}

				if (!isComplete)
					break;
			}

			if (!isComplete)
				continue;

			int mask1 = (1 << size1) - 1;

			for (int i = 0; i < size2; ++i) {
				if (((mask >> i) & 1) == 0)
					continue;

				for (int j = 0; j < size1; ++j) {
					if (!graph[j][i + size1] && ((mask1 >> j) & 1) != 0)
						mask1 ^= (1 << j);
				}
			}

			maxCliqueSize = Math.max(maxCliqueSize, dp[mask1] + Integer.bitCount(mask));
		}

		// System.out.println(maxCliqueSize);
		double answer = (1.0 * k * k * (maxCliqueSize - 1) / (2 * maxCliqueSize));
		System.out.printf("%.15f", answer);
	}
}