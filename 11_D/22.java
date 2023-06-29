import java.io.*;
import java.util.*;

public class CF11D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] ee = new boolean[n][n];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			ee[i][j] = ee[j][i] = true;
		}
		long cnt = 0;
		// how many cycles through i with intermediate vertices before i
		for (int i = 2; i < n; i++) {
			long[][] dp = new long[1 << i][i];
			for (int j = 0; j < i; j++)
				dp[0][j] = ee[i][j] ? 1 : 0;
			// dp[b][j]: how many paths from i to j with intermediate vertices in b
			for (int b = 1; b < 1 << i; b++)
				for (int j = 0; j < i; j++) {
					if ((b & 1 << j) > 0)
						continue;
					for (int k = 0; k < i; k++) {
						if ((b & 1 << k) == 0)
							continue;
						if (ee[k][j])
							dp[b][j] += dp[b ^ 1 << k][k];
					}
					if (dp[b][j] > 0 && ee[j][i])
						cnt += dp[b][j];
				}
		}
		System.out.println(cnt / 2);
	}
}
