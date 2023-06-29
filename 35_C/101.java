
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;


public class C35 
{

	public static int mod = 1000000007;
	public static long INF = (1L << 60);

	static int n,m;
	static class Pair
	{
		int x,y;
		Pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	static boolean[][] burned;
	static int[] dx={-1,0,1,0};
	static int[] dy={0,-1,0,1};
	static boolean isvalid(int x,int y)
	{
		return x>=0&&x<n&&y>=0&&y<m;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner("input.txt");
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		n=in.nextInt();
		m=in.nextInt();
		burned=new boolean[n][m];
		int k=in.nextInt();
		Queue<Pair> queue=new LinkedList<>();
		Pair prev=null;
		for(int i=0;i<k;i++)
		{
			int x=in.nextInt();
			int y=in.nextInt();
			burned[x-1][y-1]=true;
			queue.add(prev=new Pair(x-1, y-1));
		}
		while(!queue.isEmpty())
		{
			Queue<Pair> tempqueue=new LinkedList<>();
		for(Pair p : queue)
		{
			int x=p.x;
			int y=p.y;
			prev=p;
			for(int i=0;i<4;i++)
			{
				if(isvalid(x+dx[i], y+dy[i])&&!burned[x+dx[i]][y+dy[i]])
				{
					tempqueue.add(new Pair(x+dx[i], y+dy[i]));
					burned[x+dx[i]][y+dy[i]]=true;
				}
			}
		}
		queue=tempqueue;
		}
		out.printf("%d %d\n",(prev.x+1),(prev.y+1));
		out.close();

	}
	
	public static long pow(long x, long n) 
	{
		long res = 1;
		for (long p = x; n > 0; n >>= 1, p = (p * p)) 
		{
			if ((n & 1) != 0) 
			{
				res = (res * p);
			}
		}
		return res;
	}
	
	public static long pow(long x, long n, long mod) 
	{
		long res = 1;
		for (long p = x; n > 0; n >>= 1, p = (p * p) % mod) 
		{
			if ((n & 1) != 0) 
			{
				res = (res * p % mod);
			}
		}
		return res;
	}

	public static long gcd(long n1, long n2)
	{
		long r;
		while (n2 != 0) 
		{
			r = n1 % n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}

	public static long lcm(long n1, long n2) 
	{
		long answer = (n1 * n2) / (gcd(n1, n2));
		return answer;
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
		public Scanner(String s) throws FileNotFoundException {	br = new BufferedReader(new FileReader(s));}

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

