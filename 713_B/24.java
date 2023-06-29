import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskB {
		int n;
		int sepX;
		int sepY;
		int x1;
		int y1;
		int x2;
		int y2;
		FastScanner in;
		PrintWriter out;

		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			this.in = in;
			this.out = out;
			n = in.nextInt();

			int x11, x12, y11, y12;
			int x21, x22, y21, y22;
			findSeparatingX();
			findSeparatingY();

			if (sepX >= 0) {
				locate(0, 0, sepX, n);
				x11 = x1;
				y11 = y1;
				x12 = x2;
				y12 = y2;
				locate(sepX, 0, n, n);
				x21 = x1;
				y21 = y1;
				x22 = x2;
				y22 = y2;
			} else {
				locate(0, 0, n, sepY);
				x11 = x1;
				y11 = y1;
				x12 = x2;
				y12 = y2;
				locate(0, sepY, n, n);
				x21 = x1;
				y21 = y1;
				x22 = x2;
				y22 = y2;
			}

			++x11;
			++x21;
			++y11;
			++y21;
			out.println("! " + x11 + " " + y11 + " " + x12 + " " + y12 + " " + +x21 + " " + y21 + " " + x22 + " " + y22);
			out.flush();
		}

		void locate(int x1, int y1, int x2, int y2) {
			for (int step = 15; step >= 0; step--) {
				int h = 1 << step;
				if (query(x1 + h, y1, x2, y2) > 0) {
					x1 += h;
				}
				if (query(x1, y1, x2 - h, y2) > 0) {
					x2 -= h;
				}
				if (query(x1, y1 + h, x2, y2) > 0) {
					y1 += h;
				}
				if (query(x1, y1, x2, y2 - h) > 0) {
					y2 -= h;
				}
			}
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		private void findSeparatingX() {
			int l = 0;
			int r = n;
			while (r - l > 1) {
				int m = (l + r) / 2;
				if (query(0, 0, m, n) == 0) {
					l = m;
				} else {
					r = m;
				}
			}
			sepX = -1;
			if (query(0, 0, r, n) == 1 && query(r, 0, n, n) == 1) {
				sepX = r;
			}
		}

		private void findSeparatingY() {
			int l = 0;
			int r = n;
			while (r - l > 1) {
				int m = (l + r) / 2;
				if (query(0, 0, n, m) == 0) {
					l = m;
				} else {
					r = m;
				}
			}
			sepY = -1;
			if (query(0, 0, n, r) == 1 && query(0, r, n, n) == 1) {
				sepY = r;
			}
		}

		int query(int x1, int y1, int x2, int y2) {
			if (x1 >= x2 || y1 >= y2) {
				return 0;
			}
			++x1;
			++y1;
			out.println("? " + x1 + " " + y1 + " " + x2 + " " + y2);
			out.flush();
			return in.nextInt();
		}

	}

	static class FastScanner {
		private BufferedReader in;
		private StringTokenizer st;

		public FastScanner(InputStream stream) {
			in = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String rl = in.readLine();
					if (rl == null) {
						return null;
					}
					st = new StringTokenizer(rl);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}

