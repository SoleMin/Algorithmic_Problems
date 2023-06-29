import java.util.*;
import java.io.*;

public class A2OJ
{
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

	static FastIO f;

	public static void main(String args[]) throws IOException
	{
		f = new FastIO();

		long n = f.nl();

		if(n == 1)
			f.out("1\n");
		else if(n == 2)
			f.out("2\n");
		else if(n == 3)
			f.out("6\n");
		else if(n%6 == 0)
			f.out((n-1)*(n-2)*(n-3) + "\n");
		else if(n%2 == 0)
			f.out(n*(n-1)*(n-3) + "\n");
		else
			f.out(n*(n-1)*(n-2) + "\n");

		f.flush();
	}
}