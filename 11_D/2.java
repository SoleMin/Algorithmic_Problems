
	import java.awt.List;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.io.PrintWriter;
	import java.math.BigDecimal;
	import java.math.BigInteger;
	import java.text.DecimalFormat;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.InputMismatchException;
	import java.util.Locale;
	import java.util.TimeZone;
	
	public class Cycle {
	
		public static void main(String[] args) {
			Locale.setDefault(Locale.US);
			InputStream inputstream = System.in;
			OutputStream outputstream = System.out;
			FastReader in = new FastReader(inputstream);
			PrintWriter out = new PrintWriter(outputstream);
			TaskA solver = new TaskA();
			// int testcase = in.ni();
			for (int i = 0; i < 1; i++)
				solver.solve(i, in, out);
			out.close();
	
		}
	
	}
	
	class TaskA {
	
		public void solve(int testnumber, FastReader in, PrintWriter out) {
	
			int n = in.ni();
			int m = in.ni();
	
			boolean graph[][] = new boolean[n][n];
	
			for (int i = 0; i < m; i++) {
				int a = in.ni() - 1;
				int b = in.ni() - 1;
	
				graph[a][b] = true;
				graph[b][a] = true;
			}
	
			/*
			 * dp[mask][i] be the number of Hamiltonian walks over the subset mask,
			 * starting at the vertex first(mask) and ending at the vertex i
			 */
	
			long dp[][] = new long[1 << n][n];
	
			for (int i = 0; i < n; i++) {
				dp[1 << i][i] = 1;
			}
	
			long answer = 0;
			for (int mask = 1; mask < (1 << n); mask++) {
				int start = Integer.numberOfTrailingZeros(mask);
				
				for (int i = 0; i < n; i++) {
					if ((mask & (1 << i)) == 0) {
						continue;
					}
	
					for (int j = start + 1; j < n; j++) {
						if (graph[i][j] && (mask & (1 << j)) == 0) {
							dp[mask + (1 << j)][j] += dp[mask][i];
						}
	
					}
					if (graph[i][start]) {
						answer += dp[mask][i];
					}
				}
	
			}
	
			out.println((answer - m) / 2);
		}
	}
	
	class FastReader {
		public InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
	
		public FastReader(InputStream stream) {
			this.stream = stream;
		}
	
		public FastReader() {
	
		}
	
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
	
		public int ni() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	
		public String ns() {
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
	
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return isWhitespace(c);
		}
	
		public static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	
		public int[] iArr(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = ni();
			}
			return a;
		}
	
		public String next() {
			return ns();
		}
	
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	
	}