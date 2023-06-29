import java.io.*;
import java.util.*;

public class Main {

	public static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}

		public InputReader(InputStream stream) {
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

		public char nextChar() {
			return next().charAt(0);
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
	}

	public static void main(String[] args) {
		// InputStream inputStream = System.in; // Useful when taking input other than
		// console eg file handling // check ctor of inputReader
		InputReader scn = new InputReader();
		
		int n = scn.nextInt(), r = scn.nextInt();
		double[] y = new double[n];
		int[] x = new int[n];
		boolean[] mark = new boolean[n];
		for(int i = 0; i < n; i++) {
			x[i] = scn.nextInt();
		}
		for(int i = 0; i < n; i++) {
			double yc = r;
			for(int j = 0; j < n; j++) {
				if(i == j || !mark[j]) {
					continue;
				}
				if(x[i] + r < x[j] - r || x[i] - r > x[j] + r) {
					continue;
				}
				
				yc = Math.max(yc, y[j] + Math.sqrt(Math.abs(Math.pow(x[i] - x[j], 2) - 4 * r * r)));
			}
			y[i] = yc;
			mark[i] = true;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(y[i] + " ");
		}
		System.out.println();
	}
}