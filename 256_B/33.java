import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class B {
	public static void main(String[] args) {
		MScanner sc = new MScanner();
		PrintWriter out = new PrintWriter(System.out);

		long N = sc.nextLong();
		long X = sc.nextLong();
		long Y = sc.nextLong();
		long C = sc.nextLong();

		long low = 0;
		long high = N*2;
		long mid = 0;
		long ans = 0;
		while (low <= high) {
			mid = (low + high) >> 1;
			long painted = F(mid, X-1, Y-1, N);
			if (painted < C) {
				low = mid + 1;
			} else {
				ans = mid;
				high = mid - 1;
			}
		}
		out.println(ans);
		out.close();

	}

	private static long F(long mid, long x, long y, long n) {
		long base = 2 * mid * (mid + 1) + 1;
		base -= excess(mid - x);
		base -= excess(mid - y);
		base -= excess(mid - (n-1-x));
		base -= excess(mid - (n-1-y));
		base += corner(mid - (x + y + 1));
		base += corner(mid - (x + (n - y - 1) + 1));
		base += corner(mid - ((n - x - 1) + y + 1));
		base += corner(mid - (1 + (n - 1 - y) + (n - 1 - x)));
		return base;
	}

	private static long corner(long a) {
		if (a < 0)return 0;
		return (a * a + a) >> 1;
	}

	private static long excess(long thing) {
		if(thing<0)return 0;
		return thing * thing;
	}

	static class MScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public MScanner() {
			stream = System.in;
			// stream = new FileInputStream(new File("dec.in"));

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

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextInt(int N) {
			int[] ret = new int[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextInt();
			return ret;
		}

		int[][] nextInt(int N, int M) {
			int[][] ret = new int[N][M];
			for (int a = 0; a < N; a++)
				ret[a] = nextInt(M);
			return ret;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLong(int N) {
			long[] ret = new long[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextLong();
			return ret;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDouble(int N) {
			double[] ret = new double[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextDouble();
			return ret;
		}

		String next() {
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

		String[] next(int N) {
			String[] ret = new String[N];
			for (int a = 0; a < N; a++)
				ret[a] = next();
			return ret;
		}

		String nextLine() {
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

		String[] nextLine(int N) {
			String[] ret = new String[N];
			for (int a = 0; a < N; a++)
				ret[a] = nextLine();
			return ret;
		}

	}
}
