import java.io.*;
import java.util.*;
public class D11 {
	static boolean[][] g;
	static int n, m;
public static void main(String[] args) throws IOException {
	input.init(System.in);
	PrintWriter out = new PrintWriter(System.out);
	n = input.nextInt();
	m = input.nextInt();
	g = new boolean[n][n];
	for(int i = 0; i<m; i++)
	{
		int a = input.nextInt()-1, b = input.nextInt()-1;
		g[a][b] = g[b][a] = true;
	}
	long res = 0;
	map = new HashMap<Integer, Long>();
	for(int i = n-1; i>=0; i--)
	{
		memo = new long[i+1][1<<(i+1)];
		for(long[] A : memo) Arrays.fill(A, -1);
		res += count(i, i, 1<<i)/2;
	}
	out.println(res);
	out.close();
}
static long[][] memo;
static HashMap<Integer, Long> map;
static long count(int at, int start, int mask)
{
	if(memo[at][mask] != -1) return memo[at][mask];
	int bits = Integer.bitCount(mask);
	if(at == start && bits > 2) return 1;
	long res = 0;
	for(int i = 0; i<=start; i++)
	{
		if(!g[at][i]) continue;
		if(i != start && (mask & (1<<i)) > 0) continue;
		if(i == start && bits <= 2) continue;
		res += count(i, start, mask | (1<<i));
	}
	return memo[at][mask] = res;
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