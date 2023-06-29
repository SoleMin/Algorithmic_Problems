import java.io.*;
import java.util.*;
public class f {
	static int n;
	static double[][] g;
public static void main(String[] args) throws IOException {
	input.init(System.in);
	PrintWriter out = new PrintWriter(System.out);
	n = input.nextInt();
	g = new double[n][n];
	for(int i = 0; i<n; i++)
		for(int j = 0; j<n; j++)
			g[i][j] = input.nextDouble();
	for(int i = 0; i<n; i++)
		for(int j = 0; j<n; j++)
			g[j][i] = 1 - g[i][j];
	for(int i = 0; i<n; i++)
	{
		double[] dp = new double[1<<n];
		for(int mask = 0; mask < (1<<n); mask++)
		{
			if((mask & (1<<i)) == 0)
			{
				dp[mask] = 0;
				continue;
			}
			if(mask == (1<<i))
			{
				dp[mask] = 1;
				continue;
			}
			int count = Integer.bitCount(mask);
			double prob = 1.0 / (count * (count-1)/2);
			for(int a = 0; a<n; a++)
			{
				if((mask & (1<<a)) == 0) continue;
				for(int b = a+1; b<n; b++)
				{
					if((mask & (1<<b)) == 0) continue;
					double p = g[a][b] * dp[mask ^ (1<<b)] + g[b][a] * dp[mask ^ (1<<a)];
					dp[mask] += p;
				}
			}
			dp[mask] *= prob;
		}
		out.print(dp[(1<<n)-1]+" ");
	}
	out.close();
}
public static class input {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(reader.readLine());
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}
}

