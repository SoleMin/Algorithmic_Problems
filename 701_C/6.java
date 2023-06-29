
import java.io.*;
import java.util.*;

public class C {
	InputStream is;

	int __t__ = 1;
	int __f__ = 0;
	int __FILE_DEBUG_FLAG__ = __f__;
	String __DEBUG_FILE_NAME__ = "src/C4";

	FastScanner in;
	PrintWriter out;

	int charToIndex(char c) {
		if (Character.isLowerCase(c))
			return c - 'a';
		else if (Character.isUpperCase(c))
			return c - 'A' + 26;
		return -1;
	}
	
	int CH_NUM = 52;
	public void solve() {
		int n = in.nextInt();
		String s = in.next();
		
		boolean[] exist = new boolean[CH_NUM];
		int typeNum = 0;
		for (int i = 0; i < n; i++) {
			int idx = charToIndex(s.charAt(i));
			if (!exist[idx]) {
				exist[idx] = true;
				typeNum++;
			}
		}
		
		int get = 0;
		int tail = 0, head = 0;
		int res = Integer.MAX_VALUE;
		int[] cnt = new int[CH_NUM];
		while (tail < n || head < n) {
			if (head == n || typeNum == get) {
				int idx = charToIndex(s.charAt(tail++));
				if (cnt[idx] == 1) get--;
				cnt[idx]--;
			} else {
				int idx = charToIndex(s.charAt(head++));
				if (cnt[idx] == 0) get++; 
				cnt[idx]++;
			}
			if (typeNum == get)
				res = Math.min(res, head - tail);
		}
		System.out.println(res);
		/*
		int[] currentRightMost = new int[CH_NUM];
		Arrays.fill(currentRightMost, -1);
		int[][] next = new int[n+1][CH_NUM];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(next[i], 1 << 30);
		}
		for (int i = 0; i < n; i++) {
			int idx = charToIndex(s.charAt(i));
			for (int j = 0; j < CH_NUM; j++) if (exist[j]) {
				if (currentRightMost[j] != -1)
					next[currentRightMost[j]][idx] = Math.min(next[currentRightMost[j]][idx], i);
			}
			currentRightMost[idx] = i;
		}
		
		int res = Integer.MAX_VALUE;
		for (int leftMost = 0; leftMost < n; leftMost++) {
			int maxRightMost = 0;
			int idx = charToIndex(s.charAt(leftMost));
			for (int j = 0; j < CH_NUM; j++) if (exist[j]) {
				if (j != idx)
					maxRightMost = Math.max(maxRightMost, next[leftMost][j]);
			}
			res = Math.min(res, maxRightMost - leftMost + 1);
		}
		System.out.println(res);
		*/
	}

	public void run() {
		if (__FILE_DEBUG_FLAG__ == __t__) {
			try {
				is = new FileInputStream(__DEBUG_FILE_NAME__);
			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			System.out.println("FILE_INPUT!");
		} else {
			is = System.in;
		}
		in = new FastScanner(is);
		out = new PrintWriter(System.out);

		solve();
	}

	public static void main(String[] args) {
		new C().run();
	}

	public void mapDebug(int[][] a) {
		System.out.println("--------map display---------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

		System.out.println("----------------------------");
		System.out.println();
	}

	public void debug(Object... obj) {
		System.out.println(Arrays.deepToString(obj));
	}

	class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
			//stream = new FileInputStream(new File("dec.in"));

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

		int[] nextIntArray(int n) {
			return nextIntArray(n, 0);
		}

		int[] nextIntArray(int n, int margin) {
			int[] array = new int[n + margin];
			for (int i = 0; i < n; i++)
				array[i + margin] = nextInt();

			return array;
		}

		int[][] nextIntMap(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextIntArray(m);
			}
			return map;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			return nextLongArray(n, 0);
		}

		long[] nextLongArray(int n, int margin) {
			long[] array = new long[n + margin];
			for (int i = 0; i < n; i++)
				array[i + margin] = nextLong();

			return array;
		}

		long[][] nextLongMap(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextLongArray(m);
			}
			return map;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			return nextDoubleArray(n, 0);
		}

		double[] nextDoubleArray(int n, int margin) {
			double[] array = new double[n + margin];
			for (int i = 0; i < n; i++)
				array[i + margin] = nextDouble();

			return array;
		}

		double[][] nextDoubleMap(int n, int m) {
			double[][] map = new double[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextDoubleArray(m);
			}
			return map;
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

		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = next();

			return array;
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

