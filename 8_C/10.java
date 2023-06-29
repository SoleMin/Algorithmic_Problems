import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemC {
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		// generateRandom();
		
		int[] pt = readPoint(s);
		int n = Integer.valueOf(s.readLine());
		int[][] xp = new int[n+1][];
		for (int i = 1 ; i <= n ; i++) {
			xp[i] = readPoint(s);
		}
		xp[0] = pt;
		
		int[][] dist = new int[n+1][n+1];
		for (int i = 0 ; i <= n ; i++) {
			for (int j = 0 ; j <= n ; j++) {
				int dx = Math.abs(xp[i][0] - xp[j][0]);
				int dy = Math.abs(xp[i][1] - xp[j][1]);
				dist[i][j] = dx*dx + dy*dy;
			}
		}
		
		int[][] dist2 = new int[n+1][n+1];
		for (int i = 0 ; i <= n ; i++) {
			for (int j = 0 ; j <= n ; j++) {
				dist2[i][j] = dist[0][i] + dist[i][j] + dist[j][0];
			}
		}
		
		int[] dp = new int[1<<n];
		int[][] dp_prev = new int[2][1<<n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 0 ; i < (1<<n) ; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				continue;
			}
			int base = dp[i];
			// two
			for (int y = 0 ; y < n ; y++) {
				if ((i & (1<<y)) >= 1) {
					break;
				}
				for (int z = y+1 ; z < n ; z++) {
					if ((i & (1<<z)) >= 1) {
						continue;
					}
					int ti = i | (1<<y) | (1<<z);
					int d = dist2[y+1][z+1];
					if (dp[ti] > base + d) {
						dp[ti] = base + d;
						dp_prev[0][ti] = z+1;
						dp_prev[1][ti] = y+1;
					}
				}
			}
		}
		
		
		
		int bestOnes = 0;
		for (int i = 0 ; i < (1<<n) ; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				continue;
			}
			int sub = (1<<n) - 1 - i;
			int add = 0;
			for (int j = 0 ; j < n ; j++) {
				if ((sub & (1<<j)) >= 1) {
					add += dist[0][j+1] * 2;
				}
			}
			if (dp[i] + add < dp[(1<<n)-1]) {
				dp[(1<<n)-1] = dp[i] + add;
				bestOnes = sub;
			}
		}
		
		StringBuffer b = new StringBuffer();
		b.append(" 0");
		for (int i = 0 ; i < n ; i++) {
			if ((bestOnes & (1<<i)) >= 1) {
				b.append(" ").append(i+1).append(" ").append(0);
			}
		}
		
		out.println(dp[(1<<n)-1]);
		int nptn = (1<<n)-1-bestOnes;
		while (nptn >= 1) {
			int i1 = dp_prev[0][nptn];
			int i2 = dp_prev[1][nptn];
			if (i1 >= 1) {
				nptn -= 1<<(i1-1);
				b.append(" ").append(i1);
			}
			if (i2 >= 1) {
				nptn -= 1<<(i2-1);
				b.append(" ").append(i2);
			}
			b.append(" ").append(0);
		}
		out.println(b.substring(1));
		out.flush();
	}

	private static void generateRandom() {
		System.out.println("0 0");
		System.out.println("24");
		for (int i = 0 ; i < 24 ; i++) {
			int a = (int)(Math.random() * 200 - 100);
			int b = (int)(Math.random() * 200 - 100);
			System.out.println(a + " " + b);
		}
	}
	
	
	private static int[] readPoint(BufferedReader s) throws IOException {
		int[] ret = new int[2];
		String[] data = s.readLine().split(" ");
		ret[0] = Integer.valueOf(data[0]);
		ret[1] = Integer.valueOf(data[1]);
		return ret;
	}

	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}