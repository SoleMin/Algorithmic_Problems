import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author kanak893
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskC {
		public void solve(int testNumber, InputReader fi, PrintWriter out) {
			long n, k;
			n = fi.nextLong();
			k = fi.nextLong();
			long ans = 2 * n;
			long mod = (long) Math.pow(10, 9) + 7;

			if (k > 0) {
				ans = (modulus(modulus(pow(2, k + 1, mod), mod) * modulus(n, mod), mod));
				long temp = modulus(pow(2, k, mod) - 1, mod);
				ans = modulus(modulus(ans, mod) - modulus(temp, mod), mod);

			}
			if (n == 0) {
				ans = 0;
			}
			ans=ans%mod;
			out.println(ans);
		}

		static long pow(long x, long y, long mod) {
			if (y == 0) return 1 % mod;
			if (y == 1) return x % mod;
			long res = 1;
			x = x % mod;
			while (y > 0) {
				if ((y % 2) != 0) {
					res = (res * x) % mod;
				}
				y = y / 2;
				x = (x * x) % mod;
			}
			return res;
		}

		static long modulus(long a, long mod) {
			return (a % mod + mod) % mod;
		}

	}

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private InputReader.SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);

		}

	}
}
