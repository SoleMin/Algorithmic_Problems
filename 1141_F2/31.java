import java.io.*;
import java.util.*;

public class B implements Runnable {
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int n = scn.nextInt();
		int[] arr = scn.nextIntArray(n);

		int[][] a = new int[n * (n + 1) / 2][];
		int[] need = new int[a.length];
		int pos = 0;
		for (int l = 0; l < n; l++) {
			int sum = 0;
			for (int r = l; r < n; r++) {
				sum += arr[r];
				a[pos] = new int[] { l, r, sum };
				need[pos++] = sum;
			}
		}

		need = scn.uniq(need);

		int[][][] list = new int[need.length][][];
		int[] size = new int[list.length];

		for (int i = 0; i < pos; i++) {
			size[Arrays.binarySearch(need, a[i][2])]++;
		}
		for (int i = 0; i < list.length; i++) {
			list[i] = new int[size[i]][];
		}
		for (int i = 0; i < pos; i++) {
			int ind = Arrays.binarySearch(need, a[i][2]);
			list[ind][--size[ind]] = new int[] { a[i][0], a[i][1] };
		}

		int ind = -1, max = 0;

		for (int i = 0; i < list.length; i++) {
			if(list[i].length == 0) {
				continue;
			}
			Arrays.sort(list[i], (o1, o2) -> o1[1] - o2[1]);

			int count = 1, last = list[i][0][1];
			for(int j = 1; j < list[i].length; j++) {
				if(list[i][j][0] > last) {
					count++;
					last = list[i][j][1];
				}
			}
			
			if (count > max) {
				max = count;
				ind = i;
			}
		}
		
		out.println(max);
		int last = list[ind][0][1];
		out.println((list[ind][0][0] + 1) + " " + (list[ind][0][1] + 1));
		
		for(int i = 1; i < list[ind].length; i++) {
			if(list[ind][i][0] > last) {
				out.println((list[ind][i][0] + 1) + " " + (list[ind][i][1] + 1));
				last = list[ind][i][1];
			}
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
		new Thread(null, new B(), "Main", 1 << 26).start();
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
				arr[i] = arr[i] ^ arr[j];
				arr[j] = arr[i] ^ arr[j];
				arr[i] = arr[i] ^ arr[j];
			}
			return arr;
		}

		int[] uniq(int[] arr) {
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

	}
}