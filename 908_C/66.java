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
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int r = in.nextInt();
			int[] x = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = in.nextInt();
			}
			double res = 0;
			double[] y = new double[n];

			for (int i = 0; i < n; i++) {
				double curY = r;
				for (int j = 0; j < i; j++) {
					int d = Math.abs(x[i] - x[j]);
					if (d <= 2 * r) {
						int a2 = 4 * r * r - d * d;
						curY = Math.max(curY, y[j] + Math.sqrt(a2));
					}
				}
				y[i] = curY;
				out.printf("%.14f", y[i]);
				if (i < n - 1) {
					out.print(" ");
				} else {
					out.println();
				}
			}
		}

	}

	static class InputReader {
		final InputStream is;
		final byte[] buf = new byte[1024];
		int pos;
		int size;

		public InputReader(InputStream is) {
			this.is = is;
		}

		public int nextInt() {
			int c = read();
			while (isWhitespace(c))
				c = read();
			int sign = 1;
			if (c == '-') {
				sign = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = read();
			} while (!isWhitespace(c));
			return res * sign;
		}

		int read() {
			if (size == -1)
				throw new InputMismatchException();
			if (pos >= size) {
				pos = 0;
				try {
					size = is.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (size <= 0)
					return -1;
			}
			return buf[pos++] & 255;
		}

		static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}
}

