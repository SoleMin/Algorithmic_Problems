
import static java.util.Arrays.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class A implements Runnable
{
	public static void main(String [] args) throws IOException
	{
		new Thread(null, new A(), "", 1 << 20).start();
	}
	
	String file = "input";
	BufferedReader input;
	PrintWriter out;
	
	public void run() 
	{
		try
		{
			//input = new BufferedReader(new FileReader(file + ".in"));
			input = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new BufferedOutputStream(System.out));
			solve();
			input.close();
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	void solve() throws IOException
	{
		ArrayList<Integer> p = new ArrayList<Integer>();
		StringTokenizer st = tokens();
		int n = nextInt(st), k = nextInt(st);
		for(int i = 2; i <= n; i++)
			if(prime(i)) p.add(i);
		
		int count = 0;
		for(int x = 2; x <= n; x++)
		{
			if(!prime(x)) continue;
			for(int i = 0; i + 1 < p.size(); i++)
			{
				int p1 = p.get(i);
				int p2 = p.get(i + 1);
				int P = p1 + p2 + 1;
				if(P == x) 
				{
					count++;
					break;
				}
				if(P > x) break;
			}
		}
		System.out.println(count >= k ? "YES" : "NO");
				
	}
	
	boolean prime(int n)
	{
		for(int i = 2; i * i <= n; i++)
			if(n % i == 0) return false;
		return true;
	}

	StringTokenizer tokens() throws IOException
	{
		return new StringTokenizer(input.readLine());
	}
	
	String next(StringTokenizer st)
	{
		return st.nextToken();
	}
	
	int nextInt() throws IOException
	{
		return Integer.parseInt(input.readLine());
	}
	
	int nextInt(StringTokenizer st)
	{
		return Integer.parseInt(st.nextToken());
	}
	
	double nextDouble() throws IOException
	{
		return Double.parseDouble(input.readLine());
	}
	
	double nextDouble(StringTokenizer st)
	{
		return Double.parseDouble(st.nextToken());
	}
	
	void print(Object... o)
	{
		out.println(deepToString(o));
	}
}