import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import static java.lang.Math.*;
 
public class TestClass implements Runnable
{
	/*int x,y;
	public TestClass(int x,int y)
	{
		this.x=x;
		this.y=y;
	}*/
	public static void main(String args[])
	{
		new Thread(null, new TestClass(),"TESTCLASS",1<<18).start();
	}
	public void run()
	{
		//Scanner scan=new Scanner(System.in);
		InputReader hb=new InputReader(System.in);
		PrintWriter w=new PrintWriter(System.out);
		
		long n=hb.nextLong();
		long s=hb.nextLong();
		
		long start=0;
		long end=n;
		long ans=0;
		while(start<=end)
		{
			long mid=(start+end)/2;
			if(mid-get(mid)>=s)
			{
				end=mid-1;
				ans=mid;
			}
			else
			{
				start=mid+1;
			}
		}
		if(ans<1)
			w.print(0);
		else
			w.print(n-ans+1);
		w.close();
	}
	
	public long get(long a)
	{
		String str = Long.toString(a);
		int ans = 0;
		for(char ch : str.toCharArray())
			ans += (ch-'0');
		return ans;
	}
	
	
	private void shuffle(int[] arr)
	{
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			int i1 = ran.nextInt(arr.length);
			int i2 = ran.nextInt(arr.length);

			int temp = arr[i1];
			arr[i1] = arr[i2];
			arr[i2] = temp;
		}
	}
	
	static class DSU
	{
		int parent[];
		int sizeParent[];
		DSU(int n)
		{
			parent=new int[n];
			sizeParent=new int[n];
			Arrays.fill(sizeParent,1);
			for(int i=0;i<n;i++)
				parent[i]=i;
		}
		
		int find(int x)
		{
			if(x!=parent[x])
				parent[x]=find(parent[x]);
			return parent[x];
		}
		
		void union(int x,int y)
		{
			x=find(x);
			y=find(y);
			if(sizeParent[x]>=sizeParent[y])
			{
				if(x!=y)
					sizeParent[x]+=sizeParent[y];
				parent[y]=x;
			}
			else
			{
				if(x!=y)
					sizeParent[y]+=sizeParent[x];
				parent[x]=y;
			}
		}
	}
	
	static class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
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
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
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
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}
 
	static class Pair implements Comparable<Pair>
	{
		int a;
		int b;
		String str;
		public Pair(int a,int b)
		{
			this.a=a;
			this.b=b;
			str=min(a,b)+" "+max(a,b);
		}
 
		public int compareTo(Pair pair)
		{
			if(Integer.compare(a,pair.a)==0)
				return Integer.compare(b,pair.b);
 
			return Integer.compare(a,pair.a);
		}
	}
 
	
}