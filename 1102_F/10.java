import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class f {
	
	static int n, m;
	static int start;
	static int[][] memo;
	static int[][] arr;
	static int[][] costs;
	static int[][] wrapCosts;

	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n][m];
		costs = new int[n][n];
		wrapCosts = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				arr[r][c] = in.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				costs[i][j] = Integer.MAX_VALUE;
				for (int c = 0; c < m; c++) {
					costs[i][j] = Math.min(costs[i][j], Math.abs(arr[i][c] - arr[j][c]));
				}
				costs[j][i] = costs[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				wrapCosts[i][j] = Integer.MAX_VALUE;
				for (int c = 0; c < m - 1; c++) {
					wrapCosts[i][j] = Math.min(wrapCosts[i][j], Math.abs(arr[i][c + 1] - arr[j][c]));
				}
			}
		}
		memo = new int[n][1 << n];
		long best = 0;
		for (start = 0; start < n; start++) {
			for (int[] a : memo) Arrays.fill(a, -1);
			best = Math.max(best, go(start, (1 << n) - 1 - (1 << start)));
		}
		out.println(best);
		out.close();
	}
	static int go(int cur, int mask) {
		if (mask == 0) {
			return wrapCosts[start][cur];
		}
		if (memo[cur][mask] != -1) return memo[cur][mask];
		int ans = 0;
		for (int next = 0; next < n; next++) {
			int bit = 1 << next;
			if ((mask & bit) == 0) continue;
			ans = Math.max(ans, Math.min(costs[cur][next], go(next, mask ^ bit)));
		}
		return memo[cur][mask] = ans;
	}
	
	//@
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    //#
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	    //$
	}
}
