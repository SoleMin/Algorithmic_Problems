import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class D911{

	void solve()
	{
		int n = ni();
		int[] a = ia(n);
		int Q = ni();
		String[] ans = {"even", "odd"};
		int cur = merge(a, 0, n - 1) % 2;
		while(Q-->0)
		{
			int l = ni(), r = ni();
			cur ^= (r - l + 1) / 2 % 2;
			out.println(ans[cur]);
		}
		
	}
	
	int merge(int[] a, int l, int r)
	{
		if(l >= r)
			return 0;
		int mid = l + r >> 1;
		int v1 = merge(a, l, mid);
		int v2 = merge(a, mid + 1, r);
		
		int[] rep = new int[r-l+1];
		int ptr0 = 0, ptr1 = l, ptr2 = mid + 1;
		
		long len = mid-l+1;
		int ret = 0;
		while(ptr1<=mid && ptr2<=r)
		{
			if(a[ptr1] <= a[ptr2])
			{
				len--;
				rep[ptr0++] = a[ptr1++];
			}
			else
			{
				ret += len;
				rep[ptr0++] = a[ptr2++]; 
			}
		}
		
		while(ptr1 <= mid)
			rep[ptr0++] = a[ptr1++];
		while(ptr2 <= r)
			rep[ptr0++] = a[ptr2++];
		
		for(int i=0;i<ptr0;i++)
			a[l+i] = rep[i];
		
		return v1 + v2 + ret;
	}
	
	public static void main(String[] args){new D911().run();}
	
	private byte[] bufferArray = new byte[1024];
	private int bufLength = 0;
	private int bufCurrent = 0;
	InputStream inputStream;
	PrintWriter out;
	
	public void run()
	{
		inputStream = System.in;
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}
	
	int nextByte()
	{
		if(bufLength == -1)
			throw new InputMismatchException();
		if(bufCurrent >= bufLength)
		{
			bufCurrent = 0;
			try
			{bufLength = inputStream.read(bufferArray);}
			catch(IOException e)
			{ throw new InputMismatchException();}
			if(bufLength <= 0)
				return -1;
		}
		return bufferArray[bufCurrent++];
	}
	
	boolean isSpaceChar(int x)	{return (x < 33 || x > 126);}
	
	boolean isDigit(int x)	{return (x >= '0' && x <= '9');}
	
	int nextNonSpace()
	{
		int x;
		while((x=nextByte()) != -1 && isSpaceChar(x));
		return x;
	}
	
	int ni()
	{
		long ans = nl();
		if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE)
			return (int)ans;
		throw new InputMismatchException();
	}
	
	long nl()
	{
		long ans = 0;
		boolean neg = false;
		int x = nextNonSpace();
		if(x == '-') 
		{
			neg = true;
			x = nextByte();
		}
		while(!isSpaceChar(x))
		{
			if(isDigit(x))
			{
				ans = ans * 10 + x -'0';
				x = nextByte();
			}
			else
				throw new InputMismatchException();
		}
		return neg ? -ans : ans;
	}
	
	String ns()
	{
		StringBuilder sb = new StringBuilder();
		int x = nextNonSpace();
		while(!isSpaceChar(x))
		{
			sb.append((char)x);
			x = nextByte();
		}
		return sb.toString();
	}
	
	char nc()	{ return (char)nextNonSpace();}
	
	double nd()	{ return (double)Double.parseDouble(ns()); }
	
	char[] ca()	{ return ns().toCharArray();}
	
	char[][] ca(int n)
	{
		char[][] ans = new char[n][];
		for(int i=0;i<n;i++)
			ans[i] = ca();
		return ans;
	}
	
	int[] ia(int n)
	{
		int[] ans = new int[n];
		for(int i=0;i<n;i++)
			ans[i] = ni();
		return ans;
	}
	
	void db(Object... o) {System.out.println(Arrays.deepToString(o));}
	
}
