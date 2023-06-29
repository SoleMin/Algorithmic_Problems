import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class C817{

	void solve()
	{
		long n = nl(), s = nl();
		long l = 0, r = n;
		while(l < r)
		{
			long mid = (l + r)/2;
			if(mid - digSum(mid) < s)
				l = mid + 1;
			else
				r = mid;
		}
		out.println(l - digSum(l) >= s ? (n - l + 1) : 0);
	}
	
	int digSum(long k)
	{
		int sum = 0;
		while(k != 0)
		{
			sum += k % 10;
			k /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args){new C817().run();}
	
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
		if(bufLength==-1)
			throw new InputMismatchException();
		if(bufCurrent>=bufLength)
		{
			bufCurrent = 0;
			try
			{bufLength = inputStream.read(bufferArray);}
			catch(IOException e)
			{ throw new InputMismatchException();}
			if(bufLength<=0)
				return -1;
		}
		return bufferArray[bufCurrent++];
	}
	
	boolean isSpaceChar(int x)
	{return (x<33 || x>126);}
	
	boolean isDigit(int x)
	{return (x>='0' && x<='9');}
	
	int nextNonSpace()
	{
		int x;
		while((x=nextByte())!=-1 && isSpaceChar(x));
		return x;
	}
	
	int ni()
	{
		long ans = nl();
		if ( Integer.MIN_VALUE <= ans && ans <= Integer.MAX_VALUE )
			return (int)ans;
		throw new InputMismatchException();
	}
	
	long nl()
	{
		long ans = 0;
		boolean neg = false;
		int x = nextNonSpace();
		if(x=='-') 
		{
			neg = true;
			x = nextByte();
		}
		while(!isSpaceChar(x))
		{
			if(isDigit(x))
			{
				ans = ans*10 + x -'0';
				x = nextByte();
			}
			else
				throw new InputMismatchException();
		}
		return neg ? -ans:ans;
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
	
	char nc()
	{ return (char)nextNonSpace();}
	
	double nd()
	{ return (double)Double.parseDouble(ns()); }
	
	char[] ca()
	{ return ns().toCharArray();}
	
	char[] ca(int n)
	{
		char[] ans = new char[n];
		int p =0;
		int x = nextNonSpace();
		while(p<n)
		{
			ans[p++] = (char)x;
			x = nextByte();
		}
		return ans;
	}
	
	int[] ia(int n)
	{
		int[] ans = new int[n];
		for(int i=0;i<n;i++)
			ans[i]=ni();
		return ans;
	}
	
}
