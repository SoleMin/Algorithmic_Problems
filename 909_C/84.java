import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	static int [][] memo;
	static int n;
	static char [] c;
	static int mod = (int)1e9+7;
	static int dp(int ind, int loops){
		if(ind == n)
			return loops == 0?1:0;
		if(memo[ind][loops] != -1)
			return memo[ind][loops];
		long ans = 0;
		if(c[ind] == 's'){
			ans = (ans + dp(ind+1, loops))%mod;
			if(loops > 0)
				ans = (ans + dp(ind, loops-1))%mod;
		}
		else{
			ans = (ans + dp(ind+1, loops+1))%mod;
		}
		return memo[ind][loops] = (int) ans;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		n = sc.nextInt();
		memo = new int[n+1][n+1];
		for(int [] i:memo)
			Arrays.fill(i, -1);
		c = new char[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.next().charAt(0);
		}
		out.println(dp(0,0));
		out.flush();
		out.close();
	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		public Scanner(InputStream i) {
			bf = new BufferedReader(new InputStreamReader(i));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}
}