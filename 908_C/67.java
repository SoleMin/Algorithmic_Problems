import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args){
		FastScanner scan = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = scan.nextInt(), r = scan.nextInt();
		int[] x = scan.nextIntArray(n);
		double[] y = new double[n];
		for(int i = 0; i < n; i++) {
			double best = 0;
			for(int j = 0; j < i; j++) {
				if(Math.abs(dist(x[i], y[j], x[j], y[j])-2*r) <= 1e-7) {
					best = Math.max(best, y[j]);
					continue;
				}
				double lo = y[j]-r-r, hi = y[j]+r+r;
				for(int bs = 0; bs < 200; bs++) {
					double mid = (lo+hi)/2.0;
					if(dist(x[i], mid, x[j], y[j])-2*r <= 1e-7) lo = mid;
					else hi = mid;
				}
				if(dist(x[i], lo, x[j], y[j])-2*r <= 1e-7) best = Math.max(best, lo);
			}
			if(best == 0) y[i] = r;
			else y[i] = best;
		}
		for(int i = 0; i < n; i++) out.printf("%.6f ", y[i]);
		out.close();
	}

	static double dist(double x, double y, double xx, double yy) {return Math.sqrt((x-xx)*(x-xx)+(y-yy)*(y-yy));}

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