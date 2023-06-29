
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class E1 {

	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner(System.in);
		FastPrinter out = new FastPrinter(System.out);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			new E1().run(sc, out);
		}
		out.close();
	}

	int N, M, arr[][], ans;

	public void run(FastScanner sc, FastPrinter out) throws Exception {
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		int[][] nums = new int[N * M][3];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int v = sc.nextInt();
				arr[i][j] = v;
				nums[count++] = new int[] { v, j, i };
			}
		}
		Arrays.sort(nums, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return b[0] - a[0];
			}
		});
		// System.err.println(Arrays.deepToString(arr));
		// System.err.println(Arrays.deepToString(nums));
		if (N == 4 && M > 1) {
			int colCount = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			// I believe you only need top 6 numbers?
			for (int i = 0; i < 8; i++) {
				int col = nums[i][1];
				Integer newCol = map.get(col);
				if (newCol == null) {
					map.put(col, colCount++);
				}
			}
			int[][] arr = new int[N][colCount];
			for (int i = 0; i < 8; i++) {
				int val = nums[i][0];
				int col = map.get(nums[i][1]);
				int row = nums[i][2];
				arr[row][col] = val;
			}
			// System.err.println(Arrays.deepToString(arr));
			solve(0, arr);
		} else {
			ans = 0;
			for (int i = 0; i < N; i++) {
				ans += nums[i][0];
			}
		}
		System.out.println(ans);
	}

	private void solve(int index, int[][] arr) {
		if (index == arr[0].length) {
			int temp = 0;
			for (int i = 0; i < arr.length; i++) {
				int m = 0;
				for (int j = 0; j < arr[i].length; j++) {
					m = Math.max(m, arr[i][j]);
				}
				temp += m;
			}
			ans = Math.max(temp, ans);
		} else {
			for (int t = 0; t < N; t++) {
				int v = arr[0][index];
				for (int i = 0; i < N - 1; i++) {
					arr[i][index] = arr[i + 1][index];
				}
				arr[N - 1][index] = v;
				solve(index + 1, arr);
			}
		}

	}

	static class FastScanner {
		final private int BUFFER_SIZE = 1 << 10;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastScanner() {
			this(System.in);
		}

		public FastScanner(InputStream stream) {
			din = new DataInputStream(stream);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastScanner(String fileName) throws IOException {
			Path p = Paths.get(fileName);
			buffer = Files.readAllBytes(p);
			bytesRead = buffer.length;
		}

		int[] nextIntArray(int N) throws IOException {
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		String nextLine() throws IOException {
			int c = read();
			while (c != -1 && isEndline(c))
				c = read();
			if (c == -1) {
				return null;
			}
			StringBuilder res = new StringBuilder();
			do {
				if (c >= 0) {
					res.appendCodePoint(c);
				}
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		String next() throws Exception {
			int c = readOutSpaces();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg) return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg) return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg) c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg) return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			if (din == null) {
				bufferPointer = 0;
				bytesRead = -1;
			} else {
				bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			}
			if (bytesRead == -1) buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead) fillBuffer();
			return buffer[bufferPointer++];
		}

		private int readOutSpaces() throws IOException {
			while (true) {
				if (bufferPointer == bytesRead) fillBuffer();
				int c = buffer[bufferPointer++];
				if (!isSpaceChar(c)) {
					return c;
				}
			}
		}

		public void close() throws IOException {
			if (din == null) return;
			din.close();
		}

		public int[][] readGraph(int N, int M, boolean zeroIndexed, boolean bidirectional) throws Exception {
			int[][] adj = new int[N][];
			int[] numNodes = new int[N];
			int[][] input = new int[M][2];
			for (int i = 0; i < M; i++) {
				int a = nextInt();
				int b = nextInt();
				if (zeroIndexed) {
					a--;
					b--;
				}
				input[i][0] = a;
				input[i][1] = b;
				numNodes[a]++;
				if (bidirectional) numNodes[b]++;
			}
			for (int i = 0; i < N; i++) {
				adj[i] = new int[numNodes[i]];
				numNodes[i] = 0;
			}
			for (int i = 0; i < M; i++) {
				int a = input[i][0];
				int b = input[i][1];
				adj[a][numNodes[a]++] = b;
				if (bidirectional) adj[b][numNodes[b]++] = a;
			}
			return adj;
		}

		public int[][][] readWeightedGraph(int N, int M, boolean zeroIndexed, boolean bidirectional) throws Exception {
			int[][][] adj = new int[N][][];
			int[] numNodes = new int[N];
			int[][] input = new int[M][3];
			for (int i = 0; i < M; i++) {
				int a = nextInt();
				int b = nextInt();
				if (zeroIndexed) {
					a--;
					b--;
				}
				int d = nextInt();
				input[i][0] = a;
				input[i][1] = b;
				input[i][2] = d;
				numNodes[a]++;
				if (bidirectional) numNodes[b]++;
			}
			for (int i = 0; i < N; i++) {
				adj[i] = new int[numNodes[i]][2];
				numNodes[i] = 0;
			}
			for (int i = 0; i < M; i++) {
				int a = input[i][0];
				int b = input[i][1];
				int d = input[i][2];
				adj[a][numNodes[a]][0] = b;
				adj[a][numNodes[a]][1] = d;
				numNodes[a]++;
				if (bidirectional) {
					adj[b][numNodes[b]][0] = a;
					adj[b][numNodes[b]][1] = d;
					numNodes[b]++;
				}
			}
			return adj;
		}
	}

	static class FastPrinter {
		static final char ENDL = '\n';
		StringBuilder buf;
		PrintWriter pw;

		public FastPrinter(OutputStream stream) {
			buf = new StringBuilder();
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream)));
		}

		public FastPrinter(String fileName) throws Exception {
			buf = new StringBuilder();
			pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		}

		public FastPrinter(StringBuilder buf) {
			this.buf = buf;
		}

		public void print(int a) {
			buf.append(a);
		}

		public void print(long a) {
			buf.append(a);
		}

		public void print(char a) {
			buf.append(a);
		}

		public void print(char[] a) {
			buf.append(a);
		}

		public void print(double a) {
			buf.append(a);
		}

		public void print(String a) {
			buf.append(a);
		}

		public void print(Object a) {
			buf.append(a.toString());
		}

		public void println() {
			buf.append(ENDL);
		}

		public void println(int a) {
			buf.append(a);
			buf.append(ENDL);
		}

		public void println(long a) {
			buf.append(a);
			buf.append(ENDL);
		}

		public void println(char a) {
			buf.append(a);
			buf.append(ENDL);
		}

		public void println(char[] a) {
			buf.append(a);
			buf.append(ENDL);
		}

		public void println(double a) {
			buf.append(a);
			buf.append(ENDL);
		}

		public void println(String a) {
			buf.append(a);
			buf.append(ENDL);
		}

		public void println(Object a) {
			buf.append(a.toString());
			buf.append(ENDL);
		}

		public void printf(String format, Object... args) {
			buf.append(String.format(format, args));
		}

		public void close() {
			pw.print(buf);
			pw.close();
		}

		public void flush() {
			pw.print(buf);
			pw.flush();
			buf.setLength(0);
		}

	}

}