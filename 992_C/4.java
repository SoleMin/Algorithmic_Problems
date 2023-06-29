import java.io.*;
import java.util.*;

public class Main {
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		long n = scn.nextLong(), k = scn.nextLong(), mod = (int)1e9 + 7;
		if(n == 0) {
			out.println(0);
			return;
		}
		n %= mod;
		long x = (pow(2, k + 1, mod) * n) % mod;
		long y = (pow(2, k, mod) + mod - 1) % mod;
		
		long ans = ((x - y) % mod + mod) % mod;
		out.println(ans);
	}
	
	long pow(long a, long x, long m) {
		if(x == 0) {
			return 1;
		}
		long p = pow(a, x / 2, m);
		p *= p;
		p %= m;
		if(x % 2 == 1) {
			p *= a;
			p %= m;
		}
		return p;
	}
	
	long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	void run() throws Exception {
		boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;
		out = new PrintWriter(System.out);
		scn = new FastReader(onlineJudge);
		long time = System.currentTimeMillis();
		solve();
		out.flush();
		if (!onlineJudge) {
			System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
		}
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	class FastReader {
		InputStream is;

		public FastReader(boolean onlineJudge) {
			is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		}

		byte[] inbuf = new byte[1024];
		public int lenbuf = 0, ptrbuf = 0;

		int readByte() {
			if (lenbuf == -1)
				throw new InputMismatchException();
			if (ptrbuf >= lenbuf) {
				ptrbuf = 0;
				try {
					lenbuf = is.read(inbuf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return -1;
			}
			return inbuf[ptrbuf++];
		}

		boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		char nextChar() {
			return (char) skip();
		}

		String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		char[] next(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		char[][] nextMatrix(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++)
				map[i] = next(m);
			return map;
		}

		int[] nextArray(int n, boolean isOneInd) {
			int k = isOneInd ? 1 : 0;
			int[] a = new int[n + k];
			for (int i = k; i < n + k; i++)
				a[i] = nextInt();
			return a;
		}

		int[] shuffle(int[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				arr[i] = arr[i] ^ arr[j];
				arr[j] = arr[i] ^ arr[j];
				arr[i] = arr[i] ^ arr[j];
			}
			return arr;
		}
	}
}