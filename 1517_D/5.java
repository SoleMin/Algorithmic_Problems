import java.util.*;
import java.io.*;

public class D
{

	static FastIO f;
	static long ve[][], he[][];

	public static void main(String args[]) throws IOException
	{
		f = new FastIO();

		int n = f.ni(), m = f.ni(), k = f.ni(), i, j;
		ve = new long[n-1][];
		he = new long[n][];

		long[][] ans = new long[n][m], pans = new long[n][m], temp;

		for(i = 0; i < n; i++)
			he[i] = f.nla(m-1);

		for(i = 0; i < n-1; i++)
			ve[i] = f.nla(m);

		if(k%2 == 1)
		{
			for(i = 0; i < n; i++)
				Arrays.fill(ans[i], -1L);
		}
		else
		{
			k /= 2;

			while(k-->0)
			{
				for(i = 0; i < n; i++)
				{
					for(j = 0; j < m; j++)
					{
						ans[i][j] = Integer.MAX_VALUE;

						if(i != 0)
							ans[i][j] = Math.min(ans[i][j], pans[i-1][j] + 2*edge(i, j, i-1, j));

						if(i != n-1)
							ans[i][j] = Math.min(ans[i][j], pans[i+1][j] + 2*edge(i, j, i+1, j));

						if(j != 0)
							ans[i][j] = Math.min(ans[i][j], pans[i][j-1] + 2*edge(i, j, i, j-1));

						if(j != m-1)
							ans[i][j] = Math.min(ans[i][j], pans[i][j+1] + 2*edge(i, j, i, j+1));
					}
				}

				// f.err(k + "\n");
				// errorprint(ans, n, m);

				temp = pans;
				pans = ans;
				ans = temp;
			}

			temp = pans;
			pans = ans;
			ans = temp;
		}

		for(i = 0; i < n; i++)
		{
			for(j = 0; j < m; j++)
			{
				f.out(ans[i][j] + " ");
			}

			f.out("\n");
		}

		f.flush();
	}

	public static void errorprint(long[][] p, int n, int m) throws IOException
	{
		int i, j;

		for(i = 0; i < n; i++)
		{
			for(j = 0; j < m; j++)
			{
				f.err(p[i][j] + " ");
			}

			f.err("\n");
		}
		
		f.err("\n");
	}

	public static long edge(int i, int j, int x, int y)
	{
		if(i == x)
			return he[i][Math.min(j, y)];
		else
			return ve[Math.min(i, x)][j];
	}

	public static class FastIO
	{
		BufferedReader br;
		BufferedWriter bw, be;
		StringTokenizer st;

		public FastIO()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			be = new BufferedWriter(new OutputStreamWriter(System.err));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String ns() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int ni() throws IOException
		{
			return Integer.parseInt(ns());
		}

		public long nl() throws IOException
		{
			return Long.parseLong(ns());
		}

		public float nf() throws IOException
		{
			return Float.parseFloat(ns());
		}

		public double nd() throws IOException
		{
			return Double.parseDouble(ns());
		}

		public char nc() throws IOException
		{
			return ns().charAt(0);
		}

		public int[] nia(int n) throws IOException
		{
			int[] a = new int[n];
			for(int i = 0; i < n; i++)
				a[i] = ni();

			return a;
		}

		public long[] nla(int n) throws IOException
		{
			long[] a = new long[n];
			for(int i = 0; i < n; i++)
				a[i] = nl();

			return a;
		}

		public char[] nca() throws IOException
		{
			return ns().toCharArray();
		}

		public void out(String s) throws IOException
		{
			bw.write(s);
		}

		public void flush() throws IOException
		{
			bw.flush();
			be.flush();
		}

		public void err(String s) throws IOException
		{
			be.write(s);
		}
	}
}