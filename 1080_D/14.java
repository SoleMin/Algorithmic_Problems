import java.io.*;
import java.math.*;
import java.util.*;

public class OlyaAndMagicalSquare {
	public static void solveCase(FastIO io) {
		int N = io.nextInt();
		long K = io.nextLong();

		CountMap cm = new CountMap();
		cm.increment(N, BigInteger.ONE);
		long rem = K;
		int moves = 1;
		int sqSize = N;
		while (sqSize > 0) {
			long need = (1L << moves) - 1;
			BigInteger biNeed = BigInteger.valueOf(need);
			cm.decrement(sqSize, biNeed);
			if (need > rem) {
				break;
			}
			cm.increment(sqSize - 1, biNeed.multiply(BigInteger.valueOf(4)));
			rem -= need;
			++moves;
			--sqSize;
		}

		BigInteger biRem = BigInteger.valueOf(rem);
		for (int i = N; i > 0; --i) {
			BigInteger have = cm.getCount(i);
			if (have.compareTo(biRem) >= 0) {
				biRem = BigInteger.ZERO;
				break;
			}
			biRem = biRem.subtract(have);
			cm.decrement(i, have);
			cm.increment(i - 1, have.multiply(BigInteger.valueOf(4)));
		}
		if (biRem.equals(BigInteger.ZERO)) {
			io.printf("YES %d\n", sqSize);
		} else {
			io.println("NO");
		}
	}

	private static class CountMap extends HashMap<Integer, BigInteger> {
		public void increment(int k, BigInteger v) {
			put(k, getCount(k).add(v));
		}

		public void decrement(int k, BigInteger v) {
			BigInteger next = getCount(k).subtract(v);
			if (next.equals(BigInteger.ZERO)) {
				remove(k);
			} else {
				put(k, next);
			}
		}

		public BigInteger getCount(int k) {
			return getOrDefault(k, BigInteger.ZERO);
		}
	}

	public static void solve(FastIO io) {
		int T = io.nextInt();

		for (int t = 0; t < T; ++t) {
			solveCase(io);
		}
	}

	public static class FastIO {
		private InputStream reader;
		private PrintWriter writer;

		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastIO(InputStream r, OutputStream w) {
			reader = r;
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(w)));
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = reader.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
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

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
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
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		// TODO: read this byte-by-byte like the other read functions.
		public double nextDouble() {
			return Double.parseDouble(nextString());
		}

		public int[] nextIntArray(int n) {
			return nextIntArray(n, 0);
		}

		public int[] nextIntArray(int n, int off) {
			int[] arr = new int[n + off];
			for (int i = 0; i < n; i++) {
				arr[i + off] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) {
			return nextLongArray(n, 0);
		}

		public long[] nextLongArray(int n, int off) {
			long[] arr = new long[n + off];
			for (int i = 0; i < n; i++) {
				arr[i + off] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
		}

		public void println(Object... objects) {
			print(objects);
			writer.println();
		}

		public void printArray(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(arr[i]);
			}
		}

		public void printArray(long[] arr) {
			for (int i = 0; i < arr.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(arr[i]);
			}
		}

		public void printlnArray(int[] arr) {
			printArray(arr);
			writer.println();
		}

		public void printlnArray(long[] arr) {
			printArray(arr);
			writer.println();
		}

		public void printf(String format, Object... args) {
			print(String.format(format, args));
		}

		public void flush() {
			writer.flush();
		}
	}

	public static void main(String[] args) {
		FastIO io = new FastIO(System.in, System.out);
		solve(io);
		io.flush();
	}
}
