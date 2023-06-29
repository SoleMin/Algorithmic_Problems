import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) throws InterruptedException{
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		long n = scan.nextLong(), s = scan.nextLong();
		long lo = 1, hi = n+1;
		for(int bs = 0; bs < 100; bs++) {
			long mid = (lo+hi)>>1;
			long mid2 = mid;
			long c = 0;
			while(mid > 0) {
				c += mid%10;
				mid /= 10;
			}
			if(mid2-c < s) lo = mid2;
			else hi = mid2;
		}
		out.println(n-lo);
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
