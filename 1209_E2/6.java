/*input
3
2 3
2 5 7
4 2 4
3 6
4 1 5 2 10 4
8 6 6 4 9 10
5 4 9 5 8 7
3 3
9 9 9
1 1 1
1 1 1

*/
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.Random;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		int T = in.nextInt();
		for (int cT = 1; cT <= T; cT++) {
			Task solver = new Task();
			solver.solve(cT, in, out);
		}
		out.close();
	}

	static class data {
		int val, col;
		data(int _val, int _col) {
			val = _val; col = _col;
		}

		@Override
		public String toString() {
			return String.format("(%d,%d)", val, col);
		}
	}

	static class Task {
		int[][] a;
		int[][] b;
		int[][] dp;
		int[][] mb;

		ArrayList<data> all = new ArrayList<>();
		Set<Integer> st = new HashSet<>();
		int n, m;

		int cal(int col, int mask) {
			if (col == m) {
				if (Integer.bitCount(mask) == n) return 0;
				return (int)(-1e9);
			}
			int ret = dp[col][mask];
			if (ret != -1) return ret;
			int rmask = mask ^ ((1 << n) - 1);
			// ret is not a reference
			for (int mask2 = rmask; mask2 > 0; mask2 = rmask & (mask2 - 1)) {
				int now = cal(col + 1, mask | mask2) + mb[col][mask2];
				ret = Math.max(ret, now);
			}
			ret = Math.max(ret, cal(col + 1, mask));
			dp[col][mask] = ret;
			return ret;
		}
		public static int fsb(int n) {
			return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1;
		}

		void prepMb() {
			// col, cyclic, mask
			for (int col = 0; col < m; col++) {
				for (int mask = 1; mask < (1 << n); mask++) {
					int nmask = mask;
					while ((nmask & 1) == 0) nmask >>= 1;
					if (nmask == mask) {
						for (int shift = 0; shift < n; shift++) {
							int sum = 0;
							int tmask = mask;
							while (tmask > 0) {
								int i = Integer.numberOfTrailingZeros(tmask);
								sum += b[(i + shift) % n][col]; tmask ^= (1 << i);
							}
							mb[col][mask] = Math.max(mb[col][mask], sum);
						}
					} else {
						mb[col][mask] = mb[col][nmask];
					}
				}
			}
		}

		void solve(int testNumber, InputReader in, PrintWriter out) {
			n = in.nextInt(); m = in.nextInt();
			a = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = in.nextInt();
					all.add(new data(a[i][j], j));
				}
			}
			Collections.sort(all, new Comparator<data>() {
				@Override
				public int compare(final data o1, final data o2) {
					return -(o1.val - o2.val);
				}
			});
			for (data it : all) {
				if (st.size() == n) break;
				st.add(it.col);
			}
			b = new int[n][st.size()];
			int rcol = 0;
			for (int col : st) {
				for (int row = 0; row < n; row++)
					b[row][rcol] = a[row][col];
				rcol++;
			}
			m = st.size();
			dp = new int[n][(1 << n)];
			mb = new int[m][(1 << n)];

			prepMb();
			for (int i = 0; i < n; i++)
				Arrays.fill(dp[i], -1);
			System.out.println(cal(0, 0));
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}