
import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = in.nextInt();
		double r = in.nextInt();
		double[] x = new double[n+1];
		double[] y = new double[n+1];
		for (int i = 1; i <= n; i++) {
			x[i] = in.nextInt();
		}
		
		int[] lastx = new int[1001];
		for (int i = 1; i <= n; i++) {
			double s = x[i] - r, e = x[i] + r;
			for (int j = (int)Math.max(0, s); j <= (int)Math.min(1000, e); j++) {
				if (lastx[j] == 0) {
					y[i] = Math.max(y[i], findY(x[i], x[i], 0 - r, 2 * r));
				}
				else {
					y[i] = Math.max(y[i], findY(x[lastx[j]], x[i], y[lastx[j]], 2 * r));
				}
				lastx[j] = i;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			out.println(y[i]);
		}
		out.close();
	}
	
	public static double findY(double x1, double x2, double y1, double d) {
		return Math.max(y1 + Math.sqrt(-1 * Math.pow(x1, 2) + 2 * x1 * x2 + Math.pow(d, 2) - Math.pow(x2, 2)),
				y1 - Math.sqrt(-1 * Math.pow(x1, 2) + 2 * x1 * x2 + Math.pow(d, 2) - Math.pow(x2, 2)));
	}

	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
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

		public String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}

}
