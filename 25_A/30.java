import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class A implements Runnable
{
	String file = "input";
	
	void init() throws IOException
	{
		//input = new BufferedReader(new FileReader(file + ".in"));
		input = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
	}
	
	void solve() throws IOException
	{
		int odd = 0, even = 0;
		int n = nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) 
		{
			a[i] = nextInt();
			if(a[i] % 2 == 0) even++;
			else odd++;
		}
		if(even >= 2)
		{
			for(int i = 0; i < n; i++) if(a[i] % 2 == 1)
			{
				System.out.println(i + 1);
				return;
			}
		}
		else
		{
			for(int i = 0; i < n; i++) if(a[i] % 2 == 0)
			{
				System.out.println(i + 1);
				return;
			}
		}
	}
	
	String next() throws IOException
	{
		while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}
	
	long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}
	
	double nextDouble() throws IOException
	{
		return Double.parseDouble(next());
	}
	
	void print(Object... o)
	{
		System.out.println(deepToString(o));
	}
	
	void gcj(Object o)
	{
		String s = String.valueOf(o);
		out.println("Case #" + test + ": " + s);
		System.out.println("Case #" + test + ": " + s);
	}
	
	BufferedReader input;
	PrintWriter out;
	StringTokenizer st;
	int test;
	
	public static void main(String[] args) throws IOException
	{
		new Thread(null, new A(), "", 1 << 20).start();
	}
	
	public void run()
	{
		try
		{
			init();
			solve();
			out.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}