import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Main {

	static PrintWriter out;
	static InputReader ir;

	static void solve() {
		int t = ir.nextInt();
		while (t-- > 0) {
			int n = ir.nextInt();
			int m = ir.nextInt();
			int[][] a = new int[n][];
			for (int i = 0; i < n; i++) {
				a[i] = ir.nextIntArray(m);
			}
			int[][][] comx = new int[n + 1][m][2];
			for (int i = 0; i < m; i++) {
				int[] b = new int[n];
				for (int j = 0; j < n; j++) {
					b[j] = a[j][i];
				}
				Arrays.sort(b);
				for (int j = 0; j < n; j++) {
					comx[j + 1][i][0] = comx[j][i][0] + b[n - 1 - j];
					comx[j + 1][i][1] = i;
				}
			}
			int[][][] org = new int[n + 1][m][2];
			for (int i = 0; i <= n; i++)
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < 2; k++) {
						org[i][j][k] = comx[i][j][k];
					}
				}
			for (int i = 1; i <= n; i++)
				Arrays.sort(comx[i], new Comparator<int[]>() {
					public int compare(int[] A, int[] B) {
						return A[0] - B[0];
					}
				});
			// tr(org);
			// tr(comx);
			if (n == 1) {
				out.println(comx[1][m - 1][0]);
			} else if (n == 2) {
				out.println(Math.max(comx[2][m - 1][0], m >= 2 ? comx[1][m - 1][0] + comx[1][m - 2][0] : 0));
			} else if (n == 3) {
				int res = Math.max(comx[3][m - 1][0],
						m >= 3 ? comx[1][m - 1][0] + comx[1][m - 2][0] + comx[1][m - 3][0] : 0);
				if (m >= 2) {
					for (int i = 0; i < m; i++) {
						int p = comx[2][i][0];
						int ma = 0;
						for (int j = 0; j < m; j++) {
							if (comx[2][i][1] == j)
								continue;
							ma = Math.max(org[1][j][0], ma);
						}
						res = Math.max(res, p + ma);
					}
				}
				out.println(res);
			} else {
				int res = Math.max(comx[4][m - 1][0],
						m >= 4 ? comx[1][m - 1][0] + comx[1][m - 2][0] + comx[1][m - 3][0] + comx[1][m - 4][0] : 0);
				if (m >= 2) {
					for (int i = 0; i < m; i++) {
						int p = comx[3][i][0];
						int ma = 0;
						for (int j = 0; j < m; j++) {
							if (comx[3][i][1] == j)
								continue;
							ma = Math.max(org[1][j][0], ma);
						}
						res = Math.max(res, p + ma);
					}
				}
				if (m >= 3) {
					for (int i = 0; i < m; i++) {
						int p = comx[2][i][0];
						PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
						for (int j = 0; j < m; j++) {
							if (comx[2][i][1] == j)
								continue;
							pq.add(org[1][j][0]);
						}
						res = Math.max(res, p + pq.poll() + pq.poll());
					}
				}
				if (m >= 2) {
					for (int i = 0; i < m; i++) {
						int p = 0;
						for (int j = 0; j < 4; j++) {
							p = Math.max(p, a[j][i] + a[(j + 1) % 4][i]);
						}
						int ma = 0;
						for (int j = 0; j < m; j++) {
							if (i == j)
								continue;
							for (int k = 0; k < 4; k++) {
								ma = Math.max(ma, a[k][j] + a[(k + 1) % 4][j]);
							}
						}
						res = Math.max(res, p + ma);
					}
					for (int i = 0; i < m; i++) {
						int p = 0;
						for (int j = 0; j < 4; j++) {
							p = Math.max(p, a[j][i] + a[(j + 2) % 4][i]);
						}
						int ma = 0;
						for (int j = 0; j < m; j++) {
							if (i == j)
								continue;
							for (int k = 0; k < 4; k++) {
								ma = Math.max(ma, a[k][j] + a[(k + 2) % 4][j]);
							}
						}
						res = Math.max(res, p + ma);
					}
				}
				out.println(res);
			}
		}

	}

	public static void main(String[] args) {
		ir = new InputReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}

	static class InputReader {

		private InputStream in;
		private byte[] buffer = new byte[1024];
		private int curbuf;
		private int lenbuf;

		public InputReader(InputStream in) {
			this.in = in;
			this.curbuf = this.lenbuf = 0;
		}

		public boolean hasNextByte() {
			if (curbuf >= lenbuf) {
				curbuf = 0;
				try {
					lenbuf = in.read(buffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return false;
			}
			return true;
		}

		private int readByte() {
			if (hasNextByte())
				return buffer[curbuf++];
			else
				return -1;
		}

		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		private void skip() {
			while (hasNextByte() && isSpaceChar(buffer[curbuf]))
				curbuf++;
		}

		public boolean hasNext() {
			skip();
			return hasNextByte();
		}

		public String next() {
			if (!hasNext())
				throw new NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (!isSpaceChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public int nextInt() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public long nextLong() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public char[][] nextCharMap(int n, int m) {
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++)
				map[i] = next().toCharArray();
			return map;
		}
	}

	static void tr(Object... o) {
		out.println(Arrays.deepToString(o));
	}
}
