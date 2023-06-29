import java.util.*;
import java.io.*;

public class E
{
	public static void main(String[] args) throws IOException
	{new E();}
	
	FastScanner in = new FastScanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int n, m, oo = 1 << 28;
	int[] dp, cost;
	int[][] to;
	char[] w;
	
	E() throws IOException
	{
		n = in.nextInt();
		m = in.nextInt();
		w = in.next().toCharArray();
		to = new int[m+1][m+1];
		for (int i = 0; i < n-1; i++)
			if (w[i] != w[i+1])
			{
				to[w[i]-'a'][w[i+1]-'a']++;
				to[w[i+1]-'a'][w[i]-'a']++;
			}

		cost = new int[1 << m];	
		for (int i = 0; i < (1 << m); i++)
			for (int j = 0; j < m; j++)
			{
				if (((1 << j) & i) > 0)
					continue;
				for (int k = 0; k < m; k++)
				{
					if (((1 << k) & i) == 0)
						continue;
					cost[i] += to[j][k];
				}
			}
		
		dp = new int[1 << m];
		Arrays.fill(dp, oo);
		dp[0] = 0;
		for (int i = 1; i < (1 << m); i++)
		{
			for (int j = 0; j < m; j++)
				if (((i >> j) & 1) > 0)
					dp[i] = Math.min(dp[i], dp[i ^ (1 << j)]);
			dp[i] += cost[i];
		}
		out.println(dp[(1 << m)-1]);
		out.close();	
	}
	
	void sort(int[] x)
	{
		int sz = x.length;
		Random r = new Random();
		for (int i = 0; i < sz; i++)
		{
			int j = r.nextInt(sz);
			x[i] = x[j]-(x[i]-(x[j] = x[i]));
		}
		Arrays.sort(x);
	}
	
	class FastScanner {
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
		public int[] intarr(int n) throws IOException {
			int[] res = new int[n];
			for (int i = 0; i < n; i++)
				res[i] = nextInt();
			return res;
		}
	    public long nextLong() throws IOException {
		    return Long.parseLong(next());
		}
		public double nextDouble() throws IOException {
		    return Double.parseDouble(next());
		}
    }
}