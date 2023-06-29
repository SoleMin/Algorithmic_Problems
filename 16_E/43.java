import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProblemE {
	
	
	static final int INF = 1000000;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.valueOf(s.readLine());
		double[][] prob = new double[n][n];
		double[] dp = new double[1<<n];
		for (int i = 0 ; i < n ; i++) {
			String[] line = s.readLine().split(" ");
			for (int j = 0 ; j < n ; j++) {
				prob[i][j] = Double.valueOf(line[j]);
			}
		}
		
		dp[(1<<n)-1] = 1.0d;
		for (int p = (1<<n)-1 ; p >= 1 ; p--) {
			if (dp[p] > 0.0d) {
				int left = Integer.bitCount(p);
				if (left == 1) {
					continue;
				}
				double baseProb = 1.0d / (left * (left - 1) / 2);
				for (int i = 0 ; i < n ; i++) {
					if ((p & (1<<i)) == 0) {
						continue;
					}
					for (int j = i+1 ; j < n ; j++) {
						if ((p & (1<<j)) == 0) {
							continue;
						}
						dp[p-(1<<i)] += dp[p] * baseProb * prob[j][i];
						dp[p-(1<<j)] += dp[p] * baseProb * prob[i][j];
					}
				}
			}
		}
		
		
		StringBuffer b = new StringBuffer();
		for (int i = 0 ; i < n ; i++) {
			b.append(" ").append(dp[1<<i]);
		}
		out.println(b.substring(1));
		out.flush();
	}



	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}