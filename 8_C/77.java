/**
 * DA-IICT
 * Author : PARTH PATEL
 */
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;


public class C8 
{

	public static long mod = 1000000007;
	public static long INF = (1L << 60);
	static FastScanner2 in = new FastScanner2();
	static OutputWriter out = new OutputWriter(System.out);
	static int n;
	static int x,y;
	static int[] xx;
	static int[] yy;
	static int[] dist;
	static int[][] g;
	static int[] dp;
	public static int square(int x)
	{
		return abs(x*x);
	}
	static class Pair
	{
		int x,y;
		Pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) 
	{

		x=in.nextInt();
		y=in.nextInt();
		n=in.nextInt();
		xx=new int[n];
		yy=new int[n];
		dp=new int[1<<n];
		for(int i=0;i<n;i++)
		{
			xx[i]=in.nextInt();
			yy[i]=in.nextInt();
		}
		dist=new int[n];
		g=new int[n][n];
		for(int i=0;i<n;i++)
		{
			dist[i]=square(abs(xx[i]-x))+square(abs(yy[i]-y));
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				g[i][j]=square(abs(xx[i]-xx[j]))+square(yy[i]-yy[j]);
				//System.out.println("i "+i+" j "+j+" "+g[i][j]);
			}
		}
		Arrays.fill(dp, Integer.MAX_VALUE/2);
		dp[0]=0;
		for(int i=0;i<(1<<n);i++)
		{
			//we have to find dp[i]
			for(int j=0;j<n;j++)
			{
				if((i&(1<<j))>0)   //not visited j
				continue;
				dp[i|(1<<j)]=min(dp[i|(1<<j)], dp[i]+2*dist[j]);
				for(int k=j+1;k<n;k++)
				{
					if((i&(1<<k))>0)
						continue;
					dp[i|(1<<j)|(1<<k)]=min(dp[i|(1<<j)|(1<<k)], dp[i]+dist[j]+dist[k]+g[j][k]);
				}
				break;
			}
		}	
		out.println(dp[(1<<n)-1]);
		Stack<Integer> stack=new Stack<>();
		stack.push(0);
		int i=(1<<n)-1;
		while(i>0)
		{
			boolean tocontinue=false;
			for(int a=0;a<n;a++)
			{
				if((i&(1<<a))==0)
					continue;
				if(dp[i]==(dp[i^(1<<a)]+2*dist[a]))
				{
					stack.push(a+1);
					stack.push(0);
					i-=(1<<a);
					tocontinue=true;
				}
				if(tocontinue)
					continue;
				for(int b=a+1;b<n;b++)
				{
					if((i & (1<<b)) == 0) continue;
					if(dp[i]==(dp[i^(1<<a)^(1<<b)]+dist[a]+dist[b]+g[a][b]))
					{
						i-=(1<<a);
						i-=(1<<b);
						stack.push(a+1);
						stack.push(b+1);
						stack.push(0);
						tocontinue=true;
					}
					if(tocontinue)
						break;
				}
				if(tocontinue)
					break;
			}
			
		}
		for(int ii : stack)
			out.print(ii+" ");
		out.close();

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

	static class FastScanner2 
	{
		private byte[] buf = new byte[1024];
		private int curChar;
		private int snumChars;

		public int read() 
		{
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) 
			{
				curChar = 0;
				try 
				{
					snumChars = System.in.read(buf);
				} catch (IOException e) 
				{
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong()
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} 
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} 
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n)
		{
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n)
		{
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) 
			{
				arr[i] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c)
		{
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) 
		{
			return c == '\n' || c == '\r' || c == -1;
		}
	}

	static class InputReader 
	{
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputstream) 
		{
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine() 
		{
			String fullLine = null;
			while (tokenizer == null || !tokenizer.hasMoreTokens())
			{
				try 
				{
					fullLine = reader.readLine();
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}

		public String next()
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			{
				try 
				{
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) 
				{
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public long nextLong() 
		{
			return Long.parseLong(next());
		}

		public int[] nextIntArray(int n) 
		{
			int a[] = new int[n];
			for (int i = 0; i < n; i++) 
			{
				a[i] = nextInt();
			}
			return a;
		}

		public long[] nextLongArray(int n)
		{
			long a[] = new long[n];
			for (int i = 0; i < n; i++) 
			{
				a[i] = nextLong();
			}
			return a;
		}

		public int nextInt() 
		{
			return Integer.parseInt(next());
		}
	}

	static class OutputWriter 
	{
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) 
		{
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer)
		{
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects)
		{
			for (int i = 0; i < objects.length; i++) 
			{
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void println(Object... objects)
		{
			print(objects);
			writer.println();
		}

		public void close() 
		{
			writer.close();
		}

		public void flush() 
		{
			writer.flush();
		}
	}

}