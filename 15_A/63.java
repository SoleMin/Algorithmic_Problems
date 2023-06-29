
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
	int N, T;
	void solve() throws IOException
	{
		StringTokenizer st = tokens();
		N = nextInt(st); T = nextInt(st);
		T *= 2;
		ArrayList<Pair> list = new ArrayList<Pair>();
		for(int i = 0; i < N; i++)
		{
			st = tokens();
			int c = nextInt(st), L = nextInt(st);
			c *= 2; L *= 2;
			list.add(new Pair(c - L / 2, c + L / 2));
		}
		Collections.sort(list);
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < list.size(); i++)
		{
			if(i == 0 || list.get(i).x - list.get(i - 1).y >= T)
			{
				set.add(list.get(i).x - T / 2);
			}
			if(i == list.size() - 1 || list.get(i + 1).x - list.get(i).y >= T)
			{
				set.add(list.get(i).y + T / 2);
			}
		}
		System.out.println(set.size());
	}
	class Pair implements Comparable<Pair>
	{
		int x, y;
		public Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pair p)
		{
			if(x != p.x) return x - p.x;
			return y - p.y;
		}
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