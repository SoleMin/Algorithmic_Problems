import java.util.*;
import java.io.*;

public class C
{

	static FastIO f;

	public static void main(String args[]) throws IOException
	{
		f = new FastIO();

		int t, n, a, i;
		Node r, p, c;
		
		t = f.ni();
		
		while(t-->0)
		{
			n = f.ni();
			r = p = new Node(-1, null);
			// f.out("1\n");

			for(i = 0; i < n; i++)
			{
				a = f.ni();
				if(a != 1)
				{
					while(a != p.i + 1)
						p = p.p;
					p = p.p;
				}
				// if(a == p.i + 1)
				// 	p = p.p;
				// else if(p.p != null && a == p.p.i + 1)
				// 	p = p.p.p;
				c = new Node(a, p);
				p.c.add(c);
				p = c;
			}

			dfs(r, "");
		}

		f.flush();
	}

	public  static void dfs(Node n, String s) throws IOException
	{
		String t;

		if(n.i == -1)
			t = s;
		else
		{
			t = s + n.i + ".";
			f.out(s + n.i + "\n");
		}

		for(Node c : n.c)
			dfs(c, t);
	}

	static class Node
	{
		int i;
		Node p;
		ArrayList<Node> c;
	
		Node(int x, Node y)
		{
			i = x;
			p = y;
			c = new ArrayList<>();
		}
	
		@Override
		public int hashCode()
		{
			return super.hashCode();
		}
	
		@Override
		public boolean equals(Object obj)
		{
			Node that = (Node)obj;
	
			return super.equals(obj);
		}
	
		@Override
		public String toString()
		{
			return "[" + "PARAMETERS" + "]";
		}
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