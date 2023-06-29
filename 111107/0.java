import java.io.*;
import java.util.*;

class Main {
	static final long INF = Long.MAX_VALUE / 2;
	
	public static int square(int x) {
		return x * x;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken()) + 8;
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] L = new int[N];
			for (int i = 0; i < N; i++) {
				L[i] = Integer.parseInt(st.nextToken());
			}
			long[][] dp = new long[N][K + 1];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], INF);
				dp[i][0] = 0;
			}
			for (int i = N - 3; i >= 0; i--) {
				for (int j = K; j > 0; j--) {
					if (3 * j <= N - i) {
						dp[i][j] = Math.min(dp[i + 1][j], dp[i + 2][j - 1] + square(L[i] - L[i + 1]));
					}
				}
			}
			out.append(dp[0][K]).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}