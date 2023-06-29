import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static int mod = (int) 1e9 + 7;

	public static void main(String[] args) throws FileNotFoundException {
		FasterScanner s = new FasterScanner();
		int test = 1;
		testloop: while (test-- > 0) {
			int n = s.nextInt();
			int left = 1;
			int right = n;
			int x[][] = new int[2][2];
			int y[][] = new int[2][2];
			while (left < right) {
				int mid = (left + right) / 2;
				query(1, mid, 1, n);
				int ans = s.nextInt();
				if (ans < 2) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			x[0][0] = left;
			left = 1;
			right = n;
			while (left < right) {
				int mid = (left + right) / 2;
				query(1, mid, 1, n);
				int ans = s.nextInt();
				if (ans < 1) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			x[0][1] = left;
			left = 1;
			right = n;
			while (left < right) {
				int mid = (left + right + 1) / 2;
				query(mid, n, 1, n);
				int ans = s.nextInt();
				if (ans < 2) {
					right = mid - 1;
				} else {
					left = mid;
				}
			}
			x[1][0] = left;
			left = 1;
			right = n;
			while (left < right) {
				int mid = (left + right + 1) / 2;
				query(mid, n, 1, n);
				int ans = s.nextInt();
				if (ans < 1) {
					right = mid - 1;
				} else {
					left = mid;
				}
			}
			x[1][1] = left;
			// System.out.println(Arrays.deepToString(x));

			left = 1;
			right = n;
			while (left < right) {
				int mid = (left + right) / 2;
				query(1, n, 1, mid);
				int ans = s.nextInt();
				if (ans < 2) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			y[0][0] = left;
			left = 1;
			right = n;
			while (left < right) {
				int mid = (left + right) / 2;
				query(1, n, 1, mid);
				int ans = s.nextInt();
				if (ans < 1) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			y[0][1] = left;
			left = 1;
			right = n;
			while (left < right) {
				int mid = (left + right + 1) / 2;
				query(1, n, mid, n);
				int ans = s.nextInt();
				if (ans < 2) {
					right = mid - 1;
				} else {
					left = mid;
				}
			}
			y[1][0] = left;
			left = 1;
			right = n;
			while (left < right) {
				int mid = (left + right + 1) / 2;
				query(1, n, mid, n);
				int ans = s.nextInt();
				if (ans < 1) {
					right = mid - 1;
				} else {
					left = mid;
				}
			}
			y[1][1] = left;
//			System.out.println(Arrays.deepToString(x));
//			System.out.println(Arrays.deepToString(y));
			
			int x11 = 0, x12 = 0, y11 = 0, y12 = 0;
			int x21 = 0, x22 = 0, y21 = 0, y22 = 0;
			for (int x1 = 0; x1 < 2; x1++) {
				x11 = x[1][x1];
				x21 = x[1][1 - x1];
				for (int x2 = 0; x2 < 2; x2++) {
					x12 = x[0][x2];
					x22 = x[0][1 - x2];
					if (x11 > x12)
						continue;
					if (x21 > x22)
						continue;
					for (int y1 = 0; y1 < 2; y1++) {
						y11 = y[1][y1];
						y21 = y[1][1 - y1];
						for (int y2 = 0; y2 < 2; y2++) {
							y12 = y[0][y2];
							y22 = y[0][1 - y2];
							if (y11 > y12)
								continue;
							if (y21 > y22)
								continue;
							query(x11, x12, y11, y12);
							int ans1 = s.nextInt();

							query(x21, x22, y21, y22);
							int ans2 = s.nextInt();
							if (ans1 == 1 && ans2 == 1) {
								System.out.println("! " + x11 + " " + y11 + " " + x12 + " " + y12 + " " + x21 + " "
										+ y21 + " " + x22 + " " + y22);
								System.out.flush();
								break testloop;
							}
						}
					}
				}
			}

		}
	}

	public static void query(int x1, int x2, int y1, int y2) {
		 System.out.println("? " + x1 + " " + y1 + " " + x2 + " " + y2);
		 System.out.flush();
//		int count = 0;
//		if (x1 <= 2 && y1 <= 2 && x2 >= 2 && y2 >= 2)
//			count++;
//
//		if (x1 <= 3 && y1 <= 4 && x2 >= 3 && y2 >= 5)
//			count++;
//		System.out.println(count);
	}

	public static void set(int[] t, int i, int value) {
		i += t.length / 2;
		t[i] = value;
		for (; i > 1; i >>= 1)
			t[i >> 1] = Math.max(t[i], t[i ^ 1]);
	}

	// max[a, b]
	public static int max(int[] t, int a, int b) {
		int res = 0;
		for (a += t.length / 2, b += t.length / 2; a <= b; a = (a + 1) >> 1, b = (b - 1) >> 1) {
			if ((a & 1) != 0)
				res = Math.max(res, t[a]);
			if ((b & 1) == 0)
				res = Math.max(res, t[b]);
		}
		return res;
	}

	public static int[] generateDivisorTable(int n) {
		int[] divisor = new int[n + 1];
		for (int i = 1; i <= n; i++)
			divisor[i] = i;
		for (int i = 2; i * i <= n; i++)
			if (divisor[i] == i)
				for (int j = i * i; j <= n; j += i)
					if (divisor[j] == j)
						divisor[j] = i;
		return divisor;
	}

	public static long pow(long x, long n, long mod) {
		long res = 1;
		for (long p = x; n > 0; n >>= 1, p = (p * p) % mod) {
			if ((n & 1) != 0) {
				res = (res * p % mod);
			}
		}
		return res;
	}

	static long gcd(long n1, long n2) {
		long r;
		while (n2 != 0) {
			r = n1 % n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}

	static class FasterScanner {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int snumChars;

		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
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

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
}