import java.io.*;
import java.util.*;

public class E implements Runnable {
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt(), m = scn.nextInt();
			int[][] arr = scn.next2DInt(n, m);
			
			int[][] col = new int[m][2];
			for(int j = 0; j < m; j++) {
				int max = 0;
				for(int i = 0; i < n; i++) {
					max = Math.max(max, arr[i][j]);
				}
				col[j][0] = max;
				col[j][1] = j;
			}
			Arrays.parallelSort(col, (o1, o2) -> o2[0] - o1[0]);
			
			int take = Math.min(n, m);
			
			int[][] lol = new int[n][take];
			for(int j = 0; j < take; j++) {
				for(int i = 0; i < n; i++) {
					lol[i][j] = arr[i][col[j][1]];
				}
			}
			
			ans = 0;
			func(lol, 0);
			out.println(ans);
		}
	}
	
	int ans = 0;
	
	void func(int[][] arr, int col) {
		int n = arr.length, m = arr[0].length;
		if(col == m) {
			int rv = 0;
			for(int i = 0; i < n; i++) {
				int mx = 0;
				for(int j = 0; j < m; j++) {
					mx = Math.max(mx, arr[i][j]);
				}
				rv += mx; 
			}
			ans = Math.max(ans, rv);
			return;
		}
		
		for(int rot = 0; rot < n; rot++) {
			int f = arr[0][col];
			for(int j = 1; j < n; j++) {
				arr[j - 1][col] = arr[j][col];
			}
			arr[n - 1][col] = f;
			func(arr, col + 1);
		}
	}

	public void run() {
		long time = System.currentTimeMillis();
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		out = new PrintWriter(System.out);
		scn = new FastReader(oj);
		solve();
		out.flush();
		if (!oj) {
			System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
		}
	}

	public static void main(String[] args) {
		new Thread(null, new E(), "Main", 1 << 26).start();
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

		String nextLine() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while ((!isSpaceChar(b) || b == ' ')) { // when nextLine, (isSpaceChar(b) && b != ' ')
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

		int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		int[][] next2DInt(int n, int m) {
			int[][] arr = new int[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextIntArray(m);
			}
			return arr;
		}

		long[][] next2DLong(int n, int m) {
			long[][] arr = new long[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLongArray(m);
			}
			return arr;
		}

		int[] shuffle(int[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				int c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		long[] shuffle(long[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				long c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		int[] uniq(int[] arr) {
			arr = scn.shuffle(arr);
			Arrays.sort(arr);
			int[] rv = new int[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		long[] uniq(long[] arr) {
			arr = scn.shuffle(arr);
			Arrays.sort(arr);
			long[] rv = new long[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		int[] reverse(int[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}

		long[] reverse(long[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}

		int[] compress(int[] arr) {
			int n = arr.length;
			int[] rv = Arrays.copyOf(arr, n);
			rv = uniq(rv);
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.binarySearch(rv, arr[i]);
			}
			return arr;
		}

		long[] compress(long[] arr) {
			int n = arr.length;
			long[] rv = Arrays.copyOf(arr, n);
			rv = uniq(rv);
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.binarySearch(rv, arr[i]);
			}
			return arr;
		}
	}
}