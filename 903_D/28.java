import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		BigInteger ans = BigInteger.ZERO;
		int n = sc.nextInt();
		int arr[] = new int[n];
		long cum[] = new long[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
//		int n=(int)2e5;
//		for(int i=0;i<n;i++){
//			arr[i]=1;
//			if(i>n/2)
//				arr[i]=(int)1e9;
//		}
		
		for (int i = 0; i < cum.length; i++)
		{
			cum[i] = arr[i];
			if(i > 0)
				cum[i] += cum[i-1];
		}
		
		for (int i = 0; i < n; i++)
			ans = ans.add(BigInteger.valueOf((1l*(i+1)*arr[i] - cum[i])));
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
		{
			ans =  ans.subtract(BigInteger.valueOf(map.getOrDefault(arr[i]-1, 0)));
			ans = ans.add(BigInteger.valueOf(map.getOrDefault(arr[i]+1, 0)));
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	
		
	static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s)
		{
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String s) throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader(new File((s))));
		}

		public String next() throws IOException
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException
		{
			return br.readLine();
		}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else
				{
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException
		{
			return br.ready();
		}
	}
}
