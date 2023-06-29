import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class C {
	static double ycoord(double xi, double yi, double xj, double r) {
		if(Math.abs(xi-xj) > 2*r) return r;
		double dist = Math.sqrt((4*r*r)-((xi-xj)*(xi-xj)));
		//System.out.println("dist" + dist);
		return Math.max(yi+dist, r); //yi - dist?
	}
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		double r = sc.nextInt();
		double[] xcoords = new double[n];
		double[] ycoords = new double[n];
		Arrays.fill(ycoords, Integer.MIN_VALUE);
		ycoords[0] = r;
		for(int i = 0; i < n; i++) {
			xcoords[i] = sc.nextDouble();
		}
		System.out.print(r + " ");
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j < i; j++) {
				ycoords[i] = Math.max(ycoord(xcoords[j], ycoords[j],xcoords[i],r),ycoords[i]);
			}
			System.out.print(ycoords[i] + " ");
		}
		out.flush();
	}

	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
}