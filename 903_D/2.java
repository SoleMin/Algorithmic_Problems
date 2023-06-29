import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args){
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt();
		long[] a = scan.nextLongArray(n);
		BigInteger res = BigInteger.ZERO;
		for (int i = n-1; i >= 0; i--) res = res.add(BigInteger.valueOf(i*a[i] - (n-1-i)*a[i]));
		HashMap<Long, Long> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			res = res.subtract(BigInteger.valueOf(map.getOrDefault(a[i]-1, 0L)));
			res = res.add(BigInteger.valueOf(map.getOrDefault(a[i]+1, 0L)));
			map.put(a[i], map.getOrDefault(a[i], 0L)+1);
		}
		out.println(res);
		out.close();
	}
	
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
