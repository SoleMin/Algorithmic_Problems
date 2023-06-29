import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class A {
 
	static double[][] a;
	static int N;
	static double[][] memo;
 
	static double[] dp(int alive)
	{
		int count = Integer.bitCount(alive);
		if(count == 1)
		{
			double[] ret = new double[N];
			for(int i = 0; i < N; ++i)
				if((alive & (1<<i)) != 0)
				{
					ret[i] = 1;
					break;
				}
			return memo[alive] = ret;
		}
		if(memo[alive] != null)
			return memo[alive];
		
		double[] ret = new double[N];
		for(int j = 0; j < N; ++j)
			if((alive & (1<<j)) != 0)
			{
				double[] nxt = dp(alive & ~(1<<j));
				for(int i = 0; i < N; ++i)
					ret[i] += die[j][alive] * nxt[i];			
			}
		return memo[alive] = ret;
	}
 
	static double[][] die;
	static void f()
	{
		die = new double[N][1<<N];
		for(int i = 0; i < N; ++i)
			for(int j = 0; j < 1<<N; ++j)
			{
				int count = Integer.bitCount(j);
				if(count <= 1)
					continue;
				double prop = 1.0 / (count * (count - 1) >> 1);
				for(int k = 0; k < N; ++k)
					if((j & (1<<k)) != 0)
						die[i][j] += prop * a[k][i]; 
			}
 
	}
 
	public static void main(String[] args) throws IOException {
 
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
 
		N = sc.nextInt();
		
		a = new double[N][N];
		for(int i = 0; i < N; ++i)
			for(int j = 0; j < N; ++j)
				a[i][j] = sc.nextDouble();
		memo = new double[1<<N][];
		
		f();
		
		double[] ret = dp((1<<N) - 1);
		for(int i = 0; i < N - 1; ++i)
			out.printf("%.8f ",ret[i]);
		out.printf("%.8f\n", ret[N-1]);
 
		out.flush();
		out.close();
	}
 
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public double nextDouble() throws NumberFormatException, IOException
		{
			return Double.parseDouble(next());
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public boolean ready() throws IOException {return br.ready();}


	}
} 