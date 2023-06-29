import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static long[][] memo;
	static boolean[][] adjMat;
	static int N, endNode;
	static ArrayList<Integer>[] bits;
	
	static long dp(int idx, int msk)	//complexity = N * 2^(N + 1)
	{	
		if(memo[idx][msk] != -1)
			return memo[idx][msk];
		long ret = adjMat[idx][endNode] ? 1 : 0;
		for(int i = 0, sz = bits[msk].size(); i < sz; ++i)
		{
			int j = bits[msk].get(i);
			if(j > endNode)
				break;
			if(adjMat[idx][j])
				ret += dp(j, msk | 1 << j);
		}
		return memo[idx][msk] = ret;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		N = sc.nextInt();
		adjMat = new boolean[N][N];
		
		bits = new ArrayList[1 << N];
		for(int i = 0; i < 1 << N; ++i)
		{
			bits[i] = new ArrayList<>(1);
			for(int j = 0; j < N; ++j)
				if((i & 1 << j) == 0)
					bits[i].add(j);
		}
		int M = sc.nextInt();
		while(M-->0)
		{
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			adjMat[u][v] = adjMat[v][u] = true;
		}
		long ans = 0;
		for(int i = N; i > 1; --i)
		{
			memo = new long[i][1 << i];
			for(long[] x: memo)
				Arrays.fill(x, -1);
			ans += dp(endNode = i - 1, 1 << endNode);
		}
		for(int i = 0; i < N; ++i)
			for(int j = i + 1; j < N; ++j)
				if(adjMat[i][j])
					--ans;
		out.println(ans >> 1);
		out.flush();
		out.close();
	}
	 
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();} 
	}
}
