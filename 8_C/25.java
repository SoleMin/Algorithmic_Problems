import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, memo[], dS[], dd[][];

	static int dp(int idx, int msk)
	{
		if(msk == (1 << n) - 1)
			return 0;
		if(memo[msk] != -1)
			return memo[msk];
		while((msk & 1 << idx) != 0)
			++idx;
		int ret = dS[idx] * 2 + dp(idx + 1, msk | 1 << idx);
		for(int i = 0; i < n; ++i)
			if((msk & 1 << i) == 0)
				ret = Math.min(ret, dS[i] + dS[idx] + dd[i][idx] + dp(idx + 1, msk | 1 << i | 1 << idx));
		return memo[msk] = ret;
	}
	
	static StringBuilder sb = new StringBuilder("0 ");
	
	static void print(int idx, int msk)
	{
		if(msk == (1 << n) - 1)
			return;
		int opt = dp(idx, msk);
		while((msk & 1 << idx) != 0)
			++idx;
		if(dS[idx] * 2 + dp(idx + 1, msk | 1 << idx) == opt)
		{
			sb.append((idx + 1) + " 0 ");
			print(idx + 1, msk | 1 << idx);
			return;
		}
		for(int i = 0; i < n; ++i)
			if((msk & 1 << i) == 0)
				if(opt == dS[i] + dS[idx] + dd[i][idx] + dp(idx + 1, msk | 1 << i | 1 << idx))
				{
					sb.append((idx + 1) + " " + (i + 1) + " 0 ");
					print(idx + 1, msk | 1 << i | 1 << idx);
					return;
				}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Point s = new Point(sc.nextInt(), sc.nextInt());
		n = sc.nextInt();
		Point[] a = new Point[n];
		for(int i = 0; i < n; ++i)
			a[i] = new Point(sc.nextInt(), sc.nextInt());
		dS = new int[n];
		dd = new int[n][n];
		for(int i = 0; i < n; ++i)
		{
			dS[i] = dist2(s, a[i]);
			for(int j = 0; j < n; ++j)
				dd[i][j] = dist2(a[i], a[j]);
		}

		memo = new int[1 << n];
		Arrays.fill(memo, -1);
		out.println(dp(0, 0));
		print(0, 0);
		out.println(sb);
		out.flush();
		out.close();
	}

	static int dist2(Point a, Point b) { return sq(a.x - b.x) + sq(a.y - b.y); }

	static int sq(int x) { return x * x; }

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();} 
	}
} 