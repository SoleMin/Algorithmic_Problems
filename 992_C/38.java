import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {
	
	static long MOD = (long) 1e9 + 7;
	static long[][] identity = {{1, 0}, {0, 1}};
	
	public static void main(String[] args) {
		FastScanner input = new FastScanner(System.in);
		
		long x = input.nextLong();
		long k = input.nextLong();
		
		long[][] matrix = {
			{2, MOD - 1},
			{0, 1}
		};
		
		if (x == 0)
			System.out.println(0);
		else if (k == 0) {
			System.out.println((x * 2) % MOD);
		} else {
			x %= MOD;
			matrix = matrixexpo(k, matrix);
			long low = (x * matrix[0][0] + matrix[0][1]) % MOD;
			long hi = x * mathpow(k, 2) % MOD;
			System.out.println((low + hi) % MOD);
		}
	}
	
	static long mathpow(long k, long x) {
		if (k == 0)
			return 1L;
		else return mathpow(k / 2, (x * x) % MOD) * (k % 2 == 1 ? x : 1) % MOD;
	}
	
	static long[][] matrixexpo(long k, long[][] matrix) { 
		if (k == 0)
			return identity;
		if (k % 2 == 0)
			return matrixexpo(k / 2, multiply(matrix, matrix));
		else
			return multiply(matrix, matrixexpo(k / 2, multiply(matrix, matrix)));
	}
	
	static long[][] multiply(long[][] arr, long[][] brr) { 
		int n = arr.length, m = arr[0].length, p = brr[0].length;
		
		long[][] product = new long[n][p];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < p; j++)
				for (int k = 0; k < m; k++)
					product[i][j] = (product[i][j] + arr[i][k] * brr[k][j]) % MOD;
		return product;
	}
	
	// Matt Fontaine's Fast IO
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

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
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
	}
}
