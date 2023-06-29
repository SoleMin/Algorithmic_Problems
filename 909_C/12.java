import java.util.*;
import java.io.*;

public class PythonIndentation {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] dp = new int[N][N];
		dp[0][0] = 1;
		for(int i = 1; i < N; ++i) {
			char lastCmd = in.readLine().charAt(0);
			int[] sum = new int[N];
			sum[N - 1] = dp[i - 1][N - 1];
			for(int j = N - 2; j >= 0; --j)
				sum[j] = (sum[j + 1] + dp[i - 1][j]) % 1000000007;
			for(int j = 0; j < N; ++j) {
				if(lastCmd == 'f' && j > 0)
					dp[i][j] = dp[i - 1][j - 1];
				else if(lastCmd == 's')
					dp[i][j] = sum[j];
			}
		}
		int ans = 0;
		for(int i = 0; i < N; ++i)
			ans = (ans + dp[N - 1][i]) % 1000000007;
		System.out.println(ans);
	}
}
