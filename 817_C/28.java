import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

	static int[] UPPER = new int[64], LOWER = new int[64];
	static long[][][] memo;
	
	static long dp(int bit, int lims, int digs)
	{
		if(bit == -1)
			return digs == 0 ? 1 : 0;
		if(memo[lims][bit][digs] != -1)
			return memo[lims][bit][digs];
		long ret = 0;
		for(int d = 0, end = digs < 10 ? digs + 1 : 10; d < end; ++d)
			if(((lims & 1) == 1 || d >= LOWER[bit]) && ((lims & 2) == 2 || d <= UPPER[bit]))
				ret += dp(bit - 1, lims | (d > LOWER[bit] ? 1 : 0) | (d < UPPER[bit] ? 2 : 0), digs - d);
		return memo[lims][bit][digs] = ret;
	}
	
	static void create(int[] x, long n)
	{
		for(int i = 0; i < 64; ++i)
		{
			x[i] = (int) (n % 10);
			n /= 10;
		}
	}
	
	static void prepMemo(int sod)
	{
		memo = new long[4][64][sod + 1];
		for(long[][] x: memo)
			for(long[] y: x)
				Arrays.fill(y, -1);
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		long n = sc.nextLong(), s = sc.nextLong();
		create(UPPER, n);
		long ans = 0;
		for(int sod = 1; sod <= 162; ++sod)
		{
			create(LOWER, s + sod);
			prepMemo(sod);
			ans += dp(63, 0, sod);
		}
		
		
		out.println(ans);
		out.close();
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(String s) throws FileNotFoundException{	br = new BufferedReader(new FileReader(s));}

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