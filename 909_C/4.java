import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args){
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		n = scan.nextInt(); mod = (int)1e9+7;
		in = new char[n];
		for(int i = 0; i < n; i++) in[i] = scan.next().charAt(0);
		dp = new Long[n][n];
		out.println(go(0, 0));
		out.close();
	}
	
	static long go(int at, int i) {
		if(at == n-1) return 1;
		if(dp[at][i] != null) return dp[at][i];
		long res = 0;
		if(in[at] == 's') {
			res += go(at+1, i);
			res %= mod;
			if(i > 0) {
				res += go(at, i-1);
				res %= mod;
			}
		} else {
			res += go(at+1, i+1);
			res %= mod;
		}
		return dp[at][i] = res;
	}
	
	static Long[][] dp;
	static int n, mod;
	static char[] in;
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}

		public int nextInt() {return Integer.parseInt(next());}

		public long nextLong() {return Long.parseLong(next());}

		public double nextDouble() {return Double.parseDouble(next());}

		public String nextLine() {
			String line = "";
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}

		public long[] nextLongArray(int n){
			long[] a = new long[n];
			for(int i = 0; i < n; i++) a[i] = nextLong();
			return a;
		}

		public double[] nextDoubleArray(int n){
			double[] a = new double[n];
			for(int i = 0; i < n; i++) a[i] = nextDouble();
			return a;
		}

		public char[][] nextGrid(int n, int m){
			char[][] grid = new char[n][m];
			for(int i = 0; i < n; i++) grid[i] = next().toCharArray();
			return grid;
		}
	}


}