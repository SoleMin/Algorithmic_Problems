import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P911D
{
	public static void main(String[] args)
	{
		FastScanner scan = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		int inv = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = i+1; j < n; j++)
			{
				if (arr[i] > arr[j])
					inv++;
			}
		}
		inv &= 1;
		
		int[] cumul = new int[n+1];
		for (int i = 2; i < cumul.length; i++)
		{
			cumul[i] = cumul[i-1] + i-1;
		}
		int q = scan.nextInt();
		for (int i = 0; i < q; i++)
		{
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			inv += cumul[b-a+1];
			inv &= 1;
			if (inv == 0)
				pw.println("even");
			else
				pw.println("odd");
		}
		pw.flush();
	}
	
	static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;

		public FastScanner()
		{
			try
			{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		public String next()
		{
			if (st.hasMoreTokens())
				return st.nextToken();
			try
			{
				st = new StringTokenizer(br.readLine());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}

		public long nextLong()
		{
			return Long.parseLong(next());
		}

		public String nextLine()
		{
			String line = "";
			try
			{
				line = br.readLine();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return line;
		}
	}
}
