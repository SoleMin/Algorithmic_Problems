import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] chopsticks = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = n; i > 0; i--)
				chopsticks[i] = Integer.parseInt(st.nextToken());
			int[][] dp = new int[n + 1][k + 9];

			for (int i = 0; i < dp.length; i++)
				for (int j = 1; j < dp[0].length; j++)
					dp[i][j] = Integer.MAX_VALUE;
			for (int j = 1; j < dp[0].length; j++) {
				for (int i = j * 3; i < dp.length; i++) {
					int match = chopsticks[i - 1] - chopsticks[i];
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 2][j - 1] + match * match);
				}
			}
			sb.append(dp[n][k + 8] + "\n");
		}
		System.out.print(sb);
	}
}