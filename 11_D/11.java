import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemD {
	

	
	static int N;
	static boolean[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[] data = s.readLine().split(" ");
		int n = Integer.valueOf(data[0]);
		N = n;
		int m = Integer.valueOf(data[1]);
		graph = new boolean[n][n];
		for (int i = 0 ; i < m ; i++) {
			String[] line = s.readLine().split(" ");
			int a = Integer.valueOf(line[0])-1;
			int b = Integer.valueOf(line[1])-1;
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		long ans = 0;
		for (int i = 0 ; i < n ; i++) {
			ans += doit(i);
		}
		ans /= 2;
		
		out.println(ans);
		out.flush();
	}

	static long doit(int n) {
		long[][] dp = new long[1<<n][n];
		for (int i = 0 ; i < n ; i++) {
			if (graph[i][n]) {
				dp[1<<i][i] = 1;
			}
		}
		
		for (int i = 0 ; i < (1<<n) ; i++) {
			for (int j = 0 ; j < n ; j++) {
				if (dp[i][j] >= 1) {
					for (int k = 0 ; k < n ; k++) {
						if (graph[j][k] && (i & (1<<k)) == 0) {
							dp[i|1<<k][k] += dp[i][j];
						}
					}
				}
			}
		}
		
		long ret = 0;
		for (int i = 0 ; i < (1<<n) ; i++) {
			if (Integer.bitCount(i) >= 2) {
				for (int j = 0 ; j < n ; j++) {
					if (graph[j][n]) {
						ret += dp[i][j];
					}
				}
			}
		}
		return ret;
	}
	
	
	static void generateLarge() {
		System.out.println("19 171");
		for (int i = 1 ; i <= 19 ; i++) {
			for (int j = i+1 ; j <= 19 ; j++) {
				System.out.println(i + " " + j);
			}
		}
	}


	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}