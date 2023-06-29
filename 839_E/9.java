import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 -> n/2  XX n/2 + 1 -> n
public class MotherOfDragons
{
	static boolean[][] adjMatrix;
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
//		for (int i = 1; i <= n; i++)
//			System.err.printf("%d %.12f\n",i, (k*k*((i-1)/(2.0*i))));
		adjMatrix = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				adjMatrix[i][j] = sc.nextInt() == 1;
		
		long[] edges = new long[n];
		for (int i = 0; i < n; i++)
		{
			long val = 0;
			for (int j = 0; j < n; j++)
				if(adjMatrix[i][j] || i == j)
					val |= 1l<<j;
			edges[i] = val;
		}
		
		int h = n/2;
		
		int[] cliques = new int[1<<h];
		for (int i = 1; i < 1<<h; i++)
		{
			int nodes = i;
			for (int j = 0; j < h; j++)
				if((i & (1 << j)) != 0)
					nodes &= edges[j];
			if(nodes == i)
				cliques[i] = Integer.bitCount(i);
		}
		
		for (int i = 1; i < 1<<h; i++)
			for (int j = 0; j < h; j++)
				if((i & (1 << j)) != 0)
					cliques[i] = Math.max(cliques[i], cliques[i ^ (1<<j)]);
		
		int max = 0;
		for (int i = 0; i < cliques.length; i++)
			max = Math.max(max, cliques[i]);
		for (int i = 1; i < 1<<(n-h); i++)
		{
			long all = -1l;
			long tmp = (1l*i)<<h;
			for (int j = h; j < n; j++)
				if((tmp & (1l << j)) != 0)
					all &= edges[j];
			long node = all&tmp;
			if(node != tmp)
				continue;
			int connected = (int)(all & ((1<<h)-1));
			max = Math.max(max, cliques[connected] + Integer.bitCount(i));
		}
		
		System.out.printf("%.12f\n", (k*k*((max-1)/(2.0*max))));
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
		{ return Double.parseDouble(next()); }	
	}
}
