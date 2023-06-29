import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	static final int MOD = (int)1e9 + 7;
	static int n;
	static int[] t;
	static int[] g;	
	static int[][] memo;
	
	static int dp(int mask, int rem, int last)
	{
		if(rem == 0)
			return 1;
		if(memo[last][mask] != -1)
			return memo[last][mask];
		
		int ans = 0;
		for(int i = 0; i < n; i++)
		{
			if((mask & (1 << i)) == 0 && rem >= t[i] && g[i] != last)
				ans += dp(mask | 1 << i, rem - t[i], g[i]);
			
			if(ans >= MOD)
				ans -= MOD;
		}
		
		return memo[last][mask] = ans;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		
		n = in.nextInt();
		int T = in.nextInt();
		
		t = new int[n];
		g = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			t[i] = in.nextInt();
			g[i] = in.nextInt() - 1;
		}
		
		memo = new int[4][1 << n];
		for(int []x : memo)
		{
			Arrays.fill(x, -1);
		}
		
		out.println(dp(0, T, 3));
		out.close();
	}
	
	static class InputReader
	{
		BufferedReader reader;
		StringTokenizer tokenizer;
		
		public InputReader(InputStream stream)
		{
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		
		public String next()
		{
			while(tokenizer == null || !tokenizer.hasMoreTokens())
			{
				try
				{
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch(IOException e)
				{
					throw new RuntimeException(e);
				}
			}
			
			return tokenizer.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
}