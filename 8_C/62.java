
import static java.util.Arrays.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class Main implements Runnable
{
	public static void main(String [] args) throws IOException
	{
		new Thread(null, new Main(), "", 1 << 20).start();
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
	int[] x = new int[25];
	int[] y = new int[25];
	int[][] dist = new int[25][25];
	int[] single = new int[25];
	int[] c = new int[25];
	int INF = 1 << 30;
	void solve() throws IOException
	{
		StringTokenizer st = tokens();
		x[0] = nextInt(st);
		y[0] = nextInt(st);
		int n = nextInt();
		for(int i = 1; i <= n; i++)
		{
			st = tokens();
			x[i] = nextInt(st);
			y[i] = nextInt(st);
		}
		for(int i = 1; i <= n; i++)
			single[i] = 2 * ((x[i] - x[0]) * (x[i] - x[0]) + (y[i] - y[0]) * (y[i] - y[0])); 
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				dist[i][j] = single[i] / 2 + single[j] / 2 + (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
		int[] dp = new int[1 << n];
		int[] prev = new int[1 << n];
		fill(dp, INF);
		dp[0] = 0;
		for(int i = 1; i < 1 << n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if((i >> j & 1) != 0)
				{
					if(dp[i] > dp[i ^ (1 << j)] + single[j + 1])
					{
						dp[i] = dp[i ^ (1 << j)] + single[j + 1];
						prev[i] = j + 1;
					}
			
					for(int k = j + 1; k < n; k++)
						if((i >> k & 1) != 0)
						{
							if(dp[i] > dp[i ^ (1 << j) ^ (1 << k)] + dist[j + 1][k + 1])
							{
								dp[i] = dp[i ^ (1 << j) ^ (1 << k)] + dist[j + 1][k + 1];
								prev[i] = (j + 1) * 100 + (k + 1);
							}
						}
					break;
				}
			}
		}
		out.println(dp[(1 << n) - 1]);
		out.print("0 ");
		int mask = (1 << n) - 1;
		while(mask > 0)
		{
			int s = prev[mask];
			int x = s / 100;
			int y = s % 100;
			if(x == 0)
			{
				out.print(y + " " + 0 + " ");
				mask -= 1 << (y - 1);
			}
			else
			{
				out.print(x + " " + y + " " + 0 + " ");
				mask -= 1 << (y - 1);
				mask -= 1 << (x - 1);
			}
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