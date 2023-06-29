
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 9:50 ~ 
 *
 */
public class Main {
	public static int n, x, y;
	public static int[] a,b;
	public static int dp[], before[];
	public static int dx[];
	public static int d[][];
	public static final int INF = 24 * 201 * 201; 
	public static void main(String[] argv) {
		FastScanner scan = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		x = scan.nextInt();
		y = scan.nextInt();
		
		n = scan.nextInt();
		
		a = new int[n+1];
		b = new int[n+1];
		dx = new int[n+1];
		d = new int[n+1][n+1];
		for(int i = 0; i < n; ++i){
			a[i] = scan.nextInt();
			b[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; ++i){
			dx[i] = dist(i);
		}
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				d[i][j] = dist(i,j);
			}
		}
		
		dp = new int[1 << n];
		before = new int[1 << n];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int state = 0; state < (1<<n); state++){
			//if(dp[state] == INF) continue;
			for(int i = 0; i < n; ++i){
				int ii = (1 << i);
				if((state & ii) > 0){
					if(dp[state - ii] == INF) continue;
					int newdist = dp[state - ii] + dx[i] + dx[i];
					if(dp[state] > newdist){
						dp[state] = newdist;
						before[state] = state - ii;
					}
					
				} else continue;
				
				for(int j = i + 1; j < n; ++j){
					if(i == j) continue;
					int jj = (1 << j);
					if((state & jj) > 0){
						if(dp[state - ii - jj] == INF) continue;
						int newdist = dp[state - ii - jj] + dx[i] + d[i][j] + dx[j];
						if(dp[state] > newdist){
							dp[state] = newdist;
							before[state] = state - ii - jj;
						}
						
					}
				}
				break;
			}
		}

		System.out.println(dp[(1<<n)-1]);
		int state = (1<<n) - 1;
		StringBuffer ret = new StringBuffer();
		while(state > 0){
			int nstate = before[state];
			boolean find = false;
			String made = "";
			for(int i = 0; i < n; ++i){
				if(((state & (1<<i)) > 0) && ((nstate & (1<<i)) == 0)){
					find = true;
					made = made + " " + (i + 1);
				}
			}
			if(find){
				made = made + " 0";
				ret.append(made, 0, made.length());
			}
			state = nstate;
		}
		out.println("0" + ret.toString());
		out.close();
	}
	public static int dist(int to){
		return Math.abs(a[to] - x) * Math.abs(a[to] - x) + Math.abs(b[to] - y) * Math.abs(b[to] - y);
	}
	public static int dist(int from, int to){
		return Math.abs(a[from]-a[to]) * Math.abs(a[from]-a[to]) + Math.abs(b[from]-b[to]) * Math.abs(b[from]-b[to]);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream is) {
			try {
				br = new BufferedReader(new InputStreamReader(is));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					return null;
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.valueOf(next());
		}
	}
}
