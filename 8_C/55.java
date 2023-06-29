import java.io.*;
import java.util.*;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class Main {

	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	private void solution() throws IOException {
		int sx = in.nextInt();
		int sy = in.nextInt();
		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; ++i) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		int[] dp = new int[1 << n];
		int[] prev = new int[1 << n];
		Arrays.fill(dp, Integer.MAX_VALUE / 2);
		dp[0] = 0;
		prev[0] = -1;
		for (int mask = 0; mask < (1 << n); ++mask) {
			if (dp[mask] != Integer.MAX_VALUE / 2) {
				for (int next = 0; next < n; ++next) {
					if (((mask >> next) & 1) == 0) {
						int nmask = mask | (1 << next);
						int val = dp[mask] + 2 * getDist(sx, sy, x[next], y[next]);
						if (dp[nmask] > val) {
							dp[nmask] = val;
							prev[nmask] = mask;
						}
						for (int next2 = next + 1; next2 < n; ++next2) {
							if (((nmask >> next2) & 1) == 0) {
								int nnmask = nmask | (1 << next2);
								int nval = dp[mask] + getDist(sx, sy, x[next], y[next]) 
													+ getDist(x[next], y[next], x[next2], y[next2])
													+ getDist(x[next2], y[next2], sx, sy);
								if (dp[nnmask] > nval) {
									dp[nnmask] = nval;
									prev[nnmask] = mask;
								}
							}
						}
						break;
					}
				}
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		int mask = (1 << n) - 1;
		while (mask > 0) {
			for (int i = 0; i < n; ++i) {
				if (((prev[mask] >> i) & 1) == 0 && ((mask >> i) & 1) == 1) {
					res.add(i + 1);
				}
			}
			res.add(0);
			mask = prev[mask];
		}
		Collections.reverse(res);
		out.println(dp[(1 << n) - 1]);
		for (int i = 0; i < res.size(); ++i) {
			if (i != 0) {
				out.print(" ");
			}
			out.print(res.get(i));
		}
		out.println();
		out.flush();
	}

	private int getDist(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

	private class Scanner {

		private StringTokenizer tokenizer;
		private BufferedReader reader;

		public Scanner(Reader in) {
			reader = new BufferedReader(in);
			tokenizer = new StringTokenizer("");
		}

		public boolean hasNext() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				String tmp = reader.readLine();
				if (tmp == null)
					return false;
				tokenizer = new StringTokenizer(tmp);
			}
			return true;
		}

		public String next() throws IOException {
			hasNext();
			return tokenizer.nextToken();
		}

		public String nextLine() throws IOException {
			tokenizer = new StringTokenizer("");
			return reader.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
}
