
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Test {
	public static long l, r;
	static long dp[][][][];
	public static long rec(int i, int lstate, int rstate, int lrstate) {

		if (i < 0)
			return 0;
		
		long lc = l & ((long)1 << i);
		long rc = r & ((long)1 << i);
		
		if(dp[i][lstate][rstate][lrstate] != -1) return dp[i][lstate][rstate][lrstate];
		
		long max = 0;
		for (int newl = 0; newl <= 1; ++newl) {
			for (int newr = 0; newr <= 1; ++newr) {
				int nlstate = lstate;
				int nrstate = rstate;
				if (lstate == 1) {
					if (newl == 0) {
						if (lc > 0) {
							continue;
						} else {
							nlstate = 1;
						}
					}
				}
				if (rstate == 1) {
					if (newr == 0) {
						if (rc > 0) {
							nrstate = 0;
						} else {
							nrstate = 1;
						}
					} else {
						if (rc > 0) {
							nrstate = 1;
						} else {
							continue;
						}
					}
				}
				
				if(lrstate == 1 && newl > newr) continue;
				
				int nlrstate = lrstate;
				if(newl != newr) nlrstate = 0;
				
				long now = (long)((newl ^ newr) * Math.pow(2, i));
				long calc = now + rec(i - 1, nlstate, nrstate, nlrstate);
				//System.out.println(i + " / " + newl + " / " + newr + " / " + now + " / " + calc);
				max = Math.max(max, calc);
			}
		}

		return dp[i][lstate][rstate][lrstate] = max;

	}

	public static void main(String[] argv) {
		FastScanner scan = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		l = scan.nextLong();
		r = scan.nextLong();
		if(l == r) {
			out.println(l ^ r);
			out.close();
			return;
		}
		
		dp = new long[64][2][2][2];
		for(int i = 0; i < 64; ++i)
			for(int j = 0; j < 2; ++j)
				for(int k = 0; k < 2; ++k)
					for(int l = 0; l < 2; ++l)
						dp[i][j][k][l] = -1;
		int t = 0;
		while(((long)1 << t) < r) ++t;
		out.println(rec(t, 1, 1,1));
		out.close();
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