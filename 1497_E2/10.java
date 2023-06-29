import java.util.*;
import java.io.*;

public class cf1497_Div2_E2 {
	static int[] spf;
	
	public static int factor(int n) {
		int val = 1;
		while (n > 1) {
			int cnt = 0;
			int p = spf[n];
			while (n % p == 0) {
				cnt++;
				n /= p;
			}
			if (cnt % 2 == 1)
				val *= p;
		}
		return val;
	}
	
	public static void main(String args[]) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		int max = (int)(1e7) + 1;
		
		boolean[] prime = new boolean[max + 1]; 
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		spf = new int[max];
		for (int i = 2; i < max; i++) spf[i] = i;
		for (int i = 2; i * i < max; i++) {
			if (prime[i]) {
				spf[i] = i;
				for (int j = i * i; j < max; j += i) {
					prime[j] = false;
					spf[j] = i;
				}
			}
		}
		
		int[] cnts = new int[max];
		
		for ( ; t > 0; t--) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] vals = new int[n];
			for (int i = 0; i < n; i++)
				vals[i] = factor(in.nextInt());
			
			// left[i][x] = l where al ... ai such that in x moves it is valid subsequence
			int[][] left = new int[n + 1][k + 1];
			// x y z w a b c
			
			for (int x = 0; x <= k; x++) {
				int l = n;
				int now = 0;
				for (int i = n - 1; i >= 0; i--) {
					while (l - 1 >= 0 && now + ((cnts[vals[l - 1]] > 0) ? 1 : 0) <= x) {
						l--;
						now += ((cnts[vals[l]] > 0) ? 1 : 0);
						// System.out.println(now);
						cnts[vals[l]]++;
					}
					// System.out.println(i + " " + x + " " + l + " " + now);
					left[i][x] = l;
					if (cnts[vals[i]] > 1) now--;
					cnts[vals[i]]--;
				}
			}
			
			// for (int[] x: left)
				// System.out.println(Arrays.toString(x));
		
				
			int oo = (int)(1e9);
			
			int[][] dp = new int[n + 1][k + 1];
			
			for (int i = 1; i <= n; i++)
				Arrays.fill(dp[i], oo);
			
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= k; j++) {
					if (j > 0) dp[i][j] = dp[i][j - 1];
					for (int x = 0; x <= j; x++) {
						int l = left[i - 1][x];
						dp[i][j] = Math.min(dp[i][j], dp[l][j - x] + 1);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i <= k; i++) {
				min = Math.min(min, dp[n][i]);
			}
			
			out.println(min);
		}
		
		out.close();
	}

	
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
