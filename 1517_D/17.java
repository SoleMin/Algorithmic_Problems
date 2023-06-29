//Utilities
import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k;
	static int[][] horW, verW;
	static int[][][] dp = new int[505][505][15];
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 505; i++) {
			for (int j = 0; j < 505; j++) {
				for (int k = 0; k < 15; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		n = in.iscan(); m = in.iscan(); k =in.iscan();
		horW = new int[n+1][m]; verW = new int[n][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m-1; j++) {
				horW[i][j] = in.iscan();
			}
		}
		for (int i = 1; i <= n-1; i++) {
			for (int j = 1; j <= m; j++) {
				verW[i][j] = in.iscan();
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (k % 2 == 1) {
					out.print(-1 + " ");
					continue;
				}
				out.print(dfs(i, j, k/2) * 2 + " ");
			}
			out.println();
		}
		out.close();
	} 
	
	static int dfs(int r, int c, int k) {
		if (dp[r][c][k] != -1) {
			return dp[r][c][k];
		}
		if (k == 0) {
			return dp[r][c][k] = 0;
		}
		int min = Integer.MAX_VALUE;
		if (r - 1 >= 1) {
			min = Math.min(min, verW[r-1][c] + dfs(r-1, c, k-1));
		}
		if (r + 1 <= n) {
			min = Math.min(min, verW[r][c] + dfs(r+1, c, k-1));
		}
		if (c - 1 >= 1) {
			min = Math.min(min, horW[r][c-1] + dfs(r, c-1, k-1));
		}
		if (c + 1 <= m) {
			min = Math.min(min, horW[r][c] + dfs(r, c+1, k-1));
		}
		return dp[r][c][k] = min;
	}
	
	static INPUT in = new INPUT(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	private static class INPUT {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar, numChars;

		public INPUT (InputStream stream) {
			this.stream = stream;
		}

		public INPUT (String file) throws IOException {
			this.stream = new FileInputStream (file);
		}

		public int cscan () throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read (buf);
			}
			
			if (numChars == -1)
				return numChars;

			return buf[curChar++];
		}

		public int iscan () throws IOException {
			int c = cscan (), sgn = 1;
			
			while (space (c))
				c = cscan ();

			if (c == '-') {
				sgn = -1;
				c = cscan ();
			}

			int res = 0;

			do {
				res = (res << 1) + (res << 3);
				res += c - '0';
				c = cscan ();
			}
			while (!space (c));

			return res * sgn;
		}

		public String sscan () throws IOException {
			int c = cscan ();
			
			while (space (c))
				c = cscan ();

			StringBuilder res = new StringBuilder ();

			do {
				res.appendCodePoint (c);
				c = cscan ();
			}
			while (!space (c));

			return res.toString ();
		}

		public double dscan () throws IOException {
			int c = cscan (), sgn = 1;
			
			while (space (c))
				c = cscan ();

			if (c == '-') {
				sgn = -1;
				c = cscan ();
			}

			double res = 0;

			while (!space (c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * UTILITIES.fast_pow (10, iscan ());
				
				res *= 10;
				res += c - '0';
				c = cscan ();
			}

			if (c == '.') {
				c = cscan ();
				double m = 1;

				while (!space (c)) {
					if (c == 'e' || c == 'E')
						return res * UTILITIES.fast_pow (10, iscan ());

					m /= 10;
					res += (c - '0') * m;
					c = cscan ();
				}
			}

			return res * sgn;
		}

		public long lscan () throws IOException {
			int c = cscan (), sgn = 1;
			
			while (space (c))
				c = cscan ();

			if (c == '-') {
				sgn = -1;
				c = cscan ();
			}

			long res = 0;

			do {
				res = (res << 1) + (res << 3);
				res += c - '0';
				c = cscan ();
			}
			while (!space (c));

			return res * sgn;
		}

		public boolean space (int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

	public static class UTILITIES {

		static final double EPS = 10e-6;

		public static int lower_bound (int[] arr, int x) {
			int low = 0, high = arr.length, mid = -1;

			while (low < high) {
				mid = (low + high) / 2;

				if (arr[mid] >= x)
					high = mid;
				else
					low = mid + 1;
			}

			return low;
		}

		public static int upper_bound (int[] arr, int x) {
			int low = 0, high = arr.length, mid = -1;

			while (low < high) {
				mid = (low + high) / 2;

				if (arr[mid] > x)
					high = mid;
				else
					low = mid + 1;
			}

			return low;
		}

		public static long gcd (long a, long b) {
			return b == 0 ? a : gcd (b, a % b);
		}

		public static long lcm (long a, long b) {
			return a * b / gcd (a, b);
		}

		public static long fast_pow_mod (long b, long x, int mod) {
			if (x == 0) return 1;
			if (x == 1) return b;
			if (x % 2 == 0) return fast_pow_mod (b * b % mod, x / 2, mod) % mod;

			return b * fast_pow_mod (b * b % mod, x / 2, mod) % mod;
		}

		public static int fast_pow (int b, int x) {
			if (x == 0) return 1;
			if (x == 1) return b;
			if (x % 2 == 0) return fast_pow (b * b, x / 2);

			return b * fast_pow (b * b, x / 2);
		}

		public static long choose (long n, long k) {
			k = Math.min (k, n - k);
			long val = 1;

			for (int i = 0; i < k; ++i)
				val = val * (n - i) / (i + 1);

			return val;
		}

		public static long permute (int n, int k) {
			if (n < k) return 0;
			long val = 1;

			for (int i = 0; i < k; ++i)
				val = (val * (n - i));

			return val;
		}
	}
}
