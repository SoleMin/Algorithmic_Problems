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

		int n = f.ni(), k = f.ni(), a[] = f.nia(n), l, i;
		HashSet<Integer> h = new HashSet<>();

		for(i = 0; i < n; i++)
		{
			h.add(a[i]);
			if(h.size() == k)
				break;
		}

		for(l = i, h.clear(); l >= 0 && l < n; l--)
		{
			h.add(a[l]);
			if(h.size() == k)
				break;
		}

		if(i == n)
			f.out("-1 -1\n");
		else
			f.out((l+1) + " " + (i+1) + "\n");

		f.flush();
	}
}